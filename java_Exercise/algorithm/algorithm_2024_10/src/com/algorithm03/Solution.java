package com.algorithm03;

import java.util.Arrays;

public class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);

        int lastNum = nums[nums.length - 1];
        int firstNum = nums[0];
        int res = lastNum - firstNum;

        // 本题，若想差值最小，需要值向中心收束
        // 但是中心未知，因此需要通过枚举，暴力推导中心点
        for (int i = 0; i < nums.length - 1; i++) {
            int leftVal = nums[i];// 分界点左边的数值
            int rightVal = nums[i + 1];// 分界点右边的数值
            int max = Math.max(leftVal + k, lastNum - k);// 获取当前分界点时的最大值
            int min = Math.min(rightVal - k, firstNum + k);// 获取当前分界点时的最小值
            res = Math.min(res, max - min);// 遍历nums，从前到后列举所有分界点的情况
        }

        return res;
    }
}