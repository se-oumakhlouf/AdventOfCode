package com.adventofcode
package day1.part1

class Storage {

  var storage: (List[Int], List[Int]) = (List(), List())
  val calculator: Calculator = new Calculator()

  def add(elem: Int, index: Int): Unit = {
    storage = index match {
      case 0 => (storage._1 :+ elem, storage._2)
      case 1 => (storage._1, storage._2 :+ elem)
      case _ => storage
    }
  }

  def getMins: (Int, Int) = {
    (storage._1.min, storage._2.min)
  }

  private def removeFirst(list: List[Int], elem: Int): List[Int] = {
    val index = list.indexOf(elem)
    if (index != -1) {
      val (before, after) = list.splitAt(index)
      before ++ after.tail
    } else {
      list
    }

  }

  def deleteMins(min1: Int, min2: Int): Unit = {
    storage = (
      removeFirst(storage._1, min1),
      removeFirst(storage._2, min2)
    )
  }

  def totalDistance(): Int = {
    for (i <- storage._1.indices) {
      val (min1, min2) = getMins
      calculator.addToCounter(min1, min2)
      deleteMins(min1, min2)
    }
    calculator.counter
  }

  override def toString: String = {
    val l1: String = storage._1.mkString(", ")
    val l2: String = storage._2.mkString(", ")

    s"Storage:\n\t$l1 \n\t$l2"
  }

}
