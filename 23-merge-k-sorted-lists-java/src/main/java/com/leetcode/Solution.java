package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Title: 23. Merge k Sorted Lists
 * Link: https://leetcode.com/problems/merge-k-sorted-lists/
 * Difficulty: Hard
 * <p>
 * Solver: Yauheni Baltukha (baltuky)
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        ListNode current = null;
        ListNode start = null;

        final PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(value -> value.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        ListNode node;
        while ((node = removeMin(queue)) != null) {
            if (start == null) {
                start = current = node;
            } else {
                current.next = node;
                current = current.next;
            }
        }

        return start;
    }

    private ListNode removeMin(final PriorityQueue<ListNode> lists) {
        final ListNode list = lists.poll();
        if (list != null && list.next != null) {
            lists.add(list.next);
        }
        return list;
    }

    private static class RemoveMinValueLinearSolution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode current = null;
            ListNode start = null;

            ListNode node;
            while ((node = removeMin(lists)) != null) {
                if (start == null) {
                    start = current = node;
                } else {
                    current.next = node;
                    current = current.next;
                }
            }

            return start;
        }

        private ListNode removeMin(ListNode[] lists) {
            ListNode minNode = null;
            int minNodeListIndex = 0;

            for (int i = 0; i < lists.length; i++) {
                final ListNode node = lists[i];
                if (minNode == null || (node != null && node.val < minNode.val)) {
                    minNode = node;
                    minNodeListIndex = i;
                }
            }

            if (minNode != null) {
                lists[minNodeListIndex] = lists[minNodeListIndex].next;
            }

            return minNode;
        }
    }
}