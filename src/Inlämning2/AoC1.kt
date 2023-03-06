package Inlämning2

import kolinÖv.Mappar.printOut
import java.io.*
import kotlin.math.max

//AoC dag 1. Version 1

fun readFromFileAndCollectToList(): List<String> {
    return File("src/Inlämning2/aoc1.txt").readLines()
}

fun groupingList(list: List<String>): MutableList<MutableList<String>>{
    var calorieList = mutableListOf<MutableList<String>>()
    var tempList = mutableListOf<String>()
    for (s in list){
        if (!s.isEmpty()){
            tempList.add(s)
        }
        else if (s.isEmpty()){
            calorieList .add(tempList)
            tempList = mutableListOf<String>()
        }
    }
    calorieList.add(tempList)
    return calorieList

}

fun countCalories(list: MutableList<MutableList<String>>) {
    //part 1
   val calorieSum = list.map { e -> e.sumOf { it.toInt() } }
    println(calorieSum.max())
    //part 2
    val topThree = calorieSum.sortedDescending().take(3)
    println(topThree.sum())

}

fun main() {

    countCalories(groupingList(readFromFileAndCollectToList()))
    println( parseInput(readFromFile).max())

}

//AoC dag 1. Version 2

val readFromFile = File("src/Inlämning2/aoc1.txt").readText()
private fun parseInput(input: String): List<Int> =
    input
        .trim()
        .split("\n\n")
        .map { group ->
            group.split("\n")
                .mapNotNull { it.toInt() }
                .sum()
        }.sortedDescending()


fun parseInput1(s: String): List<Int> {
    return s.split("\n\n")
            .map { it -> it.lines()
                .filter { it.isNotEmpty() }
                .sumOf { it.toInt() }}
    }







