// do..while ѭ��

import java.util.*;


// do..while ѭ��
// 
// �﷨��
// 	do{
// 		�����;
// 	}while(ѭ������);
// 
// 
// 
// ע�⣺
// 	1.do..whileѭ������ִ�У����жϡ�����ִ��һ��
// 	2.�����ж���䣬����ֵ������boolean����





public class _05_DoWhile {
	public static void main(String[] args){

		int i = 0;
		do {
			System.out.print(i + " ");
			i++;
		}while(i < 10);

	}
}




// ��ϰ����do whileʵ�֣�����������Ǯ����һֱ�޴�ֱ����ǮΪֹ
class _05_Test {
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		char select;
		do {
			System.out.println("@@##  �޴������� ##@@");
			System.out.print("������Ǯ��(Y/N)��");
			while(true){
				select = sc.next().charAt(0);
				if(select == 'Y' || select == 'y' || select == 'N' || select == 'n'){
					break;
				} else {
					System.out.print("ֻ��ѡ��Ǯ���߱޴�(Y/N)��");
				}
			}
		}while(select != 'Y' && select != 'y');
		System.out.println("�������ڻ�Ǯ��(Ц)");
	}
}