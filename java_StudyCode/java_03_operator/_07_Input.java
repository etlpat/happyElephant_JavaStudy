import java.util.Scanner;
// ��util���е���Scanner��



// �Ӽ����������
// Java����������䣬��Ҫһ��Scanner(ɨ����)��Ķ���
// 
// ���裺
// 1.����Scanner�����ڵİ�(util)
// 2.����Scanner��Ķ���
// 3.ʹ�øö����next���������û��������Ϣ
// 
// 
// 
// Scanner�ࣺ
// 1.����
// 	 import java.util.Scanner;
//   ��util���е���Scanner��
// 
// 2.��������
// 	 �﷨��Scanner sc = new Scanner(System.in)
// 	 ������һ��Scanner��Ķ���sc���ܹ���System.in�ж�ȡ����
// 	 System.in����ʾ�Ӽ�������
// 	 
// 3.next()����
// 	 �﷨��String str = sc.next();
// 	 ���ܣ���ȡ�����شӼ���������ַ���
// 	 
// 4.nextInt()�ȷ���
// 	 �﷨��int a = sc.nextInt();
// 	 ���ܣ���ȡ�����شӼ��������intֵ���Ƿ�������׳��쳣
// 
// ͬ��Ҳ����nextBoolean()��nextByte()��nextShort()��nextLong()��nextFloat()��nextDouble()
// ʹ�÷�����nextInt()һ�� 





public class _07_Input{
	public static void main(String[] args){

		// ����Scanner���󣬴�System.in��������
		Scanner sc = new Scanner(System.in);


		System.out.print("�������û�������");
		String name = sc.next();// ����Ļ���ղ�����String����

		System.out.print("�������û����䣺");
		int age = sc.nextInt();// ����Ļ���ղ�����int����

		System.out.print("�������û�������");
		double score = sc.nextDouble();// ����Ļ���ղ�����Double����

		System.out.println("\n��Ϣ���£�");
		System.out.println("������" + name + "\t���䣺" + age + "\t������" + score);
	}
}