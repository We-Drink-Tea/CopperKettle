package dev.wedrinktea.event.load

import net.minecraft.resource.ResourceManager

fun interface EarlyReloadServerResources {
    fun onEarlyReloadServerResources(resourceManager: ResourceManager)
}