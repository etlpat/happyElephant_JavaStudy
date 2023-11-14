package com.test01;

public class MyTools {

    public void bubbleSort(Person[] pArr) {// 按照年龄对对象数组冒泡排序
        for (int i = 0; i < pArr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < pArr.length - i - 1; j++) {
                if (pArr[j].getAge() > pArr[j + 1].getAge()) {// 按照年龄从小到大对元素进行排序
                    Person tmp = pArr[j];
                    pArr[j] = pArr[j + 1];
                    pArr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public void printArr(Person[] pArr) {
        for (int i = 0; i < pArr.length; i++) {
            System.out.println("index:" + i + ", " + pArr[i]);
        }
    }
}
