package _03_statePattern.test01.state;

import _03_statePattern.test01.context.Context;

// 关门状态

public class CloseState extends AbstractState {
    public CloseState(Context context) {
        super(context);
    }

    @Override
    public void open() {
        System.out.println("电梯开门中~~");
        // 切换状态
        getContext().setCurrentState(getContext().OPEN_STATE);
        getContext().setIsOpen(true);
    }

    @Override
    public void close() {
        System.out.println("无效操作，电梯门已关闭。。。");
    }

    @Override
    public void run() {
        System.out.println("电梯关门时，不可运行。。。");
    }

    @Override
    public void stop() {
        System.out.println("电梯停止中~~");
        // 切换状态
        getContext().setCurrentState(getContext().STOP_STATE);
    }
}
