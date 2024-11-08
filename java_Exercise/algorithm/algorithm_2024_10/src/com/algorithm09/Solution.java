package com.algorithm09;

public class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int sadCount = 0;// 不开心的人数

        // (1)创建match数组，若xy为一对，保证match[x]=y，match[y]=x
        int[] match = new int[n];
        int x, y;
        for (int i = 0; i < n / 2; i++) {
            x = pairs[i][0];
            y = pairs[i][1];
            match[x] = y;
            match[y] = x;
        }

        // (2)从0到n-1，判断每个人是否开心
        int tmp;
        boolean flag = false;
        for (int i = 0; i < n; i++) {// i表示每个人
            flag = false;//flag为true时，表示i伤心了
            // 遍历每个人的好感度表
            for (int j = 0; preferences[i][j] != match[i]; j++) {// tmp=preferences[i][j]表示i的朋友
                // 此时,tmp表示比i老婆还亲密的朋友
                tmp = preferences[i][j];

                // 此时，判断tmp和i好还是和tmp的老婆好
                for (int k = 0; k <= preferences[tmp].length; k++) {// 遍历tmp的好感度表，看看tmp的老婆和i谁先出现
                    if (preferences[tmp][k] == match[tmp]) {// tmp的老婆先出现，i开心
                        break;
                    } else if (preferences[tmp][k] == i) {// i先出现，i伤心
                        flag = true;
                        break;
                    }
                }

                if (flag) {// flag为true，i伤心
                    sadCount++;
                    break;
                }
            }
        }

        return sadCount;
    }
}
