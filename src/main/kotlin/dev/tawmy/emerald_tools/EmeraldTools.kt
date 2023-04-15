package dev.tawmy.emerald_tools

import dev.tawmy.emerald_tools.item.EmeraldSword
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

    override fun onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
            .register(ModifyEntries { x ->
                x.addAfter(Items.GOLDEN_SWORD, EMERALD_SWORD)
            })

        println("Example mod has been initialized.")
    }
}