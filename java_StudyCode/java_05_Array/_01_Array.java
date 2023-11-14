// array：数组

import java.util.*;


// 数组 
// java中，数组是一种引用数据类型，可以存放多个同种类型的元素
// 
// 
// (1)数组的声明：(以下两种方式是等价的)
// 		①：int[] arr;
// 		②：int arr[];
// 		int[] arr = {...};// 可以在定义的同时初始化
// 		
// (2)数组的初始化：
// 		静态初始化(堆区)：
// 			double a[] = {...};
// 			(静态初始化无法在[]中自定义元素个数)
// 		动态初始化(堆区)：
// 			double a[] = new double[5];
// 		
// (3)获取数组元素个数
// 		语法：数组名.length;
// 		
// 		
// 		
// 注意事项：
// 	1.数组是引用类型，数组的本质是对象(object)
// 	  数组的元素可以是任意类型，包括对象等引用数据类型
// 	
// 	2.数组元素不赋值，空间默认补0：
// 	  整数(0) 浮点数(0.0) 字符(\u0000) boolean(false) String(null)
// 	  本质：堆区数据都有默认值0
//
//	3.数组下标范围：从(0)到(元素个数-1)
//	  若下标越界访问，会报异常
//	  
//	4.java数组全都是在【堆区】分配空间的
//	  如：int[] arr = new int[3]; / int[] arr = {1, 2, 3}
//		  数组空间开辟在堆区；但是数组名arr在栈区，存放着指向堆区数组的首地址
//	
//	5.静态初始化：如 int arr[] = {...};
//	  注意：尽管该写法与C++定义数组语法相同，但本质是不同的
//	  区别：静态初始化的[]中不能用数字定义数组大小，且静态初始化也是在堆区创建空间





public class _01_Array {
	public static void main(String[] args) {
	
		// 静态初始化数组
		int[] arr1 = {1, 2, 3, 4, 5, 6, 7}; // java数组存放在堆区

		// arr1.length表示数组的长度(元素个数)
		System.out.println(arr1.length);

		// 通过下标获取数组元素
		for(int i = 0; i < arr1.length; i++){
			System.out.print(arr1[i] + " ");
		}
		System.out.println();



		// 数组元素的值默认是0
		int arr[] = new int[4];
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");// 0 0 0 0
		}

		System.out.println(arr[4]);// 下标越界访问，报异常
	}
}





// 题目：在堆区创建包含100个[0,100]随机整数的数组
class _01_Test {
	public static void main(String[] args) {
		Random rand = new Random();

		// 在堆区创建了包含100个元素的int数组
		int[] arr = new int[100];

		for(int i = 0; i < arr.length; i++){// 存入随机数
			arr[i] = rand.nextInt(101);
		}

		for(int i = 0; i < arr.length; i++){// 打印结果
			System.out.print(arr[i] + "\t");
			if((i + 1) % 10 == 0){
				System.out.println();
			}
		}
	}
}





// 题目：创建数组，存放26个大写字母
class _01_Test2 {
	public static void main(String[] args) {

		char arr[] = new char[26];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (char)('A' + i);
		}

		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
}






// 题目：用数组存放100个[-99, 99]的整数，并找出其中最大和最小的数及其下标
class _01_Test3 {
	public static void main(String[] args) {
		Random rand = new Random();

		int arr[] = new int[100];
		for(int i = 0; i < arr.length; i++) {// 生成随机数数组
			// -99到99一共199个数字; [0,198]-99=[-99,99]
			arr[i] = rand.nextInt(199) - 99;
		}

		int maxNum = arr[0], minNum = arr[0];
		int maxIndex = 0, minIndex = 0;
		System.out.println("随机数结果如下：");
		for(int i = 0; i < arr.length; i++) {
			// 获取最大最小值及其下标
			if(maxNum < arr[i]){
				maxNum = arr[i];
				maxIndex = i;
			}
			if(minNum > arr[i]){
				minNum = arr[i];
				minIndex = i;
			}


			// 打印随机数
			if(arr[i] > 0){
				System.out.print(" ");
			}
			System.out.print(arr[i] + "\t");
			if((i + 1) % 10 == 0){
				System.out.println();
			}
		}

		System.out.println("最大值为：" + maxNum + "，下标是：" + maxIndex);
		System.out.println("最小值为：" + minNum + "，下标是：" + minIndex);
	}
}
