//Consideration：注意事项


// Java开发注意事项
// 1.源文件的基本组成部分是类class
// 
// 2.java程序的执行入口是main方法，它有固定的书写格式：
//	 public static void main(String[] args) {...} 
//	 
// 3.一个源文件中最多只能有一个public权限的类，其他类个数不限
// 	 一个源文件中未必只有一个main函数
// 	 
// 4.如果一个源文件包含一个public类，则文件名必须按该类名命名
//   (公共类的类名 == 文件名)
//   
// 5.可以将main方法写在非public类中，然后运行该类，这样入口方法就是非public类





// 一个函数只能有一个public方法(和文件同名)
public class _02_JavaConsiderations{
}

class cat{
	public static void main(String[] args){// main函数未必放在公共类中
		System.out.println("main函数在Cat类中");
	}
}

class dog{
	public static void main(String[] args){// main函数未必只有一个
		System.out.println("main函数在Dog类中");
	}
}