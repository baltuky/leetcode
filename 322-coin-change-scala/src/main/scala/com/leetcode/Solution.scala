package com.leetcode

object Solution {
  private val NoSolutionsResult: Int = -1

  object DynamicProgrammingSolution {
    def coinChange(coins: Array[Int], amount: Int): Int = {
      val dp = Array.fill(amount + 1)(Int.MaxValue)
      dp(0) = 0
      for (coin <- coins) {
        (coin to amount).foreach { x =>
          dp(x) = math.min(dp(x), if (dp(x - coin) == Int.MaxValue) Int.MaxValue else dp(x - coin) + 1)
        }
      }
      if (dp(amount) == Int.MaxValue) NoSolutionsResult else dp(amount)
    }
  }

  /**
    * Brute-force solution.
    * Function recursively tries to find necessary combination of coins that forms necessary amount of money.
    * Afterwards takes the solution with minimal number of coins.
    *
    * Too slow solution, LeetCode throws Time Limit Exceeded.
    */
  object BruteForceRecursiveSolution {
    private val ZeroSolutionsResult: Int = 0

    def coinChange(coins: Array[Int], amount: Int): Int = {
      def calculate(amount: Int): Int =
        if (amount < 0) Int.MaxValue
        else if (amount == 0) ZeroSolutionsResult
        else {
          var numberOfCoins = Int.MaxValue
          for (coin <- coins) {
            val result = calculate(amount - coin)

            if (result != Int.MaxValue) {
              numberOfCoins = math.min(numberOfCoins, result + 1)
            }
          }
          numberOfCoins
        }

      val result = calculate(amount)
      if (result == Int.MaxValue) NoSolutionsResult else result
    }
  }

  def coinChange(coins: Array[Int], amount: Int): Int = DynamicProgrammingSolution.coinChange(coins, amount)
}
