import java.util.*;

public class Bubble {
    // 冒泡排序数组(小->大)
    public boolean bubbleSort(int[] arr) {
        if (arr == null) {
            return false;
        }
        for (int i = 0; i < arr.length - 1; i++) {// 循环元素个数-1趟
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {// 每趟把最大的元素换到后面
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return true;
    }


    // 打印一维数组
    public void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Random rand = new Random();
        int maxSize = 20;
        int[] arr = new int[maxSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(101);
        }

        Bubble b = new Bubble();
        System.out.println("排序前：");
        b.printArr(arr);
        b.bubbleSort(arr);
        System.out.println("排序后：");
        b.printArr(arr);
    }
}
