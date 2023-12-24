package dev.wedrinktea.resource

import net.fabricmc.loader.api.FabricLoader
import net.minecraft.resource.*
import net.minecraft.resource.featuretoggle.FeatureSet
import net.minecraft.resource.metadata.ResourceMetadataReader
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.nio.file.Files

abstract class DynamicPackBase(
    id: Identifier,
    title: Text,
    alwaysEnabled: Boolean,
    description: Text,
    pinned: Boolean
) : ResourcePack {
    init {
        FabricLoader.getInstance().getModContainer(id.namespace).ifPresent { container ->
            container.metadata.getIconPath(512).flatMap(container::findPath).ifPresent { iconPath ->
                changeIcon(Files.readAllBytes(iconPath))
            }
        }
    }

    protected val resources = mutableMapOf<Identifier, ByteArray>()
    private val rootResources = mutableMapOf<String, ByteArray>()

    private val _id = id
    private val _title = title
    private val _alwaysEnabled = alwaysEnabled
    private val _description = description
    private val _pinned = pinned

    val id: Identifier get() = _id
    val title: Text get() = _title
    val alwaysEnabled: Boolean get() = _alwaysEnabled
    val description: Text get() = _description
    val pinned: Boolean get() = _pinned

    fun changeIcon(image: ByteArray) {
        rootResources["pack.png"] = image
    }

    fun addResource(id: Identifier, data: ByteArray) {
        resources[id] = data
    }

    fun addRootResource(name: String, data: ByteArray) {
        rootResources[name] = data
    }

    override fun close() {
    }

    override fun openRoot(vararg segments: String?): InputSupplier<InputStream>? {
        val fileName = segments.joinToString("/")

        return InputSupplier {
            ByteArrayInputStream(rootResources[fileName])
        }
    }

    override fun open(type: ResourceType?, id: Identifier?): InputSupplier<InputStream>? {
        if (!resources.containsKey(id)) {
            return null
        }

        return InputSupplier {
            ByteArrayInputStream(resources[id])
        }
    }

    override fun getNamespaces(type: ResourceType?): MutableSet<String> {
        return mutableSetOf(id.namespace)
    }

    override fun <T : Any?> parseMetadata(metaReader: ResourceMetadataReader<T>?): T? {
        return null
    }

    override fun getName(): String {
        return id.path
    }

    val profile: ResourcePackProfile = ResourcePackProfile.of(
        id.path,
        title,
        alwaysEnabled,
        object : ResourcePackProfile.PackFactory {
            override fun open(name: String?): ResourcePack {
                return this@DynamicPackBase
            }

            override fun openWithOverlays(
                name: String?,
                metadata: ResourcePackProfile.Metadata?
            ): ResourcePack {
                return this@DynamicPackBase
            }
        },
        ResourcePackProfile.Metadata(
            description,
            ResourcePackCompatibility.COMPATIBLE,
            FeatureSet.empty(),
            listOf()
        ),
        ResourcePackProfile.InsertionPosition.TOP,
        pinned,
        ResourcePackSource.BUILTIN
    )
}
