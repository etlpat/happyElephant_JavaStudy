package com._04_homework.test03;

// 案例：请问下面的代码输出什么？
// 提示：这道题【很有意思】，注意不要掉进陷阱。


import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
//        已知:Person类按照id和name重写了hashCode和equals方法,问下面代码输出什么?

        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");
        set.add(p1);
        set.add(p2);

        p1.setName("CC");
        boolean b = set.remove(p1);
        System.out.println(b);// 注意分析，这里是【false】
        System.out.println(set);

        set.add(new Person(1001, "CC"));
        System.out.println(set);

        set.add(new Person(1001, "AA"));
        System.out.println(set);
    }
}
