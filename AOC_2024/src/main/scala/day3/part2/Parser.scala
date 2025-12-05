package com.adventofcode
package day3.part2

import scala.collection.mutable.ListBuffer
import scala.util.matching.Regex

case class Parser(pattern: Regex) {

  def parse(line: String): Seq[(Int, Int)] = {

    var isEnabled = true
    val results: ListBuffer[(Int, Int)] = ListBuffer[(Int, Int)]()

    val matches = pattern.findAllMatchIn(line)

    matches.foreach { m =>
      m.matched match {
        case "do()" => isEnabled = true
        case "don't()" => isEnabled = false
        case _ => if (isEnabled) {
          val n1 = m.group(1).toInt
          val n2 = m.group(2).toInt
          results.addOne((n1, n2))
        }
      }
    }
    results.toSeq
  }

}
