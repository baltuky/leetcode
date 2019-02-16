package com.leetcode

object App {
  def main(args: Array[String]): Unit = {
    List(
      " 0000000000012345678",
      "10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459",
      "-2147483647",
      "9223372036854775808",
      "4193 with words",
      " +0 123",
      "+-2",
      "   ",
      "1",
      "+1",
      "   -42",
      "101",
      "words and 987",
      "-91283472332"
    )
      .foreach(s => println(s"Solution.myAtoi('$s'): ${Solution.myAtoi(s)}"))
  }
}
