package test1;

public class Factorial {
    public int fac1(int num) {
        if (num == 0) {
            return 1;
        } else if (num < 0) {
            return -1;
        }
        int n = 1;
        for (int i = 1; i <= num; i++) {
            n *= i;
        }
        return n;
    }

    public int fac2(int num) {
        if (num < 0) {
            return -1;
        } else if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * fac2(num - 1);
        }
    }
}
