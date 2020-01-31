package com.leetcode;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        final Solution solution = new Solution();

        int[][] grid1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        solve(solution, grid1);
    }

    private static void solve(Solution solution, int[][] grid) {
        System.out.println("[");
        for (int[] row : grid) {
            System.out.printf("%s\n", Arrays.toString(row));
        }
        System.out.printf("]: %d\n", solution.minPathSum(grid));
    }
}
