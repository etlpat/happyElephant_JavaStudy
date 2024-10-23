package com.test05;

public class Foreground {
    private FileRead fileRead;
    private FileEncipher fileEncipher;
    private FileSave fileSave;

    public Foreground() {
        fileRead = new FileRead();
        fileEncipher = new FileEncipher();
        fileSave = new FileSave();
    }

    public void runAll() {
        fileRead.run();
        fileEncipher.run();
        fileSave.run();
    }
}
