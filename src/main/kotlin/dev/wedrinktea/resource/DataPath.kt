package dev.wedrinktea.resource

enum class DataPath(private val path: String) {
    LOOT_TABLES("loot_tables/"),
    LOOT_TABLES_BLOCKS("loot_tables/blocks/"),
    TAGS("tags/"),
    TAGS_BLOCKS("tags/blocks/"),
    TAGS_ENTITY_TYPES("tags/entity_types/"),
    TAGS_FLUIDS("tags/fluids/"),
    TAGS_ITEMS("tags/items/"),
    RECIPES("recipes/"),
}