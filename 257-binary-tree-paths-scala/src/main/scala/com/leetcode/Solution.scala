package com.leetcode

/**
  * Definition for a binary tree node.
  */
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object TreeNode {
  def apply(v: Int, left: TreeNode, right: TreeNode): TreeNode = {
    val node = new TreeNode(v)
    node.left = left
    node.right = right
    node
  }

  def apply(v: Int): TreeNode = apply(v, null, null)
}

// ================================================================================
// ================================================================================

object Solution {
  def binaryTreePaths(root: TreeNode): List[String] = dfs(root)

  /**
    * Non-recursive solution using DFS
    */
  private def dfs(root: TreeNode): List[String] =
    if (root == null) Nil
    else {
      val paths = scala.collection.mutable.ListBuffer.empty[String]
      val stack = scala.collection.mutable.Stack((root, StringBuilder.newBuilder))

      while (stack.nonEmpty) {
        val (node, builder) = stack.pop()

        val path = (if (builder.isEmpty) builder else builder.clone().append("->")).append(node.value)

        if (node.left == null && node.right == null)
          paths.append(path.result())

        if (node.left != null) stack.push((node.left, path))
        if (node.right != null) stack.push((node.right, path))
      }

      paths.toList
    }

  /**
    * Recursive solution
    */
  private def tracePath(acc: List[Int], root: TreeNode): List[String] =
    if (root == null) Nil
    else if (root.left == null && root.right == null)
      List((acc ::: List(root.value)).mkString("->"))
    else {
      val v = acc ::: List(root.value)
      tracePath(v, root.left) ::: tracePath(v, root.right)
    }
}
