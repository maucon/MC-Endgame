package de.fuballer.mcendgame.component.killer

import de.fuballer.mcendgame.component.killer.db.KillerEntity
import de.fuballer.mcendgame.component.killer.db.KillerRepository
import de.fuballer.mcendgame.framework.annotation.Component
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.entity.Projectile
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.inventory.InventoryClickEvent

@Component
class KillerService(
    private val killerRepo: KillerRepository
) : Listener {
    @EventHandler
    fun onEntityDamageByEntityEvent(event: EntityDamageByEntityEvent) {
        val damaged = event.entity
        if (damaged !is Player) return

        var damageCause = event.damager

        if (damageCause is Projectile && damageCause.shooter is Entity) {
            damageCause.shooter.also { damageCause = it as Entity }
        }

        if (event.finalDamage < damaged.health) return

        val entity = KillerEntity(damaged.uniqueId, damageCause)
        killerRepo.save(entity)
    }

    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        if (!event.view.title.startsWith(KillerSettings.INVENTORY_TITLE, true)) return

        val spawnEgg = event.inventory.getItem(9) ?: return
        if (!spawnEgg.type.name.contains("EGG")) return

        event.isCancelled = true
    }
}
