package org.jetbrains.kotlin.public.course.collections.lecture

fun main() {
    val listResult = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        .filter { it % 2 == 0 }
        .map { println(it); it.toDouble() }
        .take(2)
    
    val sequenceResult = sequenceOf(1, 2, 3, 4, 5, 6, 7, 8)
        .filter { it % 2 == 0 }
        .map { println(it); it.toDouble() }
        .take(2)
    
    println(listResult)
    println(sequenceResult)
//    sequenceResult.forEach { 
//        it.toString()
//    }
}