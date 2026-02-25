package org.jetbrains.kotlin.public.course.collections

fun main() {
//    val valuesInt = iterableWithKillSwitch(listOf(0, 1, 2, 3, 4, 5).iterator()) { it >= 3 }
//    // should print 0, 1, 2
//    valuesInt.forEach { println(it) }
//
//    val valuesString = iterableWithKillSwitch(listOf(
//        "I like Kotlin",
//        "I like",
//        "I",
//        "I like",
//        "I like Kotlin"
//    ).iterator()) { it.split(" ").size < 2 }
//    // should print only the first two elements
//    valuesString.forEach { println(it) }
}

// Implement the function iterableWithKillSwitch
// The function should accept the original iterator and condition when to stop. When first element satisfies killSwitch condition, iteration should stop
// The returned iterator should produce elements from the original iterator until the killSwitch condition is met