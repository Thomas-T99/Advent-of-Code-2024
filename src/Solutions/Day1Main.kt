package Solutions

import java.io.File
import java.util.*


private val leftList: MutableList<Int> = mutableListOf()
private val rightList: MutableList<Int> = mutableListOf()
private val rightMap: MutableMap<Int, Int> = mutableMapOf()

private fun day1Main() {
    readFile("C:\\Users\\thoma\\IdeaProjects\\Advent of Code 2024\\Inputs\\Day1Input")
    part1()
    part2()
}

private fun readFile (fileName: String){
    File(fileName).forEachLine {
        val scan = Scanner(it)
        leftList.add(scan.nextInt())
        val right = scan.nextInt()
        rightList.add(right)
        if(rightMap.containsKey(right)){
            val count = rightMap[right]
            rightMap[right] = count!! + 1
        } else {
            rightMap[right] = 1
        }
    }
}

private fun part1(){
    leftList.sort()
    rightList.sort()
    var total = 0
    for (i in 0 until leftList.size) {
        total += Math.abs(leftList[i] - rightList[i])
    }
    println("Part 1: " + total +"n")
}

private fun part2(){
    var total = 0
    for (i in leftList) {
        if (rightMap.contains(i)){
            total += (rightMap[i]!! * i)
        }
    }
    println("Part 2: $total")
}

fun main(args: Array<String>) {
    day1Main()
}