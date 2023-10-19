package de.fuballer.mcendgame.component.dungeon.enemy.custom_entity.necromancer

import de.fuballer.mcendgame.component.dungeon.enemy.custom_entity.CustomEntityType
import de.fuballer.mcendgame.component.dungeon.enemy.custom_entity.MinionRepository
import de.fuballer.mcendgame.component.dungeon.enemy.custom_entity.MinionsEntity
import de.fuballer.mcendgame.component.dungeon.enemy.custom_entity.summoner.SummonerService
import de.fuballer.mcendgame.framework.annotation.Component
import org.bukkit.entity.Entity
import org.bukkit.entity.Spellcaster
import org.bukkit.event.entity.EntitySpellCastEvent
import kotlin.math.min

@Component
class NecromancerService(
    private val minionRepo: MinionRepository,
    private val summonerService: SummonerService
) {
    fun onEntitySpellCast(event: EntitySpellCastEvent) {
        if (!isNecromancer(event.entity)) return

        if (event.spell == Spellcaster.Spell.SUMMON_VEX)
            summonVexSpell(event)
    }

    private fun isNecromancer(entity: Entity) =
        entity.type == CustomEntityType.NECROMANCER.type
                && entity.customName == CustomEntityType.NECROMANCER.customName

    private fun summonVexSpell(event: EntitySpellCastEvent) {
        val minionsEntity = minionRepo.findById(event.entity.uniqueId)
            ?: MinionsEntity(event.entity.uniqueId)

        updateMinions(minionsEntity)

        val spawnAmount = min(NecromancerSettings.SPAWN_AMOUNT, NecromancerSettings.MAX_MINIONS - minionsEntity.minions.size)
        if (spawnAmount <= 0) {
            event.isCancelled = true
            return
        }

        summonerService.summonMinions(event.entity, CustomEntityType.SKELETON, spawnAmount, true, false, true, NecromancerSettings.MINION_HEALTH)
        event.isCancelled = true
    }

    private fun updateMinions(minionsEntity: MinionsEntity) {
        minionsEntity.minions.removeIf { it.isDead }
    }
}
