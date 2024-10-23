package com.algorithm05;

public class Solution {
    public long countCompleteDayPairs(int[] hours) {
        // 创建longs，用于存放余数为0~23的出现次数
        long[] longs = new long[24];
        for (int hour : hours) {
            longs[hour % 24] += 1;
        }


        // 获取1~11和13~23的对应相乘，即hours中的符合条件的整天数
        Long res = 0L;
        for (int i = 1; i < 12; i++) {
            res += longs[i] * longs[24 - i];
        }

        // 余数为0和12时单独处理
        res += accumulation(longs[0] - 1);
        res += accumulation(longs[12] - 1);

        return res;
    }


    // 求累加的方法
    public long accumulation(long n) {
        long res = 0;
        while (n > 0) {
            res += n;
            n--;
        }
        return res;
    }
}
