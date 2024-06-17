package com._01_String.test;

// 案例：有一个姓名列表str"张三, 李四, 王五, 赵六, 孙七"
//      判断以下列表中的名称，是否都存在于str中
//      str1"孙七 张三 王五"
//      str2"李四 小明 小红"


public class test4 {
    public static void main(String[] args) {
        String str = "张三, 李四, 王五, 赵六, 孙七";
        String s1 = "孙七 张三 王五";
        String s2 = "李四 小明 小红";

        System.out.println(judgeNameList(str, s1));// true
        System.out.println(judgeNameList(str, s2));// false
    }

    public static boolean judgeNameList(String nameList1, String nameList2) {
        String[] sArr = nameList2.split(" ");
        for (int i = 0; i < sArr.length; i++) {
            if (!nameList1.contains(sArr[i])) {
                return false;
            }
        }
        return true;
    }
}
