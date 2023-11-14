package com._03_templateDesignPattern.templateTest;

// 抽象模板方法
public abstract class calculateJobTimeTemplate {

    // (1)将方法共有部分提取到一个非抽象方法中
    //  计算job方法的执行时间
    public void calculateTime() {
        long start = System.currentTimeMillis();// 从1970年1月1日00:00:00开始，到现在的毫秒数(long类型的时间戳)
        job();// 调用抽象方法
        long end = System.currentTimeMillis();
        System.out.println("job方法执行时间：" + (end - start) + "ms");
    }

    // (2)抽象方法有子类具体实现
    public abstract void job();
}
