// constructor：构造器


// 构造器(构造方法)
// 
// 构造器：
// 	1.功能：为对象属性赋初值
// 	2.返回类型：构造方法，没有返回类型
// 	3.方法名：必须和类名一致
// 	4.参数：可以有参数，因此可以发生重载
// 	5.调用时机：在对象创建时，自动被系统调用，进行对象属性的初始化，且一个对象仅调用一次
// 
// 
// 语法：
// 	class 类名 {
// 		// 构造方法
// 		[访问修饰符] 类名(形参列表) {
// 			方法体;
// 		}
// 	}
// 	
// 
// 注意事项：
// 	1.构造方法也可以重载
// 	
// 	2.若程序员没有定义构造器，系统会自动生成一个默认无参的空构造器
// 	  	默认构造器，即：public Person(){}
// 	  	
//	3.一旦定义了自己的构造器，默认的构造器就被【覆盖】了，无法使用
//	  	若还想用无参构造器，可以手动重载一个
//	  	
//	4.属性的初始化顺序：【1.堆区默认初始化为0，2.显式初始化，3.调用构造器进行初始化】
//	  	显式初始化：定义属性时，int age = 10;

 	



class _09_Person {
	String name;
	int age;
	String sex;

	// 构造方法
	// 注意：1.无返回类型 2.方法名就是类名
	public _09_Person(String name1, int age1, String sex1) {
		name = name1;
		age = age1;
		sex = sex1;
		System.out.println("构造器被调用");
	}
}

class _09_Cat {
	// 默认构造器：
	// Cat() {}
}

public class _09_Constructor {
	public static void main(String[] args) {
		// 通过构造器为属性赋初值
		_09_Person p1 = new _09_Person("张三", 18, "男");// 构造器被调用

		System.out.println(p1.name);// 张三
		System.out.println(p1.age);// 18
		System.out.println(p1.sex);// 男


		// 若未定义构造器，会使用默认(无参)构造器
		_09_Cat c1 = new _09_Cat();
		// 若定义了构造器，则默认构造器会被覆盖，无法使用
		//_09_Person p2 = new _09_Person();// 报错
	}
}





// 题目：分析下面流程
// 属性初始化顺序：【1.堆区默认初始化为0，2.显式初始化，3.调用构造器进行初始化】

class _09_Dog {
	int age = 6;

	public _09_Dog(int a){
		age = a;
	}
}

class _09_Test1 {
	public static void main(String[] args) {
		_09_Dog dog = new _09_Dog(10);
		// 流程分析：
		// 1.将 _09_Dog 类信息加载到方法区
		// 2.在堆区开辟空间，存放int型变量age，默认值是0
		// 3.为属性age赋初值6
		// 4.调用构造方法，将传入的10赋值给age
		// 5.将对象的堆区地址返回给栈区的引用变量dog

		System.out.println(dog.age);// 10
	}
}