import java.util.*;


// ����1������Ҫ��д��������
class _11_MyTools {
	// ��Ŀ����1��Ҫ����������double���͵����ֵ
	public double max(double... arr){
		double maxNum = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(maxNum < arr[i]){
				maxNum = arr[i];
			}
		}
		return maxNum;
	}

	// ������������1~n��Ԫ�ص�double����
	public double[] getRandArr(int maxSize){
		Random rand = new Random();
		double[] arr = new double[rand.nextInt(maxSize) + 1];
		for(int i = 0; i < arr.length; i++){
			arr[i] = rand.nextDouble() * 100;
		}
		return arr;
	}

	// ��������ӡdouble����
	public void printArr(double[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}

	// ��Ŀ����2�������ַ�������Ԫ�أ��������±�
	public int find(String[] arr, String str){
		for(int i = 0; i < arr.length; i++){
			if(arr[i].equals(str)){
				return i;
			}
		}
		return -1;
	}
}


public class _11_ClassAndObjectExercise {
	public static void main(String[] args) {
		_11_MyTools tool = new _11_MyTools();
		int maxSize = 20;

		// ���������Ԫ�ص�double����
		double arr[] = tool.getRandArr(maxSize);
		// ��ӡdouble����
		tool.printArr(arr);
		// �ҳ����ֵԪ��
		double d = tool.max(arr);
		System.out.println("���ֵΪ��" + d);


		// �����ַ�������Ԫ���±�
		String strArr[] = {"����", "����", "����"};
		int index = tool.find(strArr, "����");
		System.out.println(index);// 2


	}
}








// ����2������һ��Employee�࣬������(���֣��Ա����䣬ְλ��нˮ)
// Ҫ�����������췽����1.(���֣��Ա����䣬ְλ��нˮ) 2.(���֣��Ա�����) 3.(ְλ��нˮ)

class _11_Employee {
	String name;
	String sex;
	int age;
	String job;
	double salary;

	public _11_Employee(String job1, double salary1){
		this.job = job1;
		this.salary = salary1;
	}
	public _11_Employee(String name1, String sex1, int age1){
		this.name = name1;
		this.sex = sex1;
		this.age = age1;
	}
	public _11_Employee(String name1, String sex1, int age1, String job1, double salary1){
		this(name1, sex1, age1);// this���ʹ��췽��������ڿ�ͷ
		this.job = job1;
		this.salary = salary1;
	}

	public void showInfo(){
		System.out.println("������" + name);
		System.out.println("�Ա�" + sex);
		System.out.println("���䣺" + age);
		System.out.println("ְλ��" + job);
		System.out.println("нˮ��" + salary);
	}
}

class _11_Test1 {
	public static void main(String[] args) {
		_11_Employee e1 = new _11_Employee("jimmy", "��", 19, "ѧ��", 1145.14);
		e1.showInfo();
	}
}








// ����3�����һ��ʯͷ�������࣬���Ժ͵������ȭ
// 
// ˼·��
// �����ǣ�ʯͷ>������ ����>���� ��>ʯͷ
// ������(ʯͷ=2  ����=1  ��=0)
// ��(ʯͷ+1)%3==���� (����+1)%3==ʯͷ�� (��+1)%3==������ʵ����ѭ��
// 

class _11_RockPaperScissors {
	// ��������ӡ�˵�
	public void menu(){
		System.out.println("**************************");
		System.out.println("*****  ʯͷ ���� ��  *****");
		System.out.println("**************************");
		System.out.println("*****   ʯͷ -- 2    *****");
		System.out.println("*****   ���� -- 1    *****");
		System.out.println("*****     �� -- 0    *****");
		System.out.println("**************************");
	}

	// ����������һ��ʯͷ������
	// ������ i:��i�β�ȭ		sc:Scanner����
	// ����ֵ��0��ʾƽ�֣�1��ʾ���ʤ��-1��ʾ����ʤ
	public int judge(int i, Scanner sc){
		String[] arr = {"�� ", "����", "ʯͷ"};

		// 1.���Բ�ȭ(����0��1��2)
		Random rand = new Random();
		int computer = rand.nextInt(3);
		// 2.��Ҳ�ȭ(����Ļ����)
		int player = -1;
		System.out.print("��" + i +"�Σ����ȭ��");
		while(true){
			player = sc.nextInt();
			if(player==0 || player==1 || player==2){
				break;
			} else{
				System.out.print("����������������룺");
			}
		}

		// 3.��ӡ��ȭ��Ϣ
		System.out.print("��ң�" + arr[player] + "  "
					   + "���ԣ�" + arr[computer] + "\t");

		// 4.��ȭʤ���ж��������ؽ��
		if(player == computer){
			System.out.println("ƽ��");
			return 0;
		} else if((player + 1) % 3 == computer){
			System.out.println("����ʤ");
			return -1;
		} else {
			System.out.println("���ʤ");
			return 1;
		}
	}

	// ��������ʼ
	public void play(){
		Scanner sc = new Scanner(System.in);
		int computerScore = 0;
		int playerScore = 0;
		// ��ӡ�˵�
		menu();
		// �����ܹ���ȭ����
		System.out.print("�������ȭ������");
		int time = sc.nextInt();
		// ѭ�����в�ȭ
		for(int i = 1; i <= time; i++){
			System.out.println("������������������������������������������������������������");
			int res = judge(i, sc);
			if(res == 1){
				playerScore++;
			} else if(res == -1){
				computerScore++;
			}
		}
		System.out.println("������������������������������������������������������������");
		System.out.println("��Ϸ��������");
		System.out.println("���Ӯ�� " + playerScore + " ��");
		System.out.println("����Ӯ�� " + computerScore + " ��");
		System.out.println("ƽ���� " + (time - playerScore - computerScore) + " ��");
	}
} 


class _11_Test2 {
	public static void main(String[] args) {
		_11_RockPaperScissors rps = new _11_RockPaperScissors();
		rps.play();
	}
} 








// ����4��
// ������������������
// 
// ֪ʶ�㲹�䣺��������
// �﷨��new ����(�����б�);
// ����������÷�����new ����(����).������(����);

class _11_Test3 {
	int num = 9;
	public void func1() {
		num = 10;
		System.out.println(num);
	}	
	public void func2() {
		System.out.println(num++);
	}

	public static void main(String[] args) {
		// ��������new _11_Test3();
		// �ڶ��������˿ռ䣬����û���������ã���������ֻ�б��д���
		
		// ���£�������������ú���
		new _11_Test3().func1();// 10

		_11_Test3 t = new _11_Test3();
		t.func2();// 9
		t.func2();// 10
	}

}