package com.leetcode

object App {
  def main(args: Array[String]): Unit = {
    List(
      "()",
      "()[]{}",
      "([)]",
      "{[]}",
      "]",
      "["
    ).foreach(s => println(s"Solution.isValid('$s') = ${Solution.isValid(s)}"))
  }
}
