package com.leetcode;

public class App {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1};
        int[] nums3 = {};

        Solution solution = new Solution();

        System.out.println(solution.removeNthFromEnd(toList(nums1), 4));
        System.out.println(solution.removeNthFromEnd(toList(nums1), 5));
        System.out.println(solution.removeNthFromEnd(toList(nums1), 0));

        System.out.println(solution.removeNthFromEnd(toList(nums2), 1));
        System.out.println(solution.removeNthFromEnd(toList(nums3), 1));
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
