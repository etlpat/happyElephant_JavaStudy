// ternary operator： 三目运算符



// 三目运算符：
// 语法： 表达式1 ? 表达式2 : 表达式3;
// 作用：若表达式1为true，则执行并返回表达式2，否则执行并返回表达式3
//
// 注意事项：
// 	a ? b : c; 相当于 if(a){res=b;} else{res=c;}
// 	因此	1.若执行b，就不会执行c；若执行c，就不会执行b
//		2.b、c必须是可返回的语句


public class _05_TernaryOperator {
	public static void main(String[] args) {

		int a = 100, b = 1, c = 50, max;

		// 求最大值
		int maxTwo = b > c ? b : c;
		int maxThree1 = a > b ? (a > c ? a : c) : (b > c ? b : c); // 三目运算符可嵌套
		int maxThree2 = (max = a > b ? a : b) > c ? max : c;
		
		System.out.println(maxTwo);// 50
		System.out.println(maxThree1);// 100
		System.out.println(maxThree2);// 100
	}
}