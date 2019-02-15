package com.leetcode

object Solution {

  def isValid(s: String): Boolean = {
    val stack = scala.collection.mutable.Stack[Char]()
    for (ch <- s) {
      if (ch == '(' || ch == '[' || ch == '{')
        stack.push(ch)
      else if (stack.nonEmpty) {
        val head = stack.pop()
        if ((ch == ')' && head != '(') || (ch == ']' && head != '[') || (ch == '}' && head != '{'))
          return false
      }
      else return false
    }
    stack.isEmpty
  }
}
