package com.algorithm03;

//  910. 最小差值 II
//
//  给你一个整数数组 nums，和一个整数 k 。
//  对于每个下标 i（0 <= i < nums.length），将 nums[i] 变成 nums[i] + k 或 nums[i] - k 。
//  nums 的 分数 是 nums 中最大元素和最小元素的差值。
//  在更改每个下标对应的值之后，返回 nums 的最小 分数 。
//
//
//
//  示例 1：
//      输入：nums = [1], k = 0
//      输出：0
//      解释：分数 = max(nums) - min(nums) = 1 - 1 = 0 。
//
//  示例 2：
//      输入：nums = [0,10], k = 2
//      输出：6
//      解释：将数组变为 [2, 8] 。分数 = max(nums) - min(nums) = 8 - 2 = 6 。
//
//  示例 3：
//      输入：nums = [1,3,6], k = 3
//      输出：3
//      解释：将数组变为 [4, 6, 3] 。分数 = max(nums) - min(nums) = 6 - 3 = 3 。
//
//  提示：
//      1 <= nums.length <= 104
//      0 <= nums[i] <= 104
//      0 <= k <= 104


public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int num1 = solution.smallestRangeII(new int[]{1}, 0);
        System.out.println(num1);

        int num2 = solution.smallestRangeII(new int[]{0, 10}, 2);
        System.out.println(num2);

        int num3 = solution.smallestRangeII(new int[]{1, 3, 6}, 3);
        System.out.println(num3);

        int num4 = solution.smallestRangeII(new int[]{8038, 9111, 5458, 8483, 5052, 9161, 8368, 2094, 8366, 9164, 53, 7222,
                9284, 5059, 4375, 2667, 2243, 5329, 3111, 5678, 5958, 815, 6841, 1377, 2752, 8569, 1483, 9191, 4675, 6230, 1169,
                9833, 5366, 502, 1591, 5113, 2706, 8515, 3710, 7272, 1596, 5114, 3620, 2911, 8378, 8012, 4586, 9610, 8361, 1646,
                2025, 1323, 5176, 1832, 7321, 1900, 1926, 5518, 8801, 679, 3368, 2086, 7486, 575, 9221, 2993, 421, 1202, 1845, 9767,
                4533, 1505, 820, 967, 2811, 5603, 574, 6920, 5493, 9490, 9303, 4648, 281, 2947, 4117, 2848, 7395, 930, 1023, 1439,
                8045, 5161, 2315, 5705, 7596, 5854, 1835, 6591, 2553, 8628}, 4643);
        System.out.println(num4);
    }
}
