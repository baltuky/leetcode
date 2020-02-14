package com.leetcode;

import java.util.*;

/**
 * Title: 139. Word Break
 * Link: https://leetcode.com/problems/word-break/
 * Difficulty: Medium
 * Solver: Yauheni Baltukha (baltuky)
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * <p>
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * <p>
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple". Note that you are allowed
 * to reuse a dictionary word.
 * <p>
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class Solution {
    public boolean wordBreak(String s, List<String> words) {
        final Set<String> dictionary = new HashSet<>(words.size());
        int maxLength = 0;

        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
            dictionary.add(word);
        }

        return isBreakable(new HashMap<>(), s, dictionary, maxLength);
    }

    private boolean isBreakable(Map<String, Boolean> memo, String s, Set<String> dictionary, int maxLength) {
        Boolean result = memo.get(s);

        if (result == null) {
            if (s.isEmpty()) {
                return true;
            }

            result = false;

            for (int i = 1; i <= Math.min(maxLength, s.length()); i++) {
                result = result ||
                        (dictionary.contains(s.substring(0, i)) && isBreakable(memo, s.substring(i), dictionary, maxLength));
            }

            memo.put(s, result);
        }

        return result;
    }
}