package dev.tawmy.emerald_tools.item.registrars

import dev.tawmy.emerald_tools.item.*
import dev.tawmy.emerald_tools.item.tool_material.EmeraldToolMaterial
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.ItemGroups
import net.minecraft.item.Items
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

class EmeraldToolRegistrar : Registrar() {

    private val emeraldSword = registerItem("emerald_sword",
        EmeraldSword(EmeraldToolMaterial.INSTANCE, 3, -2.4F, FabricItemSettings()))

    private val emeraldAxe = registerItem("emerald_axe",
        EmeraldAxe(EmeraldToolMaterial.INSTANCE, 5F, -3F, FabricItemSettings()))

    private val emeraldPickaxe = registerItem("emerald_pickaxe",
        EmeraldPickaxe(EmeraldToolMaterial.INSTANCE, 1, -2.8F, FabricItemSettings()))

    private val emeraldShovel = registerItem("emerald_shovel",
        EmeraldShovel(EmeraldToolMaterial.INSTANCE, 1.5F, -3F, FabricItemSettings()))

    private val emeraldHoe = registerItem("emerald_hoe",
        EmeraldHoe(EmeraldToolMaterial.INSTANCE, -2, -1F, FabricItemSettings()))

    override fun registerItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
            .register(ItemGroupEvents.ModifyEntries { x ->
                x.addAfter(Items.GOLDEN_SWORD, emeraldSword)
                x.addAfter(Items.GOLDEN_AXE, emeraldAxe)
            })
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
            .register(ItemGroupEvents.ModifyEntries { x ->
                x.addAfter(Items.GOLDEN_HOE, emeraldShovel)
                x.addAfter(emeraldShovel, emeraldPickaxe)
                x.addAfter(emeraldPickaxe, emeraldAxe)
                x.addAfter(emeraldAxe, emeraldHoe)
            })
    }
}