package test02;

abstract class Person {
    private String name;
    private String sex;
    private int age;

    public Person() {
    }

    public Person(String name, String sex, int age) {
        setName(name);
        setAge(age);
        setSex(sex);
    }

    public void eat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
