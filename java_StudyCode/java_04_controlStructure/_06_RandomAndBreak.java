// break��� �Լ� Random�����

import java.util.*;



// break���
// 
// �÷���
// 	break;			(����һ��ѭ��)
// 	break ��ǩ;		(������ǩָ�����ǲ�ѭ��)
// 	
// 	
// ��ǩ�﷨��
// 	lable1:
// 	while(true){
// 		lable2:
// 		while(true){
// 			break lable1;
// 		}
// 	}
// ���ͣ����ϣ�lable1�������ѭ����lable2�����ڲ�ѭ��
// 		break lable1; ֱ���������ѭ��
// 	
//
// ע�⣺
// 	1.break����������ѭ����switch���
//	2.break����ڶ��ѭ��Ƕ����ʱ������ͨ����ǩָ�������Ĳ�ѭ��
//	  ���������������е�goto��ʵ�ʿ����н��鲻Ҫʹ��break��ǩ





// java���������
// 
// (1):java.util���е�Random��
// �﷨��1.�������������Random rand = new Random();
// 		2.ͨ��next������ȡ�������rand.nextInt()/ rand.nextDouble()/ ...
// 		
// ���ܣ�rand.nextInt();����һ���������
//      rand.nextInt(100);����һ��[0,100)����������
// 		rand.nextDouble();����һ��[0, 1)������������
// 		
// ע�⣺1.�÷���Scanner����ͬ���ȴ�������Ȼ��ͨ��next�����������
// 		2.�������� nextInt(100)���ȼ���rand.nextInt() % 100
// 		3.java�У�Random����ȻҲ��α���������ÿ�����н����ͬ������Ҫ����ʱ���������
// 
// 
// 
// 
// (2):Math���е�random����
// �﷨��Math.random();
// ���ܣ�����[0,1)֮������double������
// 
// ע�⣺1.����Ĭ�Ͻ����[0,1)��ĸ�������ʹ��ʱһ��ת����������
// 		   	(int)(Math.random() * 100); ��ʾ[0,99)���������
// 		2.�����Math.random()�������rand.nextDouble()��������







// �ʣ��������ѭ������0��100�����֣��ڼ��������objNum��
public class _06_RandomAndBreak {
	public static void main(String[] args) {
		int objNum = 50;// Ŀ�����ɵ�����
	
		// (1)Random�����next�������������
		Random rand = new Random();// �������������
		int num1 = 0;
		int randNum1;
		while(true) {
			randNum1 = rand.nextInt(100) + 1;// ���1��100�������
			num1++;
			if( randNum1 == objNum){
				break;// break����������ѭ��������������if���
			}
		}
		System.out.println("��һ�ַ�ʽ " + num1 + " �������objNum " + randNum1);


		// (2)Math���е�random�������������
		int num2 = 0;
		int randNum2;
		while(true) {
			randNum2 = (int)(Math.random() * 100) + 1;// ���1��100�������
			num2++;
			if( randNum2 == objNum){
				break;
			}
		}
		System.out.println("�ڶ��ַ�ʽ " + num2 + " �������objNum " + randNum2);

	}
}





// ����break����ѭ��
class _06_Test1 {
	public static void main(String[] args) {
		for(int i = 1; i <= 10; i++){
			if(i == 4){
				break;
			}
			System.out.print(i + " ");// 1 2 3
		}
	}
}





// ��Ŀ����������������������˻���������3�λ��ᣬ��"����"�����������"666"������ɹ��������˻�
// 
// ֪ʶ�㲹�䣺�ַ����ȽϷ���(equals)����String��ķ���
// �﷨���ַ���1.equals(�ַ���2); 	����ֵ��boolean����
// ע�⣺д��1��stdPasswd.equals(passwd);  д��2��passwd.equals(stdPasswd);
// 		��������д�������������ǽ���д��1�������û��������passwd�ǿ�ָ�뵼�±���
//
class _06_Test2 {
	public static void main(String[] args) {
		String stdName = "����";
		String stdPasswd = "666";
		int chance = 3;// �����������
		boolean flag = false;

		Scanner sc = new Scanner(System.in);
		String passwd = "";
		String name = "";

		System.out.print("������������");
		name = sc.next();
		if(stdName.equals(name)){// ��������ȷ������������
			System.out.print("����" + chance + "�λ��ᣬ���������룺");
			for(int i = chance; i > 0; i--){// �����������
				passwd = sc.next();
				if(stdPasswd.equals(passwd)){
					System.out.println("������ȷ");
					flag = true;
					break;
				} else if(i != 1) {
					System.out.print("������󣬻���" + (i-1) + "�λ��᣺");
				} else if(i == 1) {
					System.out.println("��Ǹ��" + chance + "��������������");
				}
			}
		} else {
			System.out.println("�����������");
		}

		if(flag){
			System.out.println(name + "�����˻���");
		}
	}
}






// break ��ǩ;
class _06_BreakLable {
	public static void main(String[] args) {
		
		lable1:// ����һ����ǩ���������⣩
		for(int i = 0; i < 10; i++){
			lable2:
			for(int j = 0; j < 10; j++){
				if(j == 2){
					break lable1;// ֱ������lable1��ǩ���ڵ����ѭ��
				}
				System.out.print(i + "," + j + "  ");// 0,0  0,1
			}
			System.out.println("\nlable2ѭ������");
		}
		System.out.println("\nlable1ѭ������");// lable1ѭ������

		// ���ϴ�ӡ�������ʾbreak lable1ֱ������2��ѭ��
		// break lable1�� ����lable1��ǩ���ڵ����ѭ��
	}
}