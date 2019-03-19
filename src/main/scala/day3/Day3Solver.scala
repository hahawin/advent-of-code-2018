package day3

import collection.mutable.{ HashMap, MultiMap, Set }

class Day3Solver {
  def solvePartA(rectangles : List[Rectangle]): Int = {
    val locationMap = new HashMap[Location, Set[Rectangle]] with MultiMap[Location, Rectangle]
    rectangles.foreach(rectangle => locationMap.addBinding(rectangle.location, rectangle))
    0
  }

  def solvePartB(): Unit = {

  }
}
