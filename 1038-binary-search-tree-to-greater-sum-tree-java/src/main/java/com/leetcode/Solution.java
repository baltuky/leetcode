package com.leetcode;

/**
 * Title: 1038. Binary Search Tree to Greater Sum Tree
 * Link: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * Difficulty: Medium
 * Solver: Yauheni Baltukha (baltuky)
 * <p>
 * Given the root of a binary search tree with distinct values, modify it so that every node has a new value equal to
 * the sum of the values of the original tree that are greater than or equal to node.val.
 * <p>
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Example 1:
 * <pre>
 *         4
 *      /    \
 *     1      6
 *    / \    / \
 *   0   2  5   7
 *        \      \
 *         3      8
 * </pre>
 * Input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * <p>
 * Note:
 * The number of nodes in the tree is between 1 and 100.
 * Each node will have value between 0 and 100.
 * The given tree is a binary search tree.
 */

public class Solution {
    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            int val = root.val + modify(root.right, 0);
            modify(root.left, val);
            root.val = val;
        }
        return root;
    }

    private int modify(TreeNode root, int val) {
        if (root == null) {
            return val;
        }

        int value = root.val + modify(root.right, val);
        root.val = value;
        return modify(root.left, value);
    }
}