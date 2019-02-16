package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final List<Interval> result = solution.merge(Arrays.asList(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        ));

        final List<Interval> result2 = solution.merge(Collections.emptyList());
    }
}
