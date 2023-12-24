package dev.wedrinktea.resource

enum class ResourcePath(val path: String) {
    TEXTURES("textures/"),
    TEXTURES_BLOCK("${TEXTURES}block/"),
    TEXTURES_ITEM("${TEXTURES}item/"),
    TEXTURES_ENTITY("${TEXTURES}entity/"),
    TEXTURES_ARMOR("${TEXTURES}models/armor/"),
    TEXTURES_PARTICLE("${TEXTURES}particle/"),
    MODELS("models/"),
    MODELS_BLOCK("${MODELS}block/"),
    MODELS_ITEM("${MODELS}item/"),
    TEXTS("texts/"),
    LANG("lang/"),
    BLOCK_STATES("blockstates/"),
}