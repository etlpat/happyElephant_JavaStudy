
// 字符型char细节：
// 1.大小是2字节，可以存放单个字符(包括汉字)，字符用单引号' '引出
//
// 2.char变量在内存中存储的是一个整数，输出的是【unicode码】对应的字符
//   	C语言中，char是ASCII码，只占1字节；java中的unicode码包括汉字，大小2字节
//	注意：'0'=48，'A'=65，'a'=97
// 
// 3.可以巴char当作整数运算
//   如输出'a'+10=107：由于是加法运算，'a'被转换为97，+10变为107
//
//
//
// 编码表知识补充：
// ASCII：	占1字节，一共128个字符。只有符号、字母
// Unicode：	字母和汉字统一占2字节。兼容ASCII表，包含所有国家文字，缺点浪费空间
// utf-8：	大小可变，字母占1字节，汉字3字节。互联网上使用最广泛的一种Unicode码实现方式
// gbk：		字母占1字节，汉字2字节





public class _06_Char{
	public static void main(String[] args){
		char a = 'a';
		char b = '\n';
		char c = '嗨';
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);



		char ch1 = 97;// 数字表示unicode码
		char ch2 = 'a';
		char ch3 = 33333;
		System.out.println(ch1);// a
		System.out.println((int)ch2);// 97
		System.out.println(ch3);// 舵


		// 字符可以进行整数运算
		char ch4 = 'a' + 1;
		System.out.println(ch4);// b （ch4是字符型，输出b）
		System.out.println('a' + 1);// 98 （'a'在加法运算中转换为整型）

		System.out.println('男' + '女');// 52906 （字符+字符 并不会输出字符串）
		// 在运算时字符被看作整数，整型提升为两个int型，输出整数相加结果
	}
}