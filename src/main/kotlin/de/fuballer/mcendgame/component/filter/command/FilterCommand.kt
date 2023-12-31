package de.fuballer.mcendgame.component.filter.command

import de.fuballer.mcendgame.component.filter.FilterSettings
import de.fuballer.mcendgame.component.filter.db.FilterEntity
import de.fuballer.mcendgame.component.filter.db.FilterRepository
import de.fuballer.mcendgame.framework.annotation.Component
import de.fuballer.mcendgame.framework.stereotype.CommandHandler
import de.fuballer.mcendgame.util.PluginUtil
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

@Component
class FilterCommand(
    private val filterRepo: FilterRepository
) : CommandHandler {
    override fun initialize(plugin: JavaPlugin) = plugin.getCommand(FilterSettings.COMMAND_NAME)!!.setExecutor(this)

    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        val commandExecutor = sender as? Player ?: return false

        openFilter(commandExecutor)
        return true
    }

    private fun openFilter(player: Player) {
        val uuid = player.uniqueId

        val entity = filterRepo.findById(uuid)
            ?: filterRepo.save(FilterEntity(uuid))

        showFilter(player, entity.filters)
    }

    private fun showFilter(
        player: Player,
        filter: Set<Material>
    ) {
        val inventory = PluginUtil.createInventory(
            FilterSettings.FILTER_SIZE,
            FilterSettings.FILTER_WINDOW_TITLE
        )
        val filterSize = filter.size.coerceAtMost(FilterSettings.FILTER_SIZE)

        for (index in 0 until filterSize) {
            val filterItem = ItemStack(filter.elementAt(index))
            inventory.setItem(index, filterItem)
        }

        player.openInventory(inventory)
    }
}
