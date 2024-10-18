package com._03_userDefinedGeneric.test01;

public class Apple<T, R, M> {
    public <E> void fly(E e) {
        System.out.println(e.getClass().getSimpleName());
    }

    public <U> void eat(U u) {
    }

    public void run(M m) {
    }
}
