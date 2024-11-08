package com.algorithm08;

// 思路：若遍历完一次数组后，即使连胜次数仍然未到达k，
//          此时的maxValue必然是整个数组中的最大值，因此直接返回即可。
//      因此，只需要遍历1次数组，若未遍历完就得出结果，返回这个结果；
//          若遍历完1次，直接返回最大值
//

public class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int maxIndex = skills[0] > skills[1] ? 0 : 1;
        int maxValue = skills[maxIndex];
        int winCount = 1;

        // 若只比较1次，直接返回
        if (k == 1) {
            return maxIndex;
        }

        // 从第3个元素到尾遍历数组
        for (int i = 2; i < skills.length; i++) {// 每轮的i，是与当前maxValue进行比较的元素
            if (maxValue > skills[i]) {// 若maxValue获胜
                winCount++;
                if (winCount == k) {
                    return maxIndex;
                }
            } else {// 若新元素获胜
                maxIndex = i;
                maxValue = skills[i];
                winCount = 1;
            }
        }

        return maxIndex;
    }
}
