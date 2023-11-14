// this关键字


// this关键字
// 
// 概念：
// 	java虚拟机会给每个对象都分配this，代表当前对象。
// 	【this指向被调用的方法所属的对象】
// 
// this本质：
// 	this就代表对象本身(指向对象自身的引用)
//
// this功能：
// 	this关键字可以用于访问本类的属性、方法、构造器
// 	语法：(this本质是对象)
// 	1.访问属性：this.属性;
//	2.访问方法：this.方法(参数列表);
//	3.访问构造器：this(参数列表);// 注意，只能在(重载)构造器中使用，且必须放在第一条语句
//
//
//
// 注意事项：
// 	1.this只能在类内部(的方法内)使用
// 	
// 	2.this可以用来区分属性和成员变量
// 	
// 	3.方法中调用的所有自身属性/方法，本质上都是通过this关键字来调用
//	 （就算我们不写this.xxx，运行时系统也会自动补上）
	 



// 知识点补充：【哈希码】
// 	1.地址：java变量的地址由JVM虚拟机管理，无法直接获得对象的地址
//	2.哈希码(hash code)：是由地址经过处理后得到的整数，可以用来大致表示地址。
//    每个对象都有一个哈希码
//    
// 获得哈希码
// 	语法：对象.hashCode()





class _10_Cat {
	String name;
	int age;

	public _10_Cat(String name, int age) {
		this.name = name;
		this.age = age;
		// 若局部变量与属性重名，采用就近原则。构造器中name和age是局部变量(形参)
		// 此时通过this关键字，才能访问到对象的属性name和age
	}

	public void printThisHash() {
		System.out.println(this.hashCode());
	}
}


class _10_Tool {
	int a;
	int b;

	public _10_Tool(int a1) { a = a1; }
	public _10_Tool(int a1, int b1){
		this(a1);// 通过this调用(重载)构造器
		b = b1;
	}


	public void f1() {
		System.out.println("f1被调用");
	}

	public void f2() {
		System.out.println("f2被调用");
		// 直接调用方法
		f1();
		// 通过this调用方法
		this.f1();
	}

}


public class _10_This {
	public static void main(String[] args) {

		// this.属性
		_10_Cat cat = new _10_Cat("小黑", 12);
		System.out.println(cat.name);// 小黑
		System.out.println(cat.age);// 12


		// 对象及其this引用，具有相同的哈希码
		cat.printThisHash();// 366712642
		System.out.println(cat.hashCode());// 366712642
	

		// this.方法 / this.构造器
		_10_Tool tool = new _10_Tool(1, 2);
		System.out.println(tool.a + "," + tool.b);// 1,2
		tool.f2();
				// f2被调用
				// f1被调用
				// f1被调用
	}
}