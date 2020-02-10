package com.leetcode;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        String[] paths1 = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        String[] paths2 = {"/a", "/a/b/c", "/a/b/d"};
        String[] paths3 = {"/a/b/c", "/a/b/ca", "/a/b/d"};

        final Solution solution = new Solution();
        solve(solution, paths1);
        solve(solution, paths2);
        solve(solution, paths3);
    }

    private static void solve(Solution solution, String[] paths) {
        System.out.printf("%s: %s\n", Arrays.toString(paths), solution.removeSubfolders(paths));
    }
}
