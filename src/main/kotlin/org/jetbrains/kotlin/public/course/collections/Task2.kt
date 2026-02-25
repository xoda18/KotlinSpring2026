package org.jetbrains.kotlin.public.course.collections

fun main() {
//    println(firstRecurring(listOf(2, 5, 1, 2, 3, 5, 1, 2, 4))) // 2
//    println(firstRecurring(listOf("a", "b", "c", "d", "a"))) // a
//    println(firstRecurring(listOf(1, 2, 3, 4, 5))) // null
//    println(firstRecurring(emptyList<Int>())) // null
}

// Implement the function firstRecurring that finds the first element in the list
// that has already appeared earlier in the list.
// For example, in [2, 5, 1, 2, 3, 5, 1, 2, 4], the answer is 2 because
// when we reach the second '2' at index 3, it's the first time we encounter a duplicate.
// The function should work in O(n) time.
