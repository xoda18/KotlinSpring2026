package org.jetbrains.kotlin.public.course.oop.practice

/*
Presuming we have colors with the following hexes:
 - #FF6B6B (Soft Red / Coral)
 - #FFD93D (Vibrant Yellow)
 - #6BCB77 (Fresh Green)
 - #4D96FF (Bright Blue)
 Come up with some way to satisfy the following requirements:
 1. I want to have a Colour object from which I can get hex, presentable name and R, G and B components separately
 2. I want to be able to get predefined Colour objects by the name only
 */


data class Colour(val hex: String, val presentableName: String) {
    val r: Int
    val g: Int
    val b: Int
    init {
        val (rr, gg, bb) = parseHex(hex)
        r = rr
        g = gg
        b = bb
    }

    companion object {
        fun parseHex(hex: String) : Triple<Int, Int, Int> {
            val r = hex.substring(1, 3).toInt(16)
            val g = hex.substring(3, 5).toInt(16)
            val b = hex.substring(5, 7).toInt(16)
            return Triple(r, g, b)
        }
    }
}

object Colours {
    private val arr: Array<Pair<String, String>> = arrayOf(
        "Soft Red" to "#FF6B6B",
        "Coral" to "#FF6B6B",
        "Vibrant Yellow" to "#FFD93D",
        "Fresh Green" to "#6BCB77",
        "Bright Blue" to "#4D96FF"
    )
    fun get(name: String) = Colour(arr.first { it.first == name }.second, name)
}