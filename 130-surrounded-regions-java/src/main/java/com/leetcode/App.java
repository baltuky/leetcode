package com.leetcode;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        final char[][] board1 = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        final char[][] board2 = {
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
        };

        final Solution solution = new Solution();
        solve(board2, solution);
    }

    private static void solve(char[][] board, Solution solution) {
        solution.solve(board);

        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
