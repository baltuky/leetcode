package com.leetcode;

import java.util.Arrays;

// I. SOLUTION WITH POINTER
// Case 1
// n = 10

// i = 1
// pointer = 0
// {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}

// i = 2
// pointer = 1
// {0, 1, 1, 1, 1, 2, 2, 3, 3, 4}

// i = 5
// pointer = 2
// {0, 1, 2, 1, 1, 2, 2, 3, 3, 4}

// i = 7
// pointer = 2 + 1 = 3 -- if number[i] != number[pointer] - increment pointer and set number[i] to new pointer position
// {0, 1, 2, 3, 1, 2, 2, 3, 3, 4}

public class App {
    public static void main(String[] args) {
        final int[] a1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        final int[] a2 = {0, 0};
        final int[] a3 = {1, 1, 2};
        final int[] a4 = {};

        deduplicate(a1);
    }

    private static void deduplicate(int[] a) {
        final Solution solution = new Solution();
        final int size = solution.removeDuplicates(a);

        System.out.println(String.format("New size: %d", size));
        System.out.println(String.format("Result: %s", Arrays.toString(a)));
        System.out.println(String.format("Result: %s", Arrays.toString(Arrays.copyOfRange(a, 0, size))));
    }
}
