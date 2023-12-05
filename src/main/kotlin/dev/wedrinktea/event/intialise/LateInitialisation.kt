package dev.wedrinktea.event.intialise

fun interface LateInitialisation {
    fun onLateInitialisation(args: Map<String, Any?>)
}