package de.fuballer.mcendgame.domain.equipment.tool

import de.fuballer.mcendgame.domain.equipment.Equipment
import de.fuballer.mcendgame.domain.equipment.ItemAttribute
import de.fuballer.mcendgame.domain.equipment.ItemEnchantment
import de.fuballer.mcendgame.util.random.RandomOption
import org.bukkit.Material
import org.bukkit.attribute.Attribute

enum class Tool(
    override val material: Material,
    override val baseAttributes: List<ItemAttribute>,
    override val lore: String,
    override val rolledAttributes: List<RandomOption<ItemAttribute>>,
    override val enchantOptions: List<RandomOption<ItemEnchantment>>,
) : Equipment {
    BOW(
        Material.BOW,
        listOf(),
        Equipment.MAIN_HAND_SLOT_LORE,
        listOf(
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 1.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_SPEED, 0.4)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK, 0.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_MAX_HEALTH, 0.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_LUCK, 2.5))
        ),
        listOf(
            RandomOption(10, ItemEnchantment.MENDING),
            RandomOption(20, ItemEnchantment.UNBREAKING_1),
            RandomOption(15, ItemEnchantment.UNBREAKING_2),
            RandomOption(10, ItemEnchantment.UNBREAKING_3),
            RandomOption(0, ItemEnchantment.CURSE_OF_VANISHING),
            RandomOption(25, ItemEnchantment.POWER_1),
            RandomOption(20, ItemEnchantment.POWER_2),
            RandomOption(15, ItemEnchantment.POWER_3),
            RandomOption(10, ItemEnchantment.POWER_4),
            RandomOption(5, ItemEnchantment.POWER_5),
            RandomOption(20, ItemEnchantment.PUNCH_1),
            RandomOption(10, ItemEnchantment.PUNCH_2),
            RandomOption(15, ItemEnchantment.FLAME),
            RandomOption(10, ItemEnchantment.INFINITY),
        )
    ),
    TRIDENT(
        Material.TRIDENT,
        listOf(
            ItemAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 9.0),
            ItemAttribute(Attribute.GENERIC_ATTACK_SPEED, 1.1)
        ),
        Equipment.MAIN_HAND_SLOT_LORE,
        listOf(
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 1.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_SPEED, 0.4)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK, 0.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_MAX_HEALTH, 0.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_LUCK, 2.5))
        ),
        listOf(
            RandomOption(10, ItemEnchantment.MENDING),
            RandomOption(20, ItemEnchantment.UNBREAKING_1),
            RandomOption(15, ItemEnchantment.UNBREAKING_2),
            RandomOption(10, ItemEnchantment.UNBREAKING_3),
            RandomOption(0, ItemEnchantment.CURSE_OF_VANISHING),
            RandomOption(10, ItemEnchantment.CHANNELING),
            RandomOption(15, ItemEnchantment.LOYALTY_1),
            RandomOption(10, ItemEnchantment.LOYALTY_2),
            RandomOption(5, ItemEnchantment.LOYALTY_3),
            RandomOption(25, ItemEnchantment.IMPALING_1),
            RandomOption(20, ItemEnchantment.IMPALING_2),
            RandomOption(15, ItemEnchantment.IMPALING_3),
            RandomOption(10, ItemEnchantment.IMPALING_4),
            RandomOption(5, ItemEnchantment.IMPALING_5),
            RandomOption(15, ItemEnchantment.RIPTIDE_1),
            RandomOption(10, ItemEnchantment.RIPTIDE_2),
            RandomOption(5, ItemEnchantment.RIPTIDE_3),
        )
    ),
    FISHING_ROD(
        Material.FISHING_ROD,
        listOf(),
        Equipment.OFF_HAND_SLOT_LORE,
        listOf(
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 1.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_SPEED, 0.4)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK, 0.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_MAX_HEALTH, 0.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_LUCK, 2.5))
        ),
        listOf(
            RandomOption(10, ItemEnchantment.MENDING),
            RandomOption(25, ItemEnchantment.UNBREAKING_1),
            RandomOption(20, ItemEnchantment.UNBREAKING_2),
            RandomOption(15, ItemEnchantment.UNBREAKING_3),
            RandomOption(0, ItemEnchantment.CURSE_OF_VANISHING),
            RandomOption(20, ItemEnchantment.LUCK_OF_THE_SEA_1),
            RandomOption(15, ItemEnchantment.LUCK_OF_THE_SEA_2),
            RandomOption(10, ItemEnchantment.LUCK_OF_THE_SEA_3),
            RandomOption(20, ItemEnchantment.LURE_1),
            RandomOption(15, ItemEnchantment.LURE_2),
            RandomOption(10, ItemEnchantment.LURE_3),
        )
    ),
    SHIELD(
        Material.SHIELD,
        listOf(),
        Equipment.OFF_HAND_SLOT_LORE,
        listOf(
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 1.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_SPEED, 0.4)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK, 0.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_MAX_HEALTH, 1.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_LUCK, 2.5))
        ),
        listOf(
            RandomOption(10, ItemEnchantment.MENDING),
            RandomOption(25, ItemEnchantment.UNBREAKING_1),
            RandomOption(20, ItemEnchantment.UNBREAKING_2),
            RandomOption(15, ItemEnchantment.UNBREAKING_3),
            RandomOption(0, ItemEnchantment.CURSE_OF_VANISHING),
        )
    ),
    CROSSBOW(
        Material.CROSSBOW,
        listOf(),
        Equipment.MAIN_HAND_SLOT_LORE,
        listOf(
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 1.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_SPEED, 0.4)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK, 0.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_MAX_HEALTH, 0.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_LUCK, 2.5))
        ),
        listOf(
            RandomOption(10, ItemEnchantment.MENDING),
            RandomOption(25, ItemEnchantment.UNBREAKING_1),
            RandomOption(20, ItemEnchantment.UNBREAKING_2),
            RandomOption(15, ItemEnchantment.UNBREAKING_3),
            RandomOption(0, ItemEnchantment.CURSE_OF_VANISHING),
            RandomOption(15, ItemEnchantment.MULTISHOT),
            RandomOption(20, ItemEnchantment.PIERCING_1),
            RandomOption(15, ItemEnchantment.PIERCING_2),
            RandomOption(10, ItemEnchantment.PIERCING_3),
            RandomOption(5, ItemEnchantment.PIERCING_4),
            RandomOption(15, ItemEnchantment.QUICK_CHARGE_1),
            RandomOption(10, ItemEnchantment.QUICK_CHARGE_2),
            RandomOption(5, ItemEnchantment.QUICK_CHARGE_3),
        )
    ),
    FLINT_AND_STEEL(
        Material.FLINT_AND_STEEL,
        listOf(),
        Equipment.OFF_HAND_SLOT_LORE,
        listOf(
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 1.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_SPEED, 0.4)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK, 0.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_MAX_HEALTH, 0.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_LUCK, 2.5))
        ),
        listOf(
            RandomOption(10, ItemEnchantment.MENDING),
            RandomOption(25, ItemEnchantment.UNBREAKING_1),
            RandomOption(20, ItemEnchantment.UNBREAKING_2),
            RandomOption(15, ItemEnchantment.UNBREAKING_3),
            RandomOption(0, ItemEnchantment.CURSE_OF_VANISHING),
        )
    ),
    CARROT_ON_A_STICK(
        Material.CARROT_ON_A_STICK,
        listOf(),
        Equipment.OFF_HAND_SLOT_LORE,
        listOf(
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 1.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_SPEED, 0.4)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK, 0.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_MAX_HEALTH, 0.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_LUCK, 2.5))
        ),
        listOf(
            RandomOption(10, ItemEnchantment.MENDING),
            RandomOption(25, ItemEnchantment.UNBREAKING_1),
            RandomOption(20, ItemEnchantment.UNBREAKING_2),
            RandomOption(15, ItemEnchantment.UNBREAKING_3),
            RandomOption(0, ItemEnchantment.CURSE_OF_VANISHING),
        )
    ),
    WARPED_FUNGUS_ON_A_STICK(
        Material.WARPED_FUNGUS_ON_A_STICK,
        listOf(),
        Equipment.HEAD_SLOT_LORE,
        listOf(
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 1.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_SPEED, 0.4)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK, 0.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_MAX_HEALTH, 0.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_LUCK, 2.5))
        ),
        listOf(
            RandomOption(10, ItemEnchantment.MENDING),
            RandomOption(25, ItemEnchantment.UNBREAKING_1),
            RandomOption(20, ItemEnchantment.UNBREAKING_2),
            RandomOption(15, ItemEnchantment.UNBREAKING_3),
            RandomOption(0, ItemEnchantment.CURSE_OF_VANISHING),
        )
    ),
    ELYTRA(
        Material.ELYTRA,
        listOf(),
        Equipment.CHEST_SLOT_LORE,
        listOf(),
        listOf(
            RandomOption(10, ItemEnchantment.MENDING),
            RandomOption(25, ItemEnchantment.UNBREAKING_1),
            RandomOption(20, ItemEnchantment.UNBREAKING_2),
            RandomOption(15, ItemEnchantment.UNBREAKING_3),
            RandomOption(0, ItemEnchantment.CURSE_OF_VANISHING),
            RandomOption(0, ItemEnchantment.CURSE_OF_BINDING),
        )
    ),
    SHEARS(
        Material.SHEARS,
        listOf(),
        Equipment.OFF_HAND_SLOT_LORE,
        listOf(
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 1.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_SPEED, 0.4)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK, 0.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_MAX_HEALTH, 0.5)),
            RandomOption(10, ItemAttribute(Attribute.GENERIC_LUCK, 2.5))
        ),
        listOf(
            RandomOption(10, ItemEnchantment.MENDING),
            RandomOption(25, ItemEnchantment.UNBREAKING_1),
            RandomOption(20, ItemEnchantment.UNBREAKING_2),
            RandomOption(15, ItemEnchantment.UNBREAKING_3),
            RandomOption(0, ItemEnchantment.CURSE_OF_VANISHING),
            RandomOption(25, ItemEnchantment.EFFICIENCY_1),
            RandomOption(20, ItemEnchantment.EFFICIENCY_2),
            RandomOption(15, ItemEnchantment.EFFICIENCY_3),
            RandomOption(10, ItemEnchantment.EFFICIENCY_4),
            RandomOption(5, ItemEnchantment.EFFICIENCY_5),
        )
    );
}
