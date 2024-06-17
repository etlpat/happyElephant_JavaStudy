package test02;

public class English extends Person {
    public English(String name, String sex, int age) {
        super(name, sex, age);
    }

    public English() {
    }

    public void eat() {
        System.out.println("English类调用eat()");
    }

    public void horseRiding() {
        System.out.println("English类调用horseRiding()");
    }
}
