package com.adventofcode
package day1.part1

object Main extends App {

  val fileName = "input.txt"
  private val bufferedSource = scala.io.Source.fromFile(fileName)
  var storage: Storage = new Storage()

  for (line <- bufferedSource.getLines()) {
    val splits: Array[String] = line.split(" ").filter(s => s.nonEmpty)
    if (splits.length == 2) {
      storage.add(Integer.parseInt(splits.apply(0)), 0)
      storage.add(Integer.parseInt(splits.apply(1)), 1)
    }
  }
  bufferedSource.close()

  println(storage)
  println(storage.totalDistance())

}
