// while ѭ��

import java.util.*;



// whileѭ��
// 
// 
// �﷨��
// 	while(�����ж�) {
// 		�����;
// 	}
// 
// 
// 
// ע�⣺
// 	1.while�����ж���䣬����ֵ������boolean����
// 	2.ѭ����Ƕ�ף���ò�Ҫ����3�㣬����ɶ��Բ�





public class _04_While {
	public static void main(String[] args) {
		
		int i = 0;
		while(i < 10) {
			System.out.print(i + " ");
			i++;
		}
	}
}





// ��ϰ������1-100������ܱ�3��������
class _04_Test {
	public static void main(String[] args) {
		// ���˼�룺����Ϊ���������
		int start = 1;
		int end = 100;
		int num = 3;// ����ĿҪ�������ı�������Ӧ�Բ�ͬ����Ŀ

		int i = start;
		while(i <= end){
			if(i % num == 0){
				System.out.print(i + " ");
			}
			i++;
		}
	}
}