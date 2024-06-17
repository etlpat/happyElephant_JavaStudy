package com.leetcode_2024_03_12.test1;

public class Solution {
    public String reverseParentheses(String s) {
        MyLinkedList myStack = new MyLinkedList();// 栈，保存整条字符串
        MyLinkedList myQueue = new MyLinkedList();// 队列，暂时保存逆序字符串
        MyLinkedList.Element tmpElement = new MyLinkedList.Element();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ')') {// 若不为')'，元素入栈
                myStack.add(s.charAt(i));
            } else {// 若为')'，元素出栈，直到遇到'('
                while (myStack.deStack(tmpElement) && tmpElement.ch != '(') {// 持续出栈，直到出栈了左括号或栈空后停止
                    myQueue.add(tmpElement.ch);// 逆序字符入队
                }
                myStack.connectLinkedLists(myQueue);// 将逆序字符的队列入栈
                myQueue.clear();
            }
        }

        String str = "";
        while (myStack.deQueue(tmpElement)) {// 从栈底到栈顶的元素顺序即为最终结果
            str += tmpElement.ch;
        }
        return str;
    }
}


class MyLinkedList {
    public Element head, tail;

    public static class Element {// 结点元素内部类
        char ch;
        Element next;

        public Element() {
            this.next = null;
        }

        public Element(char ch, Element next) {
            this.ch = ch;
            this.next = next;
        }
    }

    public MyLinkedList() {// 构造器：创建空链表
        head = new Element();
        tail = head;
    }

    public boolean isEmpty() {// 判断链表是否为空
        return head == tail;
    }

    public void clear() {// 清空链表
        if (isEmpty()) {
            return;
        }
        head.next = null;
        tail = head;
    }

    public boolean add(char ch) {// 作为栈/队列添加元素（尾插法）
        tail.next = new Element(ch, tail.next);
        tail = tail.next;
        return true;
    }

    public boolean deStack(Element ret) {// 作为栈删除元素（尾删法）
        if (isEmpty()) {
            return false;
        }
        Element tmp = head;
        while (tmp.next != tail) {
            tmp = tmp.next;
        }
        ret.ch = tail.ch;
        ret.next = tail.next;
        tmp.next = tail.next;
        tail = tmp;
        return true;
    }

    public boolean deQueue(Element ret) {// 作为队列删除元素（头删法）
        if (isEmpty()) {
            return false;
        }
        Element tmp = head.next;
        if (tmp == tail) {
            tail = head;
        }
        ret.ch = tmp.ch;
        ret.next = tmp.next;
        head.next = tmp.next;
        return true;
    }

    public boolean connectLinkedLists(MyLinkedList otherList) {// 将otherList连接到本链表后
        if (otherList.isEmpty()) {
            return true;
        }
        this.tail.next = otherList.head.next;
        this.tail = otherList.tail;
        return true;
    }
}