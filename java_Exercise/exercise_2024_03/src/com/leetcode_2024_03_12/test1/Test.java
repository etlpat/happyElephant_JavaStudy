package com.leetcode_2024_03_12.test1;

//    TODO 1190. 反转每对括号间的子串
//
//    给出一个字符串 s（仅含有小写英文字母和括号）。
//    请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
//    注意，您的结果中 不应 包含任何括号。
//
//
//    示例 1：
//    输入：s = "(abcd)"
//    输出："dcba"
//
//    示例 2：
//    输入：s = "(u(love)i)"
//    输出："iloveu"
//    解释：先反转子字符串 "love" ，然后反转整个字符串。
//
//    示例 3：
//    输入：s = "(ed(et(oc))el)"
//    输出："leetcode"
//    解释：先反转子字符串 "oc" ，接着反转 "etco" ，然后反转整个字符串。
//
//    示例 4：
//    输入：s = "a(bcdefghijkl(mno)p)q"
//    输出："apmnolkjihgfedcbq"
//
//
//    提示：
//    1 <= s.length <= 2000
//    s 中只有小写英文字母和括号
//    题目测试用例确保所有括号都是成对出现的


public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "(abcd)";
        System.out.println(solution.reverseParentheses(s1));// dcba

        String s2 = "(u(love)i)";
        System.out.println(solution.reverseParentheses(s2));// iloveu

        String s3 = "a(bcdefghijkl(mno)p)q";
        System.out.println(solution.reverseParentheses(s3));// apmnolkjihgfedcbq

        String s4 = "(ed(et(oc))el)";
        System.out.println(solution.reverseParentheses(s4));// leetcode
    }
}
