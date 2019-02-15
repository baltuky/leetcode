package com.leetcode

object App {
  def main(args: Array[String]): Unit = {
    val cache = new LRUCache(5)

    cache.put(1, 1)
    cache.put(2, 2)
    cache.put(3, 3)
    cache.put(4, 4)
    cache.put(5, 5)

    cache.get(1)

    cache.put(6, 6)

    println(cache.toString)
  }
}
