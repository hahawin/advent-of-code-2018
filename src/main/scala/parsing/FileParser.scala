package parsing

import scala.io.Source

object FileParser {

  def readFileToString(inputResource: String): String = {
    Source.fromResource(inputResource).mkString
  }

  def readFileToLines(inputResource: String): Iterator[String]= {
    Source.fromResource(inputResource)
      .getLines()
  }

}
