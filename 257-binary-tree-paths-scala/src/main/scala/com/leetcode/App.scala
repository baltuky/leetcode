package com.leetcode

object App {
  def main(args: Array[String]): Unit = {
    List(
      TreeNode(1, TreeNode(2, null, TreeNode(5)), TreeNode(3))
    ).foreach(t => println(s"Solution.binaryTreePaths(...) = ${Solution.binaryTreePaths(t)}"))
  }
}
