package com.leetcode;

/**
 * Title: 2. Add Two Numbers
 * Link: https://leetcode.com/problems/add-two-numbers/
 * Difficulty: Medium
 * <p>
 * Solver: Yauheni Baltukha (baltuky)
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * <p>
 * Explanation: 342 + 465 = 807.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return new RecursiveSolution().addTwoNumbers(l1, l2);
    }

    private static class RecursiveSolution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return addTwoNumbers(l1, l2, 0);
        }

        private ListNode addTwoNumbers(ListNode l1, ListNode l2, int curry) {
            if (l1 == null && l2 == null) return curry > 0 ? new ListNode(curry) : null;

            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            int sum = a + b + curry;

            final ListNode node = new ListNode(sum % 10);

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            node.next = addTwoNumbers(l1, l2, sum / 10);

            return node;
        }
    }

    private static class IterativeSolution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode current = new ListNode(0);
            ListNode resultHead = current;
            int curry = 0;
            while (l1 != null || l2 != null) {
                int a = l1 == null ? 0 : l1.val;
                int b = l2 == null ? 0 : l2.val;

                int sum = a + b + curry;
                curry = sum / 10;

                current.next = new ListNode(sum % 10);
                current = current.next;

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }

            if (curry > 0) {
                current.next = new ListNode(curry);
            }

            return resultHead.next;
        }
    }
}
