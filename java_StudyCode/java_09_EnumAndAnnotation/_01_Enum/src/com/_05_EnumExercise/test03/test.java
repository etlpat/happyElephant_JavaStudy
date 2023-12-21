package com._05_EnumExercise.test03;

// 案例：创建Week枚举类，其中包含周一到周日的枚举对象
//      之后依次输出各枚举常量

public class test {
    public static void main(String[] args) {

        // 获取枚举常量的数组
        Week[] weeks = Week.values();

        for (Week week : weeks) {
            System.out.println(week);
        }
    }
}
