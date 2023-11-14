// class and object： 类与对象

import java.util.*;



// 【类】(class)
// 
// 类中的成员包括：属性和行为
//	(1)属性：又叫成员属性、成员变量、field(字段)
// 	   属性的类型：可以是基本数据类型，也可以是引用类型
// 	   
//	(2)行为：又叫成员函数、成员方法
// 
// 
// 语法：
// 	class 类名 {
// 		// 属性
// 		访问修饰符 类型 变量名;
// 		...
// 		
// 		// 方法
// 		访问修饰符 返回类型 方法名(参数列表) {
// 			方法体;
// 		}
// 		...
// 	}
//
//
//
// 注意事项：
// 	1.访问修饰符，包括四种：(public,protected,privated,默认)
// 	
// 	2.属性(即全局变量)若不赋值，有默认值0
// 	  整数(0) 浮点数(0.0) 字符(\u0000) boolean(false) String(null)
// 	  数组也是对象，因此数组的默认值规则和对象的规则的一样，都是默认为0





// 【对象】(object) 
// 
// (1)创建对象：
// 	语法：类名 对象名 = new 类名(参数列表);
//       如：Cat c1 = new Cat();
// 	内存：c1是栈区中引用变量，指向堆区中开辟的空间
// 	
// (2)访问属性：
// 	语法：对象名.属性名;
// 	
// (3)对象赋值给对象：
// 	如：对象2 = 对象1;
// 	解释：对象是引用类型，以上操作是引用赋值(地址拷贝)，对象2是对象1的别名
// 		 对象1、对象2 操纵同一块内存空间
//
//  
//  
// 
// 【对象的内存布局】【重点】：
// jvm虚拟机中，内存有三大分区：栈区、堆区、方法区
// 	
// 	class Cat{
// 		String name;
// 		int age;
// 	}
// 	Cat cat = new Cat();
// 
//	如上代码，cat对象的内存布局：
//	 1.首先，内存会把Cat类的信息(属性、方法信息)加载到方法区	
//	   （注意：无论一个类创建多少个对象，类信息只加载一次）
//	 2.在栈区生成引用变量cat，指向堆区开辟的空间，其中存放成员变量cat.name和cat.age
//	 3.cat.age，是基本数据类型，它的值就存在堆区该空间中(默认置为0)
//	   cat.name，是String(引用类型)，堆区中存放的是指针，指向方法区中的常量池内的字符串数据(默认置为null)






class _01_Cat {// 定义Cat类
	// 属性
	String name;
	int age;
	double weight;
}


public class _01_ClassAndObject {
	public static void main(String[] args){

		// 创建Cat类的对象
		_01_Cat cat1 = new _01_Cat();// 堆区

		System.out.println("姓名：" + cat1.name// null（属性不赋值，默认值为0）
					   + "\n年龄：" + cat1.age// 0
			  		   + "\n体重：" + cat1.weight);// 0.0

		// 为对象的属性赋值
		cat1.name = "小黑";
		cat1.age = 13;
		cat1.weight = 11.45;

		System.out.println("姓名：" + cat1.name 
					   + "\n年龄：" + cat1.age
					   + "\n体重：" + cat1.weight);

	}
}






// 题目：分析以下代码在内存中的流程
class _01_Person {
	int age;
	String name;
}

class _01_Test1 {
	public static void main(String[] args) {
		_01_Person a = new _01_Person();
		//↑在堆区开辟一块空间，将age默认赋为0，name默认赋为null，让引用变量a指向这块空间
		a.age = 10;
		//↑将a.age赋为10
		a.name = "张三";
		//↑将字符串"张三"存放在方法区的常量池中，用a.name指向字符串的空间
		_01_Person b;
		//↑在栈中创建引用变量b，默认值赋为null
		b = a;
		//↑将b赋为a的引用
		b.age = 20;
		//↑用b将a、b共同操纵的对象的age赋为20
		b = null;
		//↑将b赋为null
		System.out.println(a.age);// 20
		System.out.println(b.age);// 报空指针s异常
	}
}