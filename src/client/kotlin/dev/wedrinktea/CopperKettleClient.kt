package dev.wedrinktea

import dev.wedrinktea.event.intialise.InitialisationEvents
import net.fabricmc.api.ClientModInitializer

object CopperKettleClient : ClientModInitializer {
    override fun onInitializeClient() {
        InitialisationEvents
            .CLIENT_INITIALISATION
            .invoker()
            .onClientInitialisation(mapOf("Message" to "Client Initialised"))

        InitialisationEvents
            .LATE_INITIALISATION
            .invoker()
            .onLateInitialisation(mapOf("Message" to "Client Late Initialised"))
    }
}