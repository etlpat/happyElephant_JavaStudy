package com.test04;

/**
 * 案例4
 * 已给出BankAccount类
 * 要求：1.创建BankAccount的子类SavingAccount类
 * 2.方法earnMonthlyInterest，使新类每个月都有利息产生
 * 3.新类每次存款/取款时会收取1元手续费，但是每个月有3次免费机会。免费次数在调用earnMonthlyInterest方法时刷新
 */

public class Test {
    public static void main(String[] args) {
        SavingAccount account = new SavingAccount(1000);
        System.out.println(account.getBalance());// 1000.0

        account.deposit(200);//     本次免手续费，剩余 2 次免费, 余额：1200.0元
        account.withdraw(150);//    本次免手续费，剩余 1 次免费, 余额：1050.0元
        account.deposit(300);//     本次免手续费，剩余 0 次免费, 余额：1350.0元
        account.withdraw(600);//    本次收取 1元 手续费, 余额：749.0元
        account.deposit(50);//      本次收取 1元 手续费, 余额：798.0元

        account.earnMonthlyInterest();
        System.out.println(account.getBalance());// 861.84
        System.out.println(account.getFreeTimes());// 3
    }
}
