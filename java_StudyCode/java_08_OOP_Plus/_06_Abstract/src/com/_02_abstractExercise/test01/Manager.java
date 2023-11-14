package com._02_abstractExercise.test01;

public class Manager extends BasicEmployee {
    private static int workingMonth = 10;
    private double bonus;

    public Manager() {
    }

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public static int getWorkingMonth() {
        return workingMonth;
    }

    public static void setWorkingMonth(int workingMonth) {
        Manager.workingMonth = workingMonth;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                super.toString() +
                ", bonus=" + bonus +
                '}';
    }

    @Override
    public void work() {
        System.out.println("经理在管理");
    }

    @Override
    public double getAnnualSalary() {
        return workingMonth * getSalary() + bonus;
    }
}
