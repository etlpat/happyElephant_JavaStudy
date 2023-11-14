package com._04_polyExercise;

// 例题1：判断下面每条语句的对错

public class Test01 {
    public static void main(String[] args) {
        double d = 31.4;
        long l = (long) d;
        System.out.println(l);// 31

        int i = 5;
//        boolean b = (boolean) i;// 报错（java中boolean类型不能和其他类型相互强转）

        Object obj1 = "hello";
        String str1 = (String) obj1;
        System.out.println(str1);// hello

        Object obj2 = new Integer(5);
//        String str2 = (String) obj2;// 报错（向上转型后的父类引用，只能向下转型为其子类(或子类的父类)）
        Integer integer = (Integer) obj2;
    }
}
