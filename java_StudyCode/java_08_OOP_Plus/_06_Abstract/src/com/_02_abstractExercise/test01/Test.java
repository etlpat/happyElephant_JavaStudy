package com._02_abstractExercise.test01;

// 案例：编写一个抽象BasicEmployee类，属性{name,id,salary}，为其提供抽象方法work和getAnnualSalary
//      Manager类继承Employee，新增属性{workingMonth工作月数,bonus奖金}，需要重写父类方法
//      Worker类继承Employee，新增属性{workingMonth}，需要重写父类方法


public class Test {
    public static void main(String[] args) {
        BasicEmployee[] arr = new BasicEmployee[4];
        arr[0] = new Manager("老张", "1145", 6000, 20000);
        arr[1] = new Manager("老王", "1919", 5500, 28000);
        arr[2] = new Worker("小李", "256", 3200);
        arr[3] = new Worker("小赵", "128", 3500);


        for (int i = 0; i < arr.length; i++) {
            System.out.println("============");
            System.out.println(arr[i]);
            arr[i].work();
            System.out.println(arr[i].getAnnualSalary());
        }
    }
}
