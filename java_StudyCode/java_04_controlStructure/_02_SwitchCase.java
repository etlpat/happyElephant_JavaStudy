// switch case 分支结构

import java.util.*;


// switch分支机构
// 
// 语法：
// 	switch(表达式) {
// 	case 常量1:
// 		语句1;
// 		break;
// 	case 常量2:
// 		语句2;
// 		break;
// 	...
// 	default:
// 		语句n;
// 		break;
// 	}
// 
// 
// 注意：
// 	1.switch(xxx){}，表达式xxx的返回值，必须是(byte/short/int/char/enum/String)
// 	2.case子句中的值，必须是常量/常量表达式
// 	3.switch表达式的返回值，需要和case是相同类型，或者可以自动转换成case的类型
// 	4.程序从对应的case语句进入分支，并【一直向下执行】，直到全部switch语句结束，或遇到break退出




public class _02_SwitchCase {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("今天是星期几？：");
	int day = sc.nextInt();

	switch(day) {// day类型必须是(byte/short/int/char/enum/String)
	case 1:
	case 2:
	case 3:// 若未遇到break，switch分支会一直向下执行
	case 4:
	case 5:
		System.out.println("星期" + day + "，今天是工作日！");
		break;
	case 6:
	case 7:
		System.out.println("星期" + day + "，今天是休息日！");
		break;
	default:
		System.out.println("输入数据有误");
		break;
	}
	}
}