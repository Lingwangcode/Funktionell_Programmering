println("Hello World")

fun helloWorld(){
    println("Hello World!")
}

helloWorld()

fun myInt() = 5

myInt()

fun myInt2() : Int{
    return 5
}
myInt2()

fun myString(s:String, i: Int) : String{
    return "$s $i"
}
myString("Antal: ", 5)

fun myString2(s:String, i:Int) = "$s $i"
myString2("Antal: ", 5)

fun area(h: Int, b: Int) = h*b
area(4, 5)

fun area2(h: Int, b: Int) : Int{
    return h * b
}
area2(4, 5)

fun omKrets(h: Int, b: Int) = 2* (h + b)
omKrets(4, 5)

fun omKrets2(h: Int, b: Int): Int{
    return 2* (h + b)
}
omKrets2(4, 5)

var höjd = 3
var bredd = 6

area(höjd, bredd)
omKrets2(höjd, bredd)

val hight = 3
val length = 6
area(hight, length)
omKrets2(hight,length)
val list = listOf(1, 2, 3, 4, 5)

val n = list.size    // get the size of the list

val first = list.subList(0, (n + 1) / 2)
val second = list.subList((n + 1) / 2, n)

println(first)
println(second)