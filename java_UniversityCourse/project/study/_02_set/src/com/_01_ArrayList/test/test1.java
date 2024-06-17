package com._01_ArrayList.test;

// 案例：有一个ArrayList类型的购物车，其中包含：
//      {"宁夏枸杞", "黑枸杞", "C++PrimePlus", "大红袍", "特技枸杞", "茶叶", "枸杞子", "大枸杞"}
//      若用户不想买枸杞了，请将全部枸杞从ArrayList中删除


import java.util.ArrayList;

public class test1 {
    public static void main(String[] args) {
        ArrayList<String> shoppingCart = new ArrayList<>();
        String[] arr = {"宁夏枸杞", "黑枸杞", "C++PrimePlus", "大红袍", "特技枸杞", "茶叶", "枸杞子", "大枸杞"};
        arrayListAddElementArr(shoppingCart, arr);

        printShoppingCart(shoppingCart);// 购物车-[1:宁夏枸杞, 2:黑枸杞, 3:C++PrimePlus, 4:大红袍, 5:特技枸杞, 6:茶叶, 7:枸杞子, 8:大枸杞]
        // 删除并返回枸杞
        ArrayList<String> matrimonyVineArrayList = deleteMatrimonyVine(shoppingCart);
        printShoppingCart(shoppingCart);// 购物车-[1:C++PrimePlus, 2:大红袍, 3:茶叶]
        System.out.println(matrimonyVineArrayList);// [宁夏枸杞, 黑枸杞, 特技枸杞, 枸杞子, 大枸杞]
    }


    // 方法：向ArrayList内添加String数组元素
    public static boolean arrayListAddElementArr(ArrayList<String> arrayList, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }
        return true;
    }


    // 方法：打印购物车
    public static void printShoppingCart(ArrayList<String> arrayList) {
        System.out.print("购物车-[");
        for (int i = 0; i < arrayList.size() - 1; i++) {
            System.out.print((i + 1) + ":" + arrayList.get(i) + ", ");
        }
        System.out.println(arrayList.size() + ":" + arrayList.get(arrayList.size() - 1) + "]");
    }


    // 方法：删除购物车中的枸杞（并返回被删除的枸杞ArrayList）
    public static ArrayList<String> deleteMatrimonyVine(ArrayList<String> arrayList) {
        String matrimonyVine = "枸杞";
        ArrayList<String> matrimonyVineArrayList = new ArrayList<>();// 创建枸杞ArrayList
        for (int i = 0; i < arrayList.size(); ) {
            if (arrayList.get(i).contains(matrimonyVine)) {// 若当前元素中包含"枸杞"两个字
                matrimonyVineArrayList.add(arrayList.remove(i));// 删除当前元素，并存入枸杞集合
            } else {
                // 注意：ArrayList的元素位置会动态变动，若将下标为2的元素删除，后面下标为3的元素就会回来填补2下标的位置
                i++;// 因此：只有本次不进行删除操作，i才自增
            }
        }
        return matrimonyVineArrayList;// 返回枸杞集合
    }
}
