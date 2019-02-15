package com.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Codec {
    private static final Character EMPTY_NODE_PLACEHOLDER_CHAR = '#';
    private static final String EMPTY_NODE_PLACEHOLDER = EMPTY_NODE_PLACEHOLDER_CHAR.toString();
    private static final String DELIMITER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode node) {
        final Queue<TreeNode> queue = new LinkedList<>(Collections.singletonList(node));

        final StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            final TreeNode head = queue.poll();
            if (head == null) {
                result.append(EMPTY_NODE_PLACEHOLDER);
            } else {
                result.append(Integer.toString(head.val));
                queue.add(head.left);
                queue.add(head.right);
            }
            result.append(DELIMITER);
        }

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty() || EMPTY_NODE_PLACEHOLDER_CHAR.equals(data.charAt(0))) {
            return null;
        }

        final StringTokenizer tokenizer = new StringTokenizer(data, DELIMITER);
        final TreeNode root = new TreeNode(Integer.valueOf(tokenizer.nextToken()));

        final Queue<TreeNode> nodes = new LinkedList<>(Collections.singleton(root));
        while (tokenizer.hasMoreTokens()) {

            final TreeNode head = nodes.poll();

            final String leftValue = tokenizer.nextToken();
            final String rightValue = tokenizer.nextToken();

            if (!EMPTY_NODE_PLACEHOLDER.equals(leftValue)) {
                final TreeNode left = new TreeNode(Integer.valueOf(leftValue));
                head.left = left;
                nodes.add(left);
            }

            if (!EMPTY_NODE_PLACEHOLDER.equals(rightValue)) {
                final TreeNode right = new TreeNode(Integer.valueOf(rightValue));
                head.right = right;
                nodes.add(right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
