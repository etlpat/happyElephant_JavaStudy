package com._02_abstractExercise.test01;

public class Worker extends BasicEmployee {
    // 由于所有工人的工作月数一样，将其设置为静态属性
    private static int workingMonth = 12;

    public Worker() {
    }

    public Worker(String name, String id, double salary) {
        super(name, id, salary);
    }

    public static int getWorkingMonth() {
        return workingMonth;
    }

    public static void setWorkingMonth(int workingMonth) {
        Worker.workingMonth = workingMonth;
    }

    @Override
    public String toString() {
        return "Worker{" + super.toString() + "}";
    }

    @Override
    public void work() {
        System.out.println("工人在工作");
    }

    @Override
    public double getAnnualSalary() {
        return workingMonth * getSalary();
    }
}
