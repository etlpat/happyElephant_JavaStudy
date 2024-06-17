import java.util.*;    


public class Draft{
	public static void main(String[] args) {
		Tool.printArr(args);
	}
}

class Tool{
	public static void printArr(String[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}