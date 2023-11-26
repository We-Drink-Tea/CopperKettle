package dev.wedrinktea.server

import dev.wedrinktea.CopperKettle
import net.fabricmc.api.DedicatedServerModInitializer

object CopperKettleServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        // This entrypoint is suitable for setting up server-specific logic, such as registering commands.
        CopperKettle.onInitializeLate(hashMapOf("server" to "Late Initialize Server..."))
    }
}