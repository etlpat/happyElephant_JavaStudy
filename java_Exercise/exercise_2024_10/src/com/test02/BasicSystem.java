package com.test02;

public abstract class BasicSystem {
    public String OS = null;
    public FileType fileType = null;

    public BasicSystem(String OS) {
        setOS(OS);
        setFileType();
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public abstract void setFileType();

    public void play() {
        System.out.println(OS + " 系统，正在运行 " + fileType.typeName + " 格式的文件");
    }

    @Override
    public String toString() {
        return "BasicSystem{" +
                "OS='" + OS + '\'' +
                ", fileType=" + fileType +
                '}';
    }
}
