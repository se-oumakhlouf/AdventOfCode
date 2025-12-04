package com.adventofcode
package day1.part2

object Main extends App {

  val fileName = "input.txt"
  private val bufferedSource = scala.io.Source.fromFile(fileName)
  var storage: Storage = new Storage()

  for (line <- bufferedSource.getLines()) {
    val splits: Array[String] = line.split(" ").filter(s => s.nonEmpty)
    if (splits.length == 2) {
      storage.add(splits.apply(0), splits.apply(1))
    }
  }
  bufferedSource.close()

  println(storage)
  println(storage.totalSimilarity())

}
