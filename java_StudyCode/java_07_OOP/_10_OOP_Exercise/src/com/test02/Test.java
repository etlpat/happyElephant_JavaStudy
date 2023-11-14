package com.test02;

/**
 * 案例2
 * 要求：
 * 1.定义Teacher类{name, age, post职称, salary基本工资}，有方法introduce()，输出教师信息
 * 2.定义Teacher的子类，Professor教授类。增加属性工资级别，固定为1.3，并重写类方法
 * 3.定义Teacher对象，分别指向本类和子类，调用各自introduce()
 */

public class Test {
    public static void main(String[] args) {
        Teacher[] tArr = new Teacher[2];
        tArr[0] = new Teacher("张三", 33, "资深教师", 3456);
        tArr[1] = new Professor("李四", 66, "高级资深教授", 5678, 1.3);

        // 体现方法的动态绑定机制
        tArr[0].introduce();// Teacher{name='张三', age=33, post='资深教师', salary=3456.0}
        tArr[1].introduce();// Professor{name='李四', age=66, post='高级资深教授', salary=5678.0, grade=1.3}
    }
}
