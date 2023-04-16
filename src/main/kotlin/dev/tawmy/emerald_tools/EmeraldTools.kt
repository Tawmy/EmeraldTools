package dev.tawmy.emerald_tools

import dev.tawmy.emerald_tools.item.registrars.EmeraldArmorRegistrar
import dev.tawmy.emerald_tools.item.registrars.EmeraldToolRegistrar
import net.fabricmc.api.ModInitializer


@Suppress("UNUSED")
class EmeraldTools : ModInitializer {
    companion object{
        const val MOD_ID = "emerald_tools"
    }

    override fun onInitialize() {
        EmeraldToolRegistrar().registerItems()
        EmeraldArmorRegistrar().registerItems()

        println("Example mod has been initialized.")
    }
}