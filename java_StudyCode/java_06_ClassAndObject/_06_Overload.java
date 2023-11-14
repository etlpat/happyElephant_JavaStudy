// overload：重载


// 方法的重载
// 
// 重载：不同方法的方法名可以相同，提高复用性
// 
// 重载的满足条件：
// 	1.同一个作用域下(同一个类中)
// 	2.方法名：必须相同
// 	3.形参列表：(类型/数量)必须不同
// 	4.返回类型：无要求
// 	
// 	
// 	
// 注意事项：
// 	1.重载要求【一组实参只能存在唯一一种与之匹配的形参列表】
// 	
// 	2.方法重载对参数名无要求
// 	  如：void func(int a){...} 和 int func(int b){...}
// 	  以上两个方法不是重载，而是重复定义
// 	  
//	3.对重载的方法传入实参后，先不将实参自动类型转换，判断是否有形参列表匹配的方法
//	  若都不匹配，则自动转换实参，判断是否存在匹配方法





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

		// 加法重载
		int num1 = tool.add(1, 2);// (int, int)
		double num2 = tool.add(1, 2.0);// (int, double)
		double num3 = tool.add(1.0, 2.0);// (double, double)
		
		// 若实参与所有重载的形参列表都不匹配，才将实参自动类型转换
		double num4 = tool.add(1.0, 2);// (double, double)
	


		// 求最大值重载
		System.out.println(tool.max(1, 2));// 2
		System.out.println(tool.max(1.1, 2.2));// 2.2		
		System.out.println(tool.max(1.2, 27, 3.1));// 27.0	
	}
}