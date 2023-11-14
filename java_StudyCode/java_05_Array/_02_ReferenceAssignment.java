// reference assignment： 引用 赋值

import java.util.*;



// 数组赋值机制：(引用赋值)
// 
// (1)基本数据类型的赋值：
// 	【值传递：值的拷贝】
// 	如：int n2 = n1; 将n1的值直接赋给n2
// 	本质：n1、n2是两块不同的空间，只是存放的数据值相同
// 	
// 
// 		
// (2)引用数据类型的赋值：
// 	【引用传递：地址拷贝】
// 	如：int[] arr2 = arr1; 
// 	本质：将arr1的地址传给arr2，在调用arr2时，自动通过地址找到arr1的空间。
// 		  arr1、arr2指向同一块空间，arr2是arr1的引用/别名
//
//
//
// (3)深拷贝、浅拷贝
// 	浅拷贝：对内存进行简单的逐字节拷贝
// 			(将a赋值给b时，若a是引用类型，则b获得的值是指向a空间的指针)
// 	深拷贝：重新申请内存空间，对值进行拷贝操纵
// 			(将a赋值给b时，给b创建一块新空间来存放a指向的值，a、b指向不同的空间)




 public class _02_ReferenceAssignment {
 	public static void main(String[] args) {
 		
 		int[] arr1 = {1, 2, 3};
 		int[] arr2 = arr1;// 由于数组是引用数据类型，所以该赋值是引用赋值

 		arr2[0] = 100;

 		for(int i = 0; i < arr2.length; i++)// arr2的数据
 			System.out.print(arr2[i] + " ");// 100 2 3

 		System.out.println();
 		for(int i = 0; i < arr1.length; i++)// arr1的数据
 			System.out.print(arr1[i] + " ");// 100 2 3

 		// 由于引用赋值，arr2和arr1指向同一块空间
 		// 改变arr2的内容，arr1的内容也发生改变
 	}
 }





// 对数组进行深拷贝
class _02_Test {
 	public static void main(String[] args) {
 		// 数组是引用类型，int[] arr2 = arr1;将arr1地址直接拷贝给arr2，是浅拷贝
 		
 		int[] arr1 = {1, 2, 3};
 		int[] arr2 = new int[arr1.length];

 		for(int i = 0; i < arr2.length; i++){// arr2对arr1深拷贝(指向不同空间)
 			arr2[i] = arr1[i];
 		}

 		arr2[0] = 100;

 		 for(int i = 0; i < arr1.length; i++)// arr1的数据
 			System.out.print(arr1[i] + " ");// 1 2 3
 		System.out.println();
 		 for(int i = 0; i < arr2.length; i++)// arr2的数据
 			System.out.print(arr2[i] + " ");// 100 2 3
 	}
 }