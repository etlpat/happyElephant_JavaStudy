import java.util.Scanner;

/**
 * 该类是完成零钱同各个功能的类
 * （通过操作收支信息的顺序表，达到实现零钱通的功能）
 * 方法包括：
 * 1.打印菜单
 * 2.打印账单明细
 * 3.收益入账
 * 4.消费
 * 5.退出
 * 6.运行零钱通
 */


public class LooseChangeSys {

    // 打印菜单
    public void printMenu() {
        System.out.println("----------------零钱通菜单----------------");
        System.out.println("\t\t\t1.零钱通明细");
        System.out.println("\t\t\t2.收益入账");
        System.out.println("\t\t\t3.消费");
        System.out.println("\t\t\t4.退出");
    }


    // 打印账单明细
    public void printDetailAccount(InfoList infolist) {
        System.out.println("----------------零钱通明细----------------");
        if (infolist.getIndex() != 0) {
            infolist.printElement();
        } else {
            System.out.println("无消费记录");
        }
    }


    // 收益入账
    public boolean incomeRecorded(InfoList infolist, Scanner sc) {
        System.out.println("----------------账户入账-----------------");
        System.out.print("请输入入账零钱(元)：");
        double income = sc.nextDouble();

        if (income <= 0) {// 判断存钱金额是否正确
            System.out.println("收益金额需要大于0\n入账失败");
            return false;
        }

        if (infolist.addElement("收益入账", '+', income, infolist.getBalance() + income)) {// 判断数组空间是否足够
            System.out.println("入账成功！");
            return true;
        } else {
            System.out.println("记录信息数量达到上限，无法继续存放信息！");
            return false;
        }
    }


    // 消费
    public boolean consume(InfoList infolist, Scanner sc) {
        System.out.println("----------------消费--------------------");
        System.out.print("请输入消费零钱(元)：");
        double consume = sc.nextDouble();
        double balance = infolist.getBalance() - consume;

        if (consume <= 0) {// 判断消费金额是否正确
            System.out.println("消费金额需要大于0\n消费失败");
            return false;
        }
        if (balance < 0) {
            System.out.println("账户余额：" + infolist.getBalance() + "，买不起\n消费失败");
            return false;
        }

        if (infolist.addElement("消费\t", '-', consume, balance)) {// // 判断数组空间是否足够
            System.out.println("消费成功！");
            return true;
        } else {
            System.out.println("记录信息数量达到上限，无法继续存放信息！");
            return false;
        }
    }


    // 退出
    public boolean exit(Scanner sc) {
        System.out.print("确定退出吗？(y/n)：");
        char choose;
        while (true) {
            choose = sc.next().charAt(0);
            if (choose == 'y') {
                System.out.println("--------------零钱通程序退出--------------");
                return false;
            } else if (choose == 'n') {
                System.out.println("--------------取消退出-------------------");
                return true;
            }
            System.out.print("输入有误，只能选择y/n：");
        }
    }


    // 运行零钱通
    public void runLooseChangeSys() {
        Scanner sc = new Scanner(System.in);
        // 创建列表对象，存放消费信息
        InfoList infolist = new InfoList(500);
        // 打印菜单
        printMenu();
        boolean flag = true;
        do {
            System.out.print("请选择(1-4)：");
            switch (sc.nextInt()) {
                case 1:// 打印消费明细
                    printDetailAccount(infolist);
                    break;
                case 2:// 收益入账
                    incomeRecorded(infolist, sc);
                    break;
                case 3:// 消费
                    consume(infolist, sc);
                    break;
                case 4:// 退出
                    flag = exit(sc);
                    break;
                default:
                    System.out.print("选择有误，请重新输入：");
            }
        } while (flag);
    }
}
