package day1

import scala.collection.immutable.Stream.continually
import scala.collection.mutable
import scala.io.Source

object Day1Solver extends App {

  private val lines: Traversable[Int] = Source.fromResource("day1.txt")
    .getLines()
    .toStream
    .map(line => line.toInt)

  private val solver = new Day1Solver
  println(
    s"""##### Day 01 Solution #####
       |# Part A: ${solver.solvePartA(lines)}
       |# Part B: ${solver.solvePartB(lines)}
    """.stripMargin
  )

}

class Day1Solver {

  def solvePartA(inputLines: Traversable[Int]): Int = {
    inputLines.sum
  }

  def solvePartB(inputLines: Traversable[Int]): Int = {
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
