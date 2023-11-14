// pass parameter������

import java.util.*;



// ��Ա��������
// 
// (1)�����������͵Ĵ��Ρ�ֵ���ݡ�
// 
// 	���ۣ����ڻ����������ͣ�����ʱ���е���ֵ���ݣ��βεĸı䲻Ӱ��ʵ��
// 	ֵ���ݣ��β���ʵ�ε���ʱ����
// 	ԭ���βκ�ʵ�������������ջ�ռ��У���ʱջ���βε��޸Ĳ���Ӱ��mainջ�е�ʵ��
// 	
// 	ֵ���ݵ��ڴ沼�֣�
// 		1.���÷���ʱ��������һ���������ʱջ�ռ䡣�β��ڸ���ʱջ�У��βε�ֵ������ʵ�ε�ֵ
// 		2.����ִ��ʱ������ʱջ�е��β�ֵ�����޸ģ���mainջ�е�ʵ���޹�
// 		3.������ִ�н������β�������ʱջһͬ������
//
//
//
//
// (2)�����������͵Ĵ��Ρ�(��ַ)���ô��ݡ�
// 
// 	���ۣ��������ʹ��ݵ��ǵ�ַ������ͨ���β�Ӱ��ʵ��
// 	���ô��ݣ��β���ʵ�ε�����(����)������ָ��ͬһ���ڴ�ռ�
// 	
// 	���ô��ݵ��ڴ沼�֣�
// 		1.���÷���ʱ������һ����ʱ��ջ�ռ䡣�β��ڸ���ʱջ�У��β���ʵ�ε����á�
// 		  (�β�����ʱջ�У�ʵ����mainջ�У��������ô����ǵ�ַ���ݣ�����ָ��ͬһ����)
// 		2.�����βκ�ʵ��ָ��ͬһ��ռ䣬�ڷ������޸��βε����ݣ�ʵ�ε�����ͬʱ�ı�
// 		3.����ִ�н������β�������ʱջһͬ������
// 		
// 						
// �����֡���p1��p2��Person������ñ�����
// 	1.Ϊp1ָ��Ŀռ丳ֵ��p1.age = 10; 
// 	  ͨ�����ñ���p1��Ϊ��ָ��Ŀռ��age���Ը�ֵ
// 	2.Ϊp1����ֵ��p1 = p2; 
//    ��p2�д�ŵĵ�ַ����p1��p1ָ��Ŀռ�ı䣬���ǲ�Ӱ��p1ԭ��ָ��Ŀռ�






class _03_Swap {
	public void swap1(int a, int b){// �������ʹ���(ֵ����)
		int tmp = a;
		a = b;
		b = tmp;
	}

	public void swap2(int[] a, int[] b){// �������ʹ���(��ַ����)
		for(int i = 0; i < a.length; i++){
			int tmp = a[i];
			a[i] = b[i];
			b[i] = tmp;
		}
	}
}


public class _03_PassParameter {
	public static void main(String[] args) {
		
		_03_Swap s = new _03_Swap();

		// �����������͵Ĵ��� -- ֵ����
		int a = 10, b = 20;
		System.out.println(a + ", " + b);// 10, 20
		s.swap1(a, b);
		System.out.println(a + ", " + b);// 10, 20

		// �����������͵Ĵ��� -- ���ô���
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {4, 5, 6};
		printArr(arr1);// 1 2 3
		printArr(arr2);// 4 5 6
		s.swap2(arr1, arr2);
		printArr(arr1);// 4 5 6
		printArr(arr2);// 1 2 3

	}

	public static void printArr(int[] arr){// ��ӡһά���鷽��
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}








// ��ϰ1��ִ�����·�������ӡ���ʲô��
class _03_Person {
	String name;
	int age;
}

class _03_A {
	public void func(_03_Person p){
		p.name = "jack";// Ϊpָ��Ŀռ丳ֵ
		p = null;// Ϊp����ֵ
	}
}

class _03_Test1 {
	public static void main(String[] args) {
		_03_A a = new _03_A();
		_03_Person p1 = new _03_Person();
		p1.name = "bob";
		p1.age = 10;
		a.func(p1);
		// ����ִ�����̣�
		// 	1.func����������ʱջ�ռ䣬��ŵ����ñ���p��p��p1�����ͬ�ĵ�ַ
		// 	2.ͨ��p��p1ָ��Ķ�������name��Ϊjack
		//	3.��p��Ϊnull���Ƕ����ñ���p����ֵ����Ӱ����������p1ָ��Ŀռ�
		System.out.println(p1.name);// jack
		System.out.println(p1.age);// 10

	}
}








// ��ϰ2����дһ��copyPerson���������Ը���һ��_03_Person���󣬷��ظ��ƵĶ���
//		  Ҫ��õ����¶����ԭ���������������Ķ���ֻ��������ͬ 
class _03_Copy {
	public _03_Person copyPerson(_03_Person p1) {
		_03_Person p2 = new _03_Person();// ���
		p2.name = p1.name;
		p2.age = p1.age;
		return p2;
	}
}

class _03_Test2 {
	public static void main(String[] args) {
		_03_Person p1 = new _03_Person();// �����˶���p1
		p1.name = "����";
		p1.age = 18;

		_03_Copy cp = new _03_Copy();// ��������������
		_03_Person p2 = cp.copyPerson(p1);// ��p1���п����������p2��

		System.out.println(p2.name);// ����
		System.out.println(p2.age);// 18
		System.out.println(p1);// _03_Person@15db9742 (��� hashCode)
		System.out.println(p2);// _03_Person@6d06d69c
	}
}