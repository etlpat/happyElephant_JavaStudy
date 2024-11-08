package com.algorithm10;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int maxTotalReward(int[] rewardValues) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < rewardValues.length; i++) {
            if (!list.contains(rewardValues[i])) {
                list.add(rewardValues[i]);
            }
        }
        Collections.sort(list);


        if (list.size() == 1) {
            return list.get(0);
        }


        int size = list.size();
        int total = list.get(size - 1) + list.get(size - 2);
        int mark = list.get(size - 1) - list.get(size - 2);

        for (int i = size - 3; i >= 0; i--) {
            if (list.get(i) < mark) {
                total += list.get(i);
                mark -= list.get(i);
            }

        }

        return total;
    }
}
