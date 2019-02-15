package com.leetcode.uf;

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        final int n = grid.length;
        final int m = grid[0].length;
        final UnionFind uf = new UnionFind(n * m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '0')
                    continue;

                if (isI(i - 1, n) && grid[i - 1][j] == '1') uf.union(i * m + j, (i - 1) * m + j);
                if (isI(i + 1, n) && grid[i + 1][j] == '1') uf.union(i * m + j, (i + 1) * m + j);

                if (isI(j + 1, m) && grid[i][j + 1] == '1') uf.union(i * m + j, i * m + j + 1);
                if (isI(j - 1, m) && grid[i][j - 1] == '1') uf.union(i * m + j, i * m + j - 1);
            }
        }

        final boolean[] seen = new boolean[n * m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                final int root = uf.find(i * m + j);
                if (grid[i][j] == '1' && !seen[root]) {
                    seen[root] = true;
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isI(int i, int n) {
        return 0 <= i && i < n;
    }

    private class UnionFind {
        private final int[] roots;
        private final int[] weights;

        public UnionFind(int n) {
            weights = new int[n];
            roots = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
                weights[i] = 1;
            }
        }

        public int find(int i) {
            while (roots[i] != i) i = roots[i];
            return i;
        }

        public void union(int p, int q) {
            final int pRoot = find(p);
            final int qRoot = find(q);

            if (pRoot == qRoot)
                return;

            if (weights[pRoot] < weights[qRoot]) {
                roots[pRoot] = qRoot;
                weights[qRoot] += weights[pRoot];
            } else {
                roots[qRoot] = pRoot;
                weights[qRoot] += weights[pRoot];
            }
        }
    }
}