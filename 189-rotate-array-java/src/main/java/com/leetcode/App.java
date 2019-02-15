package com.leetcode;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        final int[] a1 = {1, 2, 3, 4, 5, 6, 7};
        final int[] a2 = {1};

//  I. CYCLIC REPLACEMENT SOLUTION
//        Case 1
//       {1, 2, 3, 4, 5, 6};
//        n = 6
//        k = 2
//        0 to 2 - step 1
//        2 to 4 - step 2
//        4 to 0 - step 3 -- came to the start position, in this case start position is 0, should increment start position and proceed
//        1 to 3 - step 4
//        3 to 5 - step 5
//        5 to 1 - step 6

//       {5, 6, 1, 2, 3, 4};

//       {3, 2, 1, 4, 7, 6, 5};
//        0  1  2  3  4  5  6 -- len = 7, 7 - 3 - 1
//       {5, 6, 7, 1, 2, 3, 4};

//        Case 2
//        {1, 2, 3, 4, 5, 6, 7}
//        n = 7
//        k = 2
//        0 to 2 - step 1
//        2 to 4 - step 2
//        4 to 6 - step 3
//        6 to 1 - step 4
//        1 to 3 - step 5
//        3 to 5 - step 6
//        5 to 0 - step 7
//        {6, 7, 1, 2, 3, 4, 5}

//        Case 3
//        {1, 2, 3, 4, 5, 6}
//        n = 6
//        k = 3
//        0 to 3 - step 1
//        3 to 0 - step 2 -- change start element, increment it
//        1 to 4 - step 3
//        4 to 1 - step 4 -- change start element, increment it
//        2 to 5 - step 5
//        5 to 2 - step 6
//        {1, 2, 3, 1, 5, 6}

//  II. SUB-ARRAY REVERSE SOLUTION
//       Case 1
//       n = 6
//       k = 3
//       {1, 2, 3, 4, 5, 6};
//       {3, 2, 1, 6, 5, 4};
//       {4, 5, 6, 1, 2, 3};


        System.out.println(Arrays.toString(shift(a1, 3)));
    }

    private static int[] shift(int[] a, int k) {
        final Solution solution = new Solution();
        solution.rotate(a, k);
        return a;
    }
}
