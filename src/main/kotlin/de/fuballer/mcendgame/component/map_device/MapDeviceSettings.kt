package de.fuballer.mcendgame.component.map_device

import de.fuballer.mcendgame.util.ItemCreatorUtil.create
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

object MapDeviceSettings {
    private val ITEM_NAME = ChatColor.RESET.toString() + "Map Device"
    val ITEM_LORE_LINE = ChatColor.DARK_PURPLE.toString() + "Allows to open 4 portals to a map"
    private val ITEM_LORE = listOf(ITEM_LORE_LINE)
    val ITEM = create(ItemStack(Material.RESPAWN_ANCHOR), ITEM_NAME, ITEM_LORE)

    const val MAP_DEVICE_ITEM_KEY = "map_device"

    fun getMapDeviceCraftingRecipe(key: NamespacedKey) =
        ShapedRecipe(key, ITEM).apply {
            shape("ONO", "NSN", "ONO")
            setIngredient('O', Material.OBSIDIAN)
            setIngredient('N', Material.NETHERITE_INGOT)
            setIngredient('S', Material.NETHER_STAR)
        }

    const val MAP_DEVICE_INVENTORY_TITLE = "Map Device"

    val OPEN_PORTALS_ITEM_LINE = ChatColor.GREEN.toString() + "Open portals"
    val OPEN_PORTALS_ITEM = create(ItemStack(Material.LIME_STAINED_GLASS_PANE), OPEN_PORTALS_ITEM_LINE, listOf())

    private val CLOSE_PORTALS_ITEM_LINE = ChatColor.RED.toString() + "Close portals"
    val CLOSE_PORTALS_ITEM = create(ItemStack(Material.RED_STAINED_GLASS_PANE), CLOSE_PORTALS_ITEM_LINE, listOf())

    val FILLER_ITEM = create(ItemStack(Material.GRAY_STAINED_GLASS_PANE), " ", listOf(" "))

    const val MAP_DEVICE_BLOCK_METADATA_KEY = "MAP_DEVICE"
    const val MAP_DEVICE_PORTAL_ENTITY_NAME = "mcEndgame_portal"

    val DUNGEON_INSTANCE_CLOSED = "${ChatColor.RED}Dungeon instance already closed!"
}
