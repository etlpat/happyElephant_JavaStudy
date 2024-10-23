package com.algorithm06;

// 思路：
//  题目求满足k条件的子串数量，我们把思路逆转过来！只要拿[全部子串的数量-不满足条件的子串数量]即可。
//      因此，本题转换为：求不满足条件的子串数量，
//      即：求 【0的数量>k，且1的数量>k】的子串的个数。
//  如上，就可以拿【滑动窗口】来求


public class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int left = 0, right = 0;// 滑动窗口的左右指针
        int num0 = 0, num1 = 0;// 滑动窗口中0和1的数量
        int count = 0;// 【0的数量>k，且1的数量>k】的子串的个数

        for (int i = 0; i < s.length(); i++) {
            // (1)滑动窗口右侧自增
            // 滑动窗口，右侧每次+1
            right = i;
            if (s.charAt(right) == '0') {
                num0++;
            } else {
                num1++;
            }

            // 若变动后，【0的数量>k，且1的数量>k】，则count++
            if (num0 > k && num1 > k) {
                count++;

                // (2)滑动窗口左侧自增
                int tmpNum0, tmpNum1;
                while (true) {// 滑动窗口，左侧尽量向右侧收缩
                    // 推测left++后的结果
                    tmpNum0 = num0;
                    tmpNum1 = num1;
                    if (s.charAt(left) == '0') {
                        tmpNum0--;
                    } else {
                        tmpNum1--;
                    }

                    if (!(tmpNum0 > k && tmpNum1 > k)) {// 若变动后不再满足条件，则不再变动
                        break;
                    } else {// 若left++后满足【0的数量>k，且1的数量>k】条件，则使得left向右++
                        num0 = tmpNum0;
                        num1 = tmpNum1;
                        left++;
                        count++;// 每变动1次，表示一个新子串，count++
                    }
                }

            }
        }

        // 总共的子串数（等差数列求和）
        int allSubStrNum = (s.length() + 1) * s.length() / 2;

        return allSubStrNum - count;
    }
}
