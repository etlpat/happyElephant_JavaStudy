
// �ַ���charϸ�ڣ�
// 1.��С��2�ֽڣ����Դ�ŵ����ַ�(��������)���ַ��õ�����' '����
//
// 2.char�������ڴ��д洢����һ��������������ǡ�unicode�롿��Ӧ���ַ�
//   	C�����У�char��ASCII�룬ֻռ1�ֽڣ�java�е�unicode��������֣���С2�ֽ�
//	ע�⣺'0'=48��'A'=65��'a'=97
// 
// 3.���԰�char������������
//   �����'a'+10=107�������Ǽӷ����㣬'a'��ת��Ϊ97��+10��Ϊ107
//
//
//
// �����֪ʶ���䣺
// ASCII��	ռ1�ֽڣ�һ��128���ַ���ֻ�з��š���ĸ
// Unicode��	��ĸ�ͺ���ͳһռ2�ֽڡ�����ASCII���������й������֣�ȱ���˷ѿռ�
// utf-8��	��С�ɱ䣬��ĸռ1�ֽڣ�����3�ֽڡ���������ʹ����㷺��һ��Unicode��ʵ�ַ�ʽ
// gbk��		��ĸռ1�ֽڣ�����2�ֽ�





public class _06_Char{
	public static void main(String[] args){
		char a = 'a';
		char b = '\n';
		char c = '��';
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);



		char ch1 = 97;// ���ֱ�ʾunicode��
		char ch2 = 'a';
		char ch3 = 33333;
		System.out.println(ch1);// a
		System.out.println((int)ch2);// 97
		System.out.println(ch3);// ��


		// �ַ����Խ�����������
		char ch4 = 'a' + 1;
		System.out.println(ch4);// b ��ch4���ַ��ͣ����b��
		System.out.println('a' + 1);// 98 ��'a'�ڼӷ�������ת��Ϊ���ͣ�

		System.out.println('��' + 'Ů');// 52906 ���ַ�+�ַ� ����������ַ�����
		// ������ʱ�ַ���������������������Ϊ����int�ͣ����������ӽ��
	}
}