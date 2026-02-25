package org.jetbrains.kotlin.public.course.generics.practice.answer.projections.task1

/* Projections #1

Implement a system of news agencies with the following rules:
 - There exists only regular and elite agencies
 - Regular can accept any scoop, elite - only elite scoops
 - Elite reporter can deliver only elite scoops, but to any agency
 - Regular reporter can deliver any scoop, but only to regular agencies
**/

interface NewsAccepter<in T: Scoop> {
    fun deliverScoop(item: T)
}

class MailBox<T>(private var box: T? = null) : Sender<T> {
    override fun send(item: T) {
        printCurrentBoxState()
        println("Sending the box: $item!")
        box = item
    }

    private fun printCurrentBoxState() {
        if (box != null) {
            println("I have a box: $box!")
        } else {
            println("I have nothing")
        }
    }
}

class Postman<T>(private val mailboxes: List<Sender<T>>) : Sender<T> {
    override fun send(item: T) {
        mailboxes.forEach { it.send(item) }
    }
}

interface Delivery

interface Scoop

open class Normal(open val info: String) : Scoop

data class Sensational(val reward: Int, override val info: String) : Normal(info)

    val expressPostcard = ExpressPostcard(15, "Serbia")
    val postcard = Postcard("Germany")

    val topRatedPostman = Postman(listOf(postcardStorage, expressPostcardStorage as Sender<ExpressPostcard>))
    topRatedPostman.send(expressPostcard)
    //topRatedPostman.send(postcard) // ERROR

    val juniorPostman = Postman(listOf(postcardStorage))
    juniorPostman.send(postcard)
    juniorPostman.send(expressPostcard)
}