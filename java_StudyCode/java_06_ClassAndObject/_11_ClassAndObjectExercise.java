import java.util.*;


// 案例1：按照要求写出工具类
class _11_MyTools {
	// 题目方法1：要求求出任意个double类型的最大值
	public double max(double... arr){
		double maxNum = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(maxNum < arr[i]){
				maxNum = arr[i];
			}
		}
		return maxNum;
	}

	// 方法：创建含1~n个元素的double数组
	public double[] getRandArr(int maxSize){
		Random rand = new Random();
		double[] arr = new double[rand.nextInt(maxSize) + 1];
		for(int i = 0; i < arr.length; i++){
			arr[i] = rand.nextDouble() * 100;
		}
		return arr;
	}

	// 方法：打印double数组
	public void printArr(double[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}

	// 题目方法2：查找字符串数组元素，并返回下标
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

		// 生成随机个元素的double数组
		double arr[] = tool.getRandArr(maxSize);
		// 打印double数组
		tool.printArr(arr);
		// 找出最大值元素
		double d = tool.max(arr);
		System.out.println("最大值为：" + d);


		// 查找字符串数组元素下标
		String strArr[] = {"张三", "李四", "王五"};
		int index = tool.find(strArr, "王五");
		System.out.println(index);// 2


	}
}








// 案例2：创建一个Employee类，属性有(名字，性别，年龄，职位，薪水)
// 要求有三个构造方法：1.(名字，性别，年龄，职位，薪水) 2.(名字，性别，年龄) 3.(职位，薪水)

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
		this(name1, sex1, age1);// this访问构造方法必须放在开头
		this.job = job1;
		this.salary = salary1;
	}

	public void showInfo(){
		System.out.println("姓名：" + name);
		System.out.println("性别：" + sex);
		System.out.println("年龄：" + age);
		System.out.println("职位：" + job);
		System.out.println("薪水：" + salary);
	}
}

class _11_Test1 {
	public static void main(String[] args) {
		_11_Employee e1 = new _11_Employee("jimmy", "男", 19, "学生", 1145.14);
		e1.showInfo();
	}
}








// 案例3：设计一个石头剪刀布类，可以和电脑玩猜拳
// 
// 思路：
// 规则是：石头>剪刀； 剪刀>布； 布>石头
// 我们令(石头=2  剪刀=1  布=0)
// 则：(石头+1)%3==布； (剪刀+1)%3==石头； (布+1)%3==剪刀，实现内循环
// 

class _11_RockPaperScissors {
	// 方法：打印菜单
	public void menu(){
		System.out.println("**************************");
		System.out.println("*****  石头 剪刀 布  *****");
		System.out.println("**************************");
		System.out.println("*****   石头 -- 2    *****");
		System.out.println("*****   剪刀 -- 1    *****");
		System.out.println("*****     布 -- 0    *****");
		System.out.println("**************************");
	}

	// 方法：进行一次石头剪刀布
	// 参数： i:第i次猜拳		sc:Scanner对象
	// 返回值：0表示平局，1表示玩家胜，-1表示电脑胜
	public int judge(int i, Scanner sc){
		String[] arr = {"布 ", "剪刀", "石头"};

		// 1.电脑猜拳(生成0、1、2)
		Random rand = new Random();
		int computer = rand.nextInt(3);
		// 2.玩家猜拳(从屏幕输入)
		int player = -1;
		System.out.print("第" + i +"次，请猜拳：");
		while(true){
			player = sc.nextInt();
			if(player==0 || player==1 || player==2){
				break;
			} else{
				System.out.print("输入错误，请重新输入：");
			}
		}

		// 3.打印猜拳信息
		System.out.print("玩家：" + arr[player] + "  "
					   + "电脑：" + arr[computer] + "\t");

		// 4.猜拳胜负判定，并返回结果
		if(player == computer){
			System.out.println("平局");
			return 0;
		} else if((player + 1) % 3 == computer){
			System.out.println("电脑胜");
			return -1;
		} else {
			System.out.println("玩家胜");
			return 1;
		}
	}

	// 方法：开始
	public void play(){
		Scanner sc = new Scanner(System.in);
		int computerScore = 0;
		int playerScore = 0;
		// 打印菜单
		menu();
		// 输入总共猜拳次数
		System.out.print("请输入猜拳次数：");
		int time = sc.nextInt();
		// 循环进行猜拳
		for(int i = 1; i <= time; i++){
			System.out.println("——————————————————————————————");
			int res = judge(i, sc);
			if(res == 1){
				playerScore++;
			} else if(res == -1){
				computerScore++;
			}
		}
		System.out.println("——————————————————————————————");
		System.out.println("游戏结束！！");
		System.out.println("玩家赢了 " + playerScore + " 次");
		System.out.println("电脑赢了 " + computerScore + " 次");
		System.out.println("平局了 " + (time - playerScore - computerScore) + " 次");
	}
} 


class _11_Test2 {
	public static void main(String[] args) {
		_11_RockPaperScissors rps = new _11_RockPaperScissors();
		rps.play();
	}
} 








// 案例4：
// 分析下面代码的输出结果
// 
// 知识点补充：匿名对象
// 语法：new 类名(参数列表);
// 匿名对象调用方法：new 类名(参数).方法名(参数);

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
		// 匿名对象：new _11_Test3();
		// 在堆区开辟了空间，但是没被变量引用，生命周期只有本行代码
		
		// 如下，用匿名对象调用函数
		new _11_Test3().func1();// 10

		_11_Test3 t = new _11_Test3();
		t.func2();// 9
		t.func2();// 10
	}

}