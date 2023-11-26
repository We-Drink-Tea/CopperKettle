package dev.wedrinktea

import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object CopperKettle : ModInitializer {
    const val MOD_ID = "copper-kettle"

    val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)

    override fun onInitialize() {
        LOGGER.info("Initializing...")
    }

    fun onInitializeLate(args: HashMap<String, Any>) {
        if (args.containsKey("server") || args.containsKey("client")) {
            LOGGER.info(args.values.joinToString(" "))
        }
    }
}