package com.leetcode_2024_03_12.test2;

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] num = new int[5];
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'b':
                    num[0]++;
                    break;
                case 'a':
                    num[1]++;
                    break;
                case 'l':
                    num[2]++;
                    break;
                case 'o':
                    num[3]++;
                    break;
                case 'n':
                    num[4]++;
            }
        }
        num[2] /= 2;
        num[3] /= 2;
        int min = num[0];
        for (int i = 1; i < num.length; i++) {
            if (min > num[i]) {
                min = num[i];
            }
        }
        return min;
    }
}