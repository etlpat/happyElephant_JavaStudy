// variable parameter：可变参数


// (长度)可变参数
// 
// 语法：
// 	1.定义：
//		访问修饰符 返回类型 方法名(数据类型... 数组名){
//			代码块;
//		}
// 
// 	2.调用： 对象名.方法名(变量1, 变量2,..., 变量n);
// 
// 		
// 可变参数细节：
// 	形参：格式固定，如 (double... arr)
// 	实参：可以传入0个或任意多个同类型的变量，或直接传入数组
// 	本质：可变参数本质就是数组
// 		  在方法的临时栈中创建一个数组，指向堆区空间，存放实参列表中的变量
//
//
// 注意：
// 	1.可变参数可以和普通类型参数一起放在形参列表，但必须保证可变参数在最后
// 	2.一个形参列表只能出现一个可变参数

 	



class _07_MyTools {

	// 可变参数
	double add(double... arr){// 传入任意个实参，存放到数组中
		double sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
		}
		return sum;
	}

	// 可变参数必须放在参数列表末尾(且只能有一个)
	void func(String str, int... arr){
		System.out.print(str + ": ");
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}


public class _07_VariableParameter {
	public static void main(String[] args) {
		_07_MyTools tool = new _07_MyTools();
	
		// 1.可变参数求和
		System.out.println(tool.add(1, 2, 3, 4, 5));// 15.0
		System.out.println(tool.add(1.1, 2.2, 3.3));// 6.6

		// 可变参数可以传入0个变量
		System.out.println(tool.add());// 0.0

		// 可变参数可以直接传入数组
		double[] arr = {1, 2, 3};
		System.out.println(tool.add(arr));// 6.0
		

		// 可变参数必须放在列表末尾
		tool.func("hello", 1, 2, 3);// hello: 1 2 3

	}
}





// 例题:写一个方法打印学生信息,包括姓名和n门课的总分

class _07_StudentInfo {
	// 返回姓名和n门课的总分
	public String getTotalScore(String name, double... score){
		double totalScore = 0;
		for(int i = 0; i < score.length; i++){
			totalScore += score[i];
		}
		return name + " " + score.length + "科的总分为: " + totalScore;
	}
}

class _07_Test1 {
	public static void main(String[] args) {
		_07_StudentInfo stu = new _07_StudentInfo();
		
		String s1 = stu.getTotalScore("张三", 91, 87, 73.5);// 可变参数
		String s2 = stu.getTotalScore("李四", 67.5, 88);
		String s3 = stu.getTotalScore("王五", 100, 20, 50, 99);

		System.out.println(s1 + "\n" + s2 + "\n" + s3);
		// 张三 3科的总分为: 251.5
		// 李四 2科的总分为: 155.5
		// 王五 4科的总分为: 269.0
	}
}