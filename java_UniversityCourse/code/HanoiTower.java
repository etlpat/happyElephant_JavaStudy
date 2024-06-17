

class CharStack {
	char name;
	int maxSize;
	int stackSize;
	char[] charStack;

	CharStack(int maxSize1, char name1) {// 构造方法
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


class Move {
	// 整体将num个盘子，从a->c
	public int HanoiTowerMove(int num, CharStack a, CharStack b, CharStack c){
		if(num == 1){
			c.push(a.pop());
			System.out.println(a.name + " -> " + c.name);
			return 1;
		} else {
			int n1 = HanoiTowerMove(num - 1, a, c, b);
			int n2 = HanoiTowerMove(1, a, b, c);
			int n3 = HanoiTowerMove(num - 1, b, a, c);
			return n1 + n2 + n3;
		}
	}
}




public class HanoiTower {
 	public static void main(String[] args) {
 		CharStack a = new CharStack(100, 'a');
 		CharStack b = new CharStack(100, 'b');
 		CharStack c = new CharStack(100, 'c');
 		Move m = new Move();
 		int num = 6;

 		// 栈底->栈顶，存放字母 大->小，用来模拟盘子大小顺序
		for(int i = num - 1; i >= 0; i--){
			a.push((char)('a' + i));
		}	

		a.printStack();	
		b.printStack();	
		c.printStack();	

		int n = m.HanoiTowerMove(num, a, b, c);
		System.out.println("共移动 " + n + " 次");

		a.printStack();	
		b.printStack();	
		c.printStack();	


 	}
}