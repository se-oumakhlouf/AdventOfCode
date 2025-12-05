package com.adventofcode
package day3.part2

import scala.util.matching.Regex

def printDigits(digits: Seq[(Int, Int)]): Unit = {
  digits.foreach(println)
}

object Main extends App {

  val fileName = "input.txt"
  private val bufferedSource = scala.io.Source.fromFile(fileName)
  val calculator: Calculator = Calculator()
  private val parser: Parser = Parser(new Regex("""mul\((\d{1,3}),(\d{1,3})\)|do\(\)|don't\(\)"""))

  val fullText = bufferedSource.getLines().mkString
  bufferedSource.close()

  val digits: Seq[(Int, Int)] = parser.parse(fullText)
  printDigits(digits)
  calculator.apply(digits, _ * _)

  println(s"Result: ${calculator.count}")

}
