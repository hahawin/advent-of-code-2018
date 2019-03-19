package day3

import scala.collection.mutable._

class Rectangle(val location: Location, val width: Int, val height: Int) {

  def getLocationsInside(): Set[Location] = {
    val locations = new HashSet[Location]()
    for(x <- location.x until location.x + width; y <- location.y until location.y + height) {
      locations.add(new Location(x, y))
    }
    locations
  }
}
