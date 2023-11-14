// 字符串和基本数据类型的转换



// (1)基本数据类型转化为字符串
// 语法： 变量 + ""
// 原理：若 + 有一边是字符串，则会把左右拼接为一个字符串。
// e.g. String s = 123 + "";



// (2)字符串转化为基本数据类型
// 语法：通过基本类型的包装类调用parseXX方法即可
// 	 parseXX方法：参数是字符串，返回XX类型的对应数据
//   parse：v. 分析、转换
// 
// 例如：
// 		int a = Integer.parseInt("123");
// 		double d = Double.parseDouble("123.0");
// 		boolean b = Boolean.parseBoolean("true");
// 		
// 注意：
//  1.字符串不能转为字符型数据（char无对应的parse方法）
//  2.int对应的类是Integer，char对应的是Character,其他的类都是将对应类型的首字母大写即可
// 	3.parseXX方法要保证参数String能转成有效数据，否则抛出异常（异常：编译不报错，运行时报错）





public class _10_StringAndBasicType{
	public static void main(String[] args){

		// (1)基本数据类型 -> 字符串
		int i = 100;
		double d = 11.45;
		boolean b = true;
		String s1 = i + "";// 用加号将变量与空串拼接为字符串
		String s2 = d + "";
		String s3 = b + "";
		System.out.println(s1 + "\n" + s2 + "\n" + s3);



		System.out.println("----------------------");
		// (2)字符串 -> 基本数据类型
		// 各个数据类型对应的包装类中，都包含将字符串转化为对应类型的parseXXX方法

		byte num1 = Byte.parseByte(s1);
		short num2 = Short.parseShort(s1);
		int num3 = Integer.parseInt(s1);
		long num4 = Long.parseLong(s1);
		Float num5 = Float.parseFloat(s2);
		double num6 = Double.parseDouble(s2);
		boolean b1 = Boolean.parseBoolean(s3);

		System.out.println(num3);// 100
		System.out.println(num6);// 11.45
		System.out.println(b1);// true
	}
}
