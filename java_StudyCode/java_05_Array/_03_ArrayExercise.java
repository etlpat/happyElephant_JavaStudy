import java.util.*;



// 题目1：(原地)逆序数组
// 思路：1.遍历前一半数组  2.将前后对应位置元素交换

public class _03_ArrayExercise {
 	public static void main(String[] args) {
 		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
 		int len = arr.length;

 		for(int i = 0; i < len / 2; i++){
 			int tmp = arr[i];
 			arr[i] = arr[len - 1 - i];
 			arr[len - 1 - i] = tmp;
 		}

 		for(int i = 0; i < len; i++)
 			System.out.print(arr[i] + " ");// 9 8 7 6 5 4 3 2 1
 	}
 }






// 题目2：数组增加元素
// 要求：自定义一个数组，并为其添加一个新元素，之后会询问是否继续添加(y/n)
// 思路：1.原数组是arr，定义一个比arr多一个元素的新数组newArr
//      2.将arr的内容拷贝到newArr中，再自定义newArr的最后一个元素
//      3.将arr=newArr，arr变为newArr空间的引用，旧arr的空间由于没有引用关系，自动释放

 class _03_ArrayChange {
 	public static void main(String[] args) {
 		Scanner sc = new Scanner(System.in);

 		System.out.print("请问要创建一个多大的数组？：");
 		int sz = sc.nextInt();
 		int arr[] = new int[sz];
 		for(int i = 0; i < sz; i++){
 			System.out.print("第" + (i+1) + "个元素是？：");
 			arr[i] = sc.nextInt();
 		}

 		System.out.println("数组创建成功！数组内容是：");
 		for(int i = 0; i < arr.length; i++){
 			System.out.print(arr[i] + " ");
 		}
 		System.out.println("");


 		while(true) {
 			char choose;
 			System.out.print("是否继续添加元素？(y/n)：");
 			while(true) {
	 			choose = sc.next().charAt(0);
	 			if(choose == 'y' || choose == 'n'){
	 				break;
	 			}
	 			System.out.print("输入错误，请重新输入(y/n)：");
 			}
 			if(choose == 'n'){
 				break;
 			}


 			int newArr[] = new int[arr.length + 1];
 			for(int i = 0; i < arr.length; i++){
 				newArr[i] = arr[i];
 			}
 			System.out.print("请输入新元素：");
 			newArr[arr.length] = sc.nextInt();

 			arr = newArr;// 将arr指向newArr的空间
 			// 数组是引用类型，原本旧arr的空间由于没有引用关系，会自动销毁
 		}

 		if(arr.length > sz){
	 		System.out.println("添加元素成功！数组内容是：");
	 		for(int i = 0; i < arr.length; i++){
	 			System.out.print(arr[i] + " ");
	 		}
 		}
 	}
 }