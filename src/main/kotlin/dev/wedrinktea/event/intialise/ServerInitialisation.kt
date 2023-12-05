package dev.wedrinktea.event.intialise

fun interface ServerInitialisation {
    fun onServerInitialisation(args: Map<String, Any?>)
}