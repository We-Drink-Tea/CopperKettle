package dev.wedrinktea.event.intialise

fun interface ClientInitialisation {
    fun onClientInitialisation(args: Map<String, Any?>)
}