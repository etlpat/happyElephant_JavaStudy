// switch case ��֧�ṹ

import java.util.*;


// switch��֧����
// 
// �﷨��
// 	switch(���ʽ) {
// 	case ����1:
// 		���1;
// 		break;
// 	case ����2:
// 		���2;
// 		break;
// 	...
// 	default:
// 		���n;
// 		break;
// 	}
// 
// 
// ע�⣺
// 	1.switch(xxx){}�����ʽxxx�ķ���ֵ��������(byte/short/int/char/enum/String)
// 	2.case�Ӿ��е�ֵ�������ǳ���/�������ʽ
// 	3.switch���ʽ�ķ���ֵ����Ҫ��case����ͬ���ͣ����߿����Զ�ת����case������
// 	4.����Ӷ�Ӧ��case�������֧������һֱ����ִ�С���ֱ��ȫ��switch��������������break�˳�




public class _02_SwitchCase {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("���������ڼ�����");
	int day = sc.nextInt();

	switch(day) {// day���ͱ�����(byte/short/int/char/enum/String)
	case 1:
	case 2:
	case 3:// ��δ����break��switch��֧��һֱ����ִ��
	case 4:
	case 5:
		System.out.println("����" + day + "�������ǹ����գ�");
		break;
	case 6:
	case 7:
		System.out.println("����" + day + "����������Ϣ�գ�");
		break;
	default:
		System.out.println("������������");
		break;
	}
	}
}