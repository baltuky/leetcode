package com.leetcode;

/**
 * Title: 64. Minimum Path Sum
 * Link: https://leetcode.com/problems/minimum-path-sum/
 * Difficulty: Medium
 * Solver: Yauheni Baltukha (baltuky)
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the
 * sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * Input:
 * <pre>
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * </pre>
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int prefix = Math.min(
                        j - 1 < 0 ? Integer.MAX_VALUE : dp[i][j - 1],
                        i - 1 < 0 ? Integer.MAX_VALUE : dp[i - 1][j]
                );

                dp[i][j] = grid[i][j] + (prefix == Integer.MAX_VALUE ? 0 : prefix);
            }
        }

        return dp[m - 1][n - 1];
    }
}