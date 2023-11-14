// for 循环

import java.util.*;



// for 循环
// 
// 
// 语法：
// 	for(语句1; 语句2; 语句3){
// 		代码块;
// 	}
// 	
// 
// 
// 注意：
// 	1.语句1：循环变量初始化
// 	  语句2：循环条件判断(必须返回boolean值)
// 	  语句3：循环变量迭代
// 
//	2.for循环的执行顺序是：
//		语句1->语句2->代码块->语句3->语句2->代码块->语句3...
//		
//	3.java中，for可以直接在语句1的位置定义新变量 (和C++一样)
//		如：for(int i=0; i<10; i++){...}
//		注意：这里i是循环内部创建的局部变量，出循环会销毁
//		
//	4.for循环的控制语句中，可以利用逗号表达式操作多个变量
//		如：for(int i=0, j=1; i<10; i++, j+=2){...}





public class _03_For {
	public static void main(String[] args){

		for(int i = 0; i < 1000; i++){
			System.out.print(i + 1 + "  ");
		}

		System.out.println("\n\n");


		for(int i = 0, j = 1; i < 10; i++, j += 2){
			System.out.println("i=" + i + "，j=" + j);
		}
	}
}




// 练习：打印九九乘法表
class _03_Test {
	public static void main(String[] args){

		for(int i = 1; i < 10; i++){
			for(int j = 1; j <= i; j++){
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}
	}
}


