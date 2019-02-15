package com.leetcode.recursive;

import com.leetcode.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    private static final String EMPTY_NODE_PLACEHOLDER = "#";
    private static final String DELIMITER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        final StringBuilder sb = new StringBuilder();
        serialize(sb, root);
        return sb.toString();
    }

    private void serialize(StringBuilder accumulator, TreeNode node) {
        if (node == null) {
            accumulator.append(EMPTY_NODE_PLACEHOLDER).append(DELIMITER);
        } else {
            accumulator.append(node.val).append(DELIMITER);
            serialize(accumulator, node.left);
            serialize(accumulator, node.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(new LinkedList<>(Arrays.asList(data.split(DELIMITER))));
    }

    private TreeNode deserialize(Queue<String> queue) {
        String value = queue.poll();
        if (value == null || EMPTY_NODE_PLACEHOLDER.equals(value)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(value));
            node.left = deserialize(queue);
            node.right = deserialize(queue);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
