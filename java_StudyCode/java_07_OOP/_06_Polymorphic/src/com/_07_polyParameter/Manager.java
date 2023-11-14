package com._07_polyParameter;

public class Manager extends Employee {
    private double bonus;// 奖金

    public Manager() {
    }

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    // 新增
    public void manage() {
        System.out.println("Manager" + getName() + " 在管理...");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + getBonus();
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
