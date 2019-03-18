package day2

import java.util.stream.Collectors

import output.OutputFormatter.formatSolutions
import parsing.FileParser


object Day2Solver extends App {
  private val boxIds: Stream[String] = FileParser.readFileToLines("day2.txt")
  private val solver = new Day2Solver()

  println(formatSolutions(solver.solvePartA(boxIds).toString,
    solver.solvePartB(boxIds.toList),
    2))
}

class Day2Solver {
  def solvePartA(boxIds: Stream[String]): Int = {
    val (doubles, triples) = boxIds
      .map(boxIds => checkForDoublesAndTriplets(boxIds))
      .map(booleanTuple => (boolToInt(booleanTuple._1), boolToInt(booleanTuple._2)))
      .reduce((tuple1, tuple2) => (tuple1._1 + tuple2._1, tuple1._2 + tuple2._2))

    doubles * triples
  }

  def solvePartB(boxIds: List[String]): String = {
    for (boxId1Index <- boxIds.indices; boxId2Index <- boxId1Index + 1 until boxIds.length) {
      val matchingChars = getMatchingChars(boxIds(boxId1Index), boxIds(boxId2Index))
      if(matchingChars.length == boxIds(boxId1Index).length-1) return matchingChars
    }
    ""
  }

  def checkForDoublesAndTriplets(boxId: String): (Boolean, Boolean) = {
    val charCounts = boxId.groupBy(char => char)
      .values
      .map(sameChars => sameChars.length)
    (charCounts.exists(value => value == 2), charCounts.exists(value => value == 3))
  }

  private def boolToInt(bool: Boolean): Int = {
    if (bool) 1 else 0
  }

  def getMatchingChars(boxId1: String, boxId2: String): String = {
    boxId1.
      toStream
      .zip(boxId2.toStream)
      .filter(tuple => tuple._1 == tuple._2)
      .map(tuple => tuple._1)
      .mkString("")
  }
}
