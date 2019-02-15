package com.leetcode;

public class App {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(String.format("'%s'", solution.reverseWords("the sky is blue")));
        System.out.println(String.format("'%s'", solution.reverseWords("a")));
        System.out.println(String.format("'%s'", solution.reverseWords(" 1")));
        System.out.println(String.format("'%s'", solution.reverseWords("1 ")));
    }
}
