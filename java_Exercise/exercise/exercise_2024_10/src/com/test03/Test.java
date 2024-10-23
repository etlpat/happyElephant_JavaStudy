package com.test03;

public class Test {
    // 组合模式模拟
    public static void main(String[] args) {
        File a = new File("文件夹A");
        File b = new File("文件夹B");
        File c = new File("文件夹C");
        ImagineFile imagine1 = new ImagineFile("图片1");
        ImagineFile imagine2 = new ImagineFile("图片2");
        TextFile text1 = new TextFile("文本1");
        TextFile text2 = new TextFile("文本2");

        a.fileList.add(b);
        a.fileList.add(c);
        b.fileList.add(imagine1);
        b.fileList.add(text1);
        c.fileList.add(imagine2);
        c.fileList.add(text2);

        // 开始杀毒
        a.killVirus();

    }
}
