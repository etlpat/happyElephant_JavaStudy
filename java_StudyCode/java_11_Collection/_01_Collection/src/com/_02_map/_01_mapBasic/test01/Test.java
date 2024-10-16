package com._02_map._01_mapBasic.test01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 案例：在HashMap中添加3个员工对象
//      key:员工的id，value：员工对象
//      要求用两种方法遍历并显示工资>18000的员工

public class Test {
    public static void main(String[] args) {
        Employee employee1 = new Employee("101", "张三", 37000);
        Employee employee2 = new Employee("102", "李四", 17000);
        Employee employee3 = new Employee("103", "王五", 25000);
        Employee employee4 = new Employee("104", "赵六", 15000);
        Map employees = new HashMap();

        employees.put(employee1.getId(), employee1);
        employees.put(employee2.getId(), employee2);
        employees.put(employee3.getId(), employee3);
        employees.put(employee4.getId(), employee4);

        // 遍历方式1 -- entrySet
        Set entrySet = employees.entrySet();
        for (Object object : entrySet) {
            Map.Entry entry = (Map.Entry) object;
            Employee value = (Employee) entry.getValue();
            if (value.getSalary() > 18000) {
                System.out.println(entry.getKey() + "=" + value);
            }
        }
        System.out.println("=================");

        // 遍历方式2 -- keySet
        Set keySet = employees.keySet();
        for (Object key : keySet) {
            Employee value = (Employee) employees.get(key);
            if (value.getSalary() > 18000) {
                System.out.println(key + "=" + value);
            }
        }


    }
}
