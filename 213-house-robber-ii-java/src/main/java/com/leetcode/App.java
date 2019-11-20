package com.leetcode;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        solve(solution, new int[]{2, 3, 2});
        solve(solution, new int[]{1, 2, 3, 1});
    }

    private static void solve(Solution solution, int[] nums) {
        System.out.printf("%s: %d\n", Arrays.toString(nums), solution.rob(nums));
    }
}
