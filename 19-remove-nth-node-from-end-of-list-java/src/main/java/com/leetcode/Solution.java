package com.leetcode;

/**
 * Title: 19. Remove Nth Node From End of List
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Difficulty: Medium
 * <p>
 * Solver: Yauheni Baltukha (baltuky)
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * <p>
 * Note:
 * Given n will always be valid.
 * <p>
 * Follow up:
 * Could you do this in one pass?
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode fast = head, slow = head;

        while (n >= 0 && fast != null) {
            n--;
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (n >= 0)
            head = head.next;
        else if (slow.next != null)
            slow.next = slow.next.next;

        return head;
    }
}
