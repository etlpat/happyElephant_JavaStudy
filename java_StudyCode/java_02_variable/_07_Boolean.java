
// 布尔类型：boolean
// 1.boolean类型占1字节，只允许取值true或false
// 
// 2.java中，【不可以用0或非0代表false或true】，这点和C++不同
// 	 java中boolean类型的本质不是1或0
// 	 
// 3.java中，boolean类型和其他类型直接不能强转类型转换




public class _07_Boolean{
		public static void main(String[] args){
			boolean a = true;
			boolean b = false;
			//boolean c = 1;// 报错，注意：java中boolean只能是true或false，不能用0或非0代替
			//boolean d = 0;// 报错
			System.out.println(a);
			System.out.println(b);

			// java中，boolean类型无法和其他类型相互转换
			// int a1 = (int) true;// 报错
			// int b1 = (int) false;// 报错
			// boolean a2 = (boolean) 1;// 报错
			// boolean b2 = (boolean) 0;// 报错
	}
}