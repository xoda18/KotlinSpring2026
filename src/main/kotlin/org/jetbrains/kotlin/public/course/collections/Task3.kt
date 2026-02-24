package org.jetbrains.kotlin.public.course.collections

fun main() {
//    val documents = mapOf(
//        "doc1" to listOf("kotlin", "is", "fun"),
//        "doc2" to listOf("java", "is", "also", "fun"),
//        "doc3" to listOf("kotlin", "and", "java", "interop")
//    )
//    val index = buildInvertedIndex(documents)
//    // Expected output (order of words may vary):
//    // kotlin -> [doc1, doc3]
//    // is -> [doc1, doc2]
//    // fun -> [doc1, doc2]
//    // java -> [doc2, doc3]
//    // also -> [doc2]
//    // and -> [doc3]
//    // interop -> [doc3]
//    for ((word, docs) in index) {
//        println("$word -> $docs")
//    }
}

// Implement the function buildInvertedIndex that takes a map of
// document names to their word lists, and returns the "inverted" version:
// a map from each word to the list of documents that contain it.
//
// For example, if "doc1" contains ["kotlin", "fun"] and "doc2" contains ["java", "fun"],
// then "fun" should map to ["doc1", "doc2"].