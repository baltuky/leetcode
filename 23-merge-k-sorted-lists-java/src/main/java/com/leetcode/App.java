package com.leetcode;

public class App {
    public static void main(String[] args) {
        final ListNode[] lists1 = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };

        final ListNode[] lists2 = new ListNode[]{};
        final ListNode[] lists3 = new ListNode[]{
                new ListNode(3),
                new ListNode(2),
                new ListNode(1)
        };
        final ListNode[] lists4 = new ListNode[]{};

        final Solution solution = new Solution();
        final ListNode result = solution.mergeKLists(lists2);

        System.out.println(toString(result));
    }

    private static String toString(ListNode n) {
        ListNode node = n;
        final StringBuilder builder = new StringBuilder();
        if (n == null) {
            builder.append("<null>");
        }
        while (node != null) {
            if (!builder.toString().isEmpty()) {
                builder.append(", ");
            }
            builder.append(node.val);
            node = node.next;
        }
        return builder.toString();
    }
}
