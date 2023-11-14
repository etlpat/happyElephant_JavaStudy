// pass parameter：传参

import java.util.*;



// 成员方法传参
// 
// (1)基本数据类型的传参【值传递】
// 
// 	结论：对于基本数据类型，传参时进行的是值传递，形参的改变不影响实参
// 	值传递：形参是实参的临时拷贝
// 	原理：形参和实参在两块独立的栈空间中，临时栈中形参的修改不会影响main栈中的实参
// 	
// 	值传递的内存布局：
// 		1.调用方法时，开辟了一块独立的临时栈空间。形参在该临时栈中，形参的值被赋成实参的值
// 		2.方法执行时，对临时栈中的形参值进行修改，与main栈中的实参无关
// 		3.当方法执行结束，形参随着临时栈一同被销毁
//
//
//
//
// (2)引用数据类型的传参【(地址)引用传递】
// 
// 	结论：引用类型传递的是地址，可以通过形参影响实参
// 	引用传递：形参是实参的引用(别名)，二者指向同一块内存空间
// 	
// 	引用传递的内存布局：
// 		1.调用方法时，开辟一块临时的栈空间。形参在该临时栈中，形参是实参的引用。
// 		  (形参在临时栈中，实参在main栈中，但是引用传参是地址传递，二者指向同一对象)
// 		2.由于形参和实参指向同一块空间，在方法中修改形参的内容，实参的内容同时改变
// 		3.方法执行结束，形参随着临时栈一同被销毁
// 		
// 						
// 【区分】若p1、p2是Person类的引用变量：
// 	1.为p1指向的空间赋值：p1.age = 10; 
// 	  通过引用变量p1，为其指向的空间的age属性赋值
// 	2.为p1本身赋值：p1 = p2; 
//    将p2中存放的地址赋给p1，p1指向的空间改变，但是不影响p1原本指向的空间






class _03_Swap {
	public void swap1(int a, int b){// 基本类型传参(值传递)
		int tmp = a;
		a = b;
		b = tmp;
	}

	public void swap2(int[] a, int[] b){// 引用类型传参(地址传递)
		for(int i = 0; i < a.length; i++){
			int tmp = a[i];
			a[i] = b[i];
			b[i] = tmp;
		}
	}
}


public class _03_PassParameter {
	public static void main(String[] args) {
		
		_03_Swap s = new _03_Swap();

		// 基本数据类型的传参 -- 值传递
		int a = 10, b = 20;
		System.out.println(a + ", " + b);// 10, 20
		s.swap1(a, b);
		System.out.println(a + ", " + b);// 10, 20

		// 引用数据类型的传参 -- 引用传递
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {4, 5, 6};
		printArr(arr1);// 1 2 3
		printArr(arr2);// 4 5 6
		s.swap2(arr1, arr2);
		printArr(arr1);// 4 5 6
		printArr(arr2);// 1 2 3

	}

	public static void printArr(int[] arr){// 打印一维数组方法
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}








// 练习1：执行以下方法，打印输出什么？
class _03_Person {
	String name;
	int age;
}

class _03_A {
	public void func(_03_Person p){
		p.name = "jack";// 为p指向的空间赋值
		p = null;// 为p本身赋值
	}
}

class _03_Test1 {
	public static void main(String[] args) {
		_03_A a = new _03_A();
		_03_Person p1 = new _03_Person();
		p1.name = "bob";
		p1.age = 10;
		a.func(p1);
		// 方法执行流程：
		// 	1.func方法开辟临时栈空间，存放的引用变量p，p和p1存放相同的地址
		// 	2.通过p将p1指向的对象属性name改为jack
		//	3.把p置为null，是对引用变量p自身赋值，不影响主函数中p1指向的空间
		System.out.println(p1.name);// jack
		System.out.println(p1.age);// 10

	}
}








// 练习2：编写一个copyPerson方法，可以复制一个_03_Person对象，返回复制的对象
//		  要求得到的新对象和原来的是两个独立的对象，只是属性相同 
class _03_Copy {
	public _03_Person copyPerson(_03_Person p1) {
		_03_Person p2 = new _03_Person();// 深拷贝
		p2.name = p1.name;
		p2.age = p1.age;
		return p2;
	}
}

class _03_Test2 {
	public static void main(String[] args) {
		_03_Person p1 = new _03_Person();// 创建人对象p1
		p1.name = "张三";
		p1.age = 18;

		_03_Copy cp = new _03_Copy();// 创建拷贝器对象
		_03_Person p2 = cp.copyPerson(p1);// 对p1进行拷贝，存放在p2中

		System.out.println(p2.name);// 张三
		System.out.println(p2.age);// 18
		System.out.println(p1);// _03_Person@15db9742 (输出 hashCode)
		System.out.println(p2);// _03_Person@6d06d69c
	}
}