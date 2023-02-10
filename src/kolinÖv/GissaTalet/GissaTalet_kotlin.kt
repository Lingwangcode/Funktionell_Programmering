package kolinÖv.GissaTalet

import java.lang.NumberFormatException

fun main() {
    var randomNr = (1..10).random()
    var svar = 0
        while (true) {
            while (true) {
                println("Gissa på ett tal mellan 1 och 10:")
                try {
                    svar = readln()!!.toInt()
                    break
                } catch (e: NumberFormatException) {
                    println("Du måste skriva ett siffra, försök igen")
                }
            }

            if (svar == randomNr) {
                println("Rätt")
                println("Spela igen? j/n")
                var igen = readln()
                if (igen.equals("n")) break
                else randomNr = (1..10).random()
            } else if (svar < randomNr) println("Högre")
            else println("Lägre")
        }

}