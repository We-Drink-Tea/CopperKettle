package dev.wedrinktea.event

import net.minecraft.resource.ResourcePackProfile
import java.util.function.Consumer

fun interface LoadClientResources {
    fun loadClientResources(onLoad: Consumer<ResourcePackProfile>)
}