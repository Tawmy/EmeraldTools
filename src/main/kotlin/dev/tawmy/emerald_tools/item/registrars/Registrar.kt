package dev.tawmy.emerald_tools.item.registrars

import dev.tawmy.emerald_tools.EmeraldTools
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

abstract class Registrar {
    abstract fun registerItems()

    protected fun registerItem(name: String, item: Item): Item =
        Registry.register(Registries.ITEM, Identifier(EmeraldTools.MOD_ID, name), item)
}