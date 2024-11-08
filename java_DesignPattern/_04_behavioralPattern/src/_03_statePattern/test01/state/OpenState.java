package _03_statePattern.test01.state;

import _03_statePattern.test01.context.Context;

// 开门状态

public class OpenState extends AbstractState {
    public OpenState(Context context) {
        super(context);
    }

    @Override
    public void open() {
        System.out.println("无效操作，电梯门已开启。。。");
    }

    @Override
    public void close() {
        System.out.println("电梯门关闭中~~");
        // 切换状态
        getContext().setCurrentState(getContext().CLOSE_STATE);
        getContext().setIsOpen(false);
    }

    @Override
    public void run() {
        System.out.println("电梯开门时，不可运行。。。");
    }

    @Override
    public void stop() {
        System.out.println("电梯停止中~~");
        // 切换状态
        getContext().setCurrentState(getContext().STOP_STATE);
    }
}
