package com._01_String.test;

// 案例：将间隔符内的每个子串反转
// e.g. 将 oT eb ro ton ot eb
//  反转为：To be or not to be


public class test3 {
    public static void main(String[] args) {
        String s1 = "oT eb ro ton ot eb";
        String s2 = reverseSubString(s1, " ");
        System.out.println(s1);// oT eb ro ton ot eb
        System.out.println(s2);// To be or not to be
    }


    public static String reverseSubString(String str, String separator) {
        String[] sArr = str.split(separator);
        String tmp = "";
        for (int i = 0; i < sArr.length; i++) {
            for (int j = sArr[i].length() - 1; j >= 0; j--) {
                tmp += sArr[i].charAt(j);
            }
            if (i != sArr.length - 1) {
                tmp += separator;
            }
        }
        return tmp;
    }
}
