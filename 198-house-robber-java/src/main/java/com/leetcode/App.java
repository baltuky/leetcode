package com.leetcode;

public class App {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(solution.rob(new int[]{}));
        System.out.println(solution.rob(new int[]{10}));
        System.out.println(solution.rob(new int[]{11, 10}));
        System.out.println(solution.rob(new int[]{11, 10, 13}));
        System.out.println(solution.rob(new int[]{2, 1, 1, 2}));
    }
}
