package com._02_generic.test02;

// 案例：
//  定义Employee类：
//      1)该类包含:private成员变量name,sal,birthday,其中birthday为MyDate类的对象;
//      2)为每一个属性定义getter,setter方法;
//      3)重写toString 方法输出 name,sal,birthday
//      4)MyDate类包含:private成员变量month,day,year;并为每一个属性定义getter,setter 方法;
//      5)创建该类的3个对象,并把这些对象放入ArrayList集合中(ArrayList 需使用泛型来定义),对集合中的元素进行排序,并遍历输出:
//  排序方式:
//      调用ArrayList的sort方法,传入Comparator对象[使用泛型],
//      先按照name排序,如果name相同,则按生日日期的先后排序。【即:定制排序】


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Employee emp1 = new Employee("chicken", 1145, new MyDate(2000, 3, 23));
        Employee emp2 = new Employee("bob", 1919, new MyDate(1974, 2, 25));
        Employee emp3 = new Employee("alice", 8100, new MyDate(1573, 8, 3));


        // (1)创建集合并添加元素
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        System.out.println("排序前：");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        System.out.println("==================================================");


        // (2)对集合进行排序
        Collections.sort(employees, new Comparator<Employee>() {
            // 重写排序规则
            @Override
            public int compare(Employee o1, Employee o2) {
                // 判空操作
                if (o1 == null || o2 == null) {
                    return 0;
                }
                // 若name不同，则按name排
                int sortByName = o1.getName().compareTo(o2.getName());
                if (sortByName != 0) {
                    return sortByName;
                }
                // name相同，按MyDate排
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });


        // (3)遍历排完序的ArrayList
        System.out.println("排序后：");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

    }
}
