// ��֧�ṹ��if else

import java.util.*;



// �﷨��
// 
//	if(�������ʽ1) {
//		�����1;
//	}
//	else if(�������ʽ2) {
//		�����2;
//	}
//	...
//	else {
//		�����n;
//	}
//	
//
// ע�⣺
// 	1.java�У�if�������ж���䣬�����ֻ����boolean���͡�
// 	2.�������ֻ��һ����䣬����ʡ��{}�����ǲ�����ʡ��
// 	3.if��֧��Ƕ�ף�ʵ����Ŀ����ò�Ҫ����4�㣬����ɶ��Բ�





public class _01_IfElse {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);// ����ɨ�������󣬽���System.in
		System.out.print("���������䣺");
		int age = sc.nextInt();// ���ղ�����һ������


		if(age >= 0 && age <= 18) {
			System.out.println("����δ����");
		}
		else if(age > 18 && age <= 130) {
			System.out.println("��������");
		}
		else {
			System.out.println("�������ݷǷ�");
		}

	}
}




// e.g.�ж�year�Ƿ�������(1.�ܱ�4�����������ܱ�100���� 2.�ܱ�400����)
class _01_Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("��������ݣ�");
		int year = sc.nextInt();

		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
			System.out.println(year + "�� ������");
		}
		else{
			System.out.println(year + "�� ��������");
		}
	}
}




// e.g.ifǶ����Ŀ
// �μӱ��������ɼ����ڵ���8.0�Ľ������������Ա���ʾ�����������Ů����
class _01_Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ɼ�(0~10.0)��");
		double score = sc.nextDouble();

		if(score >= 8.0 && score <= 10.0) {
			System.out.print("�������Ա�");
			char sex = sc.next().charAt(0);// �ַ���.charAt(�±�)��String��ĳ�Ա����������String��ָ���±��char
		
			if(sex == '��') {// �����ǽ�char����ֵ���бȽ�
				System.out.println("��ϲ������������������ :-)");
			} else if(sex == 'Ů') {
				System.out.println("��ϲ������������Ů���� :-)");
			} else {
				System.out.println("�Ա���������");
			}
		} 
		else if(score >= 0 && score < 8.0) {
			System.out.println("��Ǹ����δ���� :-(");
		} 
		else {
			System.out.println("�ɼ���������");
		}
	}
}

