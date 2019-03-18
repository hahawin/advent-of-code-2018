package day2

import output.OutputFormatter.formatSolutions
import parsing.FileParser


object Day2Solver extends App {
  private val boxIds: Stream[String] = FileParser.readFileToLines("day2.txt")
  private val solver = new Day2Solver()

  println(formatSolutions(solver.solvePartA(boxIds), 0, 2))
}

class Day2Solver {
  def solvePartA(boxIds : Stream[String]) : Int = {
    val (doubles, triples) = boxIds.map(boxIds => checkForDoublesAndTriplets(boxIds))
      .map(booleanTuple => (boolToInt(booleanTuple._1), boolToInt(booleanTuple._2)))
      .reduce((tuple1, tuple2) => (tuple1._1 + tuple2._1, tuple1._2 + tuple2._2))

    doubles * triples
  }

  def checkForDoublesAndTriplets(boxId : String) : (Boolean, Boolean) = {
    val charCounts = boxId.groupBy(char => char).mapValues(sameChars => sameChars.length).values
    (charCounts.exists(value => value == 2), charCounts.exists(value => value == 3))
  }

  def boolToInt(bool: Boolean): Int = {
    if(bool) 1 else 0
  }
}
