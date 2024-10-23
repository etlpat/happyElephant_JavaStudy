package com.leetcode_2024_03_11.test1;

class Solution {
    public String capitalizeTitle(String title) {
        boolean isStart = true;// 表示当前下标是单词首字母
        String newTitle = "", word = "";
        char tmp = '\0', start = '\0';
        int wordLength = 0;
        for (int i = 0; i <= title.length(); i++) {
            if (i != title.length()) {
                tmp = title.charAt(i);
            }
            if (i < title.length() && tmp != ' ') {// 当i下标不是空格
                wordLength++;
                if (isStart) {// 当前是首字母
                    isStart = false;
                    start = tmp >= 'a' && tmp <= 'z' ? (char) (tmp - 32) : tmp;// 保留大写字母
                } else {// 当前不是首字母
                    word += tmp >= 'a' && tmp <= 'z' ? tmp : (char) (tmp + 32);// 保留小写字母
                }
            } else {// 当i下标对应空格，或i为title.length()
                if (newTitle != "") {
                    newTitle += ' ';
                }
                newTitle += wordLength > 2 ? start : (char) (start + 32);
                newTitle += word;
                wordLength = 0;
                word = "";
                isStart = true;
            }
        }
        return newTitle;
    }
}
