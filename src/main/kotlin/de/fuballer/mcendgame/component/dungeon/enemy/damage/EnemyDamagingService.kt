package de.fuballer.mcendgame.component.dungeon.enemy.damage

import de.fuballer.mcendgame.framework.annotation.Component
import de.fuballer.mcendgame.util.DungeonUtil
import de.fuballer.mcendgame.util.WorldUtil
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent

@Component
class EnemyDamagingService : Listener {
    @EventHandler
    fun onEntityDamageByEntity(event: EntityDamageByEntityEvent) {
        val damager = event.damager

        if (WorldUtil.isNotDungeonWorld(damager.world)) return
        if (!DungeonUtil.isEnemyOrEnemyProjectile(damager)) return

        val target = event.entity
        if (DungeonUtil.isEnemyOrEnemyProjectile(target)) {
            event.isCancelled = true
            return
        }

        event.damage *= 2.0 / 3.0 // worlds on hard mode multiply damage by 1,5x, so we revert that
    }
}