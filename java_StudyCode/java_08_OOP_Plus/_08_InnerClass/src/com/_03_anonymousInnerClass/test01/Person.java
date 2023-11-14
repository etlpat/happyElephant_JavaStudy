package com._03_anonymousInnerClass.test01;

public class Person {
    private String name;
    private double salary;
    private double totalYearSalary = 0;

    // 构造器
    public Person() {
    }

    public Person(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // get、set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public void addYearSalary() {
        totalYearSalary += 12 * salary;
    }


    // 工作方法，其中包含匿名内部类
    public void work() {
        // 匿名内部类Person$1实现WorkBehavior接口
        WorkBehavior wb = new WorkBehavior() {
            @Override
            public void work() {
                System.out.println("电工" + name + " 进行工程作业");
            }

            @Override
            public void changeSalary(double salary) {
                System.out.println(name + "月薪变更为" + salary);
                setSalary(salary);
            }

            @Override
            public void getBonus(double bonus) {
                System.out.println(name + "获得" + bonus + "元奖金");
                totalYearSalary += bonus;
            }
        };

        wb.work();
        wb.getBonus(10000);
        wb.changeSalary(salary + 400);

        addYearSalary();
        System.out.println(name + "今年总工资为：" + totalYearSalary);
    }


    // 休息方法，其中包含匿名内部类
    public void rest() {
        // 匿名内部类Person$2实现RestBehavior类
        RestBehavior wr = new RestBehavior("周末休息") {
            @Override
            public void rest() {
                System.out.println(Person.this.name + " 正在进行" + name);
            }

            @Override
            public void sleep() {
                System.out.print(Person.this.name);
                super.sleep();
            }

            @Override
            public void eat() {
                System.out.print(Person.this.name);
                super.eat();
            }
        };

        wr.rest();
        wr.sleep();
        wr.eat();


        new RestBehavior() {
            @Override
            public void eat() {
                System.out.println(Person.this.name + "破费吃大餐，吃了烤全羊");
            }
        }.eat();
    }
}
