package de.fuballer.mcendgame.component.dungeon.enemy.generation

import org.bukkit.potion.PotionEffectType

enum class PotionEffect(
    private val type: PotionEffectType,
    private val amplifier: Int,
    private val duration: Int = Int.MAX_VALUE
) {
    STRENGTH_1(PotionEffectType.INCREASE_DAMAGE, 0),
    STRENGTH_2(PotionEffectType.INCREASE_DAMAGE, 1),
    STRENGTH_3(PotionEffectType.INCREASE_DAMAGE, 2),
    STRENGTH_4(PotionEffectType.INCREASE_DAMAGE, 3),
    RESISTANCE_1(PotionEffectType.DAMAGE_RESISTANCE, 0),
    RESISTANCE_2(PotionEffectType.DAMAGE_RESISTANCE, 1),
    RESISTANCE_3(PotionEffectType.DAMAGE_RESISTANCE, 2),
    RESISTANCE_4(PotionEffectType.DAMAGE_RESISTANCE, 3),
    SPEED_1(PotionEffectType.SPEED, 0),
    SPEED_2(PotionEffectType.SPEED, 1),
    SPEED_3(PotionEffectType.SPEED, 2),
    SPEED_4(PotionEffectType.SPEED, 3),
    FIRE_RESISTANCE(PotionEffectType.FIRE_RESISTANCE, 0),
    INVISIBILITY(PotionEffectType.INVISIBILITY, 0),
    ;

    fun getPotionEffect() = org.bukkit.potion.PotionEffect(type, duration, amplifier, false, false)
}
