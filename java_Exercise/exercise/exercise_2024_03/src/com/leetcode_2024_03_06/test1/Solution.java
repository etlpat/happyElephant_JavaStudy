package com.leetcode_2024_03_06.test1;

class Solution {
    public int findKOr(int[] nums, int k) {
        if (k == nums.length) {
            int kor = nums[0];
            for (int i = 1; i < nums.length; i++) {
                kor &= nums[i];
            }
            return kor;
        } else {
            // hasNum是所有数组元素经过“|”运算的结果，其中是1的位置表示至少有有个元素该位是1
            int hasNum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                hasNum |= nums[i];
            }
            if (k == 1) {// 若k是1，结果直接就是所有元素的“|”运算结果
                return hasNum;
            }

            int kor = 0;
            long side = 1;// 表示当前查看的位数
            int kNum;// 表示当前位数为1的数组元素个数
            while (side <= hasNum) {
                if ((hasNum & side) == side) {// 若该位有1
                    kNum = 0;
                    for (int i = 0; i < nums.length; i++) {// 遍历数组，获取kNum
                        if ((side & nums[i]) == side) {
                            kNum++;
                            if (kNum >= k) {
                                kor |= side;
                                break;
                            }
                        }
                    }
                }
                side <<= 1;
            }
            return kor;
        }
    }
}

