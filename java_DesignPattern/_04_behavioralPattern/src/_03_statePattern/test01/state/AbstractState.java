package _03_statePattern.test01.state;

// 抽象状态类
//  用于定义电梯所有状态下的全部操作

import _03_statePattern.test01.context.Context;

public abstract class AbstractState {
    // 聚合环境类，用于在某些方法中，改变当前的状态
    private Context context;

    public AbstractState(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    // 定义电梯在各种状态下的方法
    public abstract void open();

    public abstract void close();

    public abstract void run();

    public abstract void stop();
}
