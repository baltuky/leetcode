package com.leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        final Map<Integer, Integer> seen = new HashMap<>(numbers.length);

        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            final int first = target - current;
            if (seen.containsKey(first)) {
                return new int[]{seen.get(first), i};
            }
            seen.put(current, i);
        }
        return new int[2];
    }
}
