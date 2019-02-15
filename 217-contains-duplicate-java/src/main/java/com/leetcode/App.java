package com.leetcode;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        final int[] a1 = {1, 2, 3, 1};
        final int[] a2 = {1, 2, 3, 4};

        solve(a2);
    }

    private static void solve(int[] a1) {
        final Solution solution = new Solution();
        System.out.println(String.format("%s: %b", Arrays.toString(a1), solution.containsDuplicate(a1)));
    }
}
