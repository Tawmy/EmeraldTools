package dev.tawmy.emerald_tools.item.tool_material

import net.minecraft.item.Items
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient

class EmeraldToolMaterial : ToolMaterial {
    companion object {
        val INSTANCE = EmeraldToolMaterial()
    }

    override fun getMiningLevel() = 2 // ToolMaterials.IRON.miningLevel

    override fun getDurability() = 905 // ToolMaterials.DIAMOND.durability + ToolMaterials.IRON.durability / 2

    override fun getMiningSpeedMultiplier() = 6.0F // ToolMaterials.IRON.miningSpeedMultiplier

    override fun getAttackDamage() = 3.0F // ToolMaterials.DIAMOND.attackDamage

    override fun getEnchantability() = 12 // IRON 14, DIAMOND 10

    override fun getRepairIngredient(): Ingredient = Ingredient.ofItems(Items.EMERALD)
}