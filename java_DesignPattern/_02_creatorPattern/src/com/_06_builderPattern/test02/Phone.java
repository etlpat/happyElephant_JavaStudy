package com._06_builderPattern.test02;

// Phone包含建造者内部类Builder
// 外界只能通过Builder来构建Phone对象

public class Phone {
    private String cpu;
    private String screen;
    private String memory;
    private String mainBoard;

    // 私有化构造器，只能在内部(构建者内部)创建手机对象
    private Phone(PhoneBuilder builder) {
        // 将构建者对象中的属性赋给手机
        this.cpu = builder.cpu;
        this.screen = builder.screen;
        this.memory = builder.memory;
        this.mainBoard = builder.mainBoard;
    }


    //静态内部类 -- 手机构建者类
    public static final class PhoneBuilder {
        // 建造者的属性和Phone的属性保持一致
        private String cpu;
        private String screen;
        private String memory;
        private String mainBoard;

        public PhoneBuilder() {
        }

        // 返回PhoneBuilder构建者，方便链式调用
        public PhoneBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public PhoneBuilder setScreen(String screen) {
            this.screen = screen;
            return this;
        }

        public PhoneBuilder setMemory(String memory) {
            this.memory = memory;
            return this;
        }

        public PhoneBuilder setMainBoard(String mainBoard) {
            this.mainBoard = mainBoard;
            return this;
        }

        // 使用该构建者对象，创建手机对象
        public Phone buildPhone() {
            return new Phone(this);
        }
    }


    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                ", mainBoard='" + mainBoard + '\'' +
                '}';
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMainBoard() {
        return mainBoard;
    }

    public void setMainBoard(String mainBoard) {
        this.mainBoard = mainBoard;
    }
}
