package com._04_throws.test;

import java.io.IOException;

public class Test01 {
    public void func1() throws RuntimeException {// 抛出运行时异常
    }

    public void func2() {
        func1();
    }

    public void func3() throws IOException {// 抛出编译时异常
    }

    public void func4() throws IOException {
        func3();
    }


    public static void main(String[] args) throws IOException {
        new Test01().func1();

        new Test01().func2();

        new Test01().func3();

        new Test01().func4();
    }
}
