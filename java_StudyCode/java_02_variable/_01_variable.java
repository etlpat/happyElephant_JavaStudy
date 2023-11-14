// variable 变量

 

// 变量是程序的基本组成单位
// 变量的三个要素（类型+名称+值）



// int a = 1;（在内存中开辟了一块int大小的空间，存放的值为1，空间名是a）
// 变量的定义过程实际是为变量开辟空间，同一作用域下不能定义两次同名变量


public class _01_variable{
	public static void main(String[] args){
		// java变量的定义方式与C++一致
		int a = 1;
		int b = 2;
		b = 3;
		double c = 11.45;
		char d = 'd';
		String name = "jimmy";

		System.out.println(a);// 1
		System.out.println(b);// 3
		System.out.println(c);// 11.45
		System.out.println(d);// d
		System.out.println(name);// jimmy
	}
}