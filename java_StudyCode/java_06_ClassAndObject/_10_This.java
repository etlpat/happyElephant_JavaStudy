// this�ؼ���


// this�ؼ���
// 
// ���
// 	java��������ÿ�����󶼷���this������ǰ����
// 	��thisָ�򱻵��õķ��������Ķ���
// 
// this���ʣ�
// 	this�ʹ��������(ָ��������������)
//
// this���ܣ�
// 	this�ؼ��ֿ������ڷ��ʱ�������ԡ�������������
// 	�﷨��(this�����Ƕ���)
// 	1.�������ԣ�this.����;
//	2.���ʷ�����this.����(�����б�);
//	3.���ʹ�������this(�����б�);// ע�⣬ֻ����(����)��������ʹ�ã��ұ�����ڵ�һ�����
//
//
//
// ע�����
// 	1.thisֻ�������ڲ�(�ķ�����)ʹ��
// 	
// 	2.this���������������Ժͳ�Ա����
// 	
// 	3.�����е��õ�������������/�����������϶���ͨ��this�ؼ���������
//	 ���������ǲ�дthis.xxx������ʱϵͳҲ���Զ����ϣ�
	 



// ֪ʶ�㲹�䣺����ϣ�롿
// 	1.��ַ��java�����ĵ�ַ��JVM����������޷�ֱ�ӻ�ö���ĵ�ַ
//	2.��ϣ��(hash code)�����ɵ�ַ���������õ��������������������±�ʾ��ַ��
//    ÿ��������һ����ϣ��
//    
// ��ù�ϣ��
// 	�﷨������.hashCode()





class _10_Cat {
	String name;
	int age;

	public _10_Cat(String name, int age) {
		this.name = name;
		this.age = age;
		// ���ֲ��������������������þͽ�ԭ�򡣹�������name��age�Ǿֲ�����(�β�)
		// ��ʱͨ��this�ؼ��֣����ܷ��ʵ����������name��age
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
		this(a1);// ͨ��this����(����)������
		b = b1;
	}


	public void f1() {
		System.out.println("f1������");
	}

	public void f2() {
		System.out.println("f2������");
		// ֱ�ӵ��÷���
		f1();
		// ͨ��this���÷���
		this.f1();
	}

}


public class _10_This {
	public static void main(String[] args) {

		// this.����
		_10_Cat cat = new _10_Cat("С��", 12);
		System.out.println(cat.name);// С��
		System.out.println(cat.age);// 12


		// ������this���ã�������ͬ�Ĺ�ϣ��
		cat.printThisHash();// 366712642
		System.out.println(cat.hashCode());// 366712642
	

		// this.���� / this.������
		_10_Tool tool = new _10_Tool(1, 2);
		System.out.println(tool.a + "," + tool.b);// 1,2
		tool.f2();
				// f2������
				// f1������
				// f1������
	}
}