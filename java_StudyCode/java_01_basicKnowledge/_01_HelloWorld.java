
//java基础内容_输出Hello World
//注意：用控制台输出文件，若文件中含中文，需要将当前使用的Sblime编码设置为DBK(简体中文)
// 	    平时工作中统一用UTF-8

		
//表示HelloWorld是一个公开的类
public class _01_HelloWorld{//该类名必须和文件名相同
	
	//主方法main，程序的入口
	public static void main(String[] args){
		//输出字符串到屏幕上
		System.out.println("Hello World~");
	}	
}



//java代码执行过程：先编译，后运行
//编译:通过编译器使.java文件生成.class文件（每个类生成一个class文件）
//运行：通过.exe文件，将.class文件装载到JVM虚拟机中执行
// 源文件：.java   字节码文件：.class   可执行文件：.exe



//控制台指令：
//编译：javac 文件名.java
//运行：java 类名（注意，这里运行的是类名，而不是文件名）
//
//注意：若源文件发生修改，需要重新编译，刷新.class文件后再运行