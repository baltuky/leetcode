package com.leetcode;

public class Solution {
    private static final char SPACE = ' ';

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        final StringBuilder builder = new StringBuilder(s.length());

        int i = s.length() - 1;

        while (i >= 0) {
            if (Character.isSpaceChar(s.charAt(i))) {
                i--;
            } else {
                final int spaceIndex = s.lastIndexOf(SPACE, i); //  (s[j] == ' ', where k < i
                if (builder.length() > 0)
                    builder.append(SPACE);
                builder.append(s, spaceIndex + 1, i + 1);
                i = spaceIndex - 1;
            }
        }

        return builder.toString();
    }
}
