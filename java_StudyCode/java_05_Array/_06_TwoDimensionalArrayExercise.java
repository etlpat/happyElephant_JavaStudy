import java.util.*;




// ��Ŀ������������뺬��
class _06_Test1 {
	public static void main(String[] args) {

		// ������int���͵�һά����x�Ͷ�ά����y
		// ����x��y����ջ��������ֵΪNULL
		int[] x, y[];
		
		// ��y��ʼ��Ϊ�в�ȷ����ά����
		// Ϊy�ڶ������ٿռ䣬�����3��ֵΪNULL����������
		y = new int[3][];
		
		// Ϊx�ڶ�������3��int�ռ䣬Ĭ�ϴ��0
		x = new int[3];

		// ��y[0]����x�����ã����߲ٿ�ͬһ��ռ�
		y[0] = x;
	}
}







// ��Ŀ����ά�����ӡ�������
// 1 					1
// 1 1 				   1 1 
// 1 2 1 		=>	  1 2 1
// 1 3 3 1 			 1 3 3 1
// 1 4 6 4 1 		1 4 6 4 1
// ˼·��1.��n����n��Ԫ�أ���ĩ��1
// 		2.arr[i][j] = arr[i-1][j-1] + arr[i-1][j]
// 		3.���ܹ�N�У����n��ǰ��ո���N-n

public class _06_TwoDimensionalArrayExercise {
	public static void main(String[] args) {
		int row = 15;
		// �����в�ȷ����ά����
		int[][] arr = new int[row][];

		// ��������������
		for(int i = 0; i < arr.length; i++){
			arr[i] = new int[i + 1];
			for(int j = 0; j < arr[i].length; j++){
				arr[i][j] = (j==0||j==arr[i].length-1) ? 1 : arr[i-1][j-1]+arr[i-1][j];
			}
		}

		// ��ӡ�������(����д��)
		int numWidth = 0;
		int maxNum = arr[arr.length - 1][arr.length / 2 + 1];// ��ȡ������(���һ���м���)
		while(maxNum != 0){// ��ȡ������Ŀ��
			numWidth++;
			maxNum /= 10;
		}
		for(int i = 0; i < arr.length; i++){
			// ��ӡÿ��ǰ�ո�
			int k = (arr.length - i - 1) * numWidth;
			while(k != 0){
				System.out.print(" ");
				k--;
			}
			// ��ӡÿ������
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j]);
				// ��ȡ��ǰ���ֵĿ��
				int tmpWidth = 0;
				int tmpNum = arr[i][j];	
				while(tmpNum != 0){
					tmpWidth++;
					tmpNum /= 10;
				}
				// ��ȡ����ӡÿ������Ŀո���
				int spaceNum = 2 * numWidth - tmpWidth;
				while(spaceNum != 0){
					System.out.print(" ");
					spaceNum--;
				}
			}
			System.out.println();
		}
	}
}







// ��Ŀ������һ����������������飬��Ҫ�����һ��Ԫ�أ������黹������
// ����������������˼·��
// 	1.����Ĭ������ȫ��0����һ�˽�������������ĩλ��֮��ÿ�δ���±�-1
// 	2.��i�ˣ�����±����length-i�������λ�õ�ĩλ���������򽻻�����
class _06_Test2 {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int MaxSize = 10;
		int arr[] = new int[MaxSize];

		// ��������������������飺
		for(int i = arr.length - 1; i >= 0; i--){
			arr[i] = rand.nextInt(100) + 1;
			for(int j = i; j < arr.length - 1; j++){
				if(arr[j] > arr[j + 1]){
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}

		// ��ӡ����
		System.out.println("==========����ǰ==========");
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();


		// ����Ԫ�ز�����
		boolean ifLoop = false;
		boolean ifInsert = false;
		int LoopInsertNum = 0;
		while(true){
			if(ifLoop == false) {
				System.out.print("�Ƿ����Ԫ�أ�(y/n):");
				ifLoop = true;
			} else {
				System.out.print("�Ƿ��������Ԫ�أ�(y/n):");
			}

			char select;
			while(true){
				select = sc.next().charAt(0);
				if(select == 'y' || select == 'n'){
					break;
				}
				System.out.print("������������������(y/n):");
			}
			if(select == 'n'){
				if(ifInsert == false){
					System.out.println("δ���в���");
				} else {
					System.out.println("�������");
				}
				break;
			}

			// ��ȡ��������ֺ��±�
			ifInsert = true;
			LoopInsertNum++;
			System.out.print("��������������:");
			int insertNum = sc.nextInt();
			int insertIndex = 0;
			for(insertIndex = 0; insertIndex < arr.length; insertIndex++){// ��ȡӦ������±�
				if(arr[insertIndex] >= insertNum){
					break;
				}
			}
			// ���ɲ���������
			int arrNew[] = new int[arr.length + 1];
			for(int i = 0, j = 0; i < arrNew.length; i++){
				if(i == insertIndex){
					arrNew[i] = insertNum;
				} else {
					arrNew[i] = arr[j];
					j++;// i����ѭ��������j�ڷ�֧������
						// ���Ա�֤arrNew�ڽ���������֧��ͬʱ��������arr
				}
			}
			arr = arrNew;

			// ��ӡ���
			System.out.println("=========��" + LoopInsertNum + "�β���========");
			for(int i = 0; i < arr.length; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}


		// ��ӡ����
		if(ifInsert){
			System.out.println("=======������������=======");
			for(int i = 0; i < arr.length; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
	}
}

