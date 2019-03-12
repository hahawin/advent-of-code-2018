package day2

import org.scalatest.{FunSuite, PrivateMethodTester}

class Day2SolverTest extends FunSuite with PrivateMethodTester{

  val solver : Day2Solver = new Day2Solver


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

}