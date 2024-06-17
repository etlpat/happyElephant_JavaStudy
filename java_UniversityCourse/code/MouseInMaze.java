import java.util.*;


class Maze {

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
	// ��������ά����(�Թ�)����������(��ʼ����Ϊ(0,0))
	// ����ֵ��true��ʾ��ǰ�������ֱ��(�����ظ���·)�ߵ��յ�
	// Ѱ·��ʽ����������
	public boolean mouseFindWay(int[][] map, int i, int j, int m) {
		if(map[map.length-2][map[0].length-2] == 2){
			// �����������ݹ��ߵ�
			return true;
		} else {
			if(map[i][j] == 0){// ��������������·������ֱͨ�յ�
				// ��Ŀǰ����û���ݹ��
				map[i][j] = 2;
				if(m == 1){
					return sdwa(map, i, j, m);// �ݹ������������
				} else {
					return wdsa(map, i, j, m);// ��������
				}
			} else {// ���������ѱ�������(�ظ�)��������ֱͨ(�����ظ�)�յ�
				// ��ǰ�����Ѿ���������/ǽ/��·
				// (���õ��ѱ�����������ô������ÿ��·�̶������ظ�֮ǰ������һ�飬������)
				return false;
			}
		}
	}


	public boolean sdwa(int[][] map, int i, int j, int m) {// ����˳����������
		if(mouseFindWay(map, i+1, j, m)){// ��
			return true;// ���·��������ֱͨ�յ㣬����true
		} else if(mouseFindWay(map, i, j+1, m)){// ��
			return true;
		} else if(mouseFindWay(map, i-1, j, m)){// ��
			return true;
		} else if(mouseFindWay(map, i, j-1, m)){// ��
			return true;
		} else{
			// ���������Ҷ�����·(������)/��������(�ظ�����·)
			// ��ô�Ѹõ���Ϊ��·
			map[i][j] = 3;
			return false;
		}
	}


	public boolean wdsa(int[][] map, int i, int j, int m) {// ����˳����������
		if(mouseFindWay(map, i-1, j, m)){
			return true;
		} else if(mouseFindWay(map, i, j+1, m)){// ��
			return true;
		} else if(mouseFindWay(map, i+1, j, m)){// ��
			return true;
		} else if(mouseFindWay(map, i, j-1, m)){// ��
			return true;
		} else{
			map[i][j] = 3;
			return false;
		}
	}




}




public class MouseInMaze {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Maze maze = new Maze();

		// ��ʼ���Թ�
		int[][] map = maze.initMaze(20, 20, 100);
		// ��ӡ�Թ�
		maze.printMaze(map);

		System.out.print("������Ѱ·ģʽ(1.��������)(2.��������)��");
		int m = sc.nextInt();
		if(m == 1 || m == 2){
			// �������Թ�
			maze.mouseFindWay(map, 1, 1, m);
		} else{
			System.out.print("������󣬳������ :(");
		}
		// ��ӡ�Թ�
		maze.printMaze(map);
	}
}