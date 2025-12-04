package com.adventofcode
package day2.part2

case class Report(list: List[Int]) {

  private def checkStrictlySafe(l: List[Int]): Boolean = {
    if (l.length < 2) return true

    val diffs = l.zip(l.tail).map { case (a, b) => b - a }

    val allIncreasing = diffs.forall(d => d >= 1 && d <= 3)
    val allDecreasing = diffs.forall(d => d <= -1 && d >= -3)

    allIncreasing || allDecreasing
  }

  def isSafe(): Boolean = {
    if (checkStrictlySafe(list)) return true
    list.indices.exists { indexToRemove =>
      val (before, after) = list.splitAt(indexToRemove)
      val dampenedList = before ++ after.tail

      checkStrictlySafe(dampenedList)
    }
  }

}