package com.leetcode_2024_03_05.test1;

//    TODO 3014. 输入单词需要的最少按键次数 I
//
//    给你一个字符串 word，由 不同 小写英文字母组成。
//    电话键盘上的按键与 不同 小写英文字母集合相映射，可以通过按压按键来组成单词。
//    例如，按键 2 对应 ["a","b","c"]，我们需要按一次键来输入 "a"，按两次键来输入 "b"，按三次键来输入 "c"。
//    现在允许你将编号为 2 到 9 的按键重新映射到 不同 字母集合。每个按键可以映射到 任意数量 的字母，但每个字母 必须 恰好 映射到 一个 按键上。
//    你需要找到输入字符串 word 所需的 最少 按键次数。返回重新映射按键后输入 word 所需的 最少 按键次数。

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumPushes("abcde"));// 5
        System.out.println(solution.minimumPushes("xycdefghij"));// 12
    }
}
