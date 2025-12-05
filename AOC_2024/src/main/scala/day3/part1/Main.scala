package com.adventofcode
package day3.part1

import scala.util.matching.Regex

object Main extends App {

  val fileName = "test.txt"
  private val bufferedSource = scala.io.Source.fromFile(fileName)
  val calculator: Calculator = Calculator()
  private val parser: Parser = Parser(new Regex("""mul\((\d{1,3}),(\d{1,3})\)""")
  )

  for (line <- bufferedSource.getLines()) {
    val digits: Seq[(Int, Int)] = parser.parse(line)
    calculator.apply(digits, _ * _)
  }

  bufferedSource.close()
  println(s"Result: ${calculator.count}")

}
