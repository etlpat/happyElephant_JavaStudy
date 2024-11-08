package _02_commandPattern.test02;

// 案例：服务员命令厨师做菜

public class Test {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        waiter.cookCommand();
    }
}
