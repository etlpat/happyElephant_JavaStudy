// Recursion�� �ݹ�



// �����ĵݹ�
// 
// �ݹ����Ҫ�أ�
// 	1.��ȷ���������ã�����ȷ�ݹ鷽���Ĺ��ܺ�Ŀ��
// 	2.�ݹ�Ľ���������ÿ�εݹ�������˳��ݹ�������ƽ�����������޵ݹ飬Ȼ��StackOverflow
// 	3.�����ȼ۹�ϵ���ڵݹ��У�ͨ���ȼ۹�ϵ����С����Ĺ�ģ 
// 
// 
// �ݹ�ʱ���ڴ沼�֣�
// 	1.������ÿ�εݹ飬������ջ��ѹ��һ�������ջ�ռ䣬���ÿ�εݹ鷽���ı�����������
// 	2.ֱ���ݹ���������Է�����ջ���ᱻ������Ȼ�󽫽�����ظ�������
//	3.��ˣ��ݹ���õ�����ܵ�ջ�ռ�����ƣ�����ݹ�������࣬ջ�����





class _03_RecursionTools {
	public void printInt(int num) {// �ݹ��ӡ����
		if(num > 0){
			printInt(num / 10);
			System.out.print(num % 10);
		} else if(num < 0) {
			System.out.print("-");
			printInt(-num);
		}
	}

	public int factorial(int num) {// �ݹ���׳�
		if(num > 1){
			return num * factorial(num - 1);
		} else if(num == 1 || num == 0) {
			return 1;
		} else {
			return -1;
		}
	}

	// �������n��쳲�������
	// 1, 1, 2, 3, 5, 8, 13...
	// ˼·����n��쳲���������f(n) = f(n-1) + f(n-1)���� f(1) = f(2) = 1
	public int fibonacci(int n) {// ��n��쳲�����
		if(n <= 0) {
			return -1;
		} else if(n == 1 || n == 2) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	// �������ӳ���
	// ��һ�����ӣ�����ÿ���һ�룬�����һ��������n��(��û��)��ֻʣ1�����ӡ�������ж��ٸ����ӣ�
	// ˼·���ܹ�n��Ե�����f(n) = ����Ե����� + ʣ��n-1��Ե�����f(n-1)������Ե�����f(n-1)+2
	// 		(�����һ�룬�����һ�����Եı�ʣ�Ķ�2���� ��10������5+1=6����ʣ��4�����Ա�ʣ��2��)
	// 	    �����һ�죬����ֻʣһ����f(1) = 1
	public int monkeyEatPeach(int n) {// n���ܹ��Ե�������
		if(n <= 0){
			return -1;
		} else if (n == 1){
			return 1;
		} else {
			return 2 * monkeyEatPeach(n - 1) + 2;
		}
	}
}


public class _04_Recursion {
	public static void main(String[] args) {
		_03_RecursionTools tool = new _03_RecursionTools();

		// ��ӡ����
		int n1 = 114514;
		int n2 = -1919810;
		tool.printInt(n1);// 114514
		System.out.println();
		tool.printInt(n2);// -1919810
		System.out.println();


		// ��׳�
		int n3 = tool.factorial(5);
		System.out.println(n3);// 120
		int n4 = tool.factorial(0);
		System.out.println(n4);// 1
		int n5 = tool.factorial(-5);
		System.out.println(n5);// -1


		// ��쳲�������
		for(int i = 1; i <= 10; i++){
			System.out.print(tool.fibonacci(i) + " ");// 1 1 2 3 5 8 13 21 34 55
		}
		System.out.println();


		// ���ӳ���
		int day = 10;
		int peach = tool.monkeyEatPeach(day);
		if(peach != -1) {
			System.out.println("���� " + day + " ��һ������ " + peach + " ������");// 1534
		}
	}
}