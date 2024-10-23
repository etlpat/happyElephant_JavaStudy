package com.algorithm06;

public class MySolution {
    public int countKConstraintSubstrings(String s, int k) {
        int res = 0;

        // 用来暴力计算字符串
        for (int i = 0; i < s.length(); i++) {// i充当子串的起始坐标
            for (int j = i + 1; j <= s.length(); j++) {// j用来枚举子串的结束坐标
                // 若本次枚举成功，则接着枚举；直到枚举失败，就退出
                if (isCorrectString(s.substring(i, j), k)) {
                    res++;
                } else {
                    break;
                }
            }
        }

        return res;
    }


    public static boolean isCorrectString(String s, int k) {
        int num0 = 0, num1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                num0++;
            } else if (s.charAt(i) == '1') {
                num1++;
            }
        }
        // ①字符串中 0 的数量最多为 k。
        // ②字符串中 1 的数量最多为 k。
        // ①/②中满足一个，则为true
        return Math.min(num0, num1) <= k;
    }
}
