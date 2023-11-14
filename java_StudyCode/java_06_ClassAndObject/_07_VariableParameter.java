// variable parameter���ɱ����


// (����)�ɱ����
// 
// �﷨��
// 	1.���壺
//		�������η� �������� ������(��������... ������){
//			�����;
//		}
// 
// 	2.���ã� ������.������(����1, ����2,..., ����n);
// 
// 		
// �ɱ����ϸ�ڣ�
// 	�βΣ���ʽ�̶����� (double... arr)
// 	ʵ�Σ����Դ���0����������ͬ���͵ı�������ֱ�Ӵ�������
// 	���ʣ��ɱ�������ʾ�������
// 		  �ڷ�������ʱջ�д���һ�����飬ָ������ռ䣬���ʵ���б��еı���
//
//
// ע�⣺
// 	1.�ɱ�������Ժ���ͨ���Ͳ���һ������β��б������뱣֤�ɱ���������
// 	2.һ���β��б�ֻ�ܳ���һ���ɱ����

 	



class _07_MyTools {

	// �ɱ����
	double add(double... arr){// ���������ʵ�Σ���ŵ�������
		double sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
		}
		return sum;
	}

	// �ɱ����������ڲ����б�ĩβ(��ֻ����һ��)
	void func(String str, int... arr){
		System.out.print(str + ": ");
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}


public class _07_VariableParameter {
	public static void main(String[] args) {
		_07_MyTools tool = new _07_MyTools();
	
		// 1.�ɱ�������
		System.out.println(tool.add(1, 2, 3, 4, 5));// 15.0
		System.out.println(tool.add(1.1, 2.2, 3.3));// 6.6

		// �ɱ�������Դ���0������
		System.out.println(tool.add());// 0.0

		// �ɱ��������ֱ�Ӵ�������
		double[] arr = {1, 2, 3};
		System.out.println(tool.add(arr));// 6.0
		

		// �ɱ������������б�ĩβ
		tool.func("hello", 1, 2, 3);// hello: 1 2 3

	}
}





// ����:дһ��������ӡѧ����Ϣ,����������n�ſε��ܷ�

class _07_StudentInfo {
	// ����������n�ſε��ܷ�
	public String getTotalScore(String name, double... score){
		double totalScore = 0;
		for(int i = 0; i < score.length; i++){
			totalScore += score[i];
		}
		return name + " " + score.length + "�Ƶ��ܷ�Ϊ: " + totalScore;
	}
}

class _07_Test1 {
	public static void main(String[] args) {
		_07_StudentInfo stu = new _07_StudentInfo();
		
		String s1 = stu.getTotalScore("����", 91, 87, 73.5);// �ɱ����
		String s2 = stu.getTotalScore("����", 67.5, 88);
		String s3 = stu.getTotalScore("����", 100, 20, 50, 99);

		System.out.println(s1 + "\n" + s2 + "\n" + s3);
		// ���� 3�Ƶ��ܷ�Ϊ: 251.5
		// ���� 2�Ƶ��ܷ�Ϊ: 155.5
		// ���� 4�Ƶ��ܷ�Ϊ: 269.0
	}
}