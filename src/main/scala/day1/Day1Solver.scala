package day1

import output.OutputFormatter.formatSolutions
import parsing.FileParser.readFileToLines

import scala.collection.immutable.Stream.continually
import scala.collection.mutable

object Day1Solver extends App {

  private val lines: Iterator[Int] = readFileToLines("day1.txt")
    .map(line => line.toInt)
  private val solver = new Day1Solver

  println(formatSolutions(
    solver.solvePartA(lines),
    solver.solvePartB(lines),
    1)
  )

}

class Day1Solver {

  def solvePartA(inputLines: Iterator[Int]): Int = {
    inputLines.sum
  }

  def solvePartB(inputLines: Iterator[Int]): Int = {
    val previousValues = new mutable.HashSet[Int]()
    continually(inputLines.toStream)
      .flatten
      .scan(0)((a: Int, b: Int) => {
        val sum = a + b
        sum
      })
      .dropWhile(p => previousValues.add(p))
      .head
  }
}
