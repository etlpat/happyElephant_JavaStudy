package test01;

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat("猫", "雄", 11.45);
        Dog dog = new Dog("狗", "雌", "red");
        cat.talk();// Cat类调用talk()
        cat.eat();// Cat类调用eat()
        dog.talk();// Dog类调用talk()
        dog.eat();// Dog类调用eat()
    }
}
