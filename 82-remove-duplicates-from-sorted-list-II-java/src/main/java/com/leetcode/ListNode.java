package com.leetcode;

public class ListNode {
    final int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if (next == null)
            return Integer.toString(val);
        return val + "->" + next.toString();
    }
}
