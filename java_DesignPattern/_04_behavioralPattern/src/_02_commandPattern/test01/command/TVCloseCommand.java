package _02_commandPattern.test01.command;

import _02_commandPattern.test01.tv.TV;

// 具体命令类 -- 关闭电视
//  调用接收者对应的方法

public class TVCloseCommand implements AbstractCommand {
    private TV tv;

    public TVCloseCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.close();
    }
}
