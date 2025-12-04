package com.adventofcode
package day1.part2

class Storage {

  var rightMap: Map[Int, Int] = Map()
  var leftList: List[Int] = List()
  val calculator: Calculator = new Calculator()

  def add(leftElem: String, rightElem: String): Unit = {
    val intLeftElem: Int = Integer.parseInt(leftElem)
    val intRightElem: Int = Integer.parseInt(rightElem)
    val oldValue = rightMap.getOrElse(intRightElem, 0)
    rightMap = rightMap + (intRightElem -> (oldValue + 1))
    leftList = leftList :+ intLeftElem
  }



  def totalSimilarity(): Int = {
    for (value <- leftList) {
      val occurences = rightMap.getOrElse(value, 0)
      calculator.addToCounter(value, occurences, _ * _)
    }
    calculator.counter
  }

  override def toString: String = {
    s"Storage:\n\tLeft List : ${leftList.mkString(", ")} \n\tRight Map : ${rightMap.mkString(", ")}"
  }

}
