package day4

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


object GuardDutyLogParser {

  implicit def dateTimeOrdering: Ordering[LocalDateTime] = Ordering.fromLessThan(_ isBefore _)

  def parseToGuardEvents(eventLines: List[String]): List[GuardEvent] = {
    val patternWithoutGuardId = """\[(1518-\d\d-\d\d \d\d:\d\d)\] (.+)""".r
    val patternWithGuardId = """\[(1518-\d\d-\d\d \d\d:\d\d)\] Guard #(\d+) (.+)""".r
    val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    eventLines.toStream
      .map {
        case patternWithGuardId(time, guardId, eventText) => (LocalDateTime.parse(time, dateTimeFormatter), eventText, guardId.toInt)
        case patternWithoutGuardId(time, eventText) => (LocalDateTime.parse(time, dateTimeFormatter), eventText, -1)
      }.sortBy(tuple => tuple._1)
      .scan((LocalDateTime.MIN, "", 1))((leftTuple, rightTuple) => fillInGuardId(leftTuple, rightTuple))
      .drop(1)
      .map(tuple => new GuardEvent(GuardEventType.parseGuardEvent(tuple._2), tuple._1, tuple._3))
      .toList

  }

  private def fillInGuardId(leftTuple: (LocalDateTime, String, Int), rightTuple: (LocalDateTime, String, Int)) = {
    (rightTuple._1, rightTuple._2, if (rightTuple._3 == -1) leftTuple._3 else rightTuple._3)
  }
}
