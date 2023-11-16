package com.parenthesisMatching.test01;

public class ParenthesisMatching extends LinkStack {
    private LinkStack stack = new LinkStack();// 属性：存放左括号的栈

    // 判断字符是否为左括号
    private boolean isLeftParenthesis(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    // 判断字符是否为右括号
    private boolean isRightParenthesis(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    // 判断左、右括号是否匹配
    private boolean judgmentMatching(char ch1, char ch2) {
        return (ch1 == '(' && ch2 == ')') || (ch1 == '[' && ch2 == ']') || (ch1 == '{' && ch2 == '}');
    }


    // 进行括号匹配的方法
    public boolean match(String str) {
        if (!stack.isEmpty()) {// 若栈不为空，则清空栈
            stack.clearStack();
        }
        char ch;
        LNode node = new LNode();

        for (int i = 0; i < str.length(); i++) {// 遍历传入的字符串
            ch = str.charAt(i);
            if (isLeftParenthesis(ch)) {// 【若ch是左括号】，则入栈
                stack.push(ch);
            } else if (isRightParenthesis(ch)) {// 【若ch是右括号】，则出栈左括号，并判断是否匹配
                if (!stack.pop(node)) {// 若出栈失败(右括号比左括号多)，返回false
                    return false;
                }
                if (!judgmentMatching(node.getParenthesis(), ch)) {// 若左右括号不匹配，返回false
                    return false;
                }
            }
        }
        // 遍历完字符串，若栈为空，返回true；否则(左括号比右括号多)返回false
        return stack.isEmpty();
    }
}
