import java.util.*;


// ��Ŀ1����ӡ���Ľ�����
// 
// 	*	    	  	    *			    *
// 	***	   			   ***			   * *
// 	*****	  =>	  *****     =>	  *   *
// 	*******	 		 *******		 *	   *
// 	*********		*********		*********
// 	  ��1��			  ��2��			   (3)
// 	
// ���������ܸ߶�ΪN���������ڸ߶�Ϊn(���ϵ���)
// 		��(2)�У���n����(2*n-1)��'*'���׸�'*'������ʼλ��(N-n)
// 		��(3)�У�ֻ����ĩ��'*'��������' '

public class _08_ControlStructureExercise {
	public static void main(String[] args) {
		int height = 24;// ������
		char ch = '*';// ���ͼ�ε��ַ�

		for(int i = 1; i <= height; i++){// �ܹ���ӡheight�У�ÿ��ѭ����ӡһ��

			for(int k = 1; k <= height - i; k++) {// ��ӡÿ��ǰ�Ŀ�λ
				System.out.print(' ');
			}

			for(int j = 1; j <= 2*i-1; j++) {// ��ӡÿ�е�ͼ��
				if(j == 1 || j == 2*i-1 || i == height) {// ������ĩλ�û�����У���ӡ'*'�������ӡ' '
					System.out.print(ch);
				} 
				else {
					System.out.print(' ');
				}
			}

			System.out.println();// ����
		}
	}
}








// ���⣺��ʼ��100000��
// 	��>50000��ʱ��ÿ����5%��<=50000�飬ÿ����1000
// 	��һ�������ռ���Ǯ��

class _08_Exercise2 {
	public static void main(String[] args) {
		double x = 100000;
		int num = 0;
		while(x > 0){
			if(x > 50000){
				x *= 0.95;
			} else if(x >= 1000) {
				x -= 1000;
			} else {
				break;
			}
			num++;
			System.out.println(num + ": " + x);
		}

		System.out.println("����" + num + "��");// 62
	}
}








// ���⣺�ж�һ����λ���Ƿ���ˮ�ɻ���
// 	�磺1*1*1 + 3*3*3 + 5*5*5 = 153
// 	
// ���䣺Math.pow()����η���
// �﷨��double pow(double a, double b); a��ʾ������b��ʾ����

class _08_Exercise3 {
	public static void main(String[] args) {
		for(int num = 100; num < 1000; num++){
			if(num == Math.pow(num%10, 3) // ��ʾnum%10�����η�
					+ Math.pow(num/10%10, 3) 
					+ Math.pow(num/100, 3)){
				System.out.print(num + " ");// 153 370 371 407
			}
		}
	}
}








// ���⣺1.��� 1 - 1/2 + 1/3 - 1/4 +...- 1/100
// 		2.��� 1 + (1+2) + (1+2+3) +...+ (1+...+100)

class _08_Exercise4 {
	public static void main(String[] args) {
		double sum1 = 0;
		int sum2 = 0, tmp = 0;

		for(int i = 1; i <= 100; i++){
			// pow����double�����Բ���ǿת
			sum1 += Math.pow(-1, i-1) / i;// ����1

			tmp += i;// ����2��
			sum2 += tmp;
		}

		System.out.println("sum1:" + sum1);// 0.688172179310195
		System.out.println("sum2:" + sum2);// 171700
	}
}