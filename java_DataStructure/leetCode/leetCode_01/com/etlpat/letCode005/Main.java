package com.etlpat.letCode005;


/**
 * 5.最长回文子串
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 * 回文性：如果字符串向前和向后读都相同，则它满足 回文性。
 * <p>
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */


class Solution {
    // 从回文子串中心向两边找
    public String longestPalindrome(String s) {
        int leftMeddle = 0;
        int rightMeddle = 0;
        int half = 0;
        int tmp;
        for (int i = 0; i < s.length(); i++) {
            // 奇数串情况
            tmp = getHalfLength(s, i, i);
            if (tmp > half) {
                half = tmp;
                leftMeddle = i;
                rightMeddle = i;
            }
            // 偶数串情况
            if (i + 1 < s.length()) {
                tmp = getHalfLength(s, i, i + 1);
                if (tmp >= half) {
                    half = tmp;
                    leftMeddle = i;
                    rightMeddle = i + 1;
                }
            }
        }
        return s.substring(leftMeddle - half, rightMeddle + half + 1);
    }

    // 返回一半的长度
    public int getHalfLength(String s, int start, int end) {
        if (start != end) {
            if (s.charAt(start) != s.charAt(end)) {
                return -1;
            }
        }
        int n = 0;
        while (start - n - 1 >= 0 && end + n + 1 < s.length()) {
            n++;
            if (s.charAt(start - n) != s.charAt(end + n)) {
                n--;
                break;
            }
        }
        return n;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
