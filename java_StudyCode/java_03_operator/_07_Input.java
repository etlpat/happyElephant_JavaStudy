import java.util.Scanner;
// 从util包中导入Scanner类



// 从键盘输入语句
// Java键盘输入语句，需要一个Scanner(扫描器)类的对象
// 
// 步骤：
// 1.导入Scanner类所在的包(util)
// 2.创建Scanner类的对象
// 3.使用该对象的next方法接收用户输入的信息
// 
// 
// 
// Scanner类：
// 1.导包
// 	 import java.util.Scanner;
//   从util包中导入Scanner类
// 
// 2.创建对象
// 	 语法：Scanner sc = new Scanner(System.in)
// 	 创建了一个Scanner类的对象sc，能够从System.in中读取数据
// 	 System.in：表示从键盘输入
// 	 
// 3.next()方法
// 	 语法：String str = sc.next();
// 	 功能：读取并返回从键盘输入的字符串
// 	 
// 4.nextInt()等方法
// 	 语法：int a = sc.nextInt();
// 	 功能：读取并返回从键盘输入的int值，非法输入会抛出异常
// 
// 同理，也存在nextBoolean()、nextByte()、nextShort()、nextLong()、nextFloat()、nextDouble()
// 使用方法与nextInt()一致 





public class _07_Input{
	public static void main(String[] args){

		// 创建Scanner对象，从System.in接收数据
		Scanner sc = new Scanner(System.in);


		System.out.print("请输入用户姓名：");
		String name = sc.next();// 从屏幕接收并返回String数据

		System.out.print("请输入用户年龄：");
		int age = sc.nextInt();// 从屏幕接收并返回int数据

		System.out.print("请输入用户分数：");
		double score = sc.nextDouble();// 从屏幕接收并返回Double数据

		System.out.println("\n信息如下：");
		System.out.println("姓名：" + name + "\t年龄：" + age + "\t分数：" + score);
	}
}