package dev.tawmy.emerald_tools.item.registrars

import dev.tawmy.emerald_tools.item.tool_material.EmeraldToolMaterial
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.*

class EmeraldToolRegistrar : Registrar() {

    private val emeraldSword = registerItem(
        "emerald_sword",
        SwordItem(EmeraldToolMaterial.INSTANCE, 3, -2.4F, FabricItemSettings())
    )

    private val emeraldAxe = registerItem(
        "emerald_axe",
        AxeItem(EmeraldToolMaterial.INSTANCE, 5F, -3F, FabricItemSettings())
    )

    private val emeraldPickaxe = registerItem(
        "emerald_pickaxe",
        PickaxeItem(EmeraldToolMaterial.INSTANCE, 1, -2.8F, FabricItemSettings())
    )

    private val emeraldShovel = registerItem(
        "emerald_shovel",
        ShovelItem(EmeraldToolMaterial.INSTANCE, 1.5F, -3F, FabricItemSettings())
    )

    private val emeraldHoe = registerItem(
        "emerald_hoe",
        HoeItem(EmeraldToolMaterial.INSTANCE, -2, -1F, FabricItemSettings())
    )

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