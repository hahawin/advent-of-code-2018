package day4

import day4.GuardDutyLogParser.parseToGuardEvents
import parsing.FileParser

object Day4Solver extends App{
  val lines = FileParser.readFileToLines("day4.txt")
  private val guardEvents = parseToGuardEvents(lines)
  val solver = new Day4Solver
}

class Day4Solver {

}
