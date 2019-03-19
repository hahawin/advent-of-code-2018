package day2

import org.scalatest.{FunSuite, PrivateMethodTester}

class Day2SolverTest extends FunSuite with PrivateMethodTester {

  val solver: Day2Solver = new Day2Solver

  test("testPartA_whenExampleFromProblemStatement_thenReturn 12") {
    val example = Array("abcdef", "abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab")

    assert(solver.solvePartA(example.toStream) == 12)
  }

  test("testPartB_whenExampleFromProblemStatement_thenReturn fgij") {
    val example = Array("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz")
    assert(solver.solvePartB(example.toList) == "fgij")
  }

  test("testCheckForDoublesAndTriplets_givenNoMatches_thenNoMatchesFound") {
    assert(solver.checkForDoublesAndTriplets("") == (false, false))
    assert(solver.checkForDoublesAndTriplets("a") == (false, false))
    assert(solver.checkForDoublesAndTriplets("abc") == (false, false))
    assert(solver.checkForDoublesAndTriplets("byifazcrtmnls") == (false, false))
  }

  test("testCheckForDoublesAndTriplets_givenSingleDouble_thenFindDoubleAndNoTriple") {
    assert(solver.checkForDoublesAndTriplets("aa") == (true, false))
    assert(solver.checkForDoublesAndTriplets("txntvjy") == (true, false))
    assert(solver.checkForDoublesAndTriplets("uevxntvjy") == (true, false))
  }

  test("testCheckForDoublesAndTriplets_givenMultipleDoubles_thenFindDoubleAndNoTriple") {
    assert(solver.checkForDoublesAndTriplets("aabb") == (true, false))
    assert(solver.checkForDoublesAndTriplets("txyntvjy") == (true, false))
  }

  test("testCheckForDoublesAndTriplets_givenSingleTriple_thenFindTripleAndNoDouble") {
    assert(solver.checkForDoublesAndTriplets("aaa") == (false, true))
    assert(solver.checkForDoublesAndTriplets("txtntvj") == (false, true))
  }

  test("testCheckForDoublesAndTriplets_givenMultipleTriples_thenFindTripleAndNoDouble") {
    assert(solver.checkForDoublesAndTriplets("aaabbb") == (false, true))
    assert(solver.checkForDoublesAndTriplets("teextnetvj") == (false, true))
  }

  test("testCheckForDoublesAndTriplets_givenMultipleTriplesAndDoubles_thenFindTripleAndDouble") {
    assert(solver.checkForDoublesAndTriplets("addacabcbb") == (true, true))
    assert(solver.checkForDoublesAndTriplets("teevxtxnetvj") == (true, true))
  }

  test("getMatchingChars_givenEqualString_returnsFullString") {
    assert(solver.getMatchingChars("abcdefgh", "abcdefgh") == "abcdefgh")
  }

  test("getMatchingChars_givenStringWithdifferences_returnsOnlyMatchingString") {
    assert(solver.getMatchingChars("abcdefgj", "abcdefgh") == "abcdefg")
    assert(solver.getMatchingChars("abklefgh", "abcdefgh") == "abefgh")
    assert(solver.getMatchingChars("fbcdffgf", "abcdefgh") == "bcdfg")
  }

}
