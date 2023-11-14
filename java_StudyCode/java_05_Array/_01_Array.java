// array������

import java.util.*;


// ���� 
// java�У�������һ�������������ͣ����Դ�Ŷ��ͬ�����͵�Ԫ��
// 
// 
// (1)�����������(�������ַ�ʽ�ǵȼ۵�)
// 		�٣�int[] arr;
// 		�ڣ�int arr[];
// 		int[] arr = {...};// �����ڶ����ͬʱ��ʼ��
// 		
// (2)����ĳ�ʼ����
// 		��̬��ʼ��(����)��
// 			double a[] = {...};
// 			(��̬��ʼ���޷���[]���Զ���Ԫ�ظ���)
// 		��̬��ʼ��(����)��
// 			double a[] = new double[5];
// 		
// (3)��ȡ����Ԫ�ظ���
// 		�﷨��������.length;
// 		
// 		
// 		
// ע�����
// 	1.�������������ͣ�����ı����Ƕ���(object)
// 	  �����Ԫ�ؿ������������ͣ����������������������
// 	
// 	2.����Ԫ�ز���ֵ���ռ�Ĭ�ϲ�0��
// 	  ����(0) ������(0.0) �ַ�(\u0000) boolean(false) String(null)
// 	  ���ʣ��������ݶ���Ĭ��ֵ0
//
//	3.�����±귶Χ����(0)��(Ԫ�ظ���-1)
//	  ���±�Խ����ʣ��ᱨ�쳣
//	  
//	4.java����ȫ�����ڡ�����������ռ��
//	  �磺int[] arr = new int[3]; / int[] arr = {1, 2, 3}
//		  ����ռ俪���ڶ���������������arr��ջ���������ָ�����������׵�ַ
//	
//	5.��̬��ʼ������ int arr[] = {...};
//	  ע�⣺���ܸ�д����C++���������﷨��ͬ���������ǲ�ͬ��
//	  ���𣺾�̬��ʼ����[]�в��������ֶ��������С���Ҿ�̬��ʼ��Ҳ���ڶ��������ռ�





public class _01_Array {
	public static void main(String[] args) {
	
		// ��̬��ʼ������
		int[] arr1 = {1, 2, 3, 4, 5, 6, 7}; // java�������ڶ���

		// arr1.length��ʾ����ĳ���(Ԫ�ظ���)
		System.out.println(arr1.length);

		// ͨ���±��ȡ����Ԫ��
		for(int i = 0; i < arr1.length; i++){
			System.out.print(arr1[i] + " ");
		}
		System.out.println();



		// ����Ԫ�ص�ֵĬ����0
		int arr[] = new int[4];
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");// 0 0 0 0
		}

		System.out.println(arr[4]);// �±�Խ����ʣ����쳣
	}
}





// ��Ŀ���ڶ�����������100��[0,100]�������������
class _01_Test {
	public static void main(String[] args) {
		Random rand = new Random();

		// �ڶ��������˰���100��Ԫ�ص�int����
		int[] arr = new int[100];

		for(int i = 0; i < arr.length; i++){// ���������
			arr[i] = rand.nextInt(101);
		}

		for(int i = 0; i < arr.length; i++){// ��ӡ���
			System.out.print(arr[i] + "\t");
			if((i + 1) % 10 == 0){
				System.out.println();
			}
		}
	}
}





// ��Ŀ���������飬���26����д��ĸ
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






// ��Ŀ����������100��[-99, 99]�����������ҳ�����������С���������±�
class _01_Test3 {
	public static void main(String[] args) {
		Random rand = new Random();

		int arr[] = new int[100];
		for(int i = 0; i < arr.length; i++) {// �������������
			// -99��99һ��199������; [0,198]-99=[-99,99]
			arr[i] = rand.nextInt(199) - 99;
		}

		int maxNum = arr[0], minNum = arr[0];
		int maxIndex = 0, minIndex = 0;
		System.out.println("�����������£�");
		for(int i = 0; i < arr.length; i++) {
			// ��ȡ�����Сֵ�����±�
			if(maxNum < arr[i]){
				maxNum = arr[i];
				maxIndex = i;
			}
			if(minNum > arr[i]){
				minNum = arr[i];
				minIndex = i;
			}


			// ��ӡ�����
			if(arr[i] > 0){
				System.out.print(" ");
			}
			System.out.print(arr[i] + "\t");
			if((i + 1) % 10 == 0){
				System.out.println();
			}
		}

		System.out.println("���ֵΪ��" + maxNum + "���±��ǣ�" + maxIndex);
		System.out.println("��СֵΪ��" + minNum + "���±��ǣ�" + minIndex);
	}
}
