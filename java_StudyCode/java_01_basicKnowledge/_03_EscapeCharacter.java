//escape character: ת���ַ�

//����ת���ַ���
// \t��ˮƽ�Ʊ��
// \n�����з�
// \\��һ��\   ��\��Ĭ������ת���ַ�����ʼ��־���Զ�����һ���ַ���ϣ�
// \"��һ��"
// \'��һ��'
// \r�� �س�
// 
// 
// ע�⣺�س�!=����
//      �س���������ʹ���ص����е���ʼλ�ã�֮�������ָ��Ǿ�����



public class _03_EscapeCharacter{
	public static void main(String[] args){
		System.out.println("1\t2\t3");
		System.out.println("1\n2\n3");
		System.out.println("1\\2\\3");
		System.out.println("1\"2\"3");
		System.out.println("1\'2\'3");
		System.out.println("1234\r56");// 5634���س����ù��ص��������λ�ã������ָ��Ǿ�����
	}
}