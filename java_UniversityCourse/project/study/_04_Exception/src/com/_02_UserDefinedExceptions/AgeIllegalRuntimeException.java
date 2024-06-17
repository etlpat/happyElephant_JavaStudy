package com._02_UserDefinedExceptions;

// 运行时异常
public class AgeIllegalRuntimeException extends RuntimeException {
    // 无参构造器
    public AgeIllegalRuntimeException() {
    }

    // 有参构造器（可以在报异常时输出该message字符串）
    public AgeIllegalRuntimeException(String message) {// 传入自定义的异常信息
        super(message);
    }
}
