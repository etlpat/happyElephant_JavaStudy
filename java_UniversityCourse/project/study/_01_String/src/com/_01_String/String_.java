package com._01_String;

// (1)创建字符串
//
//  法1：直接创建
//  String s = "xxx";
//  法2：通过类名new字符串对象（详细请见API文档）
//  String s = new String("xxx");
//  String s = new String(charArr);// 传入char数组
//  String s = new String(byteArr);// 传入byte数组
//
//
//
// (2)常用方法
//  1.char charAt(int index);
//      返回指定索引处的 char 值。
//
//  2.int length();
//      返回此字符串的长度。
//
//  3.char[] toCharArray()
//      将此字符串转换为一个新的字符数组。
//
//  4.boolean equals(Object anObject)
//      将此字符串与指定的对象比较。
//
//  5.boolean equalsIgnoreCase(String anotherString)
//      将此 String 与另一个 String 比较，不考虑大小写。
//
//
//  6.String substring(int beginIndex)
//      返回一个新的字符串，它是此字符串的一个子字符串（截取下标范围：[begin, length()-1]）。
//    String substring(int beginIndex, int endIndex)
//      返回一个新字符串，它是此字符串的一个子字符串（截取下标范围：[begin, end)，包前不包后）。
//
//  7.String replace(CharSequence target, CharSequence replacement)
//      使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
//
//  8.boolean contains(CharSequence s)
//      当且仅当此字符串包含指定的 char 值序列时，返回 true。
//      英文：contain：包含
//
//  9.String[] split(String regex)
//      根据给定正则表达式的匹配拆分此字符串。
//
//  10.boolean startsWith(String prefix)
//      测试此字符串是否以指定的前缀开始。
//
//
//
// (3)注意事项
//  1."字符串"对象是不可变的
//      注意：每次我们用双引号直接定义一个字符串"xxx"，则该字符串会被存入常量池中
//           我们对字符串进行改动，如拼接或替换，并不会影响常量池中的字符串
//      如：name = "张三" + "李四"; "张三"、"李四"会被分别存入常量池中，不可改变
//         不过name整体并不在常量池中，是可修改的
//
//  2.常量池中，相同内容的字符串只会存储一份
//      如：String n1 = "张三";// 会在常量池中存放一个"张三"
//         String n2 = "张三";// 常量池中字符串不会重复存储
//
//  3.通过new的方式创建的字符串，每new一次，都会在堆区中产生一个新的对象
//      （仅有直接通过双引号"xxx"创建的字符串，才存在常量池中）
//      e.g.String s1 = new String("123");// 栈区引用s1指向堆区对象，堆区字符串对象又指向常量池中的"123"
//
//      e.g.String s2 = "abc";// s2指向常量池中的"abc"
//          String s3 = "ab";// s3指向在常量池中的"ab"
//          String s4 = s3 + "c";// 对象运算后的结果在堆区，s4指向堆区对象（由于s3是符号，编译阶段不会识别其内容，因此这里不会优化）
//          String s5 = "ab" + "c";// 特殊：当两个"xxx"直接相加，编译器会优化处理，由于常量池中已经有"abc"，则s5会直接指向"abc"


public class String_ {
    public static void main(String[] args) {
        // (1)字符串的定义
        char[] arr1 = {'a', 'b', 'c'};
        byte[] arr2 = {97, 98, 99};

        String s1 = "12345";
        String s2 = new String("12345");
        String s3 = new String(arr1);// 传入char数组
        String s4 = new String(arr2);// 传入byte数组

        System.out.println(s1);// 12345
        System.out.println(s2);// 12345
        System.out.println(s3);// abc
        System.out.println(s4);// abc


        // 2.常用的String方法
        System.out.println();

        System.out.println("114514".length());// 6
        System.out.println("哈和嗨吼".charAt(2));// 嗨
        // 方法：将字符串变为字符数组
        printArr("1234567".toCharArray());// {1, 2, 3, 4, 5, 6, 7}
        String s5 = new String("www");
        System.out.println("www" == s5);// false（==判断值是否相等，引用的值是其地址）
        System.out.println("www".equals(s5));// true
        // 方法：比较字符串内容（忽略大小写）
        System.out.println("qwer".equalsIgnoreCase("QWER"));// true

        // 方法：截取并返回子串
        String s6 = new String("0123456789");
        System.out.println(s6.substring(6));// 6789（截取范围：[begin, length()-1]）
        System.out.println(s6.substring(5, 8));// 567（截取范围：[begin, end)）

        // 方法：替换子串，并返回新字符串
        String s7 = new String("哈哈，你可真是个狗啊，垃圾");
        String s8 = s7.replace("狗", "*").replace("垃圾", "**");
        System.out.println(s8);// 哈哈，你可真是个*啊，**

        // 方法：判断字符串是否包含指定子串
        String s9 = new String("weafwefw张三aodshifiod");
        System.out.println(s9.contains("张三"));// true
        System.out.println(s9.contains("李四"));// false

        // 方法：按照指定内容分割字符串，并返回字符串数组
        String[] sArr = "张三, 李四, 王五, 赵六".split(", ");
        printArr(sArr);// {"张三", "李四", "王五", "赵六"}

        // 方法：判断字符串是否以指定子串开头
        String s10 = "Java111222333";
        System.out.println(s10.startsWith("Java"));// true
        System.out.println(s10.startsWith("java"));// false
    }


    // 打印字符数组
    public static void printArr(char[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1] + "}");
    }

    public static void printArr(String[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print("\"" + arr[i] + "\", ");
        }
        System.out.println("\"" + arr[arr.length - 1] + "\"}");
    }
}
