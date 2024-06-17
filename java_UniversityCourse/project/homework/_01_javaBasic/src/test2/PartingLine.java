package test2;

public class PartingLine {
    public void printChar(int n, char ch) {
        for (int i = 0; i < n; i++) {
            System.out.print(ch);
        }
    }

    public void printPartingLine(int n) {
        // 打印上三角
        for (int i = 1; i <= n; i++) {
            printChar(i, '*');
            System.out.println();
        }
        // 打印分割线
        printChar(10, '-');
        System.out.print("我是华丽的分界线");
        printChar(10, '-');
        System.out.println();
        // 打印下三角
        for (int i = n; i >= 1; i--) {
            printChar(i, '*');
            System.out.println();
        }
    }
}
