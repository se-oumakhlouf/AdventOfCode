package com.adventofcode
package day2.part1

object Main extends App {

  val fileName = "input.txt"
  private val bufferedSource = scala.io.Source.fromFile(fileName)
  var reports: List[Report] = List()

  for (line <- bufferedSource.getLines()) {
    val splits: List[Int] = line.split(" ").map(Integer.parseInt).toList
    val report: Report = Report(splits)
    reports = reports :+ report
  }

  bufferedSource.close()
//  reports.foreach(report => println(s"$report | isSafe : ${report.isSafe()}"))
  val safeReportCounter: Int = reports.count(report => report.isSafe())
  println(s"Number of safe reports $safeReportCounter")
}
