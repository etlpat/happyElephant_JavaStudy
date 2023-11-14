// Arithmetic operator： 算数运算符


// 算数运算符：
// 	+
// 	-
// 	*
// 	/
// 	%
// 	++
// 	--
// 
// 注意事项：
// 1. +：正号/加法
// 		执行加法时，从左到右进行
// 		若两操作数有一方是String，则执行字符串拼接操作，表达式返回String
// 		
// 2. /：除法
// 		两int型相除，结果也是int，直接取整
// 		double相除，结果也是double
// 		
// 3. %：取余
// 		%本质：a % b = a - a / b * b;
// 		注意：【java允许%的操作数为小数】，公式为：a%b = a-(int)a/b*b
// 		
// 4. ++：(前置/后置)自增
// 		++a：先自增，后运算
// 		a++：先运算，后自增
//
// 5. ++、-- 会自动进行类型强转转换
// 		byte b = 0;
//		(1)b=b+1;报错，(2)b++;不报错，(3)++b;不报错
//		b++; 本质相当于 b=(byte)(b+1);





public class _01_ArithmeticOperator{
	public static void main(String[] args) {
		
		// 除法 /
		System.out.println(10 / 4);// 2
		System.out.println(10 / 4.0);// 2.5
		// 表达式中有double类型，所有操作数都会提升为double，进行小数除法，结果也是double

		double d = 10 / 4;
		// 赋值运算符优先级低，先执行int型运算，之后int整型提升存入double
		System.out.println(d);// 2.0
	


		// 取余 %
		// %本质：a % b = a - a / b * b;
		// (余数符号和分子相同)
		System.out.println(10 % 3);	// 1
		System.out.println(-10 % 3); // -1	
		System.out.println(10 % -3); // 1
		System.out.println(-10 % -3); // -1



		// 自增 ++
		int a = 2;
		System.out.println(10 * a++);// 20，先运算，后自增
		System.out.println(10 * ++a);// 40，先自增，后运算



		// ++、--的强制类型转换
		byte b = 0;
		//b = b + 1;// 报错，等式右侧整型提升
		b = (byte)(b + 1);
		b++;// 不报错
		++b;// 不报错
		// 自加不报错，说明会自动进行强制类型转换
		


		// 当对小数取余
		// 公式：a%b = a-(int)a/b*b
		System.out.println(-10.5 % -3);// -1.5
		System.out.println(-10 % -3.5);// -3.0
	}
}






class _01_Test{
	public static void main(String[] args) {
		
		// 面试题1
		int i = 1;
		i = i++;
		// 先运算右边算表达式，后将表达式的值赋给i，右边的值是1
		// 执行过程生成临时变量：(1)temp=i;(2)i+=1;(3)i=temp
		System.out.println(i);// 1


		// 面试题2
		int j = 1;
		j = ++j;
		// 该过程也会生成临时变量：(1)j+=1;(2)temp=j;(3)j=temp
		System.out.println(j);// 2


		// 题目：
		// 还有59天放寒假，问还有?星期?天
		System.out.println(59 / 7 + "星期" + 59 % 7 + "天");


		// 题目：
		// 定义一个变量保存华氏度[234.5]，请求华氏度对应的摄氏度
		// 华氏度->摄氏度：5/9*(华氏度-100)
		double c = 234.5;
		double d = 5.0 / 9 * (c - 100);// 注意：要用浮点型进行运算
		System.out.println("华氏度：" + c + "\n摄氏度：" + d);
	}
}