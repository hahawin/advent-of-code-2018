package output

object OutputFormatter {

  def formatSolutions(solutionA: String, solutionB: String, day: Int): String = {
    s"""##### Day $day Solution #####
       |# Part A: $solutionA
       |# Part B: $solutionB
    """.stripMargin
  }

  def formatSolutions(solutionA: Int, solutionB: Int, day: Int): String = {
    formatSolutions(solutionA.toString, solutionB.toString, day)
  }
}
