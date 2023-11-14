// continue语句

import java.util.*;



// continue语句
// 
// 语法：continue;
// 		continue 标签;
// 		
// 功能：用于结束本次循环，并继续执行下一次循环
// 注意：1.continue语句在多层嵌套中，可以通过标签指定跳到哪层循环
// 		  continue标签与break标签使用方式相同





public class _07_Continue {
	public static void main(String[] args) {

		for(int i = 1; i < 10; i ++){
			if(i >= 3 && i <= 6){
				continue;
			}
			System.out.print(i + " ");// 1 2 7 8 9
		}
	}
}





class _07_ContinueLable {
	public static void main(String[] args) {
		lable1:
		for(int i = 0; i < 3; i++){
			lable2:
			for(int j = 0; j < 10; j++){
				if(j == 2) {
					continue lable1;// 直接跳到外侧循环
				}
				System.out.print(i + "," + j + "  ");// 0,0  0,1  1,0  1,1  2,0  2,1
			}
		}
	}
}