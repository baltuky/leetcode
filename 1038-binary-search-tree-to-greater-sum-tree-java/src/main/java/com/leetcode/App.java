package com.leetcode;

public class App {
    public static void main(String[] args) {
        final Solution solution = new Solution();

        solve(solution, tree(4,
                tree(1,
                        node(0),
                        tree(2,
                                null,
                                node(3)
                        )
                ),
                tree(6,
                        node(5),
                        tree(7,
                                null,
                                node(8)
                        )
                )
        ));
    }

    private static void solve(Solution solution, TreeNode tree) {
        System.out.println(solution.bstToGst(tree));
    }

    private static TreeNode node(int i) {
        return new TreeNode(i);
    }

    private static TreeNode tree(int value, TreeNode left, TreeNode right) {
        final TreeNode node = node(value);
        node.left = left;
        node.right = right;
        return node;
    }
}
