// two-dimensional array�� ��ά����

import java.util.*;



// ��ά����
// 
// (1)��ά�����������(��������д���ȼ�)
// 			int[][] arr;
// 			int arr[][];
// 			int[] arr[];
// 		
// (2)��ά����ĳ�ʼ����
// 		��̬��ʼ��(����)��
// 			double a[][] = {{1,1,1}, {2,2}, {3}};// ÿ��һά�����������Բ�ͬ
// 		��̬��ʼ��(����)��
// 			double a[][] = new double[2][3];
// 		�в�ȷ����ά�����ʼ����
// 			double a[][] = new double[3][];
// 		
// (3)������ȷ���Ķ�ά���飺
// 		java�����ά�����ÿ��һά����Ԫ�ظ�������ͬ
// 		�ٶ��壺int[][] arr = new int[3][];
// 			  �ڶ�������һ��ռ���3��һά��������ã�����ֵΪNULL(��ûΪһά���鿪�ٿռ�)
// 		�ڳ�ʼ����arr[0] = new int[1]; arr[1] = new int[2]; arr[2] = new int[3];
//			  Ϊÿ��һά��������ÿ��ٿռ䣬�ռ��С���Բ�ͬ
// 	
// 	
// 	
// 	
// ��ά������ڴ�ֲ���
//	��int[2][3]���͵�����arrΪ����
// 		ջ�������ñ���arrָ��һ������ռ䣬�ռ��з����������ñ���arr[0]��arr[1]
// 		���������ñ���arr[0]��arr[1]�ֱ�ָ����������е�3��int��С�Ŀռ�
// 		
// 	ԭ��java����������������(����)�����������ڴ�ռ������(��ָ��ռ��ָ��)
// 		 �磺arr[1][1]������������ͨ��ָ��arr�ҵ�arr[1]����ͨ��ָ��arr[1]�ҵ��ռ�arr[1][1]
// 		
// 				
// 		
// ע�����
// 	1.����ά�����ÿ��Ԫ�ض���һά����(����)��
// 	  ���ʣ���ά������ڴ�ռ��д����һά���������(ָ��)����Щ������ָ��һά����Ŀռ�
// 	
// 	2.��ά����.length����ʾ����һά����ĸ���
// 	  ��ά����[i].length����ʾ�±�Ϊi��һά�����Ԫ�ظ���
// 	  
// 	3.java�����ά�����ÿ��һά����Ԫ�ظ���(����)��ͬ
// 	  	
// 	4.java�����ά���飬�������Բ�ȷ������������ȷ��
// 		ԭ��java�����Ƕ��󣬶�ά����ռ��д�ŵ���һά����ռ������(ָ��)��������ȷ�涨ָ��ĸ���������ָ��ָ��Ŀռ��С����
// 	  C++�ж����ά���飬��������ȷ�����������Բ�ȷ��
// 	  	ԭ��C++��ά���������ڴ�ռ�������ͨ���̶�����������ÿ�е�Ԫ�ظ���
// 	





public class _05_TwoDimensionalArray {
	public static void main(String[] args) {

		// (1)��ά���龲̬��ʼ����
		int[] arr1[] = {{1}, {4, 5, 6}, {2, 3, 7, 8, 9}};// ע�⣺java�����ά�����ÿ��һά����������ͬ
		// ��ӡ����
		System.out.println("====��̬��ʼ����ά����====");
		for(int i = 0; i < arr1.length; i++) {// arr1.length����ά�����Ԫ�ظ�������һά����ĸ���
			for (int j = 0; j < arr1[i].length; j++) {// arr1[i].length����Ӧ��һά�����Ԫ�ظ���
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}



		// (2)��ά���鶯̬��ʼ����
		int arr2[][] = new int[6][4];

		// ��ֵ����ֵǰԪ��Ĭ��ȫΪ0��
		for(int i = 0; i < arr2.length; i++){
			for(int j = 0; j < arr2[i].length; j++){
				arr2[i][j] = i * arr2[i].length + j + 1;
			}
		}
		// ��ӡ����
		System.out.println("\n====��̬��ʼ����ά����====");
		for(int i = 0; i < arr2.length; i++){
			for(int j = 0; j < arr2[i].length; j++){
				System.out.print(arr2[i][j] + "\t");
			}
			System.out.println();
		}



		// (3)�в�ȷ����ά����ĳ�ʼ��
		int[][] arr3 = new int[9][];

		// Ϊÿ��һά���鿪�ٿռ䣬����ֵ
		for(int i = 0; i < arr3.length; i++){
			arr3[i] = new int[i + 1];// ÿ��һά���鿪�ٿռ�
			for(int j = 0; j < arr3[i].length; j++){// ��ÿ��һά���鸳ֵ
				arr3[i][j] = i + 1;
			}
		}
		// ��ӡ����
		System.out.println("\n====�в�ȷ����ά����====");
		for(int i = 0; i < arr3.length; i++){
			for(int j = 0; j < arr3[i].length; j++){
				System.out.print(arr3[i][j] + "\t");
			}
			System.out.println();
		}
	}
}







// ��Ŀ����������������Ķ�ά���飬����Ԫ����Ͳ���ƽ��ֵ
class _05_Test1 {
	public static void main(String[] args) {
		Random rand = new Random();

		int arr[][] = new int[rand.nextInt(20) + 1][];// Ϊ��ά����arr���������Ԫ��
		for(int i = 0; i < arr.length; i++){
			arr[i] = new int[rand.nextInt(10) + 1];// Ϊÿ��һά�������������Ԫ��
			for(int j = 0; j < arr[i].length; j++){
				arr[i][j] = rand.nextInt(101);// Ϊһά����ÿ��Ԫ�ظ����ֵ
			}
		}

		System.out.println("=====��ά������������=====");
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
		System.out.println("�ܹ�" + row + "��"
						 + "\nԪ�ظ�����" + num
					     + "\n�����ܺͣ�" + sum 
					     + "\nƽ��ֵ��" + sum / num);
	}
}
