package com.leetcode

object Solution {
  def maxCount(m: Int, n: Int, ops: Array[Array[Int]]): Int =
    if (ops == null || ops.length == 0) m * n
    else {
      val (row, col) = ops.foldLeft((Integer.MAX_VALUE, Integer.MAX_VALUE)) {
        case (acc, op) => (math.min(acc._1, op(0)), math.min(acc._2, op(1)))
      }
      row * col
    }
}
