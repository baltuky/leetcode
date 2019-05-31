package com.leetcode;

/**
 * Title: 25. Reverse Nodes in k-Group
 * Link: https://leetcode.com/problems/reverse-nodes-in-k-group/
 * Difficulty: Hard
 * <p>
 * Solver: Yauheni Baltukha (baltuky)
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return new RecursiveSolution().reverseKGroup(head, k);
    }

    private class RecursiveSolution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null)
                return null;

            int n = k;
            ListNode node = head;
            while (node != null && --n > 0)
                node = node.next;

            if (n == 0) {
                ListNode current = head;
                ListNode prev = null;

                for (int i = 0; i < k; i++) {
                    ListNode next = current.next;
                    current.next = prev;
                    prev = current;
                    current = next;
                }
                head.next = reverseKGroup(current, k);
                return prev;
            }
            return head;
        }
    }
}