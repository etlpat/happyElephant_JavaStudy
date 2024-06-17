package com._02_UserDefinedExceptions.test;

// 编译时异常
public class AgeIllegalException extends Exception {
    public AgeIllegalException() {
    }

    public AgeIllegalException(String message) {
        super(message);
    }
}
