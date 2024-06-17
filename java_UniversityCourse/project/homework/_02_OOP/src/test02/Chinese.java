package test02;

public class Chinese extends Person{
    public Chinese(String name, String sex, int age) {
        super(name, sex, age);
    }

    public Chinese() {
    }

    public void eat() {
        System.out.println("Chinese类调用eat()");
    }

    public void shadowBoxing(){
        System.out.println("Chinese类调用shadowBoxing()");
    }
}
