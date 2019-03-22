package day3

import output.OutputFormatter.formatSolutions
import parsing.FileParser

import scala.collection.mutable
import scala.collection.mutable.{HashMap, Set}

object Day3Solver extends App{
  val solver = new Day3Solver
  private val rectangles: List[Rectangle] = FileParser.readFileToLines("day3.txt").map(line => RectangleFactory.parseRectangle(line))
  println(formatSolutions(solver.solvePartA(rectangles).toString, solver.solvePartB(rectangles).toString, 3))
}

class Day3Solver {
  def solvePartA(rectangles : List[Rectangle]): Int = {
    val locationMap: _root_.scala.collection.mutable.HashMap[_root_.day3.Location, _root_.scala.collection.mutable.Set[_root_.day3.Rectangle]] with _root_.scala.collection.mutable.MultiMap[_root_.day3.Location, _root_.day3.Rectangle] = constructLocationMap(rectangles)
    locationMap.values.count(value => value.size > 1)
  }

  def hasNoOverlap(rectangle: Rectangle, locationToRectangles: HashMap[Location, Set[Rectangle]]): Boolean = {
    !rectangle.getLocationsInside().filter(location => locationToRectangles(location).size > 1).exists(r => true)
  }

  def solvePartB(rectangles : List[Rectangle]): Int = {
    val locationToRectangles = constructLocationMap(rectangles)
    rectangles.find(rectangle => hasNoOverlap(rectangle, locationToRectangles)).map(rectangle => rectangle.id).get
  }

  private def constructLocationMap(rectangles: List[Rectangle]) = {
    val locationMap = new HashMap[Location, mutable.Set[Rectangle]] with mutable.MultiMap[Location, Rectangle]
    rectangles.foreach(rectangle => rectangle.getLocationsInside().foreach(location => locationMap.addBinding(location, rectangle)))
    locationMap
  }
}
