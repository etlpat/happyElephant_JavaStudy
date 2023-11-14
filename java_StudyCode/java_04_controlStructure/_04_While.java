// while 循环

import java.util.*;



// while循环
// 
// 
// 语法：
// 	while(条件判断) {
// 		代码块;
// 	}
// 
// 
// 
// 注意：
// 	1.while条件判断语句，返回值必须是boolean类型
// 	2.循环的嵌套，最好不要超过3层，否则可读性差





public class _04_While {
	public static void main(String[] args) {
		
		int i = 0;
		while(i < 10) {
			System.out.print(i + " ");
			i++;
		}
	}
}





// 练习：遍历1-100，输出能被3整除的数
class _04_Test {
	public static void main(String[] args) {
		// 编程思想：化繁为简，先死后或
		int start = 1;
		int end = 100;
		int num = 3;// 将题目要求变成灵活的变量，以应对不同的题目

		int i = start;
		while(i <= end){
			if(i % num == 0){
				System.out.print(i + " ");
			}
			i++;
		}
	}
}