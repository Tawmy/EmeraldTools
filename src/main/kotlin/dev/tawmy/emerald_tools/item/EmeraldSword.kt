package dev.tawmy.emerald_tools.item

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class EmeraldSword(settings: Settings) : Item(settings) {

    override fun use(world: World?, playerEntity: PlayerEntity, hand: Hand?): TypedActionResult<ItemStack?>? {
        playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0f, 1.0f)
        return TypedActionResult.success(playerEntity.getStackInHand(hand))
    }
}