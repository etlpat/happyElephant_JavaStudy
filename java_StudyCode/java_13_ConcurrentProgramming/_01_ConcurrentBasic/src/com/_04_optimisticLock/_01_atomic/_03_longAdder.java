package com._04_optimisticLock._01_atomic;

import java.util.concurrent.atomic.LongAdder;


// 3.乐观锁——原子累加器
//
// 特点:
//  相较于“原子整数”，“原子累加器”做累加操作的性能更高。
//  性能提升的原因很简单,就是在有竞争时,设置多个累加单元,Thread-0累加Cell[0],而Thread-1累加Cell[1]...最后将结果汇总。
//  这样它们在累加时操作的不同的Cell变量,因此减少了CAS重试失败,从而提高性能。

public class _03_longAdder {
    public static void main(String[] args) {

        // (1)创建原子累加器（初值默认为0）
        LongAdder longAdder = new LongAdder();

        // (2)获取累加器中的值
        long value = longAdder.longValue();
        System.out.println(value);

        // (3)进行原子累加操作
        for (int i = 0; i < 10; i++) {
            longAdder.increment();
        }
        System.out.println(longAdder.longValue());

    }
}
