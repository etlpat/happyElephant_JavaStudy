package com._05_对表中数据的CRUD;

// 单表select语句
// 功能：查询表中指定数据
//
//
//  todo 1.基本语法：
//  SELECT [DISTINCT] field1[, field2, ...]
//      FROM table_name
//      [WHERE where_definition];
//  解释：
//      ①SELECT指定要查询的列，FROM指定要查询哪张表，WHERE表示查询的条件
//      ②DISTINCT关键字：去除查询结果中的重复数据
//      ③*：可以用通配符“*”来查询表中的全部字段（列）
//
//
//
//  todo 2.进阶语法
//  (1)SELECT关键字可以查询由列组成的表达式
//      语法：SELECT 字段/表达式...
//              FROM table_name WHERE where_definition;
//      表达式如：(field1+field2)*field3...
//
//
//  (2)AS关键字可以对字段/表达式起别名
//      语法：SELECT field1/exp1 AS 别名1, field2/exp2 AS 别名2, ...
//              FROM table_name WHERE where_definition;
//      注意：若用AS对某字段取别名，则在显示SELECT结果时优先显示别名
//
//
//  (3)ORDER BY语句对查询结果排序
//      语法：SELECT field1[, field2, ...]
//              FROM table_name
//              [WHERE where_definition]
//              ORDER BY field [ASC/DESC];
//      功能：将查询结果按照指定列，进行升序[默认]/降序排列
//      关键字：ASC--Ascending order：升序排序，若不添加排序方式关键字，则默认升序排序
//            DESC--Descending order：降序排序
//      注意：①order by指定的列名，即可以是表中的列名，也可以是as的别名
//           ②order by子句应该位于select语句结尾
//
//      补充：ORDER BY语句按照多个字段排序
//      语法：SELECT * FROM table_name [WHERE where_definition]
//              ORDER BY field1 [ASC/DESC], field2 [ASC/DESC],...
//      功能；先按field1排序，之后对每组field1值相同的数据组内，再按照field2排序
//
//
//
//  todo 3.where子句的运算符
//  注意：若WHERE子句为真，则SELECT语句会查询到该结果
//  (1)比较运算符（操作数是字段，返回bool值）：
//      ①：=、!=、>、<、>=、<=、<>
//          注意：<>和!=都表示不等于
//
//      ②：BETWEEN num1 AND num2
//          语法：field BETWEEN num1 AND num2
//          功能：判断字段是否在[num1, num2]范围中（包含num1和num2）
//
//      ③：IN(数据列表)
//          语法：field IN(value1,value2,...) 或 field IN(子查询)
//          功能：判断字段是否在数据列表/子查询中
//          注意：子查询会返回数据列表，以上二者的本质相同
//
//      ④：LIKE '模式匹配字符串'
//          语法：field [NOT] LIKE '模式匹配字符串'
//          功能：判断字段是否符合模式字符串
//          注意：LIKE运算符支持的两个通配符: _ 和 %
//                  _：代表一个任意字符
//                  %：代表零个、一个或多个任意字符
//          转义字符：\_ 表示 '_'
//                  \% 表示 '%'
//                  \\ 表示 '\'
//          如：'_i___'表示五个字符的字符串，其中第二个是i
//             '%abc%'表示一串包含abc的字符串
//             '%张_三'表示以张x三结尾的字符串
//
//      ⑤：IS NULL
//          语法：field IS NULL
//          功能：若字段为空，返回true
//          注意：SQL语句，判断是否为NULL必须用IS关键字，而不能用等于号判断
//
//  (2)逻辑运算符（操作数是bool值，返回bool值）：
//      AND（逻辑与）、OR（逻辑或）、NOT（非）


public class _04_单表select语句 {
}
