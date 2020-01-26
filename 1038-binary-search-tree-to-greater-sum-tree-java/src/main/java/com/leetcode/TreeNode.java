package com.leetcode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return toString(this, "\n\t");
    }

    private String toString(TreeNode tree, String prefix) {
        if (tree == null)
            return "<null>";
        return String.format(
                "[%s%d, %sL -> %s %sR -> %s%s]",
                prefix,
                tree.val,
                prefix,
                toString(tree.left, prefix + "\t"),
                prefix,
                toString(tree.right, prefix + "\t"),
                prefix
        );
    }
}
