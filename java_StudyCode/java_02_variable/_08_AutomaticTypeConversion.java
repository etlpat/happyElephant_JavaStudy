// Automatic Type Conversion： 自动类型转换



// java的基本数据类型转换：
// 
// (1)自动类型转换：
// 概念：当java程序在进行赋值或运算时，精度小的类型自动转换为精度(容量)大的数据类型
// （即：运算或赋值时，小内存自动转换为大内存）
//
// 数据按精度(容量)转换顺序：
// 	1. char -> int -> long -> float -> double
// 	2. byte -> short -> int -> long -> float -> double
//
// 	 	
// 	如：int a = 'c';		//（内存大小char < int，'c'按99存入int，剩余空间自动补0）
// 		double d = 80;	//（精度int < double，80按80.0存入double）
//
//
//
//
// (2)自动类型转换的细节：
// 
// 1.数据在CPU中运算时，整数比int小的会自动转换为【int】，浮点数会自动转换为【double】
//   如：byte、short、char进行运算，结果都是int
//   
// 2.多种数据混合运算时，系统会将数据转换为【最大的类型】进行计算
// 	 注意：类型提升的顺序就是操作数运算的顺序，哪对操作数进行运算，就提升哪对操作数的类型
// 
// 3.【表达式结果】的类型一定是操作数中【最大】的类型
// 	 java中，若运算结果存入比它小的类型，【不会截断】，而是直接报错
// 
// 4.精度(内存)小的数据赋值给精度(内存)大的数据会自动类型转换，反过来会报错
//	 java不会自动进行丢失精度的截断操作
//  
// 5.规定：(byte,short)和char之间不会相互自动转换
//         boolean不参与类型的自动转换
//
//    
//    
// 注意：
//  (1).byte b1 = 10;// 正确
//  (2).byte b2 = 1000;// 错误
//  (3).int n = 10; byte b3 = n;// 报错
// 如上：
// (1)中虽然常量10是int型，但系统先判断10是否在byte范围内，若在范围内则允许赋值
// 结论：用常量赋值，判断值的范围；用变量赋值，直接判断类型
//
//
// 注意：
// 运算时，自动类型转换也有其顺序（按照运算顺序依次提升）
//  (1) 2 + 3 * 1.1; 先将3转为double，乘法运算后，再将2转为double进行加法运算
//  (2) 5 / 9 * 1.1; 先按int型进行5/9的整除运算，后把结果转换为double与1.1相乘
//  (3) 1.1 * 5 / 9; 先将5转化为double进行乘法，后把9转化为double进行除法





public class _08_AutomaticTypeConversion{
	public static void main(String[] args){
		int a = 'c';
		double b = 80;
		System.out.println(a);// 99
		System.out.println(b);// 80.0



		// 1.比int短的类型在运算时转换为int
		short s1 = 1;
		short s2 = 1;
		//short s3 = s1 + s2;// 报错
		int s4 = s1 + s2;
		// 表达式运算时，数据发生整型提升，运算结果为int，不能存入short


		// 2.表达式的返回类型时操作数中最大的类型
		int n = 10;
		double d = n + 1.1 + 1.1f;
		//float f = n + 1.1 + 1.1f;
		// 报错，运算结果为double，不能存入float


		// 3.规定(byte,short)和char之间不会相互自动转换
		short sh = 1;
		byte by = 1;
		//char ch1 = sh;// 报错
		//char ch2 = by;// 报错
		
		
		// 4.boolean类型不参与类型的自动转换
		//int bo = true;// 报错
		

		// 5.整型提升也有顺序
		// 整型提升顺序就是运算顺序，因此不同类型运算顺序的先后也会影响运算的结果
		System.out.println(1.1*5/9);// 0.6111111111111112
		System.out.println(5/9*1.1);// 0.0
		System.out.println(5.0/9*1.1);// 0.6111111111111112
	}
}







// //练习题：(判断对错)
// class _08_Test{
// 	public static void main(String[] args){
// 		// 1
// 		short s = 12;
// 		s = s - 9;// x
// 		// 2
// 		byte b = 10;
// 		b = b + 11;// x
// 		b = (byte)(b + 11);
// 		// 3
// 		char c = 'a';
// 		int i = 16;
// 		float f = .314F;
// 		double d = c + i + f;
// 		// 4
// 		byte by = 16;
// 		short sh = 14;
// 		short t = by + sh;// x
// 	}
// }

