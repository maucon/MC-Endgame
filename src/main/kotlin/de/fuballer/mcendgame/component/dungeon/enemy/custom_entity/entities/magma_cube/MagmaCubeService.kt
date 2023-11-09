package de.fuballer.mcendgame.component.dungeon.enemy.custom_entity.entities.magma_cube

import de.fuballer.mcendgame.component.dungeon.enemy.custom_entity.data.CustomEntityType
import de.fuballer.mcendgame.framework.annotation.Component
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.SlimeSplitEvent

@Component
class MagmaCubeService : Listener {
    @EventHandler
    fun onSlimeSplit(event: SlimeSplitEvent) {
        if (!CustomEntityType.isType(event.entity, CustomEntityType.MAGMA_CUBE)) return
        event.isCancelled = true
    }
}