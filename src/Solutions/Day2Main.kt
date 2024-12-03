package Solutions

import java.io.File
import java.util.*

private val fileName = "C:\\Users\\thoma\\IdeaProjects\\Advent of Code 2024\\Inputs\\Day2Input"
private val lines: MutableList<MutableList<Int>> = mutableListOf()

fun day2Main() {
    readFile(fileName)
    part1()
    part2()
}

private fun readFile (fileName: String){
    File(fileName).forEachLine {
        val scan = Scanner(it)
        val line: MutableList<Int> = mutableListOf()
        while (scan.hasNextInt()){
            line.add(scan.nextInt())
        }
        lines.add(line)
    }
}

private fun part1(){
    var count = 0
    for(line in lines){
        if(isSafe(line)){
            count++
        }
    }
    println("Part 1: $count")
}

private fun part2(){
    var count = 0
    for(line in lines){
        for(i in 0 until line.size){
            val newLine = mutableListOf<Int>()
            newLine.addAll(line)
            newLine.removeAt(i)
            if(isSafe(newLine)){
                count++
                break
            }
        }
    }
    println("Part 2: $count")
}

fun isSafe(line: MutableList<Int>): Boolean{
    val safeSetPos = mutableSetOf<Int>(1, 2, 3)
    val safeSetNeg = mutableSetOf<Int>(-1, -2, -3)
    for(i in 1 until line.size){
        safeSetNeg.add(line[i] - line[i - 1])
        safeSetPos.add(line[i] - line[i - 1])
    }
    return (safeSetNeg.size == 3 || safeSetPos.size == 3)
}

fun main(args: Array<String>) {
    day2Main()
}