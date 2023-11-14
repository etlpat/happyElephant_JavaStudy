package com.test04;

public class SavingAccount extends BankAccount {
    private int freeTimes;
    private double interest = 0.08;// 每月利息

    public SavingAccount() {
        resetFreeTimes();
    }

    public SavingAccount(double balance) {
        super(balance);
        resetFreeTimes();
    }

    @Override// 存款
    public void deposit(double amount) {// 存款
        if (freeTimes > 0) {
            freeTimes -= 1;
            System.out.print("本次免手续费，剩余 " + freeTimes + " 次免费");
        } else {
            System.out.print("本次收取 1元 手续费");
            amount -= 1;// 少存了一元
        }
        super.deposit(amount);
        System.out.println(", 余额：" + getBalance() + "元");
    }

    @Override// 取款
    public void withdraw(double amount) {
        if (freeTimes > 0) {
            freeTimes -= 1;
            System.out.print("本次免手续费，剩余 " + freeTimes + " 次免费");
        } else {
            System.out.print("本次收取 1元 手续费");
            amount += 1;// 多取了一元
        }
        super.withdraw(amount);
        System.out.println(", 余额：" + getBalance() + "元");
    }

    // 每月涨利息
    public void earnMonthlyInterest() {
        super.deposit(getBalance() * interest);
        resetFreeTimes();
    }

    // 将免费次数重置为3
    public void resetFreeTimes() {
        freeTimes = 3;
    }

    // get、set方法
    public int getFreeTimes() {
        return freeTimes;
    }

    public double getInterest() {
        return interest;
    }

    public void setFreeTimes(int freeTimes) {
        this.freeTimes = freeTimes;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}
