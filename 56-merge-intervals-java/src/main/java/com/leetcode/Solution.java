package com.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//================================================================================

/**
 * Definition for an interval.
 */
class Interval {
    final int start;
    final int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

//================================================================================

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));

        final LinkedList<Interval> result = new LinkedList<>();

        for (Interval interval : intervals) {
            if (!result.isEmpty() && isIntersect(result.getLast(), interval)) {
                final Interval merged = merge(result.getLast(), interval);
                result.removeLast();
                result.offerLast(merged);
            } else {
                result.offerLast(interval);
            }
        }
        return result;
    }

    private boolean isIntersect(Interval a, Interval b) {
        return b.start <= a.end;
    }

    private Interval merge(Interval a, Interval b) {
        return new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
    }
}
