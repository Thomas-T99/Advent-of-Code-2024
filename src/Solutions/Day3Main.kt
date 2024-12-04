package Solutions

import java.io.File
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

private val fileName = "C:\\Users\\thoma\\IdeaProjects\\Advent of Code 2024\\Inputs\\Day3Input"
private var input: String = ""

fun day3Main(){
    readFile(fileName)
    part1()
    part2()
}

private fun readFile(fileName: String) {
    input = File(fileName).readText()
}

private fun part1(){
    val mulPat = Pattern.compile("mul[(][0-9]{1,3},[0-9]{1,3}[)]")
    val listOfMul: MutableList<String> = mutableListOf()
    val matcher = mulPat.matcher(input)
    while (matcher.find()) {
        listOfMul.add(matcher.group())
    }
    var total = 0
    for(mul in listOfMul) {
        val numPat = Pattern.compile("[0-9]{1,3}")
        val matcher = numPat.matcher(mul)
        matcher.find()
        val no1 = Integer.parseInt(matcher.group())
        matcher.find()
        val no2 = Integer.parseInt(matcher.group())
        total += no1 * no2
    }
    println("Part 1: $total")
}

private fun part2(){

}

fun main(args: Array<String>) {
    day3Main()
}