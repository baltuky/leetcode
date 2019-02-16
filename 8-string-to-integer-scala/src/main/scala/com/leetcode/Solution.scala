package com.leetcode

import scala.annotation.tailrec

/**
  * Title: 8. String to Integer (atoi)
  * Link: https://leetcode.com/problems/string-to-integer-atoi/
  * Difficulty: Medium
  * <p>
  * Solver: Yauheni Baltukha (baltuky)
  * <p>
  * Implement atoi which converts a string to an integer.
  * The function first discards as many whitespace characters as necessary until the first non-whitespace character is
  * found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical
  * digits as possible, and interprets them as a numerical value.
  *
  * The string can contain additional characters after those that form the integral number, which are ignored and have
  * no effect on the behavior of this function.
  *
  * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
  * exists because either str is empty or it contains only whitespace characters, no conversion is performed.
  *
  * If no valid conversion could be performed, a zero value is returned.
  *
  * Note:
  *
  * Only the space character ' ' is considered as whitespace character.
  * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
  * range: [−231,  231 − 1].
  * If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
  */

object Solution {
  private val MinusSign = '-'
  private val PlusSign = '+'

  def myAtoi(s: String): Int = {
    val input = s.trim

    if (input.isEmpty) 0
    else {

      val (negative, start) =
        if (input.headOption.contains(MinusSign)) (true, 1)
        else if (input.headOption.contains(PlusSign)) (false, 1)
        else (false, 0)

      @tailrec
      def toInt(sum: Long, s: String): Long = s.headOption match {
        case Some(c) if Character.isDigit(c) =>
          val value = sum * 10 + c - '0'

          if (negative && value * (-1) < Integer.MIN_VALUE) Integer.MIN_VALUE
          else if (!negative && Integer.MAX_VALUE < value) Integer.MAX_VALUE
          else toInt(value, s.tail)
        case _ => sum
      }

      toInt(0L, input.substring(start)).toInt * (if (negative) -1 else 1)
    }
  }
}
