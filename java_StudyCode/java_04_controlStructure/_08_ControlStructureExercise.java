import java.util.*;


// 题目1：打印空心金字塔
// 
// 	*	    	  	    *			    *
// 	***	   			   ***			   * *
// 	*****	  =>	  *****     =>	  *   *
// 	*******	 		 *******		 *	   *
// 	*********		*********		*********
// 	  （1）			  （2）			   (3)
// 	
// 分析：若总高度为N，本行所在高度为n(从上到下)
// 		则(2)中，第n行有(2*n-1)个'*'，首个'*'距离起始位置(N-n)
// 		则(3)中，只有首末是'*'，其余是' '

public class _08_ControlStructureExercise {
	public static void main(String[] args) {
		int height = 24;// 总行数
		char ch = '*';// 组成图形的字符

		for(int i = 1; i <= height; i++){// 总共打印height行，每次循环打印一行

			for(int k = 1; k <= height - i; k++) {// 打印每行前的空位
				System.out.print(' ');
			}

			for(int j = 1; j <= 2*i-1; j++) {// 打印每行的图案
				if(j == 1 || j == 2*i-1 || i == height) {// 若是首末位置或最底行，打印'*'；否则打印' '
					System.out.print(ch);
				} 
				else {
					System.out.print(' ');
				}
			}

			System.out.println();// 换行
		}
	}
}








// 例题：初始有100000块
// 	当>50000块时，每次收5%；<=50000块，每次收1000
// 	问一共可以收几次钱？

class _08_Exercise2 {
	public static void main(String[] args) {
		double x = 100000;
		int num = 0;
		while(x > 0){
			if(x > 50000){
				x *= 0.95;
			} else if(x >= 1000) {
				x -= 1000;
			} else {
				break;
			}
			num++;
			System.out.println(num + ": " + x);
		}

		System.out.println("能收" + num + "次");// 62
	}
}








// 例题：判断一共三位数是否是水仙花数
// 	如：1*1*1 + 3*3*3 + 5*5*5 = 153
// 	
// 补充：Math.pow()计算次方：
// 语法：double pow(double a, double b); a表示底数，b表示次数

class _08_Exercise3 {
	public static void main(String[] args) {
		for(int num = 100; num < 1000; num++){
			if(num == Math.pow(num%10, 3) // 表示num%10的三次方
					+ Math.pow(num/10%10, 3) 
					+ Math.pow(num/100, 3)){
				System.out.print(num + " ");// 153 370 371 407
			}
		}
	}
}








// 例题：1.输出 1 - 1/2 + 1/3 - 1/4 +...- 1/100
// 		2.输出 1 + (1+2) + (1+2+3) +...+ (1+...+100)

class _08_Exercise4 {
	public static void main(String[] args) {
		double sum1 = 0;
		int sum2 = 0, tmp = 0;

		for(int i = 1; i <= 100; i++){
			// pow返回double，所以不用强转
			sum1 += Math.pow(-1, i-1) / i;// 例题1

			tmp += i;// 例题2：
			sum2 += tmp;
		}

		System.out.println("sum1:" + sum1);// 0.688172179310195
		System.out.println("sum2:" + sum2);// 171700
	}
}