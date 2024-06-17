package com.leetcode_2024_03_12.test2;

//    TODO 1189. “气球” 的最大数量
//
//    给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
//    字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
//
//
//    示例 1：
//    输入：text = "nlaebolko"
//    输出：1
//
//    示例 2：
//    输入：text = "loonbalxballpoon"
//    输出：2
//
//
//    提示：
//    1 <= text.length <= 10^4
//    text 全部由小写英文字母组成


public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String text1 = "nlaebolko";
        System.out.println(solution.maxNumberOfBalloons(text1));

        String text2 = "loonbalxballpoon";
        System.out.println(solution.maxNumberOfBalloons(text2));
    }
}
