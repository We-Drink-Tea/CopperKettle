package dev.wedrinktea.server

import dev.wedrinktea.event.intialise.InitialisationEvents
import net.fabricmc.api.DedicatedServerModInitializer

object CopperKettleServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        InitialisationEvents
            .SERVER_INITIALISATION
            .invoker()
            .onServerInitialisation(mapOf("Message" to "Server Initialised"))

        InitialisationEvents
            .LATE_INITIALISATION
            .invoker()
            .onLateInitialisation(mapOf("Message" to "Server Late Initialised"))
    }
}