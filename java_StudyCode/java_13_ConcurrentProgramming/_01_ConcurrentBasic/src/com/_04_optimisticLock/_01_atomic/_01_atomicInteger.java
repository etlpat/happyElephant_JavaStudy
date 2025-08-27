package com._04_optimisticLock._01_atomic;

import java.util.concurrent.atomic.AtomicInteger;


// 1.乐观锁——原子整数
//  AtomicInteger原子整数的操作均为原子性的，因此可以保证这些操作的线程安全。
public class _01_atomicInteger {
    public static void main(String[] args) {

        // (1)创建原子整数
        AtomicInteger atomicInteger = new AtomicInteger(10);// 赋初值10

        // (2)获取原子整数的值
        int num1 = atomicInteger.get();
        System.out.println(num1);

        // (3)CAS：比较并设置
        //  功能：若原子整数值未变动，则将其设置为指定值。（乐观锁：通过原子性，解决线程安全问题）
        boolean flag = atomicInteger.compareAndSet(num1, num1 - 1);
        System.out.println(flag);
        System.out.println(atomicInteger.get());


        // (4)原子性的++i/i++/--i/i--
        System.out.println(atomicInteger.incrementAndGet());// ++i
        System.out.println(atomicInteger.getAndIncrement());// i++
        System.out.println(atomicInteger.decrementAndGet());// --i
        System.out.println(atomicInteger.getAndDecrement());// i--
        System.out.println(atomicInteger.get());

        // (5)原子性的add指定值
        System.out.println(atomicInteger.getAndAdd(5));// 先获取，后add
        System.out.println(atomicInteger.addAndGet(5));// 先add，后获取

        // (6)原子性的update更新值
        //  参数：lambda表达式，参数value为原子整数的旧值，返回值为新值
        System.out.println(atomicInteger.updateAndGet(value -> value * 10));// 先更新，后获取
        System.out.println(atomicInteger.getAndUpdate(value -> value / 10));// 先获取，后更新
        System.out.println(atomicInteger.get());

    }
}
