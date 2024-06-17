package test01;

public class Cat extends Pet{
    private double weight;

    public Cat(String name, String sex, double weight) {
        super(name, sex);
        setWeight(weight);
    }

    public Cat() {
    }

    public void talk() {
        System.out.println("Cat类调用talk()");
    }

    public void eat() {
        System.out.println("Cat类调用eat()");
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
