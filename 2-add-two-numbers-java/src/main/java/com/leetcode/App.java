package com.leetcode;

public class App {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.addTwoNumbers(toList(new int[]{2, 4, 3}), toList(new int[]{5, 6, 4})));
        System.out.println(solution.addTwoNumbers(toList(new int[]{1, 1}), toList(new int[]{0, 0, 1})));
        System.out.println(solution.addTwoNumbers(toList(new int[]{1}), toList(new int[]{9})));
        System.out.println(solution.addTwoNumbers(toList(new int[]{}), toList(new int[]{})));
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
