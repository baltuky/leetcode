package com.leetcode;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    maxArea = Math.max(maxArea, measureIsland(grid, i, j));
            }
        }
        return maxArea;
    }

    private int measureIsland(int[][] grid, int i, int j) {
        if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1
                    + measureIsland(grid, i - 1, j)
                    + measureIsland(grid, i + 1, j)
                    + measureIsland(grid, i, j - 1)
                    + measureIsland(grid, i, j + 1);
        }
        return 0;
    }
}
