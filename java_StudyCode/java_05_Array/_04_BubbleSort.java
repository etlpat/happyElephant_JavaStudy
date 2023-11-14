// bubble sort： 冒泡排序

import java.util.*;



// 冒泡排序：
// 题目：用数组存放一组随机数，对其从小到大进行排序
// 
// 思路：1.若对n个元素排序，就循环n-1趟
// 		2.每趟从前到后比对交换元素，将较大的换到后面
// 		3.若n个元素则第一趟交换n-1次，之后每趟交换次数逐一递减




public class _04_BubbleSort {
	public static void main(String[] args) {

		// 创建随机数数组 
		Random rand = new Random();
		int sz = 100;
		int arr[] = new int[sz];
		for(int i = 0; i < arr.length; i++){
			arr[i] = rand.nextInt(501);
		}

		// 打印排序前数组
		System.out.println("\t\t==================排序前==================");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + "\t");
			if((i + 1) % 10 == 0) System.out.println();
		}

		// 冒泡排序
		for(int i = 0; i < arr.length - 1; i++){// 排序进行length-1趟
			boolean flag = true;
			for(int j = 0; j < arr.length - 1 - i; j++){// 每趟交换length-1-i次
				if(arr[j] > arr[j + 1]){// 将小的交换到前面
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					flag = false;
				}
			}
			if(flag){// 优化代码
				break;
			}
		}

		// 打印排序后数组
		System.out.println("\n\t\t==================排序后==================");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + "\t");
			if((i + 1) % 10 == 0) System.out.println();
		}
	}
}
