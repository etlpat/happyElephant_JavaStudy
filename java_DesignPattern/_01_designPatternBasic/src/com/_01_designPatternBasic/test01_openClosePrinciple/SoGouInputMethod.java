package com._01_designPatternBasic.test01_openClosePrinciple;

// 搜狗输入法，内含皮肤类

public class SoGouInputMethod {
    private AbstractSkin abstractSkin;

    public SoGouInputMethod(AbstractSkin abstractSkin) {
        this.abstractSkin = abstractSkin;
    }

    public SoGouInputMethod() {
    }

    // 用于显示皮肤的方法
    public void displaySkin() {
        abstractSkin.displaySkin();
    }

    public AbstractSkin getAbstractSkin() {
        return abstractSkin;
    }

    public void setAbstractSkin(AbstractSkin abstractSkin) {
        this.abstractSkin = abstractSkin;
    }
}
