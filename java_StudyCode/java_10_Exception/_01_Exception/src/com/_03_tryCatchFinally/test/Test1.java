package com._03_tryCatchFinally.test;

// 问：输出什么？
// 答：4
// 注意：这里catch中返回3，finally中返回4，看似有两组返回值
//      但是，由于实际返回值只能有1个，且finally语句必然执行，因此返回finally中的4


public class Test1 {
    public static int method() {
        try {
            String[] strings = new String[3];
            if (strings[0].equals("hello")) {
                System.out.println(strings[0]);
            } else {
                strings[1] = "world";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return 3;
        } finally {
            return 4;
        }
    }

    public static void main(String[] args) {
        System.out.println(method());// 4
    }
}

