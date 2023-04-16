package dev.tawmy.emerald_tools.item.registrars

import dev.tawmy.emerald_tools.item.armor_material.EmeraldArmorMaterial
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.ArmorItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.item.Items


class EmeraldArmorRegistrar : Registrar() {
    private val emeraldHelmet = registerItem(
        "emerald_helmet",
        ArmorItem(EmeraldArmorMaterial.INSTANCE, ArmorItem.Type.HELMET, Item.Settings())
    )

    private val emeraldChestplate = registerItem(
        "emerald_chestplate",
        ArmorItem(EmeraldArmorMaterial.INSTANCE, ArmorItem.Type.CHESTPLATE, Item.Settings())
    )

    private val emeraldLeggings = registerItem(
        "emerald_leggings",
        ArmorItem(EmeraldArmorMaterial.INSTANCE, ArmorItem.Type.LEGGINGS, Item.Settings())
    )

    private val emeraldBoots = registerItem(
        "emerald_boots",
        ArmorItem(EmeraldArmorMaterial.INSTANCE, ArmorItem.Type.BOOTS, Item.Settings())
    )

    override fun registerItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
            .register(ItemGroupEvents.ModifyEntries { x ->
                x.addAfter(Items.GOLDEN_BOOTS, emeraldHelmet)
                x.addAfter(emeraldHelmet, emeraldChestplate)
                x.addAfter(emeraldChestplate, emeraldLeggings)
                x.addAfter(emeraldLeggings, emeraldBoots)
            })
    }
}