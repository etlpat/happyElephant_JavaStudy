import java.util.*;



// ��Ŀ1��(ԭ��)��������
// ˼·��1.����ǰһ������  2.��ǰ���Ӧλ��Ԫ�ؽ���

public class _03_ArrayExercise {
 	public static void main(String[] args) {
 		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
 		int len = arr.length;

 		for(int i = 0; i < len / 2; i++){
 			int tmp = arr[i];
 			arr[i] = arr[len - 1 - i];
 			arr[len - 1 - i] = tmp;
 		}

 		for(int i = 0; i < len; i++)
 			System.out.print(arr[i] + " ");// 9 8 7 6 5 4 3 2 1
 	}
 }






// ��Ŀ2����������Ԫ��
// Ҫ���Զ���һ�����飬��Ϊ�����һ����Ԫ�أ�֮���ѯ���Ƿ�������(y/n)
// ˼·��1.ԭ������arr������һ����arr��һ��Ԫ�ص�������newArr
//      2.��arr�����ݿ�����newArr�У����Զ���newArr�����һ��Ԫ��
//      3.��arr=newArr��arr��ΪnewArr�ռ�����ã���arr�Ŀռ�����û�����ù�ϵ���Զ��ͷ�

 class _03_ArrayChange {
 	public static void main(String[] args) {
 		Scanner sc = new Scanner(System.in);

 		System.out.print("����Ҫ����һ���������飿��");
 		int sz = sc.nextInt();
 		int arr[] = new int[sz];
 		for(int i = 0; i < sz; i++){
 			System.out.print("��" + (i+1) + "��Ԫ���ǣ���");
 			arr[i] = sc.nextInt();
 		}

 		System.out.println("���鴴���ɹ������������ǣ�");
 		for(int i = 0; i < arr.length; i++){
 			System.out.print(arr[i] + " ");
 		}
 		System.out.println("");


 		while(true) {
 			char choose;
 			System.out.print("�Ƿ�������Ԫ�أ�(y/n)��");
 			while(true) {
	 			choose = sc.next().charAt(0);
	 			if(choose == 'y' || choose == 'n'){
	 				break;
	 			}
	 			System.out.print("�����������������(y/n)��");
 			}
 			if(choose == 'n'){
 				break;
 			}


 			int newArr[] = new int[arr.length + 1];
 			for(int i = 0; i < arr.length; i++){
 				newArr[i] = arr[i];
 			}
 			System.out.print("��������Ԫ�أ�");
 			newArr[arr.length] = sc.nextInt();

 			arr = newArr;// ��arrָ��newArr�Ŀռ�
 			// �������������ͣ�ԭ����arr�Ŀռ�����û�����ù�ϵ�����Զ�����
 		}

 		if(arr.length > sz){
	 		System.out.println("���Ԫ�سɹ������������ǣ�");
	 		for(int i = 0; i < arr.length; i++){
	 			System.out.print(arr[i] + " ");
	 		}
 		}
 	}
 }