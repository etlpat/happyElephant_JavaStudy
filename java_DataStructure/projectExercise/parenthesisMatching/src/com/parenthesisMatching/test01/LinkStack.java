package com.parenthesisMatching.test01;

// LinkStack链栈，实现括号匹配
// 该链栈属性包含头结点，且只能从头结点入栈/出栈

import com.sun.javaws.IconUtil;

public class LinkStack {
    // 属性只包含链栈头结点
    private LNode head;

    // 静态的结点内部类
    public static class LNode {
        private char parenthesis;// 存放括号字符
        private LNode next = null;// 下一结点的引用

        public LNode() {
            next = null;
        }

        public LNode(char parenthesis, LNode next) {
            this.parenthesis = parenthesis;
            this.next = next;
        }

        public char getParenthesis() {
            return parenthesis;
        }

        public void setParenthesis(char parenthesis) {
            this.parenthesis = parenthesis;
        }

        public LNode getNext() {
            return next;
        }

        public void setNext(LNode next) {
            this.next = next;
        }
    }


    // 构造器
    public LinkStack() {
        this.head = new LNode();// 为链表创建头结点
    }

    // 元素入栈
    public boolean push(char parenthesis) {
        LNode node = new LNode(parenthesis, head.next);
        head.next = node;
        return true;
    }

    // 元素出栈，并获取被出栈的结点数据
    public boolean pop(LNode node) {
        if (head.next == null) {// 若栈为空，返回false
            return false;
        }
        node.parenthesis = head.next.parenthesis;
        node.next = null;
        head.next = head.next.next;
        return true;
    }

    // 元素出栈，重载
    public boolean pop() {
        if (head.next == null) {// 若栈为空，返回false
            return false;
        }
        head.next = head.next.next;
        return true;
    }

    // 获取栈顶元素
    public char getTop() {
        if (head.next == null) {// 若栈为空，返回\0
            return '\0';
        }
        return head.next.parenthesis;
    }

    // 清空栈
    public boolean clearStack() {
        LNode node;
        while (head.next != null) {
            node = head.next;
            head.next = head.next.next;
            node.next = null;
        }
        return true;
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return head.next == null;
    }

    // 打印栈中从栈底到本元素的信息，并返回从栈底到本元素的元素个数
    private int printStackElement(LNode node) {
        if (node == null) {// 结束条件：传入结点为空
            return 0;
        }
        int num = 1 + printStackElement(node.next);
        System.out.println("第" + num + "位：" + node.parenthesis);
        return num;
    }

    // 遍历打印栈中元素
    public void printLinkStack() {
        if (head.next == null) {
            System.out.println("栈为空");
            return;
        }
        System.out.println("元素个数为：" + printStackElement(head.next));
    }
}
