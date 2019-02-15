package com.leetcode;

public class App {
    public static void main(String[] args) {
        final Codec codec = new Codec();

        final TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        final String serialized = codec.serialize(root);
        System.out.println(serialized);

        final TreeNode tree = codec.deserialize(serialized);
        System.out.println(tree);
    }
}
