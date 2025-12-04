package com.adventofcode
package day2.part1

import scala.annotation.tailrec

case class Report (list: List[Int]) {
  require(list.length >= 2, "The list must contain at least two elements")

  val increasing: Boolean = list.head < list.apply(1)

  @tailrec
  final def isSafe(currentList: List[Int] = list): Boolean = {
    currentList match {
      case x :: y :: tail => increasing match {
        case false => x > y && x - y <= 3 && isSafe(y :: tail)
        case true => x < y && y - x <= 3 && isSafe(y :: tail)
      }
      case _ => true
    }
  }

}
