package com.etlpat.letCode006;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 6.Z字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * <p>
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * <p>
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 */


class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        int groupCount = 2 * numRows - 2;// 一组内元素的个数
        int groupNum = length / groupCount + (length % groupCount == 0 ? 0 : 1);// 一共的组数

        // 0      (8)
        // 1     7
        // 2   6
        // 3 5
        // 4

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {// 遍历行
            for (int j = 0; j < groupNum; j++) {// 遍历组
                int index1 = j * groupCount + i;// 第一位下标
                int index2 = (j + 1) * groupCount - i;// 第二位下标
                if (index1 < length) {
                    stringBuilder.append(s.charAt(index1));
                }
                if (index2 < length && index2 < ((j + 1) * groupCount) && index2 != index1) {
                    stringBuilder.append(s.charAt(index2));
                }
            }
        }
        return stringBuilder.toString();
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
        System.out.println(solution.convert("PAYPALISHIRING", 4));
        System.out.println(solution.convert("A", 1));
    }
}
