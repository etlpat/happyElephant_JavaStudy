// reference assignment�� ���� ��ֵ

import java.util.*;



// ���鸳ֵ���ƣ�(���ø�ֵ)
// 
// (1)�����������͵ĸ�ֵ��
// 	��ֵ���ݣ�ֵ�Ŀ�����
// 	�磺int n2 = n1; ��n1��ֱֵ�Ӹ���n2
// 	���ʣ�n1��n2�����鲻ͬ�Ŀռ䣬ֻ�Ǵ�ŵ�����ֵ��ͬ
// 	
// 
// 		
// (2)�����������͵ĸ�ֵ��
// 	�����ô��ݣ���ַ������
// 	�磺int[] arr2 = arr1; 
// 	���ʣ���arr1�ĵ�ַ����arr2���ڵ���arr2ʱ���Զ�ͨ����ַ�ҵ�arr1�Ŀռ䡣
// 		  arr1��arr2ָ��ͬһ��ռ䣬arr2��arr1������/����
//
//
//
// (3)�����ǳ����
// 	ǳ���������ڴ���м򵥵����ֽڿ���
// 			(��a��ֵ��bʱ����a���������ͣ���b��õ�ֵ��ָ��a�ռ��ָ��)
// 	��������������ڴ�ռ䣬��ֵ���п�������
// 			(��a��ֵ��bʱ����b����һ���¿ռ������aָ���ֵ��a��bָ��ͬ�Ŀռ�)




 public class _02_ReferenceAssignment {
 	public static void main(String[] args) {
 		
 		int[] arr1 = {1, 2, 3};
 		int[] arr2 = arr1;// ���������������������ͣ����Ըø�ֵ�����ø�ֵ

 		arr2[0] = 100;

 		for(int i = 0; i < arr2.length; i++)// arr2������
 			System.out.print(arr2[i] + " ");// 100 2 3

 		System.out.println();
 		for(int i = 0; i < arr1.length; i++)// arr1������
 			System.out.print(arr1[i] + " ");// 100 2 3

 		// �������ø�ֵ��arr2��arr1ָ��ͬһ��ռ�
 		// �ı�arr2�����ݣ�arr1������Ҳ�����ı�
 	}
 }





// ������������
class _02_Test {
 	public static void main(String[] args) {
 		// �������������ͣ�int[] arr2 = arr1;��arr1��ֱַ�ӿ�����arr2����ǳ����
 		
 		int[] arr1 = {1, 2, 3};
 		int[] arr2 = new int[arr1.length];

 		for(int i = 0; i < arr2.length; i++){// arr2��arr1���(ָ��ͬ�ռ�)
 			arr2[i] = arr1[i];
 		}

 		arr2[0] = 100;

 		 for(int i = 0; i < arr1.length; i++)// arr1������
 			System.out.print(arr1[i] + " ");// 1 2 3
 		System.out.println();
 		 for(int i = 0; i < arr2.length; i++)// arr2������
 			System.out.print(arr2[i] + " ");// 100 2 3
 	}
 }