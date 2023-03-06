package Inlämning2

import java.io.File
import java.lang.IllegalArgumentException

//AOC dag3 2022 version1

//del 1
val data = File("src/Inlämning2/aoc3.txt").readLines()

var list1 = mutableListOf<String>()
var list2 = mutableListOf<String>()

fun separateList(list: List<String>){
    for (str in list){
        var str1 = str.substring(0, str.length / 2)
        list1.add(str1)
        var str2 = str.substring(str.length/2)
        list2. add(str2)
    }

}

fun findItemType(list1: MutableList<String>,list2: MutableList<String> ) : MutableList<Char> {
    var charList = mutableListOf<Char>()
    for (i in list1.indices){
        val str1 = list1[i]
        val str2 = list2[i]
        for (char in str1)
            if (str2.contains(char)) {
                charList.add(char)
                break
            }

    }
    return charList

}

fun countPriority(list: List<Char>) : Int{
    var priorityList = mutableListOf<Int>()
    for (char in list){
        var priority = 0
        when (char) {
            in 'a'..'z' -> {
                priority = char - 'a' +1
                priorityList.add(priority)
            }
            in 'A' .. 'Z' -> {
                priority = char - 'A' + 27
                priorityList.add(priority)
            }
            else -> {
                println("Something went wrong")
            }
        }
    }
    return priorityList.sum()
}

//del 2
var newList1 = mutableListOf<String>()
var newList2 = mutableListOf<String>()
var newList3 = mutableListOf<String>()

fun separateList2(list: List<String>){
    for ((i, element) in list.withIndex()){
        when(i % 3){
            0 -> newList1.add(list[i])
            1 -> newList2.add(list[i])
            2-> newList3.add(list[i])
        }
    }

}

fun findItemType2(newList1:List<String>, newList2:List<String>, newList3:List<String>) : List<Char> {
    val charList2 = mutableListOf<Char>()
    for ((i, item) in newList1.withIndex()){
        var str1 = newList1[i]
        var str2 = newList2[i]
        var str3 = newList3[i]

        for (char in str1){
            if (str2.contains(char) && str3.contains(char)){
                charList2.add(char)
                break
            }
        }
    }
    return charList2
}


fun main() {
    separateList(data)
    println( countPriority(findItemType(list1, list2)))
    separateList2(data)
    println( countPriority(findItemType2(newList1, newList2, newList3)))

    println("Här kommer resultat av version 2")
    println(solutionPart1())

    println(solutionPart2())
}

// version 2

fun Char.priority(): Int =
    when(this){
        in 'a'..'z' -> (this - 'a') + 1
        in 'A'..'Z' -> (this - 'A') + 27
        else -> throw IllegalArgumentException()
    }

//tar en lista av strängar och returnerar det första gemensamma char som finns i alla strängar
fun List<String>.sharedItem():Char = map { it.toSet() }.reduce{left, right -> left intersect right}.first()

//hitta gemensamma char i första halva och andra halva sträng
fun String.getItem(): Char = listOf(substring(0..length/2), substring(length/2)).sharedItem()

// del 1
fun solutionPart1(): Int = data.sumOf { it.getItem().priority()}

//del 2
fun solutionPart2(): Int = data.chunked(3).sumOf { it.sharedItem().priority() }

