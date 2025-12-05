package com.adventofcode
package day3.part2

case class Calculator (var count: Int = 0) {


  def apply(seq: Seq[(Int, Int)], f: (Int, Int) => Int): Int = {
    for (digits <- seq) {
      apply(digits._1, digits._2, f)
    }
    count
  }

  def apply(x: Int, y: Int, f: (Int, Int) => Int): Int = {
    count += f(x, y)
    count
  }
}
