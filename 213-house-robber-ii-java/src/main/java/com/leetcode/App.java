package com.leetcode;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        solve(solution, new int[]{3});
        solve(solution, new int[]{2, 7, 9, 3, 1});
        solve(solution, new int[]{2, 3, 2});
        solve(solution, new int[]{1, 2, 3, 1});
        solve(solution, new int[]{1, 2, 3, 1, 5, 6, 7, 8, 9});
        solve(solution, new int[]{
                114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222,
                160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241,
                202, 144, 240
        });
    }

    private static void solve(Solution solution, int[] nums) {
        System.out.printf("%s: %d\n", Arrays.toString(nums), solution.rob(nums));
    }
}
