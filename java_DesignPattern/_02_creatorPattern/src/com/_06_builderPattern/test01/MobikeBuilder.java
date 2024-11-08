package com._06_builderPattern.test01;

// 具体构建者，用于实现零件的具体构建代码

public class MobikeBuilder extends AbstractBuilder {

    @Override
    public void buildFrame() {
        getBike().setFrame("摩拜碳纤维车架");
    }

    @Override
    public void buildSeat() {
        getBike().setSeat("摩拜真皮车座");
    }
}
