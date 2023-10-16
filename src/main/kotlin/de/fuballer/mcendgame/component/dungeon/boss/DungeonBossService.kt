package de.fuballer.mcendgame.component.dungeon.boss

import de.fuballer.mcendgame.MCEndgame
import de.fuballer.mcendgame.component.corruption.CorruptionSettings
import de.fuballer.mcendgame.component.dungeon.boss.db.BossType
import de.fuballer.mcendgame.component.dungeon.boss.db.DungeonBossEntity
import de.fuballer.mcendgame.component.dungeon.boss.db.DungeonBossRepository
import de.fuballer.mcendgame.component.dungeon.world.db.WorldManageRepository
import de.fuballer.mcendgame.event.DungeonCompleteEvent
import de.fuballer.mcendgame.event.EventGateway
import de.fuballer.mcendgame.framework.stereotype.Service
import de.fuballer.mcendgame.helper.WorldHelper
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Creature
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.LivingEntity
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.entity.EntityTargetEvent
import org.bukkit.inventory.ItemStack
import java.util.*

class DungeonBossService(
    private val dungeonBossRepo: DungeonBossRepository,
    private val worldManageRepo: WorldManageRepository
) : Service {
    private val random = Random()

    fun spawnNewMapBoss(
        world: World,
        location: Location,
        mapTier: Int
    ): Creature {
        location.yaw = 180f

        val bossType = BossType.getRandom()

        val boss = world.spawnEntity(location, bossType.customEntityType.type) as Creature
        boss.customName = bossType.customEntityType.customName
        boss.isCustomNameVisible = false

        addBossAttributes(boss, mapTier, bossType)

        val entity = DungeonBossEntity(boss.uniqueId, mapTier, null, bossType)
        dungeonBossRepo.save(entity)

        return boss
    }

    private fun addBossAttributes(boss: Creature, mapTier: Int, bossType: BossType) {
        boss.addPotionEffects(DungeonBossSettings.BOSS_POTION_EFFECTS)
        boss.removeWhenFarAway = false
        boss.setAI(false)

        var attributeInstance = boss.getAttribute(Attribute.GENERIC_MAX_HEALTH) ?: return
        val newHealth = bossType.baseHealth + mapTier * bossType.healthPerTier
        attributeInstance.baseValue = newHealth
        boss.health = newHealth

        attributeInstance = boss.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE) ?: return
        val newDamage = bossType.baseDamage + mapTier * bossType.damagePerTier
        attributeInstance.baseValue = newDamage

        attributeInstance = boss.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) ?: return
        val newSpeed = bossType.speed
        attributeInstance.baseValue = newSpeed
    }

    fun onEntityDamage(event: EntityDamageEvent) {
        val entity = event.entity
        if (WorldHelper.isNotDungeonWorld(event.entity.world)) return
        if (entity.type == EntityType.RAVAGER) (entity as LivingEntity).setAI(true)
    }

    fun onEntityTarget(event: EntityTargetEvent) {
        val entity = event.entity
        if (WorldHelper.isNotDungeonWorld(entity.world)) return
        if (entity.type == EntityType.RAVAGER) onBossTarget(event)
    }

    private fun onBossTarget(event: EntityTargetEvent) {
        val entity = event.entity
        val worldName = entity.world.name
        val uuid = entity.uniqueId

        val dungeonBossEntity = dungeonBossRepo.findById(uuid) ?: return
        val abilityTask = dungeonBossEntity.abilityTask
        if (abilityTask != null && !abilityTask.isCancelled) return

        val mapTier = worldManageRepo.findById(worldName)?.mapTier ?: 1
        val runnable = DungeonBossAbilitiesRunnable(
            dungeonBossRepo,
            entity as Creature,
            dungeonBossEntity.type,
            mapTier,
        ).runTaskTimer(
            MCEndgame.PLUGIN,
            0,
            DungeonBossSettings.BOSS_ABILITY_CHECK_PERIOD.toLong()
        )

        dungeonBossEntity.abilityTask = runnable
        dungeonBossRepo.save(dungeonBossEntity)
    }

    fun onEntityDeath(event: EntityDeathEvent) {
        val entity = event.entity
        val uuid = entity.uniqueId

        val mapTier = dungeonBossRepo.findById(uuid)?.mapTier ?: return

        val world = entity.world

        event.drops.clear()
        dropBossLoot(entity, mapTier)

        val dungeonCompleteEvent = DungeonCompleteEvent(mapTier, world)
        EventGateway.apply(dungeonCompleteEvent)

        dungeonBossRepo.delete(uuid)
    }

    private fun dropBossLoot(
        entity: Entity,
        mapTier: Int
    ) {
        val world = entity.world
        val loc = entity.location

        val corruptionChance = DungeonBossSettings.calculateCorruptDropChance(mapTier)
        dropCorruptionHearts(CorruptionSettings.getCorruptionItem(), corruptionChance, world, loc)

        val doubleCorruptionChance = DungeonBossSettings.calculateDoubleCorruptDropChance(mapTier)
        dropCorruptionHearts(CorruptionSettings.getDoubleCorruptionItem(), doubleCorruptionChance, world, loc)
    }

    private fun dropCorruptionHearts(
        corruptionHeart: ItemStack,
        chance: Double,
        world: World,
        loc: Location
    ) {
        val restChance = chance % 1
        val extraDrop = random.nextDouble() < restChance
        val corruptionCount = chance.toInt() + if (extraDrop) 1 else 0

        corruptionHeart.amount = corruptionCount
        world.dropItemNaturally(loc, corruptionHeart)
    }
}
