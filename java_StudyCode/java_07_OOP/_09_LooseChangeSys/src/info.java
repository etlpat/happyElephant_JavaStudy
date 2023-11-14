import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 该类的属性是零钱通所需要的信息
 * 属性包含：
 * 1.收支名称
 * 2.收支符号（收入+，支出-）
 * 3.收支费用
 * 4.收支时间
 * 5.账户余额
 * 方法包括：
 * 重写toString，返回指定格式的字符串信息
 */


public class info {
    private String name;
    private char sign;
    private double looseChange;
    private String nowTime;
    private double balance;


    // 构造方法
    public info(String name, char sign, double looseChange, double balance) {
        setName(name);
        setSign(sign);
        setLooseChange(looseChange);
        setNowTime();
        setBalance(balance);
    }

    @Override
    public String toString() {
        return name + "\t" + sign + looseChange + "\t" + nowTime + "\t余额：" + balance;
    }

    // get、set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public double getLooseChange() {
        return looseChange;
    }

    public void setLooseChange(double looseChange) {
        this.looseChange = looseChange;
    }

    public String getNowTime() {
        return nowTime;
    }

    public void setNowTime() {
        Date date = new Date();// 创建日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 创建日期格式化对象
        this.nowTime = sdf.format(date);// 将属性赋为指定格式的时间字符串
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
