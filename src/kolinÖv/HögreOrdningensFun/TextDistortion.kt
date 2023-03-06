package kolinÖv.HögreOrdningensFun

fun toUpperCase(s:String) : String {
    return s.toUpperCase()
}

fun removAllDigits(s:String): String{
    return s.filter { it.isLetter() }
}

fun toLowerCase(s:String) : String {
    return s.toLowerCase()
}


fun textDistort(action: (s:String) -> String){
    println("Enter your text: ")
    val svar = readln();
    println(action(svar))
}

fun main() {
    var upperCase: (s: String) -> String = {s -> s.toUpperCase()}
    var lowerCase: (s:String) -> String = ::toLowerCase
    var removDigits: (s:String) -> String = { s -> s.filter { it.isLetter() }}
    textDistort(upperCase)
    textDistort(::toLowerCase)
    textDistort(removDigits)
}