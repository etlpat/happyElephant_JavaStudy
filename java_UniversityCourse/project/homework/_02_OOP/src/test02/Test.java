package test02;

public class Test {
    public void showEat(Person p) {
        p.eat();
    }

    public static void main(String[] args) {
        Chinese c = new Chinese("张三", "男", 16);
        English e = new English("jimmy", "man", 18);
        Test test = new Test();
        test.showEat(c);// Chinese类调用eat()
        test.showEat(e);// English类调用eat()
    }
}
