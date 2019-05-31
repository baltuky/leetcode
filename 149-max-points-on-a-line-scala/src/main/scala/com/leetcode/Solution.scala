package com.leetcode

object Solution {

  class Line(var a: Point, var b: Point) {
    private val xDenominator = (b.x - a.x).toLong
    private val yDenominator = (b.y - a.y).toLong

    def contains(p: Point): Boolean =
      yDenominator * (p.x - a.x) - xDenominator * (p.y - a.y) == 0
  }

  private def isEqualPoints(a: Point)(b: Point) = a.x == b.x && a.y == b.y

  private def findNumberOfBelongingPoints(start: Point, end: Point, points: Array[Point]) =
    if (isEqualPoints(start)(end)) points.count(isEqualPoints(start))
    else {
      val line = new Line(start, end)
      points.foldLeft(0) {
        case (count, p) => if (line.contains(p)) count + 1 else count
      }
    }

  def maxPoints(points: Array[Point]): Int =
    if (points.length < 3) points.length
    else {
      val memo = scala.collection.mutable.Map[((Int, Int), (Int, Int)), Int]()
      points.combinations(2).foldLeft(0) {
        case (max, pair) =>
          val (start, end) = (pair(0), pair(1))

          val key = ((start.x, start.y), (end.x, end.y))

          val n = memo.get(key).orElse(memo.get(key.swap))
            .getOrElse(findNumberOfBelongingPoints(start, end, points))

          memo.update(key, n)
          memo.update(key.swap, n)

          if (max < n) n else max
      }
    }
}