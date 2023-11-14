// Logical operator�� �߼������
// Bit operator��λ�����



// (1)�߼��������
// �������Ӷ������ֵΪboolean���͵ı��ʽ�����ս��Ҳ��booleanֵ
// ע�⣺java�У�λ�����Ҳ�������߼��жϣ�����û�ж�·����C++��CҲ�����ԣ�
//
//  
// &&����·��
// ||����·��
// !����
// &���߼��� 	(����·)
// |���߼��� 	(����·)
// ^���߼���� 	(����·)
// 
// 
//   
// ע�����
//  1.��·����(��·��������Ѿ�ȷ�����Ͳ���������ִ�У�Ч�ʸ�)
//  	&&��������ִ�У������Ϊfalse����ִ���ұ�
// 		||��������ִ�У������Ϊtrue����ִ���ұ�
// 	
//  3.&��|��^������������boolean���ͣ�ִ���߼��롢��������� �������ж�·��
//	 	     �����������������ͣ�ִ��λ����
// 	
// 	4.�߼�������Ĳ�����������boolean����   




// (2)λ�������
// ���������������ͣ�����ת��Ϊ�����ƽ���λ����
// 
// 
// &����λ��		��ȫ1��Ϊ1��
// |����λ�� 	����1��Ϊ1��
// ^����λ��� 	��ͬ0��1��
// 
//  
// ע�����
// 	1.λ�����ֻ����������(byte,int...)���ַ�(char)���ͣ�char����Ӧ�ı������λ����
// 	2.��λ�����&��|��^�Ĳ�������boolean���ͣ�ִ���߼����㣨����·��	






public class _03_LogicalAndBitOperator{
	public static void main(String[] args) {
	
		// (1)�߼������
		int a = 10, b = 20;
		//System.out.println(a && b);// �����߼������������ֻ��Ϊboolean����
		//System.out.println(!a);// ����

		// �룺&&��&
		System.out.println(a > 100 && ++a > 0);// false
		System.out.println(a);// 10�� &&��·
		System.out.println(a > 100 & ++a > 0);// false
		System.out.println(a);// 11�� &����·

		// ��||��|
		System.out.println(b < 100 || --b > 30);// true
		System.out.println(b);// 20�� ||��·
		System.out.println(b < 100 | --b > 30);// true
		System.out.println(b);// 19�� |����·

		// �ǣ�!
		System.out.println(!false);// true

		// ���^
		System.out.println(true ^ false);// true
		System.out.println(true ^ true);// false
		System.out.println("-----------------");




		// (2)λ�����
		//System.out.println(1.111 ^ 1.111);// ���������������Ǹ�����
		System.out.println('A' ^ 'B');// 3����char�Զ�ת��Ϊint��������
		
		int num1 = 5; // 0101
		int num2 = 12;// 1100 
		System.out.println(num1 & num2);// 0100��4
		System.out.println(num1 | num2);// 1101��13
		System.out.println(num1 ^ num2);// 1001��9
	}
}






// ��ϰ��
class _03_Test{
	public static void main(String[] args) {
		// ��ϰ1
		int x1 = 5, y1 = 5;
		if(x1++ == 6 & ++y1 == 6)
			x1 = 11;
		System.out.println(x1 + ", " + y1);// 6, 6

		// ��ϰ2
		int x2 = 5, y2 = 5;
		if(x2++ == 6 && ++y2 == 6)
			x2 = 11;
		System.out.println(x2 + ", " + y2);// 6, 5

		// ��ϰ3
		int x3 = 5, y3 = 5;
		if(x3++ == 5 | ++y3 == 5)
			x3 = 11;
		System.out.println(x3 + ", " + y3);// 11, 6

		// ��ϰ4
		int x4 = 5, y4 = 5;
		if(x4++ == 5 || ++y4 == 5)
			x4 = 11;
		System.out.println(x4 + ", " + y4);// 11, 5


		// ��ϰ5
		boolean x = true, y = false;
		short z = 46;
		if((z++ == 46) && (y = true)) z++;
		if((x = false) || (++z == 49)) z++;
		System.out.println(x);// false
		System.out.println(y);// true
		System.out.println(z);// 50
		// ע�⿴�� = �� ==���Լ���·����
	}
}
