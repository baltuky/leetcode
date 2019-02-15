package com.leetcode;

class Solution {
    public void rotate(int[] nums, int k) {
        final ReverseSubArraySolution solution = new ReverseSubArraySolution();
        solution.rotate(nums, k);
    }

    class ReverseSubArraySolution {
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length < 2)
                return;

            k = k % nums.length;

            if (k == 0)
                return;

            revert(nums, 0, nums.length - k - 1);
            revert(nums, nums.length - k, nums.length - 1);
            revert(nums, 0, nums.length - 1);
        }

        private void revert(int[] nums, int s, int e) {
            while (s < e) {
                swap(nums, s, e);
                s++;
                e--;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int e = nums[i];
            nums[i] = nums[j];
            nums[j] = e;
        }
    }

    class CyclicReplacementSolution {
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length < 2)
                return;

            final int n = nums.length;

            k = k % n;

            if (k == 0)
                return;

            int start = 0;
            int destination = wrapIndex(k, n);
            int replacement = nums[0];

            for (int step = 0; step < n; step++) {
                int newReplacement = nums[destination];
                nums[destination] = replacement;
                replacement = newReplacement;

                if (destination == start) {
                    start = wrapIndex(start + 1, n);
                    destination++;
                    replacement = nums[start];
                }

                destination = wrapIndex(destination + k, n);
            }
        }

        private int wrapIndex(int d, int n) {
            return d % n;
        }
    }
}