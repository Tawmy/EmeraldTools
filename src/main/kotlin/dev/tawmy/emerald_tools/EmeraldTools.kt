package dev.tawmy.emerald_tools

import dev.tawmy.emerald_tools.item.*
import dev.tawmy.emerald_tools.item.tool_material.EmeraldToolMaterial
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.ModifyEntries
import net.minecraft.item.ItemGroups
import net.minecraft.item.Items
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier


@Suppress("UNUSED")
object EmeraldTools : ModInitializer {
    private const val MOD_ID = "emerald_tools"

    private val EMERALD_SWORD = Registry.register(
        Registries.ITEM, Identifier("emerald_tools", "emerald_sword"),
        EmeraldSword(EmeraldToolMaterial.INSTANCE, 3, -2.4F, FabricItemSettings())
    )

    private val EMERALD_AXE = Registry.register(
        Registries.ITEM, Identifier("emerald_tools", "emerald_axe"),
        EmeraldAxe(EmeraldToolMaterial.INSTANCE, 5F, -3F, FabricItemSettings())
    )

    private val EMERALD_PICKAXE = Registry.register(
        Registries.ITEM, Identifier("emerald_tools", "emerald_pickaxe"),
        EmeraldPickaxe(EmeraldToolMaterial.INSTANCE, 1, -2.8F, FabricItemSettings())
    )

    private val EMERALD_SHOVEL = Registry.register(
        Registries.ITEM, Identifier("emerald_tools", "emerald_shovel"),
        EmeraldShovel(EmeraldToolMaterial.INSTANCE, 1.5F, -3F, FabricItemSettings())
    )

    private val EMERALD_HOE = Registry.register(
        Registries.ITEM, Identifier("emerald_tools", "emerald_hoe"),
        EmeraldHoe(EmeraldToolMaterial.INSTANCE, -2, -1F, FabricItemSettings())
    )

    override fun onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
            .register(ModifyEntries { x ->
                x.addAfter(Items.GOLDEN_SWORD, EMERALD_SWORD)
                x.addAfter(Items.GOLDEN_AXE, EMERALD_AXE)
            })
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
            .register(ModifyEntries { x ->
                x.addAfter(Items.GOLDEN_HOE, EMERALD_SHOVEL)
                x.addAfter(EMERALD_SHOVEL, EMERALD_PICKAXE)
                x.addAfter(EMERALD_PICKAXE, EMERALD_AXE)
                x.addAfter(EMERALD_AXE, EMERALD_HOE)
            })

        println("Example mod has been initialized.")
    }
}