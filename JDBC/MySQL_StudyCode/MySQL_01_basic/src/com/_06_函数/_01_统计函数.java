package com._06_函数;

// 统计函数/聚合函数
//
//  todo 1.COUNT()函数
//  语法：SELECT COUNT(*/field)
//          FROM table_name
//          [WHERE where_definition];
//
//  功能：返回查询结果的行数（统计数据的条数）
//
//  问：count(*)和count(field)的区别是什么？
//  答：二者均统计查询结果的行数，区别是count(field)不会统计结果为null的数据，
//      而count(*)会统计数据项全为null的记录
//
//
//  todo 2.SUM()函数
//  语法：SELECT SUM(field/exp)
//          FROM table_name
//          [WHERE where_definition];
//
//  功能：返回满足where条件的数值列的和
//
//
//  todo 3.AVG()函数
//  语法：SELECT AVG(field/exp)
//          FROM table_name
//          [WHERE where_definition];
//
//  功能：返回满足where条件的数值列的平均值
//
//
//  todo 4.MAX()/MIN()函数
//  语法：SELECT MAX(field/exp)
//          FROM table_name
//          [WHERE where_definition];
//
//  功能：返回满足where条件的数值列的最大/最小值
//
//
//
//  todo 5.注意事项【重点】
//  注意：①统计函数不能用于where子句中，
//        原因：where子句必须先对查询结果进行过滤，过滤之后才能使用统计函数。
//        若想在where子句中获得统计函数返回的值，只能通过select子查询来实现
//      ②统计函数可以用于having子句中
//


public class _01_统计函数 {
}
