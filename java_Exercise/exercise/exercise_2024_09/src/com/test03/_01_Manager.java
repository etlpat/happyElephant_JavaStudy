package com.test03;

public class _01_Manager extends _01_Employee {
    private double bonus;// 奖金


    public _01_Manager() {
        super();// 若不写，子类也会自动补充父类的默认无参构造器super()
    }

    public _01_Manager(String name, double salary, double bonus) {
        super(name, salary);// 调用父类构造器
        this.bonus = bonus;
    }


    @Override
    public double getYearSalary() {
        // 通过super调用父类方法
        return super.getYearSalary() + bonus;
    }

    @Override
    public void func1(int n) {
        System.out.println("_01_Manager类:func1(int n)");
    }

    @Override
    public String toString() {// 子类中不能直接访问父类中的private成员，只能通过方法获取
        return "_01_Manager{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", salary=" + getSalary() +
                ", bonus=" + bonus +
                '}';
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
