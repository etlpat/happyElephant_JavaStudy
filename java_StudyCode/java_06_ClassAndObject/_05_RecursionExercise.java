import java.util.*;




// 递归案例1：老鼠走迷宫
// (1)创建迷宫(init maze):
// 	创建row行，col的迷宫。墙用1表示，路用0表示
// 	用int类二维数组表示迷宫，一共row+2行，col+2列，周围一圈是墙壁
//	随机生成wallNum个墙壁
// 
// (2)老鼠找路(mouse find way)：
//	1.迷宫入口是1行1列，出口是row行cow列
//  2.迷宫的值：(0)路没被走过，(1)墙，(2)被走过且可通向终点，(3)被走过但走不通
// 	3.寻路方式：下右上左
// 	4.返回值为boolean，true表示当前坐标能(一次性)通向终点
// 	
// 注意：由于某一点会向四周所有方位递归，所有只需要判断没有走过的坐标即可；
// 		 若再次递归已经走过的坐标，会造成重复遍历
// 		 【因此，递归的条件是(0：没被走过)，而不是(!1：非墙)】



class _05_Maze {// 迷宫类

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
	// 
	// 思路：1.老鼠当前下标是(i,j)，迷宫出口下标是(map.length-2, map[0].length-2)
	// 		2.迷宫值：(0)路没被走过； (1)墙； (2)被走过且可(一次性)通向终点； (3)被走过但走不通
	// 		3.寻路方式：下右上左
	// 		4.返回值为boolean，true表示当前坐标能(一次性)通向终点
	// 		
	// 注意：由于某一点会向四周所有方位递归，所有只需要判断没有走过的坐标即可；
	// 		 若再次递归已经走过的坐标，会造成重复遍历
	// 		 【因此，递归的条件是(0：没被走过)，而不是(!1：非墙)】
	// 		 
	public boolean mouseFindWay(int[][] map, int i, int j){// i、j是当前位置下标
		if(map[map.length-2][map[0].length-2] == 2){// 结束条件：终点值被赋为2
			return true;
		} else {
			if(map[i][j] == 0){// 0表示路没被走过，向下右上左四个方向依次遍历
				map[i][j] = 2;// 假设该坐标可通向终点
				if(mouseFindWay(map, i + 1, j)){
					return true;// 若该坐标下方可通向终点，则返回该坐标可通向终点
				} 
				else if(mouseFindWay(map, i, j + 1)){
					return true;
				}			
				else if(mouseFindWay(map, i - 1, j)){
					return true;
				}			
				else if(mouseFindWay(map, i, j - 1)){
					return true;
				} else {// 若四个方向都为false(都走不通或被遍历过)
					map[i][j] = 3;
					return false;
				}
			} else {
				// 若map[i][j]是1、3，表示墙、死路，返回false
				// 若是2，已经遍历过，不能再重复遍历，返回false（不是第一次遍历，说明该点不能一次性通向终点）
				return false;
			}
		}
	}
}


public class _05_RecursionExercise {
	public static void main(String[] args) {
		_05_Maze maze = new _05_Maze();

		int[][] map = maze.initMaze(20, 20, 100);
		maze.printMaze(map);// 打印初始地图

		System.out.println();
		maze.mouseFindWay(map, 1, 1);// 老鼠从(1,1)进入迷宫
		maze.printMaze(map);
	}
}






























// 递归案例2：汉诺塔
// 汉诺塔：有A、B、C三根石柱，A上从大到小放着n个圆盘。要把A上的圆盘，借助B，全部放到C上
// 要求：小圆盘上不能放大圆盘，一次只能移动1个圆盘
// 提示：借助栈先进先出的规则可以模拟在柱子上移动圆盘


class _05_Stack {
	char name;
	int maxSize;
	int stackSize;
	char[] charStack;

	_05_Stack(int maxSize1, char name1) {// 构造方法
		name = name1;
		maxSize = maxSize1;
		charStack = new char[maxSize];
		stackSize = 0;
	}

	public boolean push(char ch) {// 入栈
		if(stackSize == maxSize){
			return false;
		}
		charStack[stackSize] = ch;
		stackSize++;
		return true;
	}

	public char pop() {// 出栈
		if(stackSize == 0){
			return '\0';
		}
		stackSize--;
		return charStack[stackSize];
	}

	public void printStack() {// 打印栈内元素(从栈底到栈顶)
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

	// 返回值：盘子从a柱全部移动到c的次数
	// 参数：num表示总共移动盘子的个数；a、b、c三个栈，用以模拟三座汉诺塔
	// 参数位置：(num, a, b, c)表示【整体移动num个盘子，从a上，借助b，移到c】
	// 						      【移动的盘数, 起始栈, 中间栈, 目标栈】
	// 
	// 思路(将A栈的所有盘子移动到C栈)：
	// 	(1)若只有一个盘：直接从A栈移动到C栈
	// 	(2)若有多个盘：看成两个整体
	// 		1.将上面num-1个盘子整体，从a移动到b
	// 		2.将a最下面的盘子从a移动到c
	// 		3.将b上num-1个盘子整体，从b移动到c
	// 
	public int HanoiTowerMove(int num, _05_Stack a, _05_Stack b, _05_Stack c) {
		if(num == 1){
			// 若A上只有一个盘子：直接移到C栈
			c.push(a.pop());
			System.out.println(a.name + " -> " + c.name);
			return 1;

		} else {
			// 将num个盘看成两个，最下面的和上面的所有
			int n1 = HanoiTowerMove(num - 1, a, c, b);// 将num-1个盘，从a上，借助c，放入b
			int n2 = HanoiTowerMove(1, a, b, c);
			int n3 =  HanoiTowerMove(num - 1, b, a, c);
			// 等价关系：以上三步将整个a塔搬运到c塔
			return n1 + n2 + n3;
		}
	}
}


class _05_Test1 {
	public static void main(String[] args) {
		// 创建汉诺塔对象
		_05_HanoiTower hanoi = new _05_HanoiTower();
		// 创建栈对象(模拟汉诺塔的柱子)
		_05_Stack stackA = new _05_Stack(100, 'a');
		_05_Stack stackB = new _05_Stack(100, 'b');
		_05_Stack stackC = new _05_Stack(100, 'c');
		// A塔初始盘子的个数
		int num = 6;


		// 从栈底到栈顶，存入盘子
		// (用字母从大到小代替盘子从大到小)
		for(int i = num - 1; i >= 0; i--){
			stackA.push((char)('a' + i));
		}		
		
		// 栈底到栈顶打印盘子
		stackA.printStack();// f e d c b a
		stackB.printStack();// null
		stackC.printStack();// null

		// 挪动盘子
		System.out.println();
		int n = hanoi.HanoiTowerMove(num, stackA, stackB, stackC);
		System.out.println("盘子交换的次数为：" + n + "次\n");// 63

		stackA.printStack();// null
		stackB.printStack();// null
		stackC.printStack();// f e d c b a
	}
}






























// 递归案例3：八皇后
// 题目要求：在8*8的棋盘中，放8个皇后，保证每个皇后都不能互相攻击
// 皇后攻击规则：皇后可以攻击其坐标所在的行、列、斜线上的棋子


class _05_EightEmpresses {

	// 初始化棋盘
	public int[][] initMap() {
		int[][] map = new int[8][8];
		return map; 
	}

	// 打印地图(的图形)
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

	// 打印地图(的值)
	public void printMapValue(int[][] map) {
		int n = 1;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++){
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
	}


	// 方法：放置八皇后
	// 功能：指定初始位置(第0行，任意列)，将map变为八皇后的一种解法
	// 
	// 遍历规则：从上到下(0行->7行)，从左到右(0列->7列)
	// 棋盘：0表示空位，-9~-1表示皇后，1~8表示皇后攻击范围(不可下子)
	// 返回值：true 当前情况存在真解
	// 
	// 思路：
	// 	1.规则：0表示当前坐标可以放皇后
	// 		   假如当前坐标为0，将下标设为-9，表示皇后(8个皇后攻击范围最高是8，-9保证皇后一直为负)
	// 		   然后将皇后的行、列、斜线方向数值++(正数表示皇后的攻击范围)
	// 	2.递归：若当前行放置好皇后，那么开始放下一行的皇后...直到放置好8个皇后结束递归
	// 	3.结束条件：结束条件：棋盘行数下标为(0~7)，当7行放好后，行数变为8，返回true
	// 	
	public boolean setEmpress(int[][] map, int i, int j){
		if(i == map.length){
			// 结束条件：i=9，说明前8行已经放好皇后
			return true;
		} else {
			if(map[i][j] == 0) {
				// 将该皇后的攻击范围的数字自增(1-8表示攻击范围)
				for(int x = 0; x < map.length; x++){
					for(int y = 0; y < map[x].length; y++){
						if(x == i || y == j || y == x + j - i || y == -x + i + j){
							map[x][y]++;
						}
					}
				}
				int tmp = map[i][j];
				// 将皇后置为-9(保证可以一直是负数)
				map[i][j] = -9;

				// 向更高层递归(行+1，列从左到右)
				for(int k = 0; k < map[0].length; k++){
					if(setEmpress(map, i+1, k)){
						return true;
					}
				}

				// 假如下一层每个坐标都返回false，那么这个坐标不是皇后
				map[i][j] = tmp;// 置回将皇后置为原先的值
				for(int x = 0; x < map.length; x++){// 去掉一层攻击范围
					for(int y = 0; y < map[x].length; y++){
						if(x == i || y == j || y == x + j - i || y == -x + i + j){
							map[x][y]--;
						}
					}
				}
				return false;

			} else {
				// 该坐标是皇后/攻击范围中
				return false;
			}
		}
	}

}


class _05_Test2 {
	public static void main(String[] args) {
		EightEmpresses emp8 = new EightEmpresses();
		//初始化棋盘
		int[][] map = emp8.initMap();
		// 打印棋盘
		emp8.printMapPirture(map);

		boolean b = false;
		for(int j = 0; j < 8; j++){
			// 八皇后游戏开始：
			b = emp8.setEmpress(map, 0, j);

			// 打印棋盘
			System.out.println("\n第" + (j+1) + "次：\n函数返回：" + b);
			emp8.printMapPirture(map);
			// 重置地图
			map = emp8.initMap();
		}
	}
}