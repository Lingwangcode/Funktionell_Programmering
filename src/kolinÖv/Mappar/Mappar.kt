package kolinÖv.Mappar

import kolinÖv.Djur.Djur

var djur1 = Djur("Hund", 4, "Vove")
var djur2 = Djur("Katt", 4, "Kattis")
var djur3 = Djur("Katt", 4, "Miao")
var djur4 = Djur("Spindel", 6, "Spin")
var djur5 = Djur("Spindel", 6, "Svin")
var djur6 = Djur("Orm", 0, "Ormis")

var djurList = mutableListOf(djur1, djur2, djur3, djur4, djur5, djur6)

var djurMapSort = djurList.groupBy { it.sort }

fun <T> printOut(map: Map<(T), List<Djur>>){ map.map { println("${it.key}, ${it.value.map { it.namn }}") }}
fun <T> printOutDistinct(map: Map<(T), List<Djur>>){ map.map { println("${it.key}, ${it.value.map { it.sort }.distinct()}") }}

var djurMapBen = djurList.groupBy { it.antalBen }


fun filter(map: Map<String, List<Djur>>) : Map<String, List<Djur>>{ // TODO
    //return map.filterKeys { ${it.startWith("K")}}
    return map
}

fun finnsKatt(map: Map<String, List<Djur>>) : Boolean{
   return map.any{(key, _) -> key.equals("Katt")}
}


fun main() {

    printOut(djurMapSort)
    println()
    printOutDistinct(djurMapBen)
    println()
    printOut( djurMapSort.filterKeys { it.startsWith("K") })
    println()
    printOutDistinct(djurMapSort.filterValues { it.size == 1 })
    println()
    println( djurMapSort.any { (key, _) -> key.equals("Katt")})
    println()
    println( djurMapSort.all { (key, _) -> key.equals("Katt")})

}

