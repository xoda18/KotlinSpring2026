package org.jetbrains.kotlin.public.course.generics.practice.task.projections.task1

/* Projections #1

Implement a system of news agencies with the following rules:
 - There exists only regular and elite agencies
 - Regular can accept any scoop, elite - only elite scoops
 - Elite reporter can deliver only elite scoops, but to any agency
 - Regular reporter can deliver any scoop, but only to regular agencies
**/

interface Sender<in T> {
    fun send(item: T)
}

class MailBox<T>(private var box: T? = null): Sender<T> {
    override fun send(item: T) {
        printCurrentBoxState()
        println("Sending the box: $item!")
        box = item
    }
}

class Postman<T>(private val mailboxes: List<Sender<in T>>): Sender<T> {
    override fun send(item: T) {
        mailboxes.forEach { it.send(item) }
    }
}

interface Scoop

open class Normal(open val info: String) : Scoop

fun main() {
    val postcardStorage = MailBox<Postcard>()
    val expressPostcardStorage = MailBox<ExpressPostcard>()

    val expressPostcard = ExpressPostcard(15, "Serbia")
    val postcard = Postcard("Germany")

    val topRatedPostman = Postman(listOf(postcardStorage, expressPostcardStorage as Sender<ExpressPostcard>))
    val juniorPostman = Postman(listOf(postcardStorage))

    topRatedPostman.send(expressPostcard)
    //topRatedPostman.send(postcard)

    juniorPostman.send(postcard)
    juniorPostman.send(expressPostcard)
}