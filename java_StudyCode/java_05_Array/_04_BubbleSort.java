// bubble sort�� ð������

import java.util.*;



// ð������
// ��Ŀ����������һ��������������С�����������
// 
// ˼·��1.����n��Ԫ�����򣬾�ѭ��n-1��
// 		2.ÿ�˴�ǰ����ȶԽ���Ԫ�أ����ϴ�Ļ�������
// 		3.��n��Ԫ�����һ�˽���n-1�Σ�֮��ÿ�˽���������һ�ݼ�




public class _04_BubbleSort {
	public static void main(String[] args) {

		// ������������� 
		Random rand = new Random();
		int sz = 100;
		int arr[] = new int[sz];
		for(int i = 0; i < arr.length; i++){
			arr[i] = rand.nextInt(501);
		}

		// ��ӡ����ǰ����
		System.out.println("\t\t==================����ǰ==================");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + "\t");
			if((i + 1) % 10 == 0) System.out.println();
		}

		// ð������
		for(int i = 0; i < arr.length - 1; i++){// �������length-1��
			boolean flag = true;
			for(int j = 0; j < arr.length - 1 - i; j++){// ÿ�˽���length-1-i��
				if(arr[j] > arr[j + 1]){// ��С�Ľ�����ǰ��
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					flag = false;
				}
			}
			if(flag){// �Ż�����
				break;
			}
		}

		// ��ӡ���������
		System.out.println("\n\t\t==================�����==================");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + "\t");
			if((i + 1) % 10 == 0) System.out.println();
		}
	}
}
