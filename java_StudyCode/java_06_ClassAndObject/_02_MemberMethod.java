// member method： 成员方法

import java.util.*;



// 成员方法
// 
// (1)方法定义
// 语法：
// 	class XX类 {
// 		...
// 		访问修饰符 返回类型 方法名(形参列表) {
// 			代码块;
// 			return 返回值;
// 		}
// 		...
// 	}
// 	
// 	
// (2)方法调用
// 语法：对象名.方法名(实参列表);
// 	
// 	
// 	
// (3)方法执行时的内存布局【重点】
// 	1.当程序执行到方法调用语句时，就会开辟一块【独立的临时栈空间】
// 	2.该方法的形参拷贝，以及在该方法内创建的变量，都存放在这块临时栈空间中
// 	3.当方法执行结束，这块临时栈空间会被释放(销毁)
//
// 
// 
// 注意事项：
// 	1.方法名建议遵循小驼峰命名法(getValue)，要见名知意
// 	  
// 	2.方法不能嵌套定义
// 
//	3.四种访问修饰符 [public,protected,privated,默认]
//	  
//	4.返回值：java方法只能有一个返回值，可以是基本类型或引用类型
//	  返回值必须与返回类型一致或兼容(可以自动转换为返回类型)
//
//	5.形参：可以有0个或多个，可以是基本类型或引用类型
//	  实参必须与形参类型一致或兼容(实参可以自动转换为形参类型)
//	  形参是实参的临时拷贝
//	 
//	6.同一类中的方法调用：可直接调用。 如：printA();// 本质是this.printA();
//	  跨类的方法调用：通过对象调用。 如：对象名.printA(); 





class _02_Cat {
	// 属性
	String name;
	int age;

	// 方法
	public void speak() {
		System.out.println("喵喵喵~");
	}

	public void setName(String name1) { this.name = name1; }
	public void setAge(int age1) { age = age1; }
	public String getName() { return name; }
	public int getAge() { return this.age; }
}



class _02_MyTools {
	public int add(int a, int b) {// 两数求和
		return a + b;
	}

	public void printArr(int[] arr, String space){// 重载：打印一维数组
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + space);
		}
		System.out.println();
	}
	public void printArr(int[][] arr, String space){// 重载：打印二维数组
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j] + space);
			}
			System.out.println();
		}
	}

	public double[] getSumAndSub(double a, double b){// 方法返回两数和与差的数组
		double[] resArr = new double[2];
		resArr[0] = a + b;
		resArr[1] = a - b;
		return resArr;
	}
}



public class _02_MemberMethod {
	public static void main(String[] args) {

		// (1)猫的类
		_02_Cat c1 = new _02_Cat();
		
		c1.setName("小白");
		c1.setAge(6);
		System.out.println("姓名：" + c1.getName() + "\n年龄：" + c1.getAge());
		c1.speak();	// 喵喵喵~
	


		// (2)工具的类
		_02_MyTools tool = new _02_MyTools();

		// 1.add方法
		int result = tool.add(15, 22);
		// ↑执行如上方法时，开辟了一块独立的临时栈空间，存放形参a、b(实参的临时拷贝)。
		// ↑当返回a+b的值后，临时栈空间被销毁
		System.out.println(result);// 37


		// 2.打印数组的重载方法
		int[] arr1 = {1, 2, 3, 4, 5};
		int[][] arr2 = {{1, 2, 3}, {4, 5}, {6}};
		tool.printArr(arr1, " ");// 重载1：打印一维数组
		tool.printArr(arr2, "|");// 重载2：打印二维数组


		// 3.返回类型是数组的方法
		double[] res = tool.getSumAndSub(3.14, 2);
		// 由于数组存放在堆区，方法结束后不会销毁
		System.out.println(res[0]);// 5.140000000000001
		System.out.println(res[1]);// 1.1400000000000001

	}
}








// 例题：创建图形类，根据行、列、字符，打印矩阵
class _02_Picture {
	public void printMatrix(int row, int col, char ch) {
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				System.out.print(ch + " ");
			}
			System.out.println();
		}
	}
}

class _02_Test {
	public static void main(String[] args) {
		_02_Picture p = new _02_Picture();
		p.printMatrix(20, 30, '*');
	}
}