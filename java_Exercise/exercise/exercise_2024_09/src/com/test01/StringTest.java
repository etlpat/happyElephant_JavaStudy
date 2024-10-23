package com.test01;

public class StringTest {
    public static void main(String[] args) {

        String myString = "HelloWorld";
        System.out.println(myString);


        // 计算字符串长度
        System.out.println(myString.length());


        // 截取子串(包前不包后)
        System.out.println(myString.substring(0, 5));


        // 获取下标对应的字符
        System.out.println(myString.charAt(5));


        // 字符串拼接（+）
        System.out.println(myString + "你好世界");
        System.out.println("PS" + 514);// 将数字转为字符串并拼接

        String tmp = myString.substring(0, 5) + "114514";
        System.out.println(tmp);


        // 判断字符串是否相等
        // equals方法用于逐一比较两字符串是否相等（很多类都重写了equals方法，使其可以合理的判断是否相等）
        System.out.println("123".equals("123"));
        System.out.println("123".equals("1234"));
        // ==对于引用类型，判断其地址是否相等
        // 注意：只有字符串常量是共享的，而+或substring等操作产生的字符串是不能共享的
        System.out.println("HelloWorld" == myString);// true
        System.out.println("Hello" == myString.substring(0,5));// false


        // 空串""和null
        // 注意：""空串是空串，而不是null
        String str1 = "";
        String str2 = null;
        System.out.println(str1.length());// 0
        System.out.println(str1.equals(str2));// false

    }
}
