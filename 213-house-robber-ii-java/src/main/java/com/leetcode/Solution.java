package com.leetcode;

import java.util.Arrays;

/**
 * Title: 213. House Robber II
 * Link: https://leetcode.com/problems/house-robber-ii/
 * Difficulty: Medium
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two
 * adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
 * of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * <p>
 * Example 2:
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.
 */
class Solution {
    public int rob(int[] nums) {
        return new DynamicProgrammingBottomUpSolution().rob(nums);
    }

    private static class DynamicProgrammingBottomUpSolution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            } else if (nums.length == 1) {
                return nums[0];
            }
            return Math.max(
                    rob(nums, 0, nums.length - 1),
                    rob(nums, 1, nums.length)
            );
        }

        private int rob(int[] nums, int l, int r) {
            int pprev = 0, prev = 0;

            for (int i = l; i < r; i++) {
                int rob = Math.max(pprev + nums[i], prev);
                pprev = prev;
                prev = rob;
            }
            return Math.max(pprev, prev);
        }
    }

    private static class DynamicProgrammingTopDownSolution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            } else if (nums.length == 1) {
                return nums[0];
            }
            return Math.max(
                    rob(memo(nums), nums, 0, nums.length - 1),
                    rob(memo(nums), nums, 1, nums.length)
            );
        }

        private int[] memo(int[] nums) {
            int[] dp1 = new int[nums.length];
            Arrays.fill(dp1, -1);
            return dp1;
        }

        private int rob(int[] dp, int[] nums, int l, int r) {
            if (r <= l) {
                return 0;
            } else if (dp[l] == -1) {
                dp[l] = Math.max(
                        rob(dp, nums, l + 1, r),
                        nums[l] + rob(dp, nums, l + 2, r)
                );
            }
            return dp[l];
        }
    }
}