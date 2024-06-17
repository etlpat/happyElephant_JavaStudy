package test3;

public class Test {
    public static void main(String[] args) {
        Bubble b = new Bubble();
        int[] arr = b.createArr(20);
        b.printArr(arr);// -43 -52 -34 -25 95 90 15 41 -1 97 -81 -50 0 76 63 38 65 4 -79 -41
        b.bubbleSort(arr);
        b.printArr(arr);// -81 -79 -52 -50 -43 -41 -34 -25 -1 0 4 15 38 41 63 65 76 90 95 97
    }
}
