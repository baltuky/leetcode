package com.leetcode

object App {
  def main(args: Array[String]): Unit = {
    List(
      List((84, 250), (0, 0), (1, 0), (0, -70), (0, -70), (1, -1), (21, 10), (42, 90), (-42, -230)),
      List((0, 0), (1, 65536), (65536, 0)),
      List((0, 0)),
      List((0, 0), (0, 0)),
      List((1, 1), (1, 1), (1, 1)),
      List((1, 1), (3, 2), (5, 3), (4, 1), (2, 3), (1, 4)),
      List((1, 1), (2, 2), (3, 3))
    ).foreach(points =>
      println(s"maxPoints($points) = ${Solution.maxPoints(points.map(p => Point(p._1, p._2)).toArray)}"))
  }
}
