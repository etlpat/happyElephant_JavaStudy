package com.test03;

public class _01_Test {
    public static void main(String[] args) {
        _01_Employee[] empArr = new _01_Employee[4];

        empArr[0] = new _01_Employee("张三", 3000);
        empArr[1] = new _01_Employee("李四", 4000);
        empArr[2] = new _01_Manager("王五", 5000, 20000);
        empArr[3] = new _01_Manager("赵六", 6666, 33333);


        for (_01_Employee emp : empArr) {
            System.out.print(emp);
            System.out.println("\t年薪：" + emp.getYearSalary());
        }


        empArr[2].func1(1);// _01_Manager类:func1(int n)
        empArr[2].func1("1");// _01_Employee类:func1(String s)


        _01_Manager m1 = (_01_Manager) empArr[2];
//        _01_Manager m2 = (_01_Manager) empArr[0];// 报错
    }
}
