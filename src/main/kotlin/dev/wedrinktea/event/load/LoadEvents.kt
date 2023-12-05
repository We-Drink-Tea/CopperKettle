package dev.wedrinktea.event.load

import net.fabricmc.fabric.api.event.Event
import net.fabricmc.fabric.api.event.EventFactory

object LoadEvents {
    val EARLY_RELOAD_CLIENT: Event<EarlyReloadClientResources> =
        EventFactory.createArrayBacked(
            EarlyReloadClientResources::class.java
        ) { callbacks: Array<EarlyReloadClientResources> ->
            EarlyReloadClientResources { resourceManager ->
                for (callback in callbacks) {
                    callback.onEarlyReloadClientResources(resourceManager)
                }
            }
        }

    val EARLY_RELOAD_SERVER: Event<EarlyReloadServerResources> =
        EventFactory.createArrayBacked(
            EarlyReloadServerResources::class.java
        ) { callbacks: Array<EarlyReloadServerResources> ->
            EarlyReloadServerResources { resourceManager ->
                for (callback in callbacks) {
                    callback.onEarlyReloadServerResources(resourceManager)
                }
            }
        }

    val LOAD_CLIENT_RESOURCES: Event<LoadClientResources> =
        EventFactory.createArrayBacked(
            LoadClientResources::class.java
        ) { callbacks: Array<LoadClientResources> ->
            LoadClientResources { onLoad ->
                for (callback in callbacks) {
                    callback.loadClientResources(onLoad)
                }
            }
        }

    val LOAD_SERVER_RESOURCES: Event<LoadServerResources> =
        EventFactory.createArrayBacked(
            LoadServerResources::class.java
        ) { callbacks: Array<LoadServerResources> ->
            LoadServerResources { onLoad ->
                for (callback in callbacks) {
                    callback.loadServerResources(onLoad)
                }
            }
        }
}