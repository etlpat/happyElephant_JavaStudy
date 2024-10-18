package com._02_generic;

// 泛型的作用是：在类声明时，可以通过一个标识，
//      表示类中某个属性的类型/方法的返回类型/参数类型...


// 可以在类声明时定义泛型；之后就可以在类内，将这些泛型作为数据类型使用。
public class Person<E, T, Q> {
    // 泛型可以作为属性类型
    private E e;
    private T t;
    private Q q;

    // 泛型可以作为参数类型
    public Person(E e, T t, Q q) {
        this.e = e;
        this.t = t;
        this.q = q;
    }

    public Person() {
    }


    // 获取全部对象的运行类型
    public String getAllElementClass() {
        return "运行类型：e=" + e.getClass().toString().substring(16)
                + ", t=" + t.getClass().toString().substring(16)
                + ", q=" + q.getClass().toString().substring(16);
    }


    // 泛型可以作为返回类型
    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Q getQ() {
        return q;
    }

    public void setQ(Q q) {
        this.q = q;
    }
}
