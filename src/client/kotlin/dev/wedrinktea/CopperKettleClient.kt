package dev.wedrinktea

import net.fabricmc.api.ClientModInitializer

object CopperKettleClient : ClientModInitializer {
    override fun onInitializeClient() {
        CopperKettle.onInitializeLate(hashMapOf("client" to "Late Initialize Client..."))
    }
}