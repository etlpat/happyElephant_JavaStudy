package test4;

public class Test {
    public static void main(String[] args) {
        FindSubstring fs = new FindSubstring();
        String[] arr = {"张三", "李四", "王五"};
        fs.printArr(arr);

        // 获得乱码字符串
        String messyStr = fs.createMessyCode(arr);
        System.out.println(messyStr);

        // 获得元组再乱码中的下标
        int[] indexArr = fs.findIndex(messyStr, arr);
        fs.printArr(indexArr);
    }
}
