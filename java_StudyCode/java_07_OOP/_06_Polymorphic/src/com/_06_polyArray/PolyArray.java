// polymorphic array：多态数组

// 多态数组
//
// (1)概念
//  多态数组：数组的定义类型为父类，用来存放子类对象
//
// (2)本质
//  还是父类引用指向子类对象(向上转型)，仍遵循对象多态的规则
//
// (3)内存分析
//  （以Object[]数组arr，存放String元素为例）
//  栈区的引用arr指向堆区的Object[]数组空间，存放的元素是Object类的引用。
//  每个元素(Object引用)指向堆区中String对象的空间（父类引用指向子类对象）




package com._06_polyArray;

// 案例：Teacher、Student类都继承Person类
//  ①.创建一个Person(父类)数组，存放Teacher、Student(子类)对象各两个
//  ②.调用数组元素Teacher中的特有方法teach、Student中的特有方法study

public class PolyArray {
    public static void main(String[] args) {
        // (1)多态数组
        Person[] personArr = new Person[4];
        // 每个元素是父类引用，指向子类对象
        personArr[0] = new Teacher("孔子", 53, 5600);
        personArr[1] = new Teacher("墨子", 62, 4900);
        personArr[2] = new Student("小明", 14, 67);
        personArr[3] = new Student("小红", 15, 98);


        // (2)多态调用say()方法
        for (int i = 0; i < personArr.length; i++) {
            System.out.println("index:" + i + ", " + personArr[i].say());
        }
//        index:0, Teacher 姓名：孔子 年龄：53 薪水：5600.0
//        index:1, Teacher 姓名：墨子 年龄：62 薪水：4900.0
//        index:2, Student 姓名：小明 年龄：14 分数：67.0
//        index:3, Student 姓名：小红 年龄：15 分数：98.0


        // (3)调用子类中特有的方法 【用instanceof判断元素的运行类型】
        for (int i = 0; i < personArr.length; i++) {
            if (personArr[i] instanceof Teacher) {// 判断personArr[i]的运行类型是否是Teacher类(或其子类)
                ((Teacher) personArr[i]).teach();
            } else if (personArr[i] instanceof Student) {
                ((Student) personArr[i]).study();
            }
        }
//        Teacher孔子 在讲课...
//        Teacher墨子 在讲课...
//        Student小明 在学习...
//        Student小红 在学习...
    }
}
