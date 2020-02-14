package com.leetcode;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        solve(solution, "leetcode", Arrays.asList("leet", "code"));
        solve(solution, "applepenapple", Arrays.asList("apple", "pen"));
        solve(solution, "catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        solve(solution, times("a", 150).concat("b"), Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
    }

    private static void solve(Solution solution, String s, List<String> dictionary) {
        System.out.printf("%s, %s: %b\n", s, dictionary.toString(), solution.wordBreak(s, dictionary));
    }

    private static String times(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(s);
        }
        return builder.toString();
    }
}
