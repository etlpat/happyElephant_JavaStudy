// �ַ����ͻ����������͵�ת��



// (1)������������ת��Ϊ�ַ���
// �﷨�� ���� + ""
// ԭ���� + ��һ�����ַ�������������ƴ��Ϊһ���ַ�����
// e.g. String s = 123 + "";



// (2)�ַ���ת��Ϊ������������
// �﷨��ͨ���������͵İ�װ�����parseXX��������
// 	 parseXX�������������ַ���������XX���͵Ķ�Ӧ����
//   parse��v. ������ת��
// 
// ���磺
// 		int a = Integer.parseInt("123");
// 		double d = Double.parseDouble("123.0");
// 		boolean b = Boolean.parseBoolean("true");
// 		
// ע�⣺
//  1.�ַ�������תΪ�ַ������ݣ�char�޶�Ӧ��parse������
//  2.int��Ӧ������Integer��char��Ӧ����Character,�������඼�ǽ���Ӧ���͵�����ĸ��д����
// 	3.parseXX����Ҫ��֤����String��ת����Ч���ݣ������׳��쳣���쳣�����벻��������ʱ����





public class _10_StringAndBasicType{
	public static void main(String[] args){

		// (1)������������ -> �ַ���
		int i = 100;
		double d = 11.45;
		boolean b = true;
		String s1 = i + "";// �üӺŽ�������մ�ƴ��Ϊ�ַ���
		String s2 = d + "";
		String s3 = b + "";
		System.out.println(s1 + "\n" + s2 + "\n" + s3);



		System.out.println("----------------------");
		// (2)�ַ��� -> ������������
		// �����������Ͷ�Ӧ�İ�װ���У����������ַ���ת��Ϊ��Ӧ���͵�parseXXX����

		byte num1 = Byte.parseByte(s1);
		short num2 = Short.parseShort(s1);
		int num3 = Integer.parseInt(s1);
		long num4 = Long.parseLong(s1);
		Float num5 = Float.parseFloat(s2);
		double num6 = Double.parseDouble(s2);
		boolean b1 = Boolean.parseBoolean(s3);

		System.out.println(num3);// 100
		System.out.println(num6);// 11.45
		System.out.println(b1);// true
	}
}
