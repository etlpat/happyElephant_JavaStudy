import java.util.*;




// �ݹ鰸��1���������Թ�
// (1)�����Թ�(init maze):
// 	����row�У�col���Թ���ǽ��1��ʾ��·��0��ʾ
// 	��int���ά�����ʾ�Թ���һ��row+2�У�col+2�У���ΧһȦ��ǽ��
//	�������wallNum��ǽ��
// 
// (2)������·(mouse find way)��
//	1.�Թ������1��1�У�������row��cow��
//  2.�Թ���ֵ��(0)·û���߹���(1)ǽ��(2)���߹��ҿ�ͨ���յ㣬(3)���߹����߲�ͨ
// 	3.Ѱ·��ʽ����������
// 	4.����ֵΪboolean��true��ʾ��ǰ������(һ����)ͨ���յ�
// 	
// ע�⣺����ĳһ������������з�λ�ݹ飬����ֻ��Ҫ�ж�û���߹������꼴�ɣ�
// 		 ���ٴεݹ��Ѿ��߹������꣬������ظ�����
// 		 ����ˣ��ݹ��������(0��û���߹�)��������(!1����ǽ)��



class _05_Maze {// �Թ���

	// ����1�������Թ�
	public int[][] initMaze(int row, int col, int wallNum) {
		Random rand = new Random();
		int[][] map = new int[row + 2][col + 2];
		for(int i = 0; i < map.length; i++){// ������Χǽ��
			for(int j = 0; j < map[i].length; j++){
				if(i==0 || i==map.length-1 || j==0 || j==map[i].length-1){
					map[i][j] = 1;
				} 
			}
		}
		for(int n = 0; n < wallNum; n++) {// ��������ϰ�
			int x = rand.nextInt(row) + 1;// [1, row]
			int y = rand.nextInt(col) + 1;// [1, col]
			if(map[x][y] == 1 || (x==1 && y==1) || (x==row && y==col)) {
				n--;// ��֤�ϰ��������ڳ���ڻ��ظ�����
			} else {
				map[x][y] = 1;
			}
		}
		return map;
	}


	// ����2����ӡ�Թ�
	public void printMaze(int[][] map) {
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				switch(map[i][j]) {
				case 0:
					System.out.print("  ");
					break;				
				case 1:
					System.out.print("# ");
					break;			
				case 2:
					System.out.print("0 ");
					break;		
				case 3:
					System.out.print("X ");		
					break;
				}
			}
			System.out.println();
		}
	}


	// ����3��������·
	// 
	// ˼·��1.����ǰ�±���(i,j)���Թ������±���(map.length-2, map[0].length-2)
	// 		2.�Թ�ֵ��(0)·û���߹��� (1)ǽ�� (2)���߹��ҿ�(һ����)ͨ���յ㣻 (3)���߹����߲�ͨ
	// 		3.Ѱ·��ʽ����������
	// 		4.����ֵΪboolean��true��ʾ��ǰ������(һ����)ͨ���յ�
	// 		
	// ע�⣺����ĳһ������������з�λ�ݹ飬����ֻ��Ҫ�ж�û���߹������꼴�ɣ�
	// 		 ���ٴεݹ��Ѿ��߹������꣬������ظ�����
	// 		 ����ˣ��ݹ��������(0��û���߹�)��������(!1����ǽ)��
	// 		 
	public boolean mouseFindWay(int[][] map, int i, int j){// i��j�ǵ�ǰλ���±�
		if(map[map.length-2][map[0].length-2] == 2){// �����������յ�ֵ����Ϊ2
			return true;
		} else {
			if(map[i][j] == 0){// 0��ʾ·û���߹��������������ĸ��������α���
				map[i][j] = 2;// ����������ͨ���յ�
				if(mouseFindWay(map, i + 1, j)){
					return true;// ���������·���ͨ���յ㣬�򷵻ظ������ͨ���յ�
				} 
				else if(mouseFindWay(map, i, j + 1)){
					return true;
				}			
				else if(mouseFindWay(map, i - 1, j)){
					return true;
				}			
				else if(mouseFindWay(map, i, j - 1)){
					return true;
				} else {// ���ĸ�����Ϊfalse(���߲�ͨ�򱻱�����)
					map[i][j] = 3;
					return false;
				}
			} else {
				// ��map[i][j]��1��3����ʾǽ����·������false
				// ����2���Ѿ����������������ظ�����������false�����ǵ�һ�α�����˵���õ㲻��һ����ͨ���յ㣩
				return false;
			}
		}
	}
}


public class _05_RecursionExercise {
	public static void main(String[] args) {
		_05_Maze maze = new _05_Maze();

		int[][] map = maze.initMaze(20, 20, 100);
		maze.printMaze(map);// ��ӡ��ʼ��ͼ

		System.out.println();
		maze.mouseFindWay(map, 1, 1);// �����(1,1)�����Թ�
		maze.printMaze(map);
	}
}






























// �ݹ鰸��2����ŵ��
// ��ŵ������A��B��C����ʯ����A�ϴӴ�С����n��Բ�̡�Ҫ��A�ϵ�Բ�̣�����B��ȫ���ŵ�C��
// Ҫ��СԲ���ϲ��ܷŴ�Բ�̣�һ��ֻ���ƶ�1��Բ��
// ��ʾ������ջ�Ƚ��ȳ��Ĺ������ģ�����������ƶ�Բ��


class _05_Stack {
	char name;
	int maxSize;
	int stackSize;
	char[] charStack;

	_05_Stack(int maxSize1, char name1) {// ���췽��
		name = name1;
		maxSize = maxSize1;
		charStack = new char[maxSize];
		stackSize = 0;
	}

	public boolean push(char ch) {// ��ջ
		if(stackSize == maxSize){
			return false;
		}
		charStack[stackSize] = ch;
		stackSize++;
		return true;
	}

	public char pop() {// ��ջ
		if(stackSize == 0){
			return '\0';
		}
		stackSize--;
		return charStack[stackSize];
	}

	public void printStack() {// ��ӡջ��Ԫ��(��ջ�׵�ջ��)
		if(stackSize == 0){
			System.out.println("null");
		}
		else {
			for(int i = 0; i < stackSize; i++){
				System.out.print(charStack[i] + " ");
			}
			System.out.println();
		}
	}
}


class _05_HanoiTower {

	// ����ֵ�����Ӵ�a��ȫ���ƶ���c�Ĵ���
	// ������num��ʾ�ܹ��ƶ����ӵĸ�����a��b��c����ջ������ģ��������ŵ��
	// ����λ�ã�(num, a, b, c)��ʾ�������ƶ�num�����ӣ���a�ϣ�����b���Ƶ�c��
	// 						      ���ƶ�������, ��ʼջ, �м�ջ, Ŀ��ջ��
	// 
	// ˼·(��Aջ�����������ƶ���Cջ)��
	// 	(1)��ֻ��һ���̣�ֱ�Ӵ�Aջ�ƶ���Cջ
	// 	(2)���ж���̣�������������
	// 		1.������num-1���������壬��a�ƶ���b
	// 		2.��a����������Ӵ�a�ƶ���c
	// 		3.��b��num-1���������壬��b�ƶ���c
	// 
	public int HanoiTowerMove(int num, _05_Stack a, _05_Stack b, _05_Stack c) {
		if(num == 1){
			// ��A��ֻ��һ�����ӣ�ֱ���Ƶ�Cջ
			c.push(a.pop());
			System.out.println(a.name + " -> " + c.name);
			return 1;

		} else {
			// ��num���̿���������������ĺ����������
			int n1 = HanoiTowerMove(num - 1, a, c, b);// ��num-1���̣���a�ϣ�����c������b
			int n2 = HanoiTowerMove(1, a, b, c);
			int n3 =  HanoiTowerMove(num - 1, b, a, c);
			// �ȼ۹�ϵ����������������a�����˵�c��
			return n1 + n2 + n3;
		}
	}
}


class _05_Test1 {
	public static void main(String[] args) {
		// ������ŵ������
		_05_HanoiTower hanoi = new _05_HanoiTower();
		// ����ջ����(ģ�⺺ŵ��������)
		_05_Stack stackA = new _05_Stack(100, 'a');
		_05_Stack stackB = new _05_Stack(100, 'b');
		_05_Stack stackC = new _05_Stack(100, 'c');
		// A����ʼ���ӵĸ���
		int num = 6;


		// ��ջ�׵�ջ������������
		// (����ĸ�Ӵ�С�������ӴӴ�С)
		for(int i = num - 1; i >= 0; i--){
			stackA.push((char)('a' + i));
		}		
		
		// ջ�׵�ջ����ӡ����
		stackA.printStack();// f e d c b a
		stackB.printStack();// null
		stackC.printStack();// null

		// Ų������
		System.out.println();
		int n = hanoi.HanoiTowerMove(num, stackA, stackB, stackC);
		System.out.println("���ӽ����Ĵ���Ϊ��" + n + "��\n");// 63

		stackA.printStack();// null
		stackB.printStack();// null
		stackC.printStack();// f e d c b a
	}
}






























// �ݹ鰸��3���˻ʺ�
// ��ĿҪ����8*8�������У���8���ʺ󣬱�֤ÿ���ʺ󶼲��ܻ��๥��
// �ʺ󹥻����򣺻ʺ���Թ������������ڵ��С��С�б���ϵ�����


class _05_EightEmpresses {

	// ��ʼ������
	public int[][] initMap() {
		int[][] map = new int[8][8];
		return map; 
	}

	// ��ӡ��ͼ(��ͼ��)
	public void printMapPirture(int[][] map) {
		int n = 1;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++){
				if(map[i][j] == 0){
					System.out.print("# ");
				} else if(map[i][j] > 0){
					System.out.print("X ");
				} else {
					System.out.print(n + " ");
					n++;
				}
			}
			System.out.println();
		}
	}

	// ��ӡ��ͼ(��ֵ)
	public void printMapValue(int[][] map) {
		int n = 1;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++){
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
	}


	// ���������ð˻ʺ�
	// ���ܣ�ָ����ʼλ��(��0�У�������)����map��Ϊ�˻ʺ��һ�ֽⷨ
	// 
	// �������򣺴��ϵ���(0��->7��)��������(0��->7��)
	// ���̣�0��ʾ��λ��-9~-1��ʾ�ʺ�1~8��ʾ�ʺ󹥻���Χ(��������)
	// ����ֵ��true ��ǰ����������
	// 
	// ˼·��
	// 	1.����0��ʾ��ǰ������ԷŻʺ�
	// 		   ���統ǰ����Ϊ0�����±���Ϊ-9����ʾ�ʺ�(8���ʺ󹥻���Χ�����8��-9��֤�ʺ�һֱΪ��)
	// 		   Ȼ�󽫻ʺ���С��С�б�߷�����ֵ++(������ʾ�ʺ�Ĺ�����Χ)
	// 	2.�ݹ飺����ǰ�з��úûʺ���ô��ʼ����һ�еĻʺ�...ֱ�����ú�8���ʺ�����ݹ�
	// 	3.�����������������������������±�Ϊ(0~7)����7�зźú�������Ϊ8������true
	// 	
	public boolean setEmpress(int[][] map, int i, int j){
		if(i == map.length){
			// ����������i=9��˵��ǰ8���Ѿ��źûʺ�
			return true;
		} else {
			if(map[i][j] == 0) {
				// ���ûʺ�Ĺ�����Χ����������(1-8��ʾ������Χ)
				for(int x = 0; x < map.length; x++){
					for(int y = 0; y < map[x].length; y++){
						if(x == i || y == j || y == x + j - i || y == -x + i + j){
							map[x][y]++;
						}
					}
				}
				int tmp = map[i][j];
				// ���ʺ���Ϊ-9(��֤����һֱ�Ǹ���)
				map[i][j] = -9;

				// ����߲�ݹ�(��+1���д�����)
				for(int k = 0; k < map[0].length; k++){
					if(setEmpress(map, i+1, k)){
						return true;
					}
				}

				// ������һ��ÿ�����궼����false����ô������겻�ǻʺ�
				map[i][j] = tmp;// �ûؽ��ʺ���Ϊԭ�ȵ�ֵ
				for(int x = 0; x < map.length; x++){// ȥ��һ�㹥����Χ
					for(int y = 0; y < map[x].length; y++){
						if(x == i || y == j || y == x + j - i || y == -x + i + j){
							map[x][y]--;
						}
					}
				}
				return false;

			} else {
				// �������ǻʺ�/������Χ��
				return false;
			}
		}
	}

}


class _05_Test2 {
	public static void main(String[] args) {
		EightEmpresses emp8 = new EightEmpresses();
		//��ʼ������
		int[][] map = emp8.initMap();
		// ��ӡ����
		emp8.printMapPirture(map);

		boolean b = false;
		for(int j = 0; j < 8; j++){
			// �˻ʺ���Ϸ��ʼ��
			b = emp8.setEmpress(map, 0, j);

			// ��ӡ����
			System.out.println("\n��" + (j+1) + "�Σ�\n�������أ�" + b);
			emp8.printMapPirture(map);
			// ���õ�ͼ
			map = emp8.initMap();
		}
	}
}