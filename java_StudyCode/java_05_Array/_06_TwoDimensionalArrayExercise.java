import java.util.*;




// 题目：分析下面代码含义
class _06_Test1 {
	public static void main(String[] args) {

		// 创建了int类型的一维数组x和二维数组y
		// 变量x、y都在栈区，引用值为NULL
		int[] x, y[];
		
		// 将y初始化为列不确定二维数组
		// 为y在堆区开辟空间，存放了3个值为NULL的数组引用
		y = new int[3][];
		
		// 为x在堆区开辟3个int空间，默认存放0
		x = new int[3];

		// 将y[0]赋成x的引用，二者操控同一块空间
		y[0] = x;
	}
}







// 题目：二维数组打印杨辉三角
// 1 					1
// 1 1 				   1 1 
// 1 2 1 		=>	  1 2 1
// 1 3 3 1 			 1 3 3 1
// 1 4 6 4 1 		1 4 6 4 1
// 思路：1.第n行有n个元素，首末是1
// 		2.arr[i][j] = arr[i-1][j-1] + arr[i-1][j]
// 		3.若总共N行，则第n行前面空格有N-n

public class _06_TwoDimensionalArrayExercise {
	public static void main(String[] args) {
		int row = 15;
		// 创建列不确定二维数组
		int[][] arr = new int[row][];

		// 存放杨辉三角数据
		for(int i = 0; i < arr.length; i++){
			arr[i] = new int[i + 1];
			for(int j = 0; j < arr[i].length; j++){
				arr[i][j] = (j==0||j==arr[i].length-1) ? 1 : arr[i-1][j-1]+arr[i-1][j];
			}
		}

		// 打印杨辉三角(整活写法)
		int numWidth = 0;
		int maxNum = arr[arr.length - 1][arr.length / 2 + 1];// 获取最大的数(最后一行中间数)
		while(maxNum != 0){// 获取最大数的宽度
			numWidth++;
			maxNum /= 10;
		}
		for(int i = 0; i < arr.length; i++){
			// 打印每行前空格
			int k = (arr.length - i - 1) * numWidth;
			while(k != 0){
				System.out.print(" ");
				k--;
			}
			// 打印每行数据
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j]);
				// 获取当前数字的宽度
				int tmpWidth = 0;
				int tmpNum = arr[i][j];	
				while(tmpNum != 0){
					tmpWidth++;
					tmpNum /= 10;
				}
				// 获取并打印每个数间的空格数
				int spaceNum = 2 * numWidth - tmpWidth;
				while(spaceNum != 0){
					System.out.print(" ");
					spaceNum--;
				}
			}
			System.out.println();
		}
	}
}







// 题目：创建一个升序随机正数数组，并要求插入一个元素，该数组还是升序
// 创建正数升序数组思路：
// 	1.数组默认内容全是0，第一趟将随机正数存放在末位，之后每次存放下标-1
// 	2.第i趟，存放下标的是length-i，从这个位置到末位，进行升序交换排序
class _06_Test2 {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int MaxSize = 10;
		int arr[] = new int[MaxSize];

		// 生成随机正数的升序数组：
		for(int i = arr.length - 1; i >= 0; i--){
			arr[i] = rand.nextInt(100) + 1;
			for(int j = i; j < arr.length - 1; j++){
				if(arr[j] > arr[j + 1]){
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}

		// 打印数组
		System.out.println("==========插入前==========");
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();


		// 插入元素并排序
		boolean ifLoop = false;
		boolean ifInsert = false;
		int LoopInsertNum = 0;
		while(true){
			if(ifLoop == false) {
				System.out.print("是否插入元素？(y/n):");
				ifLoop = true;
			} else {
				System.out.print("是否继续插入元素？(y/n):");
			}

			char select;
			while(true){
				select = sc.next().charAt(0);
				if(select == 'y' || select == 'n'){
					break;
				}
				System.out.print("数据有误，请重新输入(y/n):");
			}
			if(select == 'n'){
				if(ifInsert == false){
					System.out.println("未进行插入");
				} else {
					System.out.println("插入结束");
				}
				break;
			}

			// 获取插入的数字和下标
			ifInsert = true;
			LoopInsertNum++;
			System.out.print("请输入插入的数字:");
			int insertNum = sc.nextInt();
			int insertIndex = 0;
			for(insertIndex = 0; insertIndex < arr.length; insertIndex++){// 获取应插入的下标
				if(arr[insertIndex] >= insertNum){
					break;
				}
			}
			// 生成插入后的数组
			int arrNew[] = new int[arr.length + 1];
			for(int i = 0, j = 0; i < arrNew.length; i++){
				if(i == insertIndex){
					arrNew[i] = insertNum;
				} else {
					arrNew[i] = arr[j];
					j++;// i跟随循环自增，j在分支中自增
						// 可以保证arrNew在进行其他分支的同时完整拷贝arr
				}
			}
			arr = arrNew;

			// 打印结果
			System.out.println("=========第" + LoopInsertNum + "次插入========");
			for(int i = 0; i < arr.length; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}


		// 打印数组
		if(ifInsert){
			System.out.println("=======最终数组如下=======");
			for(int i = 0; i < arr.length; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
	}
}

