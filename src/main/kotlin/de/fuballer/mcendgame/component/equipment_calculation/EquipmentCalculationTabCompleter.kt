package de.fuballer.mcendgame.component.equipment_calculation

import de.fuballer.mcendgame.framework.annotation.Component
import de.fuballer.mcendgame.framework.stereotype.CommandTabCompleter
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

@Component
class EquipmentCalculationTabCompleter : CommandTabCompleter {
    override fun initialize(plugin: JavaPlugin) {
        plugin.getCommand(EquipmentCalculationSettings.COMMAND_NAME)!!.tabCompleter = this
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>?
    ): List<String>? {
        if (sender !is Player) return null
        return listOf("<damage>")
    }
}
