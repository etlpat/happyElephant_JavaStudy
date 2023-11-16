package com.expressionEvaluation.test01;

public class ExpressionEvaluation {
    private LinkStack numberStack = new LinkStack();// 数字栈，存放操作数
    private LinkStack symbolStack = new LinkStack();// 符号栈，存放标点符号、括号


    // 判断是否为'+''-'
    private boolean isAddOrSubtract(char ch) {
        return ch == '+' || ch == '-';
    }

    // 判断是否为'*''/'
    private boolean isMultiplyOrDivide(char ch) {
        return ch == '*' || ch == '/';
    }

    // 判断是否为'+''-''*''/'
    private boolean isOperator(char ch) {
        return isAddOrSubtract(ch) || isMultiplyOrDivide(ch);
    }

    // 判断是否为'('')'
    private boolean isParentheses(char ch) {
        return ch == '(' || ch == ')';
    }

    // 判断字符是否为数字
    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }


    // 判断运算符优先级（若operator1优先级>=operator2，返回true）
    public boolean judgmentOperatorPriority(char operator1, char operator2) {
        return isMultiplyOrDivide(operator1) && isOperator(operator2) ||// 若operator1为乘除，只要operator2为运算符，就返回true
                isAddOrSubtract(operator1) && isAddOrSubtract(operator2);// 若operator1为加减，只有operator2为加减，才返回true
    }


    // 用指定操作符计算两个操作数
    private Double calculateTwoNumber(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return null;
        }
    }


    // 将表达式的操作数和运算符拆开放入字符串数组，并返回该字符串数组
    public String[] expressionToStringArray(String expression) {
        int operatorNum = 0;// 运算符号数
        int parenthesesNum = 0;// 括号数
        for (int i = 0; i < expression.length(); i++) {// 获取运算符数和括号数
            if (isOperator(expression.charAt(i))) {
                operatorNum++;
            } else if (isParentheses(expression.charAt(i))) {
                parenthesesNum++;
            }
        }

        String[] expArr = new String[2 * operatorNum + 1 + parenthesesNum];

        for (int i = 0, j = 0; j < expression.length(); j++) {// 遍历表达式字符串和字符串数组
            if (isNumber(expression.charAt(j))) {// 若表达式的当前字符是数字
                expArr[i] = "" + expression.charAt(j);
                // 注意：while的判断中的j+1<length，是为了防止后面charAt(j+1)越界访问
                while (j + 1 < expression.length() && isNumber(expression.charAt(j + 1))) {// 将连续的一串数字全部存入数组
                    j++;
                    expArr[i] += expression.charAt(j);
                }
                i++;

            } else if (isOperator(expression.charAt(j)) || isParentheses(expression.charAt(j))) {// 若表达式的当前字符是运算符或括号
                expArr[i] = "" + expression.charAt(j);
                i++;
            }
            // 若表达式当前字符是其他（如空格），只有j自增，i不自增
        }
        return expArr;
    }


    // 将两个数字栈的栈顶元素出栈，并用指定运算符运算，将运算结果重新压回数字栈
    private boolean evaluationTwoNumberOfStack(LinkStack.LNode numNode1, LinkStack.LNode numNode2, char operator) {
        if (!(numberStack.pop(numNode2) && numberStack.pop(numNode1))) {// 数字出栈
            return false;
        }
        numberStack.push(calculateTwoNumber(Double.valueOf(numNode1.getData()), Double.valueOf(numNode2.getData()), operator) + "");// 将运算后的结果入栈
        return true;
    }


    // 进行表达式求值
    public double evaluation(String expression) {
        String[] expArr = expressionToStringArray(expression);
        LinkStack.LNode numNode1 = new LinkStack.LNode();
        LinkStack.LNode numNode2 = new LinkStack.LNode();
        LinkStack.LNode operatorNode = new LinkStack.LNode();

        for (int i = 0; i < expArr.length; i++) {// 将表达式数组的元素入栈并计算

            if (isNumber(expArr[i].charAt(0))) {// 若元素为数字：则让其进入数字栈
                numberStack.push(expArr[i]);

            } else if (isOperator(expArr[i].charAt(0))) {// 若元素是操作符
                // 操作：将优先级>=当前操作符的栈内操作符依次出栈，直到栈空或遇到'('为止；之后将该操作符入栈
                while (!symbolStack.isEmpty() && symbolStack.getTop().charAt(0) != '(' &&   // 当栈不为空，且栈顶不为'('
                        judgmentOperatorPriority(symbolStack.getTop().charAt(0), expArr[i].charAt(0))) { // 且栈顶运算符优先级>=当前操作符
                    symbolStack.pop(operatorNode);// 运算符出栈
                    evaluationTwoNumberOfStack(numNode1, numNode2, operatorNode.getData().charAt(0));// 用被出栈的运算符，计算数字栈顶的两个操作数
                }
                symbolStack.push(expArr[i]);// 循环结束后，将该运算符入栈

            } else if (isParentheses(expArr[i].charAt(0))) {// 若元素是括号
                if (expArr[i].charAt(0) == '(') {// 若是左括号，则入栈
                    symbolStack.push(expArr[i]);
                } else {// 若是右括号，则将运算符依次出栈，直到遇到左括号为止
                    while (symbolStack.getTop().charAt(0) != '(') {
                        symbolStack.pop(operatorNode);// 运算符出栈
                        evaluationTwoNumberOfStack(numNode1, numNode2, operatorNode.getData().charAt(0));// 用被出栈的运算符，计算数字栈顶的两个操作数
                    }
                    symbolStack.pop();// 左括号出栈
                }
            }
        }

        // 遍历并处理完表达式数组后，若运算符栈非空，则将剩余全部运算符依次出栈并进行运算
        while (!symbolStack.isEmpty()) {
            symbolStack.pop(operatorNode);
            evaluationTwoNumberOfStack(numNode1, numNode2, operatorNode.getData().charAt(0));
        }

        // 最后，操作数栈中剩余唯一的数字，就是最终运算结果
        return Double.valueOf(numberStack.getTop());
    }
}
