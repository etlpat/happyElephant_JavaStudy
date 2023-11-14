// scope：作用域


// 作用域
// 
// 1.变量分类
// 	java中，变量分为：①成员变量(属性)、 ②局部变量
// 
// 
// 2.作用域分类
// 	全局变量：也就是属性，作用域是整个类中
// 	局部变量：是除属性外的其它变量，作用域在定义它的代码块(大括号)中
//
//
// 3.变量默认值【重点】
// 	①全局变量：属性有默认值0	(0、 0.0、 \u0000、 false、 null)
// 	②局部变量：无默认值，必须赋值后才能使用
// 本质：【堆区数据都有默认值0，而栈区变量没有默认值】
//  
// 
// 
// 注意事项：
// 	1.全局变量(属性)和局部变量可以重名，访问时遵循【就近原则】
// 	
// 	2.属性的生命周期长：从对象的创建到对象的销毁	(从堆区创建空间到堆区空间释放)
// 	  局部变量的生命周期短：从变量的创建到变量所在的代码块结束	(从栈中创建变量到临时栈被销毁)





class _08_Cat {
	// 全局变量，即属性，作用域是整个类中
	String name;
	int age = 10;// 将age指定为10
	double weight;// 属性(堆区)有默认值0.0


	public void eat() {
		// 局部变量
		int num = 0;// 局部变量(栈区)无默认值，必须赋初值
		{
			// 局部变量，作用域仅在代码块(大括号)中
			int i = 0, j = 0;
		}
	}


	public void test() {
		// 1.全局变量的作用域：在整个类中
		System.out.println(weight);// 0.0
		System.out.println(age);// 10

		// 2.局部变量的作用域：仅在其代码块中
		//System.out.println(num);// 报错
		{
			int i = 100;
		}
		//System.out.println(i);// 报错
	

		// 3.全局变量和局部变量可以重名，访问遵循优先原则
		int age = 20;
		System.out.println(age);// 20
	}
}



public class _08_Scope {
	public static void main(String[] args) {
		_08_Cat cat = new _08_Cat();

		cat.test();
	}
}