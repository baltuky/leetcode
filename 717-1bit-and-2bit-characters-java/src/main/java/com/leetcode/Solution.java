package com.leetcode;

/**
 * Title: 717. 1-bit and 2-bit Characters
 * Link: https://leetcode.com/problems/1-bit-and-2-bit-characters/
 * Difficulty: Easy
 * <p>
 * Solver: Yauheni Baltukha (baltuky)
 * <p>
 * We have two special characters. The first character can be represented by one bit 0. The second character can be
 * represented by two bits (10 or 11).
 * <p>
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not.
 * The given string will always end with a zero.
 */

/**
 * Solutions goes through the array, from left to right by steps i-th element + 1.
 * In case if i-th element is 1 (beginning of two byte symbol (10 or 11)), counter incremented by 2 (i-th element + 1)
 * In case if i-th element is 0 counter incremented by 1.
 * <p>
 * At the end it analyses results:
 * <p>
 * Case 1: (Counter ended-up at position 2, result is true)
 * [1, 0, 0] (two byte char, one byte char)
 *        ^
 * <p>
 * Case 2: (Counter ended-up at position 4, exceeded array size, result is false)
 * [1, 1, 1, 0] (two byte char, two byte char)
 */
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }
}
