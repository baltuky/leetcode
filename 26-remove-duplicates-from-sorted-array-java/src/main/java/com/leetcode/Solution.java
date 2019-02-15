package com.leetcode;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int pointer = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[pointer]) {
                nums[++pointer] = nums[i];
            }
        }
        return pointer + 1;
    }
}
