package dev.tawmy.emerald_tools.item

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterial
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class EmeraldSword(material: ToolMaterial, attackDamage: Int, attackSpeed: Float, settings: Settings) :
    SwordItem(material, attackDamage, attackSpeed, settings) {

    override fun use(world: World?, playerEntity: PlayerEntity, hand: Hand?): TypedActionResult<ItemStack?>? {
        playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0f, 1.0f)
        return TypedActionResult.success(playerEntity.getStackInHand(hand))
    }
}