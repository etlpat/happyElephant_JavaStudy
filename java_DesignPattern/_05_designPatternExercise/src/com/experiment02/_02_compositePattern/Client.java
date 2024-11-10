package com.experiment02._02_compositePattern;

import com.experiment02._02_compositePattern.tree.Folder;
import com.experiment02._02_compositePattern.tree.ImageFile;
import com.experiment02._02_compositePattern.tree.TextFile;
import com.experiment02._02_compositePattern.tree.VideoFile;

public class Client {
    public static void main(String[] args) {
        // 创建树
        Folder folder1 = new Folder("imageFile");
        folder1.add(new ImageFile("image1.jpg"));
        folder1.add(new ImageFile("image2.jpg"));
        Folder folder2 = new Folder("videoFile");
        folder2.add(new VideoFile("video1.mp4"));
        Folder folder3 = new Folder("textFile");
        folder3.add(new TextFile("text1.txt"));
        folder3.add(new TextFile("text2.txt"));
        folder3.add(new TextFile("text3.txt"));
        Folder root = new Folder("root");
        root.add(folder1);
        root.add(folder2);
        root.add(folder3);


        // 调用display()方法，递归遍历树的全部结点
        root.display();

    }
}
