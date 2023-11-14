// Logical operator： 逻辑运算符
// Bit operator：位运算符



// (1)逻辑运算符：
// 用于连接多个返回值为boolean类型的表达式，最终结果也是boolean值
// 注意：java中，位运算符也能用作逻辑判断，但是没有短路规则（C++、C也都可以）
//
//  
// &&：短路与
// ||：短路或
// !：非
// &：逻辑与 	(不短路)
// |：逻辑或 	(不短路)
// ^：逻辑异或 	(不短路)
// 
// 
//   
// 注意事项：
//  1.短路规则：(短路：当结果已经确定，就不会继续向后执行，效率高)
//  	&&：从左到右执行，若左边为false，则不执行右边
// 		||：从左到右执行，若左边为true，则不执行右边
// 	
//  3.&、|、^：若操作数是boolean类型，执行逻辑与、或、异或运算 【不进行短路】
//	 	     若操作数是整数类型，执行位运算
// 	
// 	4.逻辑运算符的操作数必须是boolean类型   




// (2)位运算符：
// 操作数是整数类型，将其转换为二进制进行位运算
// 
// 
// &：按位与		（全1才为1）
// |：按位或 	（有1就为1）
// ^：按位异或 	（同0异1）
// 
//  
// 注意事项：
// 	1.位运算符只能用于整数(byte,int...)或字符(char)类型，char按对应的编码进行位运算
// 	2.若位运算符&、|、^的操作数是boolean类型，执行逻辑运算（不短路）	






public class _03_LogicalAndBitOperator{
	public static void main(String[] args) {
	
		// (1)逻辑运算符
		int a = 10, b = 20;
		//System.out.println(a && b);// 报错，逻辑运算符操作数只能为boolean类型
		//System.out.println(!a);// 报错

		// 与：&&、&
		System.out.println(a > 100 && ++a > 0);// false
		System.out.println(a);// 10， &&短路
		System.out.println(a > 100 & ++a > 0);// false
		System.out.println(a);// 11， &不短路

		// 或：||、|
		System.out.println(b < 100 || --b > 30);// true
		System.out.println(b);// 20， ||短路
		System.out.println(b < 100 | --b > 30);// true
		System.out.println(b);// 19， |不短路

		// 非：!
		System.out.println(!false);// true

		// 异或：^
		System.out.println(true ^ false);// true
		System.out.println(true ^ true);// false
		System.out.println("-----------------");




		// (2)位运算符
		//System.out.println(1.111 ^ 1.111);// 报错，操作数不能是浮点数
		System.out.println('A' ^ 'B');// 3，将char自动转换为int进行运算
		
		int num1 = 5; // 0101
		int num2 = 12;// 1100 
		System.out.println(num1 & num2);// 0100，4
		System.out.println(num1 | num2);// 1101，13
		System.out.println(num1 ^ num2);// 1001，9
	}
}






// 练习：
class _03_Test{
	public static void main(String[] args) {
		// 练习1
		int x1 = 5, y1 = 5;
		if(x1++ == 6 & ++y1 == 6)
			x1 = 11;
		System.out.println(x1 + ", " + y1);// 6, 6

		// 练习2
		int x2 = 5, y2 = 5;
		if(x2++ == 6 && ++y2 == 6)
			x2 = 11;
		System.out.println(x2 + ", " + y2);// 6, 5

		// 练习3
		int x3 = 5, y3 = 5;
		if(x3++ == 5 | ++y3 == 5)
			x3 = 11;
		System.out.println(x3 + ", " + y3);// 11, 6

		// 练习4
		int x4 = 5, y4 = 5;
		if(x4++ == 5 || ++y4 == 5)
			x4 = 11;
		System.out.println(x4 + ", " + y4);// 11, 5


		// 练习5
		boolean x = true, y = false;
		short z = 46;
		if((z++ == 46) && (y = true)) z++;
		if((x = false) || (++z == 49)) z++;
		System.out.println(x);// false
		System.out.println(y);// true
		System.out.println(z);// 50
		// 注意看清 = 和 ==，以及短路规则
	}
}
