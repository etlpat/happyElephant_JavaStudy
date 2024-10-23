package com.algorithm07;


// 方法：【滑动窗口】法
// 思路：枚举右端点，尽量缩短左端点
//      右端点：每次+1
//      左端点：每次尽量往右缩，直到符合题目条件&&子串长度最短
//      限制条件：滑动窗口，即该数组，始终满足题目要求的条件，
//              类似于毛毛虫，从左到右爬。


public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;// 滑动窗口的左右指针
        int sum = 0;// 滑动窗口中元素的数值和
        int res = nums.length + 1;// 返回的值

        for (int i = 0; i < nums.length; i++) {
            right = i;// 滑动窗口右端，每次+1
            sum += nums[right];

            while (true) {// 滑动窗口左端，尽量缩短
                if (sum - nums[left] < target) {// 若去除左端后，不满足条件了，则直接退出（滑动窗口中元素，要始终符合题目条件）
                    break;
                }
                // 否则，持续增加左端下标
                sum -= nums[left];
                left++;
            }

            // 每次右移1，左缩到最短后，更新res
            if (sum >= target) {
                res = Math.min(res, right - left + 1);
            }
        }

        if (res == nums.length + 1) {// 若是窗口滑倒最后，都不满足条件，则返回0
            res = 0;
        }

        return res;
    }
}
