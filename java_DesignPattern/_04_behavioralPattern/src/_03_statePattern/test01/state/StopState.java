package _03_statePattern.test01.state;

import _03_statePattern.test01.context.Context;

// 停止状态

public class StopState extends AbstractState {
    public StopState(Context context) {
        super(context);
    }

    @Override
    public void open() {
        if (getContext().isOpen()) {
            System.out.println("无效操作，电梯门已开启。。。");
        } else {
            System.out.println("电梯开门中~~");
            // 切换状态
            getContext().setCurrentState(getContext().OPEN_STATE);
            getContext().setIsOpen(true);
        }
    }

    @Override
    public void close() {
        if (!getContext().isOpen()) {
            System.out.println("无效操作，电梯门已关闭。。。");
        } else {
            System.out.println("电梯门关闭中~~");
            // 切换状态
            getContext().setCurrentState(getContext().CLOSE_STATE);
            getContext().setIsOpen(false);
        }
    }

    @Override
    public void run() {
        System.out.println("电梯即将开始运行~~");
        getContext().setCurrentState(getContext().RUN_STATE);
    }

    @Override
    public void stop() {
        System.out.println("无效操作，电梯已停止。。。");
    }
}
