package dev.wedrinktea.event

import net.minecraft.resource.ResourcePackProfile
import java.util.function.Consumer

fun interface LoadServerResources {
    fun loadServerResources(onLoad: Consumer<ResourcePackProfile>)
}