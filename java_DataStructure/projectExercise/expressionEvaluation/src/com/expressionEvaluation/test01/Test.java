package com.expressionEvaluation.test01;

// 用栈实现表达式的运算【中缀->后缀】
//
// (1)思路：
//  1.将中缀表达式按左优先的顺序转化为后缀表达式
//  e.g.中缀：A+B-C*D/E+F => 后缀：AB+CD*E/-F+
//      后缀表达式符号从左到右顺序，表示中缀表达式运算符的计算顺序
//  2.用栈完成后缀表达式的运算
//
//
// (2)代码实现
//  1.用【运算符栈】实现中缀表达式转后缀表达式
//    e.g.A+B-C*D/E+F*(G-H)-I => AB+CD*E/-FGH-*+I-
//    步骤：①遇到操作数：直接加入后缀表达式
//        ②若遇到运算符：依次弹出栈内优先级大于等于当前运算符的所有运算符，并使它们加入后缀表达式。（直到碰到“(”或栈空则停止）
//                     之后把当前运算符入栈。
//        ③若遇到界限符：若遇到“(”，则直接将其入栈；
//                     若遇到“)”，则依次弹出栈内运算符并将其加入后缀表达式，直到遇到“(”为止。
//
//  2.用【操作数栈】实现后缀表达式求值
//    步骤：①若遇到操作数，则让操作数入栈，
//          若遇到运算符，则让两个操作数出栈并用该运算符计算，将结果重新入栈
//        ②重复步骤①，直到表达式运算完为止，此时栈中唯一的操作数，就是表达式的结果
//
//
// (3)注意事项
//  这里我们用左优先，将中缀->后缀，运算符优先顺序为从左到右【计算机中统一用后缀】
//  用右优先，将中缀->前缀，运算顺序从右到左，也能达到同样的效果


public class Test {
    public static void main(String[] args) {
        // 以下为一些表达式，右面是正确答案
        String s1 = "(5 + 3 / 4) * 6 - 7 + 8";  // 35.5
        String s2 = "(4 - 2 / 3) * 5 / 4 + 6";  // 10.166666666666666666666666666667
        String s3 = "(2 + 4 / 5) * 3 - 6 / 2";  // 5.4
        String s4 = "4 - (2 / 3 - 6 + 8)";      // 1.3333333333333333333333333333333
        String s5 = "(9 - 6) * (4 + 5) - 7";    // 20
        String s6 = "(8 - 6 + 4) * 5 / 2";      // 15
        String s7 = "(10 - 8 + 6) * 4 / 2";     // 16
        String s8 = "((15/(7-(1+1)))*3)-(2+(1+1))";// 5


        ExpressionEvaluation ee = new ExpressionEvaluation();

        // (1)将表达式转化为数组
        MyTools.printArr(ee.expressionToStringArray(s1));// {(, 5, +, 3, /, 4, ), *, 6, -, 7, +, 8}
        MyTools.printArr(ee.expressionToStringArray(s2));// {(, 4, -, 2, /, 3, ), *, 5, /, 4, +, 6}
        MyTools.printArr(ee.expressionToStringArray(s8));// {(, (, 15, /, (, 7, -, (, 1, +, 1, ), ), ), *, 3, ), -, (, 2, +, (, 1, +, 1, ), )}


        // (2)计算表达式求值
        System.out.println(ee.evaluation(s1));// 35.5
        System.out.println(ee.evaluation(s2));// 10.166666666666668
        System.out.println(ee.evaluation(s3));// 5.399999999999999
        System.out.println(ee.evaluation(s4));// 1.333333333333333
        System.out.println(ee.evaluation(s5));// 20.0
        System.out.println(ee.evaluation(s6));// 15.0
        System.out.println(ee.evaluation(s7));// 16.0
        System.out.println(ee.evaluation(s8));// 5.0
    }
}
