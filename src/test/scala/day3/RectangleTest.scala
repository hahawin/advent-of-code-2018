package day3

import org.scalatest.FunSuite

class RectangleTest extends FunSuite {

  test("testGetLocationsInside_when2by2AtOrigin_thenReturn4Locations") {
    val rectangle = new Rectangle(1, new Location(0,0), 2,2)
    val locations = Set(new Location(0,0), new Location(1,0), new Location(0,1), new Location(1,1))
    assert(rectangle.getLocationsInside() == locations)
  }

  test("testGetLocationsInside_when3by2At14_thenReturn6Locations") {
    val rectangle = new Rectangle(1, new Location(1,4), 3,2)
    val locations = Set(new Location(1,4), new Location(2,4), new Location(3,4),
      new Location(1,5), new Location(2,5), new Location(3,5))
    assert(rectangle.getLocationsInside() == locations)
  }

}
