// Force type conversion： 强制类型转换


// 强制类型转换：
// 是自动类型转换的逆过程，将容量大的数据类型强制转换为容量小的类型
// 语法： (类型)变量
// 注意：对变量进行强制类型转换可能造成精度缺失
// 
// 
// 
// 强制类型转换注意细节：
// 
// 1.数据类型 小->大，会自动类型转换
//   数据类型 大->小，需要强制类型转换
// 
// 2.强制类型转换算单目操作符，优先级较高
// 
// 3.int常量可以直接赋给char、short等（优先判断范围）
//   但想将int变量赋给char、short等，需要强转类型转换





public class _09_ForceTypeConversion{
	public static void main(String[] args) {

		int a = (int)1.9;
		int b = 2000;
		byte c = (byte)b;
		System.out.println(a);// 1，精度损失
		System.out.println(c);// -48，数据溢出


		//int n1 = (int)3*1.5+2;// 报错，优先级问题
		int n2 = (int)(3*1.5+2);


		int in = 99;
		char ch1 = 99;// int常量，符合范围就可以赋值
		char ch2 = (char)in;
		// char ch3 = in;// 报错

	}
}