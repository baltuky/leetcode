package com.leetcode

object Solution {
  def arrayNesting(nums: Array[Int]): Int = nums.indices.foldLeft(0) {
    case (longest, i) =>
      if (nums(i) >= 0) {
        var index = i
        var depth = 0
        while (nums(index) >= 0) {
          depth += 1
          val nextIndex = nums(index)
          nums(index) = -1
          index = nextIndex
        }
        math.max(longest, depth)
      }
      else longest
  }
}
