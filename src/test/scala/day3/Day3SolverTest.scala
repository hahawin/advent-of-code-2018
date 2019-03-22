package day3

import org.scalatest.FunSuite

class Day3SolverTest extends FunSuite {

  val solver = new Day3Solver
  test("testPartA when example from problem statement then return 4") {
    val example = List(
      new Rectangle(1, new Location(1,3), 4,4),
      new Rectangle(2, new Location(3,1), 4,4),
      new Rectangle(3, new Location(5,5), 2,2)
    )

    assert(solver.solvePartA(example) == 4)
  }

  test("testPartA when triple overlap, return overlap") {
    val example = List(
      new Rectangle(1, new Location(1,3), 4,4),
      new Rectangle(2, new Location(3,1), 4,4),
      new Rectangle(3, new Location(4,4), 2,2)
    )

    assert(solver.solvePartA(example) == 6)
  }

  test("testPartB when example from problem, return 3") {
    val example = List(
      new Rectangle(1, new Location(1,3), 4,4),
      new Rectangle(2, new Location(3,1), 4,4),
      new Rectangle(3, new Location(5,5), 2,2)
    )

    assert(solver.solvePartB(example) == 3)
  }

}
