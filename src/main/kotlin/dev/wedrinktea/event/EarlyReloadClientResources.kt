package dev.wedrinktea.event

import net.minecraft.resource.ResourceManager

fun interface EarlyReloadClientResources {
    fun onEarlyReloadClientResources(resourceManager: ResourceManager)
}