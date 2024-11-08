package com._05_prototypePattern.test02;

public class MeritCertificate implements Cloneable {
    private Student student = null;

    public MeritCertificate() {
    }

    public MeritCertificate(Student student) {
        this.student = student;
    }


    // 重写clone方法，实现深克隆
    @Override
    protected MeritCertificate clone() throws CloneNotSupportedException {
        if (student == null) {
            return new MeritCertificate();
        }
        // 若学生不为空，深克隆。创建新的Student对象（与该对象的student值相同）作为克隆对象的成员。
        return new MeritCertificate(new Student(student.getId(), student.getName(), student.getAge()));
    }


    public void show() {
        System.out.println("“三好学生”:" + student + "获得该奖状~~");
    }

    @Override
    public String toString() {
        return "MeritCertificate{" +
                "student=" + student +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
