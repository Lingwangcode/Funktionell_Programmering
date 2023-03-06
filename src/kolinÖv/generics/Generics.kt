package kolinÖv.generics

//övning 9a egen version av funktionen "filter"
fun <T> List<T>.myFilter(predicate: (T) -> Boolean) : List<T>{
    var newList = listOf<T>()
    for (element in this){
        if (predicate(element))
            newList += element
    }
    return newList
}
//övning 9b egen version av funktionen "map"
fun<T> List<T>.myMap(function: (T) -> (T)): List<T>{
    var newList = listOf<T>()
    for (element in this){
        newList += function(element)
    }
    return newList
}
fun main() {
    val list = listOf("hej", "då", "yes", "hej", "hej")
    println( list.myFilter { it == "hej" })

    println(list.myMap { it.toUpperCase() })
    println(list.myMap { "[$it 123]" })


}