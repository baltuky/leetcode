package com.leetcode;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public ListNode(int x, ListNode next) {
        this(x);
        this.next = next;
    }
}
