package com.test05;

public class Doctor {
    private String name;
    private int age;
    private String job;
    private double salary;

    public Doctor() {
    }

    public Doctor(String name, int age, String job, double salary) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof Doctor) {
            Doctor d = (Doctor) obj;
                                                      return name.equals(d.name) && age == d.age && job.equals(d.job) && salary == d.salary;
        }
        return false;
    }

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
