package _02_commandPattern.test01.tv;

import _02_commandPattern.test01.command.AbstractCommand;
import _02_commandPattern.test01.command.TVChangeChannelCommand;
import _02_commandPattern.test01.command.TVCloseCommand;
import _02_commandPattern.test01.command.TVOpenCommand;

// 调用者 -- 电视遥控器
//  调用者中，通过调用命令方法，来完成对接收者TV的操作

public class TVRemoteControl {
    private TV tv;

    // 命令类
    private AbstractCommand tvOpenCommand, tvCloseCommand, tvChangeChannelCommand;

    public TVRemoteControl(TV tv) {
        this.tv = tv;
        tvOpenCommand = new TVOpenCommand(tv);
        tvCloseCommand = new TVCloseCommand(tv);
        tvChangeChannelCommand = new TVChangeChannelCommand(tv);
    }


    // 执行命令 -- 调用命令对象的execute()方法
    public void openTV() {
        tvOpenCommand.execute();
    }

    public void closeTV() {
        tvCloseCommand.execute();
    }

    public void changeTVChannel() {
        tvChangeChannelCommand.execute();
    }


    public TV getTv() {
        return tv;
    }

    public void setTv(TV tv) {
        this.tv = tv;
    }
}
