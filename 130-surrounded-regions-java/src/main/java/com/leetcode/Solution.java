package com.leetcode;

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        int n = board.length;
        int m = board[0].length;

        final boolean[][] onBoards = new boolean[n][m];

        for (int i = 0; i < m; i++) {
            traverse(board, onBoards, 0, i);
            traverse(board, onBoards, n - 1, i);
        }

        for (int i = 0; i < n; i++) {
            traverse(board, onBoards, i, 0);
            traverse(board, onBoards, i, m - 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!onBoards[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void traverse(char[][] board, boolean[][] onBoards, int i, int j) {
        if (0 <= i && 0 <= j && i < board.length && j < board[0].length && board[i][j] == 'O' && !onBoards[i][j]) {
            onBoards[i][j] = true;

            traverse(board, onBoards, i - 1, j);
            traverse(board, onBoards, i + 1, j);
            traverse(board, onBoards, i, j - 1);
            traverse(board, onBoards, i, j + 1);
        }
    }
}
