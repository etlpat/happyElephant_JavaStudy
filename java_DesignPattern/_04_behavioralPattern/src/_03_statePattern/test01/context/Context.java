package _03_statePattern.test01.context;

// 环境类
//  用于保存当前的电梯状态，并实现当前状态下的操作

import _03_statePattern.test01.state.*;

public class Context {
    // 电梯当前的状态
    private AbstractState currentState;

    // 电梯门是否开启
    private boolean isOpen = false;

    // 保存电梯的具体状态对象，方便切换状态
    public final OpenState OPEN_STATE = new OpenState(this);
    public final CloseState CLOSE_STATE = new CloseState(this);
    public final RunState RUN_STATE = new RunState(this);
    public final StopState STOP_STATE = new StopState(this);


    public Context() {
        // 电梯默认为停止状态
        currentState = STOP_STATE;
    }


    // 当前状态下，电梯的四大操作
    public void open() {
        if (currentState == null) {
            return;
        }
        currentState.open();
    }

    public void close() {
        if (currentState == null) {
            return;
        }
        currentState.close();
    }

    public void run() {
        if (currentState == null) {
            return;
        }
        currentState.run();
    }

    public void stop() {
        if (currentState == null) {
            return;
        }
        currentState.stop();
    }


    public AbstractState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(AbstractState currentState) {
        this.currentState = currentState;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
}
