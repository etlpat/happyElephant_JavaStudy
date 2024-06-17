package com.leetcode_2024_03_18.test2;


//    TODO 231. 2 的幂
//
//    给你一个整数 n，请你判断该整数是否是 2 的幂次方。
//    如果是，返回 true ；否则，返回 false 。
//    如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
//
//
//    示例 1：
//    输入：n = 1
//    输出：true
//    解释：20 = 1
//
//    示例 2：
//    输入：n = 16
//    输出：true
//    解释：24 = 16
//
//    示例 3：
//    输入：n = 3
//    输出：false
//
//
//    提示：
//    -231 <= n <= 231 - 1


public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isPowerOfTwo(1));
        System.out.println(solution.isPowerOfTwo(16));
        System.out.println(solution.isPowerOfTwo(17));
    }
}
