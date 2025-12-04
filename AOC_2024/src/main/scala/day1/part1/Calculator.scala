package com.adventofcode
package day1.part1

class Calculator (var counter: Int = 0) {

  def addToCounter(x: Int, y: Int): Int = {
    val res = x - y
    res match {
      case value if value < 0 => counter += value.abs
      case value => counter += value
    }
    counter
  }

}
