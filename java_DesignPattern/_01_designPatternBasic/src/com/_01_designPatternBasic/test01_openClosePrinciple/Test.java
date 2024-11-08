package com._01_designPatternBasic.test01_openClosePrinciple;

// 实现开闭原则
//
// 案例：搜狗输入法的皮肤设计
// 分析：搜狗输入法的皮肤是输入法背景图片、窗口颜色和声音等元素的组合。用户可以根据自己的喜爱更换自己的输入法的皮肤,也
//      可以从网上下载新的皮肤。这些皮肤有共同的特点,可以为其定义一个抽象类(AbstractSkin),而每个具体的皮肤
//      (DefaultSpecificSkin和MySpecificSkin)是其子类。用户窗体可以根据需要选择或者增加新的主题,而不需要修改原代
//      码,所以它是满足开闭原则的。
//

public class Test {
    public static void main(String[] args) {
        SoGouInputMethod inputMethod1 = new SoGouInputMethod(new DefaultSpecificSkin());
        inputMethod1.displaySkin();

        SoGouInputMethod inputMethod2 = new SoGouInputMethod(new MySpecificSkin());
        inputMethod2.displaySkin();

        // 该案例符合开闭原则，若是搜狗输入法想要新皮肤，只需要定义新的皮肤类即可
        // （由于动态绑定机制，不需要修改原本代码，只需要拓展代码）

        SoGouInputMethod inputMethod3 = new SoGouInputMethod(new AbstractSkin() {
            @Override
            public void displaySkin() {
                System.out.println("匿名皮肤1");
            }
        });
        inputMethod3.displaySkin();
    }
}
