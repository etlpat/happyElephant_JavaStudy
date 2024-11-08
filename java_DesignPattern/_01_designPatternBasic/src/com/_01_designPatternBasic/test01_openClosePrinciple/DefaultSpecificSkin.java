package com._01_designPatternBasic.test01_openClosePrinciple;

public class DefaultSpecificSkin extends AbstractSkin {
    @Override
    public void displaySkin() {
        System.out.println("显示默认皮肤");
    }
}
