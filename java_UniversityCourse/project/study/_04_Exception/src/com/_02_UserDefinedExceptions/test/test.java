package com._02_UserDefinedExceptions.test;

// 编译时异常，只要写出来，编译器就会给出错误提示
// 此时我们可以用throws，将编译器的报错传给上一层。上一层的方法调用语句会有错误提示。
//
// 编译时异常(编译器会报红线)，只有用throws层层上传，最后传到try-catch中，红线才会消失


public class test {
    public static void main(String[] args) {
        boolean flag = false;
        try {
            int age = setAge(130);
        } catch (AgeIllegalException ae) {
            flag = true;
            System.out.println(ae);
        } finally {
            if (flag) {
                System.out.println("年龄范围错误！");
            } else {
                System.out.println("年龄范围正确！");
            }
        }
    }

    public static int setAge(int num) throws AgeIllegalException {
        if (num < 0 || num > 120) {
            throw new AgeIllegalException("编译时异常-年龄超出[0,120]范围，你设置的年龄：" + num);
        }
        return num;
    }
}


