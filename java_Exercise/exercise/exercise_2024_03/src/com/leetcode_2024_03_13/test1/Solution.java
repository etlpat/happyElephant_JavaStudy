package com.leetcode_2024_03_13.test1;

class Solution {
    public String maximumOddBinaryNumber(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            str = s.charAt(i) == '1' ? 1 + str : str + 0;
        }
        return str.substring(1) + 1;
    }
}
