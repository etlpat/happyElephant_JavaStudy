package com.parenthesisMatching.test01;

// 案例：括号匹配
//
// 1.要求
//  输入一段表达式字符串，判断其中括号是否匹配，如：{()[()()][()]()}
//  括号包含：“()” “[]” “{}”
//  注意：这里并不要求{}在外层，[]在中层，()在内层
//
// 2.思路
//  用栈辅助实现括号匹配
//  1.从左到右遍历字符串，若遇到左括号，将其入栈
//  2.若遇到右括号，则将栈顶的括号出栈，看看是否匹配
//  3.若遍历完字符串，且栈中无剩余左括号，则代表该表达式中括号正确匹配


public class Test {
    public static void main(String[] args) {
        String s1 = "{()[()()]()}[()]";
        String s2 = "{(1 + 2) * [(3 + 4) * 5] / (6 * 7)} - [8 + 9 * (10 + 11)]";
        String s3 = "{{{[[[((()))]]][[[((()))]]]}}}";
        String s4 = "1234567890";
        String s5 = "}}}]]])))";// 仅右括号
        String s6 = "((([[[{{{";// 仅左括号
        String s7 = "{()[(]()](]}[{)]";// 左右不匹配
        String s8 = "{(1 + 2) * [(3 + 4) * 5] / (6 * 7)]";// 左右不匹配


        ParenthesisMatching pm = new ParenthesisMatching();
        System.out.println(pm.match(s1));// true
        System.out.println(pm.match(s2));// true
        System.out.println(pm.match(s3));// true
        System.out.println(pm.match(s4));// true
        System.out.println(pm.match(s5));// false
        System.out.println(pm.match(s6));// false
        System.out.println(pm.match(s7));// false
        System.out.println(pm.match(s8));// false
    }
}
