package com._02_finalDetail;

//  final和static往往搭配使用，效率更高
//  原因：底层编译器做了优化处理，这二者搭配不会导致类加载


class AA {
    public final static int a1 = 10;// 调用该变量，不会导致类加载
    public static int a2 = 20;

    static {
        System.out.println("AA静态代码块执行");
    }
}


public class Test02 {
    public static void main(String[] args) {
        // 注意：调用final和static搭配的成员，不会导致类加载（底层做过修改）
        System.out.println(AA.a1);
        //10


        System.out.println("==========");
        System.out.println(AA.a2);
        //AA静态代码块执行（此时类加载）
        //20
    }
}
