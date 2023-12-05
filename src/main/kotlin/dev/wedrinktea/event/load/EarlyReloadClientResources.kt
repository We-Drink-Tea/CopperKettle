package dev.wedrinktea.event.load

import net.minecraft.resource.ResourceManager

fun interface EarlyReloadClientResources {
    fun onEarlyReloadClientResources(resourceManager: ResourceManager)
}