package com.leetcode_2024_03_18.test1;

//class NumArray {// 笨办法：每次调用方法，执行一会遍历
//    int[] nums;
//
//    public NumArray(int[] nums) {
//        this.nums = nums;
//    }
//
//    public int sumRange(int left, int right) {
//        int sum = 0;
//        for (int i = left; i <= right; i++) {
//            sum += nums[i];
//        }
//        return sum;
//    }
//}


class NumArray {// 只在创建时执行一次遍历，调用方法时直接获得结果
    int[] sums;// 存放从0到当前下标的nums数值的和

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        return left == 0 ? sums[right] : sums[right] - sums[left - 1];
    }
}
