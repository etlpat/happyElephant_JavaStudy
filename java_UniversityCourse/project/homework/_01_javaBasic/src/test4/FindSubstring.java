package test4;

import java.util.Random;

public class FindSubstring {
    public int MaxSizeRandomLength = 20;// 一行乱码吗字符个数

    private String createRandomString() {// 创建一行乱码
        Random rand = new Random();
        int n = rand.nextInt(MaxSizeRandomLength + 1);
        String str = "";
        for (int i = 0; i < n; i++) {
            str += (char) (rand.nextInt(127) + 1);// 拼接ascii为1到127的字符
        }
        return str;
    }


    public String createMessyCode(String[] arr) {// 将传入的数组混入乱码的方法
        String str = "" + createRandomString();
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            str += createRandomString();
        }
        return str;
    }


    public void printArr(String[] arr) {// 打印数组元素
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void printArr(int[] arr) {// 打印数组元素
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public int[] findIndex(String str, String[] strArr) {// 查找子串
        int[] arr = new int[strArr.length];
        for (int index = 0; index < strArr.length; index++) {// 遍历字符数组
            for (int i = 0; i < str.length(); i++) {// 遍历字符串
                if (str.charAt(i) == strArr[index].charAt(0)) {
                    boolean flag = true;
                    for (int j = 0; j < strArr[index].length(); j++) {
                        if (str.charAt(i + j) != strArr[index].charAt(j)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        arr[index] = i;
                    }
                }
            }
        }
        return arr;
    }
}
