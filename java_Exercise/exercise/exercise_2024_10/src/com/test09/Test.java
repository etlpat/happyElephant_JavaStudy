package com.test09;

public class Test {
    public static void main(String[] args) {
        Headquarters headquarters = new Headquarters();
        Player player1 = new Player("张三");
        Player player2 = new Player("李四");
        Player player3 = new Player("王五");
        Player player4 = new Player("赵六");


        headquarters.attach(player1);
        headquarters.attach(player2);
        headquarters.attach(player3);
        headquarters.attach(player4);


        // player1受伤
        player1.request(headquarters);
        System.out.println("======================");

        // player3受伤
        player3.request(headquarters);
    }
}
