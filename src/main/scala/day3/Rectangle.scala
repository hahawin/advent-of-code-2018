package day3

import scala.collection.mutable._

class Rectangle(val id: Int, val location: Location, val width: Int, val height: Int) {

  def getLocationsInside(): Set[Location] = {
    val locations = new HashSet[Location]()
    for(x <- location.x until location.x + width; y <- location.y until location.y + height) {
      locations.add(new Location(x, y))
    }
    locations
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[Rectangle]

  override def equals(other: Any): Boolean = other match {
    case that: Rectangle =>
      (that canEqual this) &&
        id == that.id &&
        location == that.location &&
        width == that.width &&
        height == that.height
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(id, location, width, height)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"Rectangle #$id, $location, ${width}x$height)"
}
