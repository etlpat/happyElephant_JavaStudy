// two-dimensional array： 二维数组

import java.util.*;



// 二维数组
// 
// (1)二维数组的声明：(下面三种写法等价)
// 			int[][] arr;
// 			int arr[][];
// 			int[] arr[];
// 		
// (2)二维数组的初始化：
// 		静态初始化(堆区)：
// 			double a[][] = {{1,1,1}, {2,2}, {3}};// 每个一维数组列数可以不同
// 		动态初始化(堆区)：
// 			double a[][] = new double[2][3];
// 		列不确定二维数组初始化：
// 			double a[][] = new double[3][];
// 		
// (3)列数不确定的二维数组：
// 		java允许二维数组的每个一维数组元素个数不相同
// 		①定义：int[][] arr = new int[3][];
// 			  在堆区创建一块空间存放3个一维数组的引用，引用值为NULL(还没为一维数组开辟空间)
// 		②初始化：arr[0] = new int[1]; arr[1] = new int[2]; arr[2] = new int[3];
//			  为每个一维数组的引用开辟空间，空间大小可以不同
// 	
// 	
// 	
// 	
// 二维数组的内存分布：
//	以int[2][3]类型的数组arr为例：
// 		栈区的引用变量arr指向一块堆区空间，空间中放着两个引用变量arr[0]和arr[1]
// 		堆区的引用变量arr[0]和arr[1]分别指向两块堆区中的3个int大小的空间
// 		
// 	原理：java中数组是引用类型(对象)，数组名是内存空间的引用(即指向空间的指针)
// 		 如：arr[1][1]操作，本质是通过指针arr找到arr[1]，再通过指针arr[1]找到空间arr[1][1]
// 		
// 				
// 		
// 注意事项：
// 	1.【二维数组的每个元素都是一维数组(对象)】
// 	  本质：二维数组的内存空间中存放着一维数组的引用(指针)，这些引用又指向一维数组的空间
// 	
// 	2.二维数组.length，表示其中一维数组的个数
// 	  二维数组[i].length，表示下标为i的一维数组的元素个数
// 	  
// 	3.java允许二维数组的每个一维数组元素个数(列数)不同
// 	  	
// 	4.java定义二维数组，列数可以不确定，行数必须确定
// 		原因：java数组是对象，二维数组空间中存放的是一维数组空间的引用(指针)，必须明确规定指针的个数，但是指针指向的空间大小随意
// 	  C++中定义二维数组，列数必须确定，行数可以不确定
// 	  	原因：C++二维数组整体内存空间连续，通过固定列数来划分每行的元素个数
// 	





public class _05_TwoDimensionalArray {
	public static void main(String[] args) {

		// (1)二维数组静态初始化：
		int[] arr1[] = {{1}, {4, 5, 6}, {2, 3, 7, 8, 9}};// 注意：java允许二维数组的每个一维数组列数不同
		// 打印数据
		System.out.println("====静态初始化二维数组====");
		for(int i = 0; i < arr1.length; i++) {// arr1.length：二维数组的元素个数，即一维数组的个数
			for (int j = 0; j < arr1[i].length; j++) {// arr1[i].length：对应的一维数组的元素个数
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}



		// (2)二维数组动态初始化：
		int arr2[][] = new int[6][4];

		// 赋值（赋值前元素默认全为0）
		for(int i = 0; i < arr2.length; i++){
			for(int j = 0; j < arr2[i].length; j++){
				arr2[i][j] = i * arr2[i].length + j + 1;
			}
		}
		// 打印数据
		System.out.println("\n====动态初始化二维数组====");
		for(int i = 0; i < arr2.length; i++){
			for(int j = 0; j < arr2[i].length; j++){
				System.out.print(arr2[i][j] + "\t");
			}
			System.out.println();
		}



		// (3)列不确定二维数组的初始化
		int[][] arr3 = new int[9][];

		// 为每行一维数组开辟空间，并赋值
		for(int i = 0; i < arr3.length; i++){
			arr3[i] = new int[i + 1];// 每行一维数组开辟空间
			for(int j = 0; j < arr3[i].length; j++){// 给每行一维数组赋值
				arr3[i][j] = i + 1;
			}
		}
		// 打印数据
		System.out.println("\n====列不确定二维数组====");
		for(int i = 0; i < arr3.length; i++){
			for(int j = 0; j < arr3[i].length; j++){
				System.out.print(arr3[i][j] + "\t");
			}
			System.out.println();
		}
	}
}







// 题目：生成随机行列数的二维数组，对其元素求和并求平均值
class _05_Test1 {
	public static void main(String[] args) {
		Random rand = new Random();

		int arr[][] = new int[rand.nextInt(20) + 1][];// 为二维数组arr生成随机个元素
		for(int i = 0; i < arr.length; i++){
			arr[i] = new int[rand.nextInt(10) + 1];// 为每个一维数组生成随机个元素
			for(int j = 0; j < arr[i].length; j++){
				arr[i][j] = rand.nextInt(101);// 为一维数组每个元素赋随机值
			}
		}

		System.out.println("=====二维数组数据如下=====");
		int num = 0;
		int row = 0;
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			row++;
			for (int j = 0; j < arr[i].length; j++){
				sum += arr[i][j];
				num++;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==========================");
		System.out.println("总共" + row + "行"
						 + "\n元素个数：" + num
					     + "\n数据总和：" + sum 
					     + "\n平均值：" + sum / num);
	}
}
