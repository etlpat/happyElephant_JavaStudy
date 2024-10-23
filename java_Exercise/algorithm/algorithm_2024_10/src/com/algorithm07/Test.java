package com.algorithm07;

//  209. 长度最小的子数组
//
//  给定一个含有 n 个正整数的数组和一个正整数 target 。
//  找出该数组中满足其总和大于等于 target 的长度最小的子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
//  并返回其长度。如果不存在符合条件的子数组，返回 0 。
//
//  示例 1：
//      输入：target = 7, nums = [2,3,1,2,4,3]
//      输出：2
//      解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//
//  示例 2：
//      输入：target = 4, nums = [1,4,4]
//      输出：1
//
//  示例 3：
//      输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//      输出：0
//
//  提示：
//      1 <= target <= 109
//      1 <= nums.length <= 105
//      1 <= nums[i] <= 105
//
//  进阶：
//      如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。


public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));

        System.out.println(solution.minSubArrayLen(4, new int[]{1, 4, 4}));

        System.out.println(solution.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
