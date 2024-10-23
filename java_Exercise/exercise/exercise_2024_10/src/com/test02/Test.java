package com.test02;

public class Test {
    public static void main(String[] args) {

        // 测试Windows系统
        BasicSystem windowsSystem = new BasicSystem("Windows") {
            @Override
            public void setFileType() {
                this.fileType = new JPGType();
            }
        };

        windowsSystem.play();
        System.out.println(windowsSystem);
        System.out.println("============================");


        // 测试Linux系统
        BasicSystem linuxSystem = new BasicSystem("Linux") {
            @Override
            public void setFileType() {
                this.fileType = new GIFType();
            }
        };

        linuxSystem.play();
        System.out.println(linuxSystem);
        System.out.println("============================");


        // 测试UNIX系统
        BasicSystem unixSystem = new BasicSystem("UNIX") {
            @Override
            public void setFileType() {
                this.fileType = new PNGType();
            }
        };

        unixSystem.play();
        System.out.println(unixSystem);
    }
}
