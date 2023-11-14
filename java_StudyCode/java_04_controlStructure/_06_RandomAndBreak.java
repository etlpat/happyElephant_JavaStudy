// break语句 以及 Random随机数

import java.util.*;



// break语句
// 
// 用法：
// 	break;			(跳出一层循环)
// 	break 标签;		(跳出标签指定的那层循环)
// 	
// 	
// 标签语法：
// 	lable1:
// 	while(true){
// 		lable2:
// 		while(true){
// 			break lable1;
// 		}
// 	}
// 解释：如上，lable1修饰外层循环，lable2修饰内层循环
// 		break lable1; 直接跳出外层循环
// 	
//
// 注意：
// 	1.break是用于跳出循环或switch语句
//	2.break语句在多层循环嵌套中时，可以通过标签指定跳出哪层循环
//	  （很像其它语言中的goto）实际开发中建议不要使用break标签





// java生成随机数
// 
// (1):java.util包中的Random类
// 语法：1.创建随机数对象：Random rand = new Random();
// 		2.通过next方法获取随机数：rand.nextInt()/ rand.nextDouble()/ ...
// 		
// 功能：rand.nextInt();返回一个随机整数
//      rand.nextInt(100);返回一个[0,100)间的随机整数
// 		rand.nextDouble();返回一个[0, 1)间的随机浮点数
// 		
// 注意：1.用法和Scanner类相同，先创建对象，然后通过next方法获得数据
// 		2.参数：如 nextInt(100)，等价于rand.nextInt() % 100
// 		3.java中，Random类虽然也是伪随机，但是每次运行结果不同，不需要设置时间戳当种子
// 
// 
// 
// 
// (2):Math类中的random方法
// 语法：Math.random();
// 功能：生成[0,1)之间的随机double浮点数
// 
// 注意：1.由于默认结果是[0,1)间的浮点数，使用时一般转换成整数：
// 		   	(int)(Math.random() * 100); 表示[0,99)的随机整数
// 		2.这里的Math.random()与上面的rand.nextDouble()功能类似







// 问：用随机数循环生成0到100的数字，第几次随机到objNum？
public class _06_RandomAndBreak {
	public static void main(String[] args) {
		int objNum = 50;// 目标生成的数字
	
		// (1)Random类对象next方法生成随机数
		Random rand = new Random();// 创建随机数对象
		int num1 = 0;
		int randNum1;
		while(true) {
			randNum1 = rand.nextInt(100) + 1;// 获得1到100的随机数
			num1++;
			if( randNum1 == objNum){
				break;// break作用是跳出循环，而不是跳出if语句
			}
		}
		System.out.println("第一种方式 " + num1 + " 次随机到objNum " + randNum1);


		// (2)Math类中的random方法生成随机数
		int num2 = 0;
		int randNum2;
		while(true) {
			randNum2 = (int)(Math.random() * 100) + 1;// 获得1到100的随机数
			num2++;
			if( randNum2 == objNum){
				break;
			}
		}
		System.out.println("第二种方式 " + num2 + " 次随机到objNum " + randNum2);

	}
}





// 利用break跳出循环
class _06_Test1 {
	public static void main(String[] args) {
		for(int i = 1; i <= 10; i++){
			if(i == 4){
				break;
			}
			System.out.print(i + " ");// 1 2 3
		}
	}
}





// 题目：输入用姓名、密码进入账户，密码有3次机会，若"丁真"输入的密码是"666"则解锁成功，进入账户
// 
// 知识点补充：字符串比较方法(equals)，是String类的方法
// 语法：字符串1.equals(字符串2); 	返回值：boolean类型
// 注意：写法1：stdPasswd.equals(passwd);  写法2：passwd.equals(stdPasswd);
// 		以上两种写法都成立。但是建议写法1，避免用户端输入的passwd是空指针导致报错
//
class _06_Test2 {
	public static void main(String[] args) {
		String stdName = "丁真";
		String stdPasswd = "666";
		int chance = 3;// 密码输入次数
		boolean flag = false;

		Scanner sc = new Scanner(System.in);
		String passwd = "";
		String name = "";

		System.out.print("请输入姓名：");
		name = sc.next();
		if(stdName.equals(name)){// 若姓名正确，就输入密码
			System.out.print("你有" + chance + "次机会，请输入密码：");
			for(int i = chance; i > 0; i--){// 三次密码机会
				passwd = sc.next();
				if(stdPasswd.equals(passwd)){
					System.out.println("密码正确");
					flag = true;
					break;
				} else if(i != 1) {
					System.out.print("密码错误，还有" + (i-1) + "次机会：");
				} else if(i == 1) {
					System.out.println("抱歉，" + chance + "次密码均输入错误");
				}
			}
		} else {
			System.out.println("姓名输入错误");
		}

		if(flag){
			System.out.println(name + "进入账户！");
		}
	}
}






// break 标签;
class _06_BreakLable {
	public static void main(String[] args) {
		
		lable1:// 定义一个标签（名称随意）
		for(int i = 0; i < 10; i++){
			lable2:
			for(int j = 0; j < 10; j++){
				if(j == 2){
					break lable1;// 直接跳出lable1标签所在的这层循环
				}
				System.out.print(i + "," + j + "  ");// 0,0  0,1
			}
			System.out.println("\nlable2循环结束");
		}
		System.out.println("\nlable1循环结束");// lable1循环结束

		// 如上打印结果，表示break lable1直接跳出2层循环
		// break lable1： 跳出lable1标签所在的这层循环
	}
}