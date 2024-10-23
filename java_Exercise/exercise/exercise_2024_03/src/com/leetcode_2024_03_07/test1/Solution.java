package com.leetcode_2024_03_07.test1;

class Solution {
    public int[] divisibilityArray(String word, int m) {
        int[] ints = new int[word.length()];
        long num = 0;// 记录可否被整除的数字
        for (int i = 0; i < word.length(); i++) {
            if (i != 0 && ints[i - 1] == 0) {// 若上次未被整除，添加一位继续判断
                num *= 10;
            } else {// 若上次被整除，则本次直接判断末尾的数是否整除即可
                num = 0;
            }
            num += (word.charAt(i) - '0');
            num %= m;// 这里num%=m，比影响整除判断，且能减少位数

            num = i != 0 && ints[i - 1] == 0 ? (num * 10 + word.charAt(i) - '0') % m : (word.charAt(i) - '0') % m;

            if (num % m == 0) {
                ints[i] = 1;
            }
        }
        return ints;
    }
}
