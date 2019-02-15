package com.leetcode

object App {
  def main(args: Array[String]): Unit = {
    List(
      ("acd", "ab*cd"),
      ("a", ".*.."),
      ("abcdef", "abc.*"),
      ("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s")
    ).foreach {
      case (input, pattern) => println(s"isMatch($input,$pattern) = ${Solution.isMatch(input, pattern)}")
    }
  }
}
