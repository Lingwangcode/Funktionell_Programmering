package kolinÖv.ExtensionFunc

import java.util.DoubleSummaryStatistics

class Rectangel (var bredd: Double, var höjd: Double){
    fun area() : Double= bredd * höjd
    fun omkrets() : Double = 2 * (bredd + höjd)

}
fun String.doubleUpp() = "$this, $this"
fun String.printRepeat(i :Int): String {
   var temp = ""
    for (i in 1..i){
        temp += "$this "
    }
    return temp
}

fun main() {
    val rectangel1 = Rectangel(4.0, 5.5)
    val rectangel2 = Rectangel(5.0, 5.6)
    println("Area: ${rectangel1.area()}")
    var omkrets = "Omkrets: ${rectangel1.omkrets()}"
    println(omkrets.doubleUpp())
    println(omkrets.printRepeat(4))

}
