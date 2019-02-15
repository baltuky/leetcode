package com.leetcode;

import com.leetcode.dfs.Solution;

public class App {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final char[][] map1 = {
                {'1', '1', '1', '1', '0' },
                {'1', '1', '0', '1', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '0', '0', '0' }
        };

        final char[][] map2 = {
                {'1', '1', '0', '0', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '1', '0', '0' },
                {'0', '0', '0', '1', '1' }
        };

        final char[][] map3 = {
                {'1', '1', '1' },
                {'0', '1', '0' },
                {'1', '1', '1' }
        };

        final char[][] map4 = {
                {'1', '0', '1', '1', '1' },
                {'1', '0', '1', '0', '1' },
                {'1', '1', '1', '0', '1' }
        };

        System.out.println(solution.numIslands(map1));
        System.out.println(solution.numIslands(map2));
        System.out.println(solution.numIslands(map3));
        System.out.println(solution.numIslands(map4));
    }
}
