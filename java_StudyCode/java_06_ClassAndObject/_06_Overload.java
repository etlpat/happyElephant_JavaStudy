// overload������


// ����������
// 
// ���أ���ͬ�����ķ�����������ͬ����߸�����
// 
// ���ص�����������
// 	1.ͬһ����������(ͬһ������)
// 	2.��������������ͬ
// 	3.�β��б�(����/����)���벻ͬ
// 	4.�������ͣ���Ҫ��
// 	
// 	
// 	
// ע�����
// 	1.����Ҫ��һ��ʵ��ֻ�ܴ���Ψһһ����֮ƥ����β��б�
// 	
// 	2.�������ضԲ�������Ҫ��
// 	  �磺void func(int a){...} �� int func(int b){...}
// 	  �������������������أ������ظ�����
// 	  
//	3.�����صķ�������ʵ�κ��Ȳ���ʵ���Զ�����ת�����ж��Ƿ����β��б�ƥ��ķ���
//	  ������ƥ�䣬���Զ�ת��ʵ�Σ��ж��Ƿ����ƥ�䷽��





class _06_MyTools {
	int add(int a, int b){
		System.out.println("(int, int)");
		return a + b;
	}
	double add(int a, double b){
		System.out.println("(int, double)");
		return a + b;
	}
	// double add(double a, int b){
	// 	System.out.println("(double, int)");
	// 	return a + b;
	// }
	double add(double a, double b){
		System.out.println("(double, double)");
		return a + b;
	}


	int max(int a, int b) {
		return a > b ? a : b;
	}
	double max(double a, double b) {
		return a > b ? a : b;
	}
	double max(double a, double b, double c) {
		return a > b ? (a > c ? a : c) : (b > c ? b : c);
	}

}


public class _06_Overload {
	public static void main(String[] args) {
		_06_MyTools tool = new _06_MyTools();

		// �ӷ�����
		int num1 = tool.add(1, 2);// (int, int)
		double num2 = tool.add(1, 2.0);// (int, double)
		double num3 = tool.add(1.0, 2.0);// (double, double)
		
		// ��ʵ�����������ص��β��б���ƥ�䣬�Ž�ʵ���Զ�����ת��
		double num4 = tool.add(1.0, 2);// (double, double)
	


		// �����ֵ����
		System.out.println(tool.max(1, 2));// 2
		System.out.println(tool.max(1.1, 2.2));// 2.2		
		System.out.println(tool.max(1.2, 27, 3.1));// 27.0	
	}
}