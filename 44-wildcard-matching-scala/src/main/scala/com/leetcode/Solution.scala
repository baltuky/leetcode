package com.leetcode

object Solution {
  private val Asterisk = '*'
  private val QuestionMark = '?'

  private val DefaultMemoValue: Int = 0
  private val TrueMemoValue: Int = 1
  private val FalseMemoValue: Int = -1

  def isMatch(s: String, p: String): Boolean =
    isMatch(Array.ofDim[Int](s.length + 1, p.length + 1), s, normalize(p), 0, 0)

  private def isMatchWithMemo(memo: Array[Array[Int]], s: String, p: String, i: Int, j: Int): Boolean =
    if (memo(i)(j) == DefaultMemoValue) {
      val result = isMatch(memo, s, p, i, j)
      memo(i)(j) = if (result) TrueMemoValue else FalseMemoValue
      result
    }
    else memo(i)(j) == TrueMemoValue

  private def isMatch(memo: Array[Array[Int]], s: String, p: String, i: Int, j: Int): Boolean = {
    if (i == s.length) j == p.length || p.substring(j) == Asterisk.toString
    else if (j == p.length) i == s.length
    else if (p.charAt(j) == Asterisk) isMatchWithMemo(memo, s, p, i + 1, j) || isMatchWithMemo(memo, s, p, i, j + 1)
    else (p.charAt(j) == s.charAt(i) || p.charAt(j) == QuestionMark) && isMatchWithMemo(memo, s, p, i + 1, j + 1)
  }

  private def normalize(pattern: String) = pattern.foldRight("") { case (ch, acc) =>
    if (ch == Asterisk && !acc.headOption.contains(Asterisk) || ch != Asterisk) ch + acc
    else acc
  }
}
