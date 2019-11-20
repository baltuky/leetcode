package com.leetcode;

public class App {
    public static void main(String[] args) {
        int n = 2;

        final Solution solution = new Solution();
        int[] counts = solution.countBits(n);

        for (int i = 0; i <= n; i++) {
            int index = i == 0 ? 0 : i & (i - 1);
            System.out.printf("%8d | %sb | %8d | %d\n", i, String.format("%8s", Integer.toBinaryString(i)).replaceAll(" ", "0"), index, counts[i]);
        }
    }
}
