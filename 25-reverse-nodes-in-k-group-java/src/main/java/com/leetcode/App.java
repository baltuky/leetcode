package com.leetcode;

public class App {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2};
        int[] nums3 = {1};
        int[] nums4 = {};

        Solution solution = new Solution();
        System.out.println(solution.reverseKGroup(toList(nums1), 2));
        System.out.println(solution.reverseKGroup(toList(nums2), 3));
        System.out.println(solution.reverseKGroup(toList(nums3), 3));
        System.out.println(solution.reverseKGroup(toList(nums4), 1));
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
