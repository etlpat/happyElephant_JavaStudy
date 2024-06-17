package com.leetcode_2024_03_05.test3;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        // 队列数组，该数组下标对应队列中字符串长度
        MyQueue[] myQueues = new MyQueue[101];
        for (int i = 0; i <= 100; i++) {
            myQueues[i] = new MyQueue();
        }
        // 将字符串下标存入对应长度的队列中
        for (int i = 0; i < nums.length; i++) {
            myQueues[nums[i].length()].enQueue(i);
        }
        int count = 0;
        // 经循环后，变为求长度为count位的字符串中第k大的数字
        for (int i = 100; i >= 1; i--) {
            if (k > myQueues[i].sz) {
                k -= myQueues[i].sz;
            } else {
                count = i;
                break;
            }
        }

        // 对等长字符串进行基数排序，获得递增的linkedList序列
        MyQueue[] myBucket = new MyQueue[10];// 创建编号0~9的桶
        for (int i = 0; i < 10; i++) {
            myBucket[i] = new MyQueue();
        }
        MyQueue linkedList = myQueues[count];// 对该队列中字符串进行排序
        MyQueue.Element tmp;
        int t, l;
        boolean flag;
        for (int i = count - 1; i >= 0; i--) {// 从个位开始依次向十位、百位排序
            tmp = linkedList.head.next;
            while (tmp != null) {// 元素入桶
                l = nums[tmp.index].charAt(i) - '0';// 表示tmp对应字符串在第i位的数字
                myBucket[l].tail.next = tmp;
                tmp = tmp.next;
                myBucket[l].tail = myBucket[l].tail.next;
                myBucket[l].tail.next = null;
                myBucket[l].sz++;
            }
            t = 0;
            flag = true;
            while (t <= 9) {// 将桶从0~9编号连成串
                while (t <= 9 && myBucket[t].sz == 0) {
                    t++;// t指向下一个非空桶
                }
                if (t > 9) {
                    break;
                }
                if (flag) {// 若首次连接
                    linkedList.head.next = myBucket[t].head.next;
                    linkedList.tail = myBucket[t].tail;
                    flag = false;
                } else {
                    linkedList.tail.next = myBucket[t].head.next;
                    linkedList.tail = myBucket[t].tail;
                }
                myBucket[t].clear();
                t++;
            }
        }

//        // 打印从小到大的序列
//        MyQueue.Element e = linkedList.head.next;
//        System.out.print("{");
//        while (e.next != null) {
//            System.out.print(nums[e.index] + ", ");
//            e = e.next;
//        }
//        System.out.println(nums[e.index] + "}");

        // 基数排序后的序列的第k位，即为所求元素
        k = linkedList.sz - k + 1;
        tmp = linkedList.head.next;
        while (--k > 0) {
            tmp = tmp.next;
        }
        return nums[tmp.index];
    }
}


class MyQueue {
    public Element head = new Element(-1, null);
    public Element tail = head;
    int sz = 0;

    public static class Element {
        int index;
        Element next;

        public Element() {
            this.next = null;
        }

        public Element(int index, Element next) {
            this.index = index;
            this.next = next;
        }
    }

    public void enQueue(int index) {
        tail.next = new Element(index, tail.next);
        tail = tail.next;
        sz++;
    }

    public int deQueue() {
        if (head == tail) {
            return -1;
        } else if (head.next == tail) {
            tail = head;
        }
        Element tmp = head.next;
        head.next = tmp.next;
        sz--;
        return tmp.index;
    }

    public void clear() {
        tail = head;
        head.next = null;
        sz = 0;
    }
}

