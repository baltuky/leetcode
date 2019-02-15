package com.leetcode;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        final int[] a1 = {2, 2, 1};
        final int[] a2 = {4, 1, 2, 1, 2};

        solve(a1);
        solve(a2);
    }

    private static void solve(int[] a) {
        final Solution solution = new Solution();
        System.out.println(String.format("%s: %d", Arrays.toString(a), solution.singleNumber(a)));
    }
}
