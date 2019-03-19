package day3

class Location(val x: Int, val y: Int) {


  def canEqual(other: Any): Boolean = other.isInstanceOf[Location]

  override def equals(other: Any): Boolean = other match {
    case that: Location =>
      (that canEqual this) &&
        x == that.x &&
        y == that.y
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(x, y)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
