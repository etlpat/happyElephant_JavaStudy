package com.etlpat.letCode003;


import java.util.HashSet;

/**
 * 3.无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * <p>
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */


// 滑动窗口
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        HashSet<Character> set = new HashSet<>();// 存放当前不重复的字符串
        for (int end = 0; end < s.length(); end++) {
            char charAt = s.charAt(end);
            if (!set.contains(charAt)) {// 若集合不包含重复元素
                set.add(charAt);
            } else {// 字母重复，记录max，并把左端重复串吐掉
                if (set.size() > max) {
                    max = set.size();
                }
                while (s.charAt(start) != charAt) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
        }

        // 结束时，判断一次长度
        if (set.size() > max) {
            max = set.size();
        }
        return max;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("aaaaa"));
        System.out.println(solution.lengthOfLongestSubstring("abcde"));
    }
}
