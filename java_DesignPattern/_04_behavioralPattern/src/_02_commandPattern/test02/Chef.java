package _02_commandPattern.test02;

// 接收者 -- 厨师

public class Chef {
    // 接收者方法被命令类调用
    public void cook() {
        System.out.println("厨师做菜~");
    }
}
