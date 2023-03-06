package Inlämning2

import java.io.File

//AOC dag2 version 1

val list = File("src/Inlämning2/aoc2.txt").readLines()

fun partOne(list:List<String>){
    var pointList = mutableListOf<Int>()
    for(value in list){
        if (value.equals("A Y")) pointList.add(8)
        else if (value.equals("A X"))pointList.add(4)
        else if (value.equals("A Z"))pointList.add(3)
        else if (value.equals("B Y"))pointList.add(5)
        else if (value.equals("B X"))pointList.add(1)
        else if (value.equals("B Z"))pointList.add(9)
        else if (value.equals("C Y"))pointList.add(2)
        else if (value.equals("C X"))pointList.add(7)
        else if (value.equals("C Z"))pointList.add(6)
        else println("Invalid values in file")

    }
    println(pointList.sum())
}

fun partTwo(list:List<String>){
    var pointList2 = mutableListOf<Int>()
    for(value in list){
        if (value.equals("A Y")) pointList2.add(4)
        else if (value.equals("A X"))pointList2.add(3)
        else if (value.equals("A Z"))pointList2.add(8)
        else if (value.equals("B Y"))pointList2.add(5)
        else if (value.equals("B X"))pointList2.add(1)
        else if (value.equals("B Z"))pointList2.add(9)
        else if (value.equals("C Y"))pointList2.add(6)
        else if (value.equals("C X"))pointList2.add(2)
        else if (value.equals("C Z"))pointList2.add(7)
        else println("Invalid values in file")

    }
    println(pointList2.sum())
}
fun main() {
    //partOne(list)
    //partTwo(list)

    println(solutionPart1)
    println(solutionPart2)
}

//AOC dag2 version 2

val part1 : Map<String, Int> =
    mapOf("A Y" to 2 + 6, "A X" to 1 + 3, "A Z" to 3 + 0,
        "B Y" to 2 + 3, "B X" to 1 + 0, "B Z" to 3 + 6,
        "C Y" to 2 + 0, "C X" to 1 + 6, "C Z" to 3 + 3)

val solutionPart1 = list.sumOf {part1[it] ?: 0 }

val part2 : Map<String, Int> =
    mapOf("A Y" to 1 + 3, "A X" to 3 + 0, "A Z" to 2 + 6,
        "B Y" to 2 + 3, "B X" to 1 + 0, "B Z" to 3 + 6,
        "C Y" to 3 + 3, "C X" to 2 + 0, "C Z" to 1 + 6)

val solutionPart2 = list.sumOf {part2[it] ?: 0 }