package _03_statePattern.test01.state;

import _03_statePattern.test01.context.Context;

// 运行状态

public class RunState extends AbstractState {
    public RunState(Context context) {
        super(context);
    }

    @Override
    public void open() {
        System.out.println("电梯运行中，不可开门。。。");
    }

    @Override
    public void close() {
        System.out.println("电梯运行中，不可关门。。。");
    }

    @Override
    public void run() {
        System.out.println("无效操作，电梯正在运行。。。");
    }

    @Override
    public void stop() {
        System.out.println("电梯即将停止~~");
        getContext().setCurrentState(getContext().STOP_STATE);
    }
}
