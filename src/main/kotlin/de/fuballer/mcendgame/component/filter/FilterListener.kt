package de.fuballer.mcendgame.component.filter

import de.fuballer.mcendgame.framework.annotation.Component
import de.fuballer.mcendgame.framework.stereotype.EventListener
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.event.inventory.InventoryClickEvent

@Component
class FilterListener(
    private val filterService: FilterService
) : EventListener {

    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) = filterService.onInventoryClick(event)

    @EventHandler
    fun onEntityItemPickup(event: EntityPickupItemEvent) = filterService.onEntityItemPickup(event)
}
