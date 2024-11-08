package _02_commandPattern.test01.command;

import _02_commandPattern.test01.tv.TV;

// 具体命令类 -- 打开电视
//  调用接收者对应的方法

public class TVOpenCommand implements AbstractCommand {
    private TV tv;

    public TVOpenCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.open();
    }
}
