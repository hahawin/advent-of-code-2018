package day4

import java.time.LocalDateTime

class GuardEvent(val guardEventType: GuardEventType, val time: LocalDateTime, val guardId: Int) {

  override def toString = s"$time Guard #$guardId ${guardEventType.toString}"
}


