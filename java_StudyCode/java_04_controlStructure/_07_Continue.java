// continue���

import java.util.*;



// continue���
// 
// �﷨��continue;
// 		continue ��ǩ;
// 		
// ���ܣ����ڽ�������ѭ����������ִ����һ��ѭ��
// ע�⣺1.continue����ڶ��Ƕ���У�����ͨ����ǩָ�������Ĳ�ѭ��
// 		  continue��ǩ��break��ǩʹ�÷�ʽ��ͬ





public class _07_Continue {
	public static void main(String[] args) {

		for(int i = 1; i < 10; i ++){
			if(i >= 3 && i <= 6){
				continue;
			}
			System.out.print(i + " ");// 1 2 7 8 9
		}
	}
}





class _07_ContinueLable {
	public static void main(String[] args) {
		lable1:
		for(int i = 0; i < 3; i++){
			lable2:
			for(int j = 0; j < 10; j++){
				if(j == 2) {
					continue lable1;// ֱ���������ѭ��
				}
				System.out.print(i + "," + j + "  ");// 0,0  0,1  1,0  1,1  2,0  2,1
			}
		}
	}
}