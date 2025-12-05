package com.adventofcode
package day3.part1

import scala.util.matching.Regex

case class Parser(pattern: Regex) {

  def parse(line: String): Seq[(Int, Int)] = {
    pattern.findAllIn(line).collect {
      case pattern(n1, n2) => (n1.toInt, n2.toInt)
    }.toSeq
  }

}
