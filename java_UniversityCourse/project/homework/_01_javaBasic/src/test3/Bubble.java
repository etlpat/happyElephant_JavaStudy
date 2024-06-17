package test3;

import java.util.Random;

public class Bubble {
    public int[] createArr(int size) {// 生成随机整数数组
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(201) - 100;// 生成-100到100的随机数
        }
        return arr;
    }


    public void printArr(int[] arr) {// 打印数组元素
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public boolean bubbleSort(int[] arr) {// 冒泡排序
        if (arr == null) {
            return false;
        }
        for (int i = 0; i < arr.length - 1; i++) {// 循环元素个数-1趟
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {// 每趟将大元素的换到后面
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {// 假如本趟没进行交换，则提前退出
                break;
            }
        }
        return true;
    }
}
