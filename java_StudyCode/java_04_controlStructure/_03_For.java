// for ѭ��

import java.util.*;



// for ѭ��
// 
// 
// �﷨��
// 	for(���1; ���2; ���3){
// 		�����;
// 	}
// 	
// 
// 
// ע�⣺
// 	1.���1��ѭ��������ʼ��
// 	  ���2��ѭ�������ж�(���뷵��booleanֵ)
// 	  ���3��ѭ����������
// 
//	2.forѭ����ִ��˳���ǣ�
//		���1->���2->�����->���3->���2->�����->���3...
//		
//	3.java�У�for����ֱ�������1��λ�ö����±��� (��C++һ��)
//		�磺for(int i=0; i<10; i++){...}
//		ע�⣺����i��ѭ���ڲ������ľֲ���������ѭ��������
//		
//	4.forѭ���Ŀ�������У��������ö��ű��ʽ�����������
//		�磺for(int i=0, j=1; i<10; i++, j+=2){...}





public class _03_For {
	public static void main(String[] args){

		for(int i = 0; i < 1000; i++){
			System.out.print(i + 1 + "  ");
		}

		System.out.println("\n\n");


		for(int i = 0, j = 1; i < 10; i++, j += 2){
			System.out.println("i=" + i + "��j=" + j);
		}
	}
}




// ��ϰ����ӡ�žų˷���
class _03_Test {
	public static void main(String[] args){

		for(int i = 1; i < 10; i++){
			for(int j = 1; j <= i; j++){
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}
	}
}


