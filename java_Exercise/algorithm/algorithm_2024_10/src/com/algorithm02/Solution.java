package com.algorithm02;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Index = 0, nums2Index = 0;// 双指针，用于记录数组当前下标
        int median1 = 0, median2 = 0;// 用于记录中位数
        int allLength = nums1.length + nums2.length;

        // 共遍历allLength/2+1次（每一次，获取并过掉第i小的值）
        for (int i = 1; i <= allLength / 2 + 1; i++) {
            // 获取中位数
            if (i == allLength / 2 || i == allLength / 2 + 1) {
                if (nums1Index == nums1.length) {
                    median2 = nums2[nums2Index];
                } else if (nums2Index == nums2.length) {
                    median2 = nums1[nums1Index];
                } else {
                    median2 = Math.min(nums1[nums1Index], nums2[nums2Index]);
                }
                if (i == allLength / 2) {
                    median1 = median2;
                }
            }

            // 过掉本轮中最小的数
            if (nums2Index == nums2.length || nums1Index < nums1.length && nums1[nums1Index] < nums2[nums2Index]) {
                nums1Index++;
            } else {
                nums2Index++;
            }
        }

        System.out.println(median1);
        System.out.println(median2);

        if (allLength % 2 == 1) {
            return median2;
        } else {
            return (median1 + median2) * 1.0 / 2;
        }
    }
}
