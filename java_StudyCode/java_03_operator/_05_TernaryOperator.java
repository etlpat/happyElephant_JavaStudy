// ternary operator�� ��Ŀ�����



// ��Ŀ�������
// �﷨�� ���ʽ1 ? ���ʽ2 : ���ʽ3;
// ���ã������ʽ1Ϊtrue����ִ�в����ر��ʽ2������ִ�в����ر��ʽ3
//
// ע�����
// 	a ? b : c; �൱�� if(a){res=b;} else{res=c;}
// 	���	1.��ִ��b���Ͳ���ִ��c����ִ��c���Ͳ���ִ��b
//		2.b��c�����ǿɷ��ص����


public class _05_TernaryOperator {
	public static void main(String[] args) {

		int a = 100, b = 1, c = 50, max;

		// �����ֵ
		int maxTwo = b > c ? b : c;
		int maxThree1 = a > b ? (a > c ? a : c) : (b > c ? b : c); // ��Ŀ�������Ƕ��
		int maxThree2 = (max = a > b ? a : b) > c ? max : c;
		
		System.out.println(maxTwo);// 50
		System.out.println(maxThree1);// 100
		System.out.println(maxThree2);// 100
	}
}