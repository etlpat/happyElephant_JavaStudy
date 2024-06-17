package test1;

public class Test {
    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(f.fac1(5));// 120
        System.out.println(f.fac1(0));// 1
        System.out.println(f.fac1(-10));// -1
        System.out.println(f.fac2(5));// 120
        System.out.println(f.fac2(0));// 1
        System.out.println(f.fac2(-10));// -1
    }
}
