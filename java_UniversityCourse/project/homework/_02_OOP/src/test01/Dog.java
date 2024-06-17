package test01;

public class Dog extends Pet{
    private String color;

    public Dog(String name, String sex, String color) {
        super(name, sex);
        setColor(color);
    }

    public Dog() {
    }

    public void talk() {
        System.out.println("Dog类调用talk()");
    }

    public void eat() {
        System.out.println("Dog类调用eat()");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
