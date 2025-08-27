package com._04_optimisticLock._01_atomic;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;


// 2.乐观锁——原子引用
//  原子引用：用于将引用类型的对象封装为原子对象
public class _02_atomicReference {
    public static void main(String[] args) {

        // (1)创建原子引用
        AtomicReference<BigDecimal> reference = new AtomicReference<>(new BigDecimal("33.33"));

        // (2)获取原子引用的值
        BigDecimal prev = reference.get();
        System.out.println(prev);
        BigDecimal next = prev.subtract(new BigDecimal("12.34567"));

        // (3)CAS：比较并设置
        boolean flag = reference.compareAndSet(prev, next);
        System.out.println(flag);
        System.out.println(reference.get());

    }
}
