package com.leetcode.dfs;

public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    eraseIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    private void eraseIsland(char[][] grid, int i, int j) {
        if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            eraseIsland(grid, i, j - 1);
            eraseIsland(grid, i, j + 1);
            eraseIsland(grid, i - 1, j);
            eraseIsland(grid, i + 1, j);
        }
    }
}
