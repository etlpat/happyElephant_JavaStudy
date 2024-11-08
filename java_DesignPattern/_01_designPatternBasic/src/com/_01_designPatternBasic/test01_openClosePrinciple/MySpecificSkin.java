package com._01_designPatternBasic.test01_openClosePrinciple;

public class MySpecificSkin extends AbstractSkin {

    @Override
    public void displaySkin() {
        System.out.println("显示自定义皮肤");
    }
}
