package day2

import java.io.File
import java.util.*

private val fileName = "C:\\Users\\thoma\\IdeaProjects\\Advent of Code 2024\\src\\day2\\Day2Input"
private val lines: MutableList<MutableList<Int>> = mutableListOf()

fun main() {
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
    var count: Int = 0
    for(line in lines){
        var safe = true;
        val ind0 = line[0]
        val ind1 = line[1]
        if (ind0 > ind1 && ind0 - ind1 < 4){
            for (i in 2 until line.size ){
                if (line[i] >= line[i-1] || line[i-1] - line[i] > 3){
                    safe = false
                    break
                }
            }
        } else if (ind0 < ind1 && ind1 - ind0 < 4){
            for (i in 2 until line.size ){
                if (line[i] <= line[i-1] || line[i] - line[i-1] > 3){
                    safe = false
                    break
                }
            }
        } else {
            safe = false;
        }
        if (safe) {
            count++
        }
    }
    println("Part 1: $count")
}

private fun part2(){}

fun main(args: Array<String>) {
    main();
}