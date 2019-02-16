package com.leetcode

object App {
  def main(args: Array[String]): Unit = {
    List(
      (15, Array(1, 2, 3, 4)),
      (0, Array(1, 2, 3, 4)),
      (3, Array(2))
    ).foreach { case (amount, coins) =>
      val parametersString = s"(${coins.mkString("{", ",", "}")},$amount)"
      println(s"Solution.coinChange$parametersString = ${Solution.coinChange(coins, amount)}")
      println(s"Solution.coinChangeRecursive($parametersString) = ${Solution.coinChangeRecursive(coins, amount)}")
      println("================================================================================")
    }
  }
}
