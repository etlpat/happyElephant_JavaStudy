// Force type conversion�� ǿ������ת��


// ǿ������ת����
// ���Զ�����ת��������̣������������������ǿ��ת��Ϊ����С������
// �﷨�� (����)����
// ע�⣺�Ա�������ǿ������ת��������ɾ���ȱʧ
// 
// 
// 
// ǿ������ת��ע��ϸ�ڣ�
// 
// 1.�������� С->�󣬻��Զ�����ת��
//   �������� ��->С����Ҫǿ������ת��
// 
// 2.ǿ������ת���㵥Ŀ�����������ȼ��ϸ�
// 
// 3.int��������ֱ�Ӹ���char��short�ȣ������жϷ�Χ��
//   ���뽫int��������char��short�ȣ���Ҫǿת����ת��





public class _09_ForceTypeConversion{
	public static void main(String[] args) {

		int a = (int)1.9;
		int b = 2000;
		byte c = (byte)b;
		System.out.println(a);// 1��������ʧ
		System.out.println(c);// -48���������


		//int n1 = (int)3*1.5+2;// �������ȼ�����
		int n2 = (int)(3*1.5+2);


		int in = 99;
		char ch1 = 99;// int���������Ϸ�Χ�Ϳ��Ը�ֵ
		char ch2 = (char)in;
		// char ch3 = in;// ����

	}
}