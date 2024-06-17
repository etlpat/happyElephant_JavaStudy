import java.util.*;


class Maze {

	// 方法1：生成迷宫
	public int[][] initMaze(int row, int col, int wallNum) {
		Random rand = new Random();
		int[][] map = new int[row + 2][col + 2];
		for(int i = 0; i < map.length; i++){// 生成周围墙壁
			for(int j = 0; j < map[i].length; j++){
				if(i==0 || i==map.length-1 || j==0 || j==map[i].length-1){
					map[i][j] = 1;
				} 
			}
		}
		for(int n = 0; n < wallNum; n++) {// 生成随机障碍
			int x = rand.nextInt(row) + 1;// [1, row]
			int y = rand.nextInt(col) + 1;// [1, col]
			if(map[x][y] == 1 || (x==1 && y==1) || (x==row && y==col)) {
				n--;// 保证障碍不生成在出入口或重复生成
			} else {
				map[x][y] = 1;
			}
		}
		return map;
	}


	// 方法2：打印迷宫
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


	// 方法3：老鼠找路
	// 参数：二维数组(迷宫)，老鼠坐标(初始坐标为(0,0))
	// 返回值：true表示当前坐标可以直接(不走重复的路)走到终点
	// 寻路方式：下右上左
	public boolean mouseFindWay(int[][] map, int i, int j, int m) {
		if(map[map.length-2][map[0].length-2] == 2){
			// 结束条件：递归走到
			return true;
		} else {
			if(map[i][j] == 0){// 若该坐标是是新路，可能直通终点
				// 当目前坐标没被递归过
				map[i][j] = 2;
				if(m == 1){
					return sdwa(map, i, j, m);// 递归遍历下右上左
				} else {
					return wdsa(map, i, j, m);// 上右下左
				}
			} else {// 若该坐标已被遍历过(重复)，不可能直通(不走重复)终点
				// 当前坐标已经被遍历过/墙/死路
				// (若该点已被遍历过，那么接下来每步路程都是在重复之前的再走一遍，无意义)
				return false;
			}
		}
	}


	public boolean sdwa(int[][] map, int i, int j, int m) {// 查找顺序：下右上左
		if(mouseFindWay(map, i+1, j, m)){// 下
			return true;// 若下方坐标可以直通终点，返回true
		} else if(mouseFindWay(map, i, j+1, m)){// 右
			return true;
		} else if(mouseFindWay(map, i-1, j, m)){// 上
			return true;
		} else if(mouseFindWay(map, i, j-1, m)){// 左
			return true;
		} else{
			// 若上下左右都是死路(不能走)/被遍历过(重复走老路)
			// 那么把该点设为死路
			map[i][j] = 3;
			return false;
		}
	}


	public boolean wdsa(int[][] map, int i, int j, int m) {// 查找顺序：上右下左
		if(mouseFindWay(map, i-1, j, m)){
			return true;
		} else if(mouseFindWay(map, i, j+1, m)){// 右
			return true;
		} else if(mouseFindWay(map, i+1, j, m)){// 下
			return true;
		} else if(mouseFindWay(map, i, j-1, m)){// 左
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

		// 初始化迷宫
		int[][] map = maze.initMaze(20, 20, 100);
		// 打印迷宫
		maze.printMaze(map);

		System.out.print("请输入寻路模式(1.下右上左)(2.上右下左)：");
		int m = sc.nextInt();
		if(m == 1 || m == 2){
			// 老鼠走迷宫
			maze.mouseFindWay(map, 1, 1, m);
		} else{
			System.out.print("输入错误，程序结束 :(");
		}
		// 打印迷宫
		maze.printMaze(map);
	}
}