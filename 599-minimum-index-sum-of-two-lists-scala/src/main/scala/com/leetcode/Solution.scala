package com.leetcode

object Solution {
  def findRestaurant(list1: Array[String], list2: Array[String]): Array[String] = {
    val wordsIndices = list1.zipWithIndex.toMap
    val result = scala.collection.mutable.ArrayBuffer.empty[String]
    var minimalSum = Int.MaxValue

    list2.indices.foreach(i =>
      wordsIndices.get(list2(i)).foreach(j =>
        if (i + j <= minimalSum) {
          if (i + j < minimalSum) {
            result.clear()
            minimalSum = i + j
          }
          result.append(list2(i))
        }
      )
    )
    result.toArray
  }
}
