// Recursion： 递归



// 方法的递归
// 
// 递归的三要素：
// 	1.明确方法的作用：即明确递归方法的功能和目的
// 	2.递归的结束条件：每次递归必须向退出递归的条件逼近；否则会无限递归，然后StackOverflow
// 	3.方法等价关系：在递归中，通过等价关系来缩小问题的规模 
// 
// 
// 递归时的内存布局：
// 	1.方法的每次递归，都会在栈顶压入一块独立的栈空间，存放每次递归方法的变量、参数等
// 	2.直到递归结束，所以方法的栈都会被弹出，然后将结果返回给调用者
//	3.因此，递归调用的深度受到栈空间的限制，如果递归次数过多，栈会溢出





class _03_RecursionTools {
	public void printInt(int num) {// 递归打印整数
		if(num > 0){
			printInt(num / 10);
			System.out.print(num % 10);
		} else if(num < 0) {
			System.out.print("-");
			printInt(-num);
		}
	}

	public int factorial(int num) {// 递归求阶乘
		if(num > 1){
			return num * factorial(num - 1);
		} else if(num == 1 || num == 0) {
			return 1;
		} else {
			return -1;
		}
	}

	// 例：求第n个斐波那契数
	// 1, 1, 2, 3, 5, 8, 13...
	// 思路：第n个斐波那契数：f(n) = f(n-1) + f(n-1)，且 f(1) = f(2) = 1
	public int fibonacci(int n) {// 第n个斐波那契
		if(n <= 0) {
			return -1;
		} else if(n == 1 || n == 2) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	// 例：猴子吃桃
	// 有一堆桃子，猴子每天吃一半，并多吃一个。到第n天(还没吃)，只剩1个桃子。求最初有多少个桃子？
	// 思路：总共n天吃的数量f(n) = 当天吃的数量 + 剩余n-1天吃的数量f(n-1)，当天吃的量是f(n-1)+2
	// 		(当天吃一半，并多吃一个，吃的比剩的多2个。 如10个，吃5+1=6个，剩下4个，吃比剩多2个)
	// 	    当最后一天，桃子只剩一个，f(1) = 1
	public int monkeyEatPeach(int n) {// n天总共吃的桃子数
		if(n <= 0){
			return -1;
		} else if (n == 1){
			return 1;
		} else {
			return 2 * monkeyEatPeach(n - 1) + 2;
		}
	}
}


public class _04_Recursion {
	public static void main(String[] args) {
		_03_RecursionTools tool = new _03_RecursionTools();

		// 打印整数
		int n1 = 114514;
		int n2 = -1919810;
		tool.printInt(n1);// 114514
		System.out.println();
		tool.printInt(n2);// -1919810
		System.out.println();


		// 求阶乘
		int n3 = tool.factorial(5);
		System.out.println(n3);// 120
		int n4 = tool.factorial(0);
		System.out.println(n4);// 1
		int n5 = tool.factorial(-5);
		System.out.println(n5);// -1


		// 求斐波那契数
		for(int i = 1; i <= 10; i++){
			System.out.print(tool.fibonacci(i) + " ");// 1 1 2 3 5 8 13 21 34 55
		}
		System.out.println();


		// 猴子吃桃
		int day = 10;
		int peach = tool.monkeyEatPeach(day);
		if(peach != -1) {
			System.out.println("猴子 " + day + " 天一共吃了 " + peach + " 个桃子");// 1534
		}
	}
}