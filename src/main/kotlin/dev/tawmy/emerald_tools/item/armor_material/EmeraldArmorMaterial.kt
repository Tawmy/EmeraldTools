package dev.tawmy.emerald_tools.item.armor_material

import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.Items
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Util
import java.util.*

class EmeraldArmorMaterial : ArmorMaterial {
    companion object {
        val INSTANCE = EmeraldArmorMaterial()
    }

    private val baseDurability = Util.make(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java)) { x ->
        x[ArmorItem.Type.BOOTS] = 13
        x[ArmorItem.Type.LEGGINGS] = 15
        x[ArmorItem.Type.CHESTPLATE] = 16
        x[ArmorItem.Type.HELMET] = 11
    } // same values as ArmorMaterials.java

    private val protectionAmounts = Util.make(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java)) { x ->
        x[ArmorItem.Type.BOOTS] = 2
        x[ArmorItem.Type.LEGGINGS] = 5
        x[ArmorItem.Type.CHESTPLATE] = 6
        x[ArmorItem.Type.HELMET] = 2
    } // same values as IRON from ArmorMaterials.java

    private val durabilityMultiplier = 24 // midpoint between iron and diamond; ArmorMaterials.java
    private val enchantability = 10 // DIAMOND; IRON would be 9
    private val equipSound = SoundEvents.ITEM_ARMOR_EQUIP_IRON
    private val repairIngredient = Ingredient.ofItems(Items.EMERALD)
    private val toughness = 0F
    private val knockbackResistance = 0F

    override fun getDurability(type: ArmorItem.Type) = baseDurability[type]!! * this.durabilityMultiplier

    override fun getProtection(type: ArmorItem.Type) = protectionAmounts[type]!!

    override fun getEnchantability() = enchantability

    override fun getEquipSound(): SoundEvent = equipSound

    override fun getRepairIngredient(): Ingredient = repairIngredient

    override fun getName() = "emerald"

    override fun getToughness() = toughness

    override fun getKnockbackResistance() = knockbackResistance
}