package com.leetcode;

/**
 * Title: 82. Remove Duplicates from Sorted List II
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * Difficulty: Medium
 * <p>
 * Solver: Yauheni Baltukha (baltuky)
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * <p>
 * Example 2:
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                final int val = current.val;

                while (current != null && current.val == val)
                    current = current.next;

                if (prev == null)
                    head = current;
                else
                    prev.next = current;

                continue;
            }
            prev = current;
            current = current.next;
        }

        return head;
    }
}
