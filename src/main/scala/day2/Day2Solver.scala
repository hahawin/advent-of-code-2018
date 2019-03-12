package day2


object Day2Solver extends App {



}

class Day2Solver {

  def checkForDoublesAndTriplets(boxId : String) : (Boolean, Boolean) = {
    val charCounts = boxId.groupBy(char => char).mapValues(sameChars => sameChars.length).values
    (charCounts.exists(value => value == 2), charCounts.exists(value => value == 3))
  }
}
