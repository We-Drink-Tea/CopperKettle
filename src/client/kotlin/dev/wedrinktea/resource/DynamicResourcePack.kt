package dev.wedrinktea.resource

import dev.wedrinktea.event.load.LoadEvents
import net.minecraft.resource.ResourcePack
import net.minecraft.resource.ResourceType
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import java.io.ByteArrayInputStream

class DynamicResourcePack(
    id: Identifier,
    title: Text,
    alwaysEnabled: Boolean,
    description: Text,
    pinned: Boolean = false
) : DynamicPackBase(id, title, alwaysEnabled, description, pinned) {
    init {
        LoadEvents.LOAD_CLIENT_RESOURCES.register { packs ->
            packs.accept(createProfile(this))
        }
    }

    override fun findResources(
        type: ResourceType,
        namespace: String,
        prefix: String,
        consumer: ResourcePack.ResultConsumer
    ) {
        if (type == ResourceType.CLIENT_RESOURCES && namespace == id.namespace) {
            resources.entries.filter {
                it.key.namespace == namespace && it.key.path.startsWith(prefix)
            }
                .forEach { (id, data) ->
                    consumer.accept(id) { ByteArrayInputStream(data) }
                }
        }
    }

    fun addItemTexture(name: String, data: ByteArray) {
        resources[id] = data
    }

    fun addBlockTexture(name: String, data: ByteArray) {
        resources[id] = data
    }
}