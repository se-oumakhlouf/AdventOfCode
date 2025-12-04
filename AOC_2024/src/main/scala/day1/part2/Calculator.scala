package com.adventofcode
package day1.part2

class Calculator (var counter: Int = 0) {

  def addToCounter(x: Int, y: Int, f: (Int, Int) => Int): Int = {
    val res = f(x, y)
    res match {
      case value if value < 0 => counter += value.abs
      case value => counter += value
    }
    counter
  }

}
