package dev.wedrinktea.event.intialise

import net.fabricmc.fabric.api.event.Event
import net.fabricmc.fabric.api.event.EventFactory

object InitialisationEvents {
    val CLIENT_INITIALISATION: Event<ClientInitialisation> =
        EventFactory.createArrayBacked(
            ClientInitialisation::class.java
        ) { callbacks: Array<ClientInitialisation> ->
            ClientInitialisation { args ->
                for (callback in callbacks) {
                    callback.onClientInitialisation(args)
                }
            }
        }
    
    val SERVER_INITIALISATION: Event<ServerInitialisation> =
        EventFactory.createArrayBacked(
            ServerInitialisation::class.java
        ) { callbacks: Array<ServerInitialisation> ->
            ServerInitialisation { args ->
                for (callback in callbacks) {
                    callback.onServerInitialisation(args)
                }
            }
        }

    val LATE_INITIALISATION: Event<LateInitialisation> =
        EventFactory.createArrayBacked(
            LateInitialisation::class.java
        ) { callbacks: Array<LateInitialisation> ->
            LateInitialisation { args ->
                for (callback in callbacks) {
                    callback.onLateInitialisation(args)
                }
            }
        }
}