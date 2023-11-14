package com._04_memberInnerClass.test01;

public class Person {
    private String name;
    private int age;
    private double salary;
    private Dog dog;

    // Person的成员内部类Dog，继承抽象Animal类
    public class Dog extends Animal {
        public Dog() {
        }

        public Dog(String name, int age) {
            super(name, age);
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + getName() + '\'' +
                    ", age=" + getAge() +
                    '}';
        }

        @Override
        public void eat() {
            System.out.println("小狗" + getName() + " 吃骨头");
        }

        @Override
        public void sleep() {
            System.out.println("小狗" + getName() + " 在睡觉");
        }

        public void findMaster() {
            System.out.println("小狗" + getName() + " 寻找主人" + Person.this.name);
        }
    }


    // 该方法会调用Person对象的dog属性的方法
    public void playWithDog() {
        if (dog == null) {
            System.out.println(getName() + " 没养小狗");
            return;
        }
        System.out.println(getName() + "的小狗是：" + dog);
        dog.eat();
        dog.sleep();
        dog.findMaster();
    }


    // 新建并返回成员内部类Dog的实例的方法
    public Dog getDogInstance(String dogName, int dogAge) {
        return new Dog(dogName, dogAge);
    }


    // 构造器
    public Person() {
    }

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Person(String name, int age, double salary, String dogName, int dogAge) {
        this(name, age, salary);
        this.dog = new Dog(dogName, dogAge);
    }


    // get、set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(String dogName, int dogAge) {
        this.dog = new Dog(dogName, dogAge);
    }
}
