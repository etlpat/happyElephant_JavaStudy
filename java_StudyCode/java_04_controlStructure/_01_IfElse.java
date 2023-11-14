// 分支结构：if else

import java.util.*;



// 语法：
// 
//	if(条件表达式1) {
//		代码块1;
//	}
//	else if(条件表达式2) {
//		代码块2;
//	}
//	...
//	else {
//		代码块n;
//	}
//	
//
// 注意：
// 	1.java中，if的条件判断语句，【结果只能是boolean类型】
// 	2.若代码块只有一条语句，可以省略{}，但是不建议省略
// 	3.if分支的嵌套，实际项目中最好不要超过4层，否则可读性差





public class _01_IfElse {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);// 创建扫描器对象，接收System.in
		System.out.print("请输入年龄：");
		int age = sc.nextInt();// 接收并返回一个整型


		if(age >= 0 && age <= 18) {
			System.out.println("您还未成年");
		}
		else if(age > 18 && age <= 130) {
			System.out.println("您成年了");
		}
		else {
			System.out.println("输入数据非法");
		}

	}
}




// e.g.判断year是否是闰年(1.能被4整除，但不能被100整除 2.能被400整除)
class _01_Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入年份：");
		int year = sc.nextInt();

		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
			System.out.println(year + "年 是闰年");
		}
		else{
			System.out.println(year + "年 不是闰年");
		}
	}
}




// e.g.if嵌套题目
// 参加比赛，若成绩大于等于8.0的晋级，并根据性别提示进入男子组或女子组
class _01_Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入成绩(0~10.0)：");
		double score = sc.nextDouble();

		if(score >= 8.0 && score <= 10.0) {
			System.out.print("请输入性别：");
			char sex = sc.next().charAt(0);// 字符串.charAt(下标)：String类的成员方法，返回String中指定下标的char
		
			if(sex == '男') {// 本质是将char的码值进行比较
				System.out.println("恭喜晋级，分配至男子组 :-)");
			} else if(sex == '女') {
				System.out.println("恭喜晋级，分配至女子组 :-)");
			} else {
				System.out.println("性别输入有误");
			}
		} 
		else if(score >= 0 && score < 8.0) {
			System.out.println("抱歉，您未晋级 :-(");
		} 
		else {
			System.out.println("成绩输入有误");
		}
	}
}

