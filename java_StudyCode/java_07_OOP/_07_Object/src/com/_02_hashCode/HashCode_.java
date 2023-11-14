// hashCode方法（属于Object类）
//
// 1.hashCode()
//  功能：返回对象的哈希码
//  作用：提高具有哈希结构的容器的效率
//  注意：子类多对hashCode()方法进行改写
//
//
// 2.哈希码：
//  哈希码一般是通过将对象的内部地址转换成一个10进制整数来实现的（但是不能完全等价于地址）
//      两个引用指向同一个对象，哈希值肯定一样
//      两个引用指向不同对象，哈希值一般不一样（特殊情况下可能一样）




package com._02_hashCode;

public class HashCode_ {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = o1;
        Object o3 = new Object();

        // 哈希码一般是将对象的地址转换成整数
        System.out.println(o1.hashCode());// 460141958
        System.out.println(o2.hashCode());// 460141958
        System.out.println(o3.hashCode());// 1163157884
    }
}
