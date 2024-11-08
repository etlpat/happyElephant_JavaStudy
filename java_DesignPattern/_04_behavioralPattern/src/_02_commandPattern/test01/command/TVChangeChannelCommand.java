package _02_commandPattern.test01.command;

import _02_commandPattern.test01.tv.TV;

// 具体命令类 -- 电视换台
//  调用接收者对应的方法

public class TVChangeChannelCommand implements AbstractCommand {
    private TV tv;

    public TVChangeChannelCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.changeChannel();
    }
}
