package com.experiment03._01_iteratorPattern;

import com.experiment03._01_iteratorPattern.Iterator.AbstractIterator;
import com.experiment03._01_iteratorPattern.container.SkyworthTV;
import com.experiment03._01_iteratorPattern.container.TCLTV;

public class Client {
    public static void main(String[] args) {
        // (1)测试创维电视的迭代器
        SkyworthTV skyworthTV = new SkyworthTV();
        AbstractIterator iterator1 = skyworthTV.iterator();

        // 从头到尾、从尾到头遍历迭代器
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }
        while (iterator1.hasPrevious()) {
            System.out.print(iterator1.previous() + " ");
        }

        System.out.println("\n==============================");


        // (2)测试TCL电视的迭代器
        TCLTV tcltv = new TCLTV();
        AbstractIterator iterator2 = tcltv.iterator();

        // 从头到尾、从尾到头遍历迭代器
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + " ");
        }
        while (iterator2.hasPrevious()) {
            System.out.print(iterator2.previous() + " ");
        }
    }
}
