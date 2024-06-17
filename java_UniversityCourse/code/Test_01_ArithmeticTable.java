// 打印算数表

import java.util.*;


public class Test_01_ArithmeticTable {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		int heitght = 0;
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		int sum = 0;
		
		System.out.println("出几道题？：");
		heitght = sc.nextInt();
		System.out.println("\n\n");
		for(int i = 0; i < heitght; i++){
			while(true) {
				num1 = rand.nextInt(90) + 10;// 生成[10,99]
				num2 = rand.nextInt(90) + 10;// 生成[10,99]
				if((num1 + num2) / 100 == 0){// 保证两数相加结果是两位数
					break;
				}
			}
			System.out.print("\t" + num1 + "+" + num2 + "=");

			result = sc.nextInt();
			if(result == num1 + num2){
				System.out.println("\tT\n");
			} else {
				System.out.println("\tF  " + (num1 + num2) + "\n");
				sum++;
			}
		}
		System.out.println("\n\t错" + sum + "个");

	}
}

