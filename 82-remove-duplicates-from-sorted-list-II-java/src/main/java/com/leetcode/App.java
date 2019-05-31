package com.leetcode;

public class App {
    public static void main(String[] args) {
        final int[] nums1 = {1, 2, 3, 3, 3, 4, 4, 5, 5};
        final int[] nums2 = {1};
        final int[] nums3 = {};

        final Solution solution = new Solution();

        System.out.println(solution.deleteDuplicates(toList(nums1)));
        System.out.println(solution.deleteDuplicates(toList(nums2)));
        System.out.println(solution.deleteDuplicates(toList(nums3)));
    }

    private static ListNode toList(int[] nums) {
        ListNode head = null;
        for (int i = nums.length - 1; 0 <= i; i--) {
            final ListNode node = new ListNode(nums[i]);
            if (head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }
        }
        return head;
    }
}
