package _02_commandPattern.test02;

// 调用者 -- 服务员

public class Waiter {
    Command command = new CookCommand();

    // 调用者调用命令
    public void cookCommand() {
        command.execute();
    }
}
