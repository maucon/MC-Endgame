package de.fuballer.mcendgame.component.dungeon.type.command

import de.fuballer.mcendgame.component.dungeon.type.DungeonTypeSettings
import de.fuballer.mcendgame.component.dungeon.type.data.DungeonType
import de.fuballer.mcendgame.component.dungeon.type.db.PlayerDungeonTypeEntity
import de.fuballer.mcendgame.component.dungeon.type.db.PlayerDungeonTypeRepository
import de.fuballer.mcendgame.domain.CommandAction
import de.fuballer.mcendgame.framework.annotation.Component
import de.fuballer.mcendgame.framework.stereotype.CommandHandler
import de.fuballer.mcendgame.helper.CommandHelper
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

@Component
class DungeonTypeCommand(
    private val playerDungeonTypeRepo: PlayerDungeonTypeRepository,
    private val commandHelper: CommandHelper
) : CommandHandler {
    override fun initialize(plugin: JavaPlugin) = plugin.getCommand(DungeonTypeSettings.COMMAND_NAME)!!.setExecutor(this)

    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        val commandExecutor = sender as? Player ?: return false
        if (args.isEmpty()) return false

        val commandAction = commandHelper.getCommandAction(args[0]) ?: return false
        return when (commandAction) {
            CommandAction.GET -> printDungeonType(args, commandExecutor)
            CommandAction.SET -> setDungeonType(args, commandExecutor)
        }
    }

    private fun printDungeonType(
        args: Array<out String>,
        commandExecutor: Player
    ): Boolean {
        if (args.size > 2) return false

        val targetPlayer =
            if (args.size == 1) commandExecutor
            else {
                commandHelper.getPlayer(commandExecutor, args[1]) ?: return true
            }

        val entity = playerDungeonTypeRepo.findById(targetPlayer.uniqueId)
        if (entity == null) {
            commandExecutor.sendMessage(DungeonTypeSettings.PLAYER_NO_DUNGEON_TYPE)
            return true
        }

        val message = DungeonTypeSettings.getDungeonTypeMessage(targetPlayer.name!!, entity.dungeonType)
        commandExecutor.sendMessage(message)

        return true
    }

    private fun setDungeonType(
        args: Array<out String>,
        commandExecutor: Player
    ): Boolean {
        if (args.size != 3) return false

        val targetPlayer = commandHelper.getPlayer(commandExecutor, args[1]) ?: return false

        val dungeonType: DungeonType
        try {
            dungeonType = DungeonType.valueOf(args[2])
        } catch (_: IllegalArgumentException) {
            commandExecutor.sendMessage(DungeonTypeSettings.INVALID_DUNGEON_TYPE)
            return true
        }

        val entity = PlayerDungeonTypeEntity(targetPlayer.uniqueId, dungeonType)
            .also { playerDungeonTypeRepo.save(it) }

        val message = DungeonTypeSettings.getDungeonTypeMessage(targetPlayer.name!!, entity.dungeonType)
        commandExecutor.sendMessage(message)

        return true
    }
}
