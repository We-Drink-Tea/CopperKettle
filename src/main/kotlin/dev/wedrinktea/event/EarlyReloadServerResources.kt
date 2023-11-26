package dev.wedrinktea.event

import net.minecraft.resource.ResourceManager

fun interface EarlyReloadServerResources {
    fun onEarlyReloadServerResources(resourceManager: ResourceManager)
}