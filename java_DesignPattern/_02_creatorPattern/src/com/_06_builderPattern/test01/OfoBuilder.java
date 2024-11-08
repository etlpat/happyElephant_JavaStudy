package com._06_builderPattern.test01;

// 具体构建者，用于实现零件的具体构建代码

public class OfoBuilder extends AbstractBuilder {

    @Override
    public void buildFrame() {
        getBike().setFrame("ofo铝合金车架");
    }

    @Override
    public void buildSeat() {
        getBike().setSeat("ofo橡胶车座");
    }
}
