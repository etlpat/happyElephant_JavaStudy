// member method�� ��Ա����

import java.util.*;



// ��Ա����
// 
// (1)��������
// �﷨��
// 	class XX�� {
// 		...
// 		�������η� �������� ������(�β��б�) {
// 			�����;
// 			return ����ֵ;
// 		}
// 		...
// 	}
// 	
// 	
// (2)��������
// �﷨��������.������(ʵ���б�);
// 	
// 	
// 	
// (3)����ִ��ʱ���ڴ沼�֡��ص㡿
// 	1.������ִ�е������������ʱ���ͻῪ��һ�顾��������ʱջ�ռ䡿
// 	2.�÷������βο������Լ��ڸ÷����ڴ����ı�����������������ʱջ�ռ���
// 	3.������ִ�н����������ʱջ�ռ�ᱻ�ͷ�(����)
//
// 
// 
// ע�����
// 	1.������������ѭС�շ�������(getValue)��Ҫ����֪��
// 	  
// 	2.��������Ƕ�׶���
// 
//	3.���ַ������η� [public,protected,privated,Ĭ��]
//	  
//	4.����ֵ��java����ֻ����һ������ֵ�������ǻ������ͻ���������
//	  ����ֵ�����뷵������һ�»����(�����Զ�ת��Ϊ��������)
//
//	5.�βΣ�������0�������������ǻ������ͻ���������
//	  ʵ�α������β�����һ�»����(ʵ�ο����Զ�ת��Ϊ�β�����)
//	  �β���ʵ�ε���ʱ����
//	 
//	6.ͬһ���еķ������ã���ֱ�ӵ��á� �磺printA();// ������this.printA();
//	  ����ķ������ã�ͨ��������á� �磺������.printA(); 





class _02_Cat {
	// ����
	String name;
	int age;

	// ����
	public void speak() {
		System.out.println("������~");
	}

	public void setName(String name1) { this.name = name1; }
	public void setAge(int age1) { age = age1; }
	public String getName() { return name; }
	public int getAge() { return this.age; }
}



class _02_MyTools {
	public int add(int a, int b) {// �������
		return a + b;
	}

	public void printArr(int[] arr, String space){// ���أ���ӡһά����
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + space);
		}
		System.out.println();
	}
	public void printArr(int[][] arr, String space){// ���أ���ӡ��ά����
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j] + space);
			}
			System.out.println();
		}
	}

	public double[] getSumAndSub(double a, double b){// ����������������������
		double[] resArr = new double[2];
		resArr[0] = a + b;
		resArr[1] = a - b;
		return resArr;
	}
}



public class _02_MemberMethod {
	public static void main(String[] args) {

		// (1)è����
		_02_Cat c1 = new _02_Cat();
		
		c1.setName("С��");
		c1.setAge(6);
		System.out.println("������" + c1.getName() + "\n���䣺" + c1.getAge());
		c1.speak();	// ������~
	


		// (2)���ߵ���
		_02_MyTools tool = new _02_MyTools();

		// 1.add����
		int result = tool.add(15, 22);
		// ��ִ�����Ϸ���ʱ��������һ���������ʱջ�ռ䣬����β�a��b(ʵ�ε���ʱ����)��
		// ��������a+b��ֵ����ʱջ�ռ䱻����
		System.out.println(result);// 37


		// 2.��ӡ��������ط���
		int[] arr1 = {1, 2, 3, 4, 5};
		int[][] arr2 = {{1, 2, 3}, {4, 5}, {6}};
		tool.printArr(arr1, " ");// ����1����ӡһά����
		tool.printArr(arr2, "|");// ����2����ӡ��ά����


		// 3.��������������ķ���
		double[] res = tool.getSumAndSub(3.14, 2);
		// �����������ڶ��������������󲻻�����
		System.out.println(res[0]);// 5.140000000000001
		System.out.println(res[1]);// 1.1400000000000001

	}
}








// ���⣺����ͼ���࣬�����С��С��ַ�����ӡ����
class _02_Picture {
	public void printMatrix(int row, int col, char ch) {
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				System.out.print(ch + " ");
			}
			System.out.println();
		}
	}
}

class _02_Test {
	public static void main(String[] args) {
		_02_Picture p = new _02_Picture();
		p.printMatrix(20, 30, '*');
	}
}