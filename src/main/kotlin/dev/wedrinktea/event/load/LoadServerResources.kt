package dev.wedrinktea.event.load

import net.minecraft.resource.ResourcePackProfile
import java.util.function.Consumer

fun interface LoadServerResources {
    fun loadServerResources(onLoad: Consumer<ResourcePackProfile>)
}