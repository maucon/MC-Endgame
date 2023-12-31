package de.fuballer.mcendgame.component.dungeon.tweaks.armor_durability

import de.fuballer.mcendgame.framework.annotation.Component
import de.fuballer.mcendgame.util.WorldUtil
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerItemDamageEvent
import java.lang.Integer.min

@Component
class ArmorDurabilityService : Listener {
    @EventHandler
    fun onPlayerItemDamage(event: PlayerItemDamageEvent) {
        if (WorldUtil.isNotDungeonWorld(event.player.world)) return

        event.damage = min(event.damage, ArmorDurabilitySettings.MAX_ARMOR_DAMAGE)
    }
}
