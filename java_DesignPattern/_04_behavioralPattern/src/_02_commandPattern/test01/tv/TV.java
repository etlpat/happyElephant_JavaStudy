package _02_commandPattern.test01.tv;

// 接收者 -- 电视
//  接收者被命令类调用

public class TV {
    public void open() {
        System.out.println("打开电视~~");
    }

    public void close() {
        System.out.println("关掉电视~~");
    }

    public void changeChannel() {
        System.out.println("电视换台~~");
    }
}
