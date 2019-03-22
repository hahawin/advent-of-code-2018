package day3

object RectangleFactory {

  def parseRectangle(line: String): Rectangle = {
    val pattern = "#(.+) @ (.+),(.+): (.+)x(.+)".r
    val pattern(id, x, y, width, height) = line
    new Rectangle(id.toInt, new Location(x.toInt, y.toInt), width.toInt, height.toInt)
  }

}
