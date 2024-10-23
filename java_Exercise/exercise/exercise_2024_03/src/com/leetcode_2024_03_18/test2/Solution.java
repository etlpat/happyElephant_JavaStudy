package com.leetcode_2024_03_18.test2;

class Solution {
    public boolean isPowerOfTwo(int n) {
        boolean flag = false;
        if (n <= 0) {
            return false;
        }
        while (n != 0) {
            if (n % 2 == 1) {
                if (flag) {
                    return false;
                }
                flag = true;
            }
            n >>= 1;
        }
        return true;
    }
}