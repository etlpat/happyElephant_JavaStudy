//escape character: 转义字符

//常见转义字符：
// \t：水平制表符
// \n：换行符
// \\：一个\   （\会默认视作转义字符的起始标志，自动与下一个字符结合）
// \"：一个"
// \'：一个'
// \r： 回车
// 
// 
// 注意：回车!=换行
//      回车的作用是使光标回到本行的起始位置，之后新文字覆盖旧文字



public class _03_EscapeCharacter{
	public static void main(String[] args){
		System.out.println("1\t2\t3");
		System.out.println("1\n2\n3");
		System.out.println("1\\2\\3");
		System.out.println("1\"2\"3");
		System.out.println("1\'2\'3");
		System.out.println("1234\r56");// 5634，回车是让光标回到本行最初位置，新文字覆盖旧文字
	}
}