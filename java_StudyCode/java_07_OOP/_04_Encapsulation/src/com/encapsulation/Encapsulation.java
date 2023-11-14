// encapsulation：封装


// 封装
//
// 封装概念：
//  把从事物中抽象出来的数据[属性]和对数据的操作[方法]封装在一起，
//  将属性保护在类内部，外部只有通过方法，才能对内部的属性进行操作
//
//
// 封装实现步骤：
//  1.将属性设置为private(仅类内可访问)
//  2.提供公共的set方法，用于在类外修改属性的值
//  3.提供公共的get方法，用来在类外获取属性的值
//    IDEA快捷键：(Alt+Insert)快速生成set、get方法
//
//
// 封装的好处：
//  1.对用户隐藏代码实现的细节
//  2.用方法来限制对属性的修改，保证安全合理
//
//
//
// 注意：
//  1.若在set方法中对属性赋值进行限制，构造器赋初值时也建议调用set方法
//    否则，构造器内不会对初值进行限制




package com.encapsulation;

public class Encapsulation {
    public static void main(String[] args) {
        Person p1 = new Person();

        p1.setName("12345678901234567890");// 名字必须在1到16个字符之间
        p1.setAge(3000);// 年龄需要在1到130之间
        System.out.println(p1.info());// name=null age=0 salary=0.0 job=null

        p1.setName("张三");
        p1.setAge(19);
        p1.setSalary(1145.14);
        p1.setJob("厨师");
        System.out.println(p1.info());// name=张三 age=19 salary=1145.14 job=厨师
    }
}


// 要求：定义一个Person类，有name、age、salary、job属性
//      后三个属性定为私有，并写出属性的get、set方法
//      其中name要求1到16字符，age是正数且小于130
class Person {
    public String name;
    private int age;
    private double salary;
    private String job;

    // IDEA生成构造器和get、set方法快捷键：
    // Alt + Insert

    public Person(String name, int age, double salary, String job) {
        // 可以在构造器中调用set方法(为初值添加限制)
        setName(name);
        setAge(age);
        setSalary(salary);
        setJob(job);
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // 限制姓名长度
        if (1 <= name.length() && name.length() <= 16) {
            this.name = name;
        } else {
            System.out.println("名字必须在1到16个字符之间");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        // 限制年龄大小
        if (age > 0 && age <= 130) {
            this.age = age;
        } else {
            System.out.println("年龄需要在1到130之间");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String info() {// 用字符串返回属性的信息
        return "name=" + name + " age=" + age + " salary=" + salary + " job=" + job;
    }
}