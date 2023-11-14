// Plus Sign： 加号 +



// java中 + 号的使用：
// 1.当左右两边都是数值型时，执行加法运算
// 2.当左右两边【有一方】是字符串，则做拼接运算
// 3. + 的运算顺序是从左到右
//
//  
// e.g.输出以下内容
//  1.(100 + 3 + "hello") // 103hello
//		从左到右+，左侧数值先加为整型103，后与"hello"字符串拼接
//
//  2.("hello" + 100 + 3) // hello1003
//  	从左到右+，左侧先拼接为字符串"hello100"，后与3继续拼接




public class _02_PlusSign{
	public static void main(String[] args){
		// 注意：java中 + 的新规则：左右有一方是字符串，则做拼接运算
		// 		+ 执行顺序是从左到右
		
		System.out.println(114 + 5.14);// 119.14
		System.out.println("123" + 4);// 1234
		System.out.println('a' + 1);// 98
		System.out.println(1 + 2 + "3");// 33
		System.out.println("1" + 2 + 3);// 123
	}
}