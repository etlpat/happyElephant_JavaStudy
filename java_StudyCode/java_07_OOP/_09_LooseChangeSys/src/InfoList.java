/**
 * 该类是以每条收支信息为元素构成的顺序表
 * 元素包括：
 * 1.收支信息的数组
 * 2.有效信息个数
 * 方法包括：
 * 1.添加元素（收支信息）
 * 2.打印所有元素信息
 * 3.获取当前账余额
 * 4.获取有效元素个数
 */


public class InfoList {
    private info[] infoList;// 消费信息列表
    private int index;// 有效信息个数


    // 构造函数
    public InfoList(int maxSize) {
        infoList = new info[maxSize];
        index = 0;
    }

    public InfoList() {
        infoList = new info[1000];
        index = 0;
    }

    // 增加元素
    public boolean addElement(String name, char sign, double looseChange, double balance) {
        if (index == infoList.length)
            return false;
        infoList[index] = new info(name, sign, looseChange, balance);
        index++;
        return true;
    }

    // 打印所有元素信息
    public void printElement() {
        for (int i = 0; i < index; i++) {
            System.out.println(infoList[i]);
        }
    }

    // 获取当前余额
    public double getBalance() {
        if (index == 0)
            return 0;
        return infoList[index - 1].getBalance();
    }

    // 获取元素个数
    public int getIndex() {
        return index;
    }
}
