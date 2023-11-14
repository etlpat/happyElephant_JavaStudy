// do..while 循环

import java.util.*;


// do..while 循环
// 
// 语法：
// 	do{
// 		代码块;
// 	}while(循环条件);
// 
// 
// 
// 注意：
// 	1.do..while循环，先执行，再判断。至少执行一次
// 	2.条件判断语句，返回值必须是boolean类型





public class _05_DoWhile {
	public static void main(String[] args){

		int i = 0;
		do {
			System.out.print(i + " ");
			i++;
		}while(i < 10);

	}
}




// 练习：用do while实现：若张三不还钱，就一直鞭打，直到还钱为止
class _05_Test {
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		char select;
		do {
			System.out.println("@@##  鞭打张三！ ##@@");
			System.out.print("张三还钱吗(Y/N)：");
			while(true){
				select = sc.next().charAt(0);
				if(select == 'Y' || select == 'y' || select == 'N' || select == 'n'){
					break;
				} else {
					System.out.print("只能选择还钱或者鞭打！(Y/N)：");
				}
			}
		}while(select != 'Y' && select != 'y');
		System.out.println("张三终于还钱了(笑)");
	}
}