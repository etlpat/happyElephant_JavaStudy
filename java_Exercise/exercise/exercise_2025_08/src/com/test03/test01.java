package com.test03;


import java.util.Scanner;

public class test01 {

    public static void judgeString(String str){
        if (str.length()<8){
            System.out.println("Weak");
        }
        int num = 0;
        boolean[] flags = new boolean[4];
        for (char c : str.toCharArray()) {
               if ('a' <= c && c <= 'z' && !flags[0]){
                   flags[0] = true;
                   num++;
               }else if ('A' <= c && c <= 'Z' && !flags[1]){
                   flags[1] = true;
                   num++;
               } else if ('0' <= c && c <= '9' && !flags[2]) {
                   flags[2] = true;
                   num++;
               }else if (!flags[3]){
                   flags[3] = true;
                   num++;
               }
        }
        if (num==4){
            System.out.println("Strong");
        }else if (num==3){
            System.out.println("Medium");
        }else {
            System.out.println("Weak");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 1; i <= num; i++){
            judgeString(sc.next());
        }
    }
}
