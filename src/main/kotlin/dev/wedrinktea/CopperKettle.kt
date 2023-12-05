package dev.wedrinktea

import dev.wedrinktea.event.intialise.ClientInitialisation
import dev.wedrinktea.event.intialise.InitialisationEvents
import dev.wedrinktea.event.intialise.LateInitialisation
import dev.wedrinktea.event.intialise.ServerInitialisation
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object CopperKettle : ModInitializer {
    const val MOD_ID = "copper-kettle"

    val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)

    init {
        InitialisationEvents.CLIENT_INITIALISATION.register(
            ClientInitialisation { args ->
                unpackTest(args)
            }
        )

        InitialisationEvents.SERVER_INITIALISATION.register(
            ServerInitialisation { args ->
                unpackTest(args)
            }
        )

        InitialisationEvents.LATE_INITIALISATION.register(
            LateInitialisation { args ->
                unpackTest(args)
            }
        )
    }

    override fun onInitialize() {
        LOGGER.info("Initializing...")
    }

    private fun unpackTest(args: Map<String, Any?>) {
        if (args.containsKey("Message")) {
            LOGGER.info(args["Message"].toString())
        }
    }
}
