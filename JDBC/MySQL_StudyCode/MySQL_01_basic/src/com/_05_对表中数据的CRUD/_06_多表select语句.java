package com._05_对表中数据的CRUD;

// 多表查询语句
//
//
//  todo 0.知识点补充 —— SELECT语句内部的执行顺序
//  执行顺序：FROM子句 -> WHERE子句 -> SELECT子句
//      ①FROM子句：选择表，若是多表则进行笛卡尔积拼接操作
//      ②WHERE子句：对表进行筛选过滤
//      ③SELECT子句：将过滤后的表的指定列，输出到用户端上
//  因此：FROM子句中取的别名可以被WHERE、SELECT子句沿用；而SELECT子句中取的别名只能在本句中使用
//
//
//  todo 1.基本语法
//  语法：SELECT * FROM table1, table2;
//  功能：将table1中的每一行数据，与table2中的每一行数据进行组合，返回组合后的结果
//      【返回table1与table2中数据的笛卡尔积】
//  注意：①若table1有m行数据，table2有n行数据，则组合后共返回m*n行数据
//      ②多表查询返回的新表，它的列由table1和table2的所有列拼接而成
//
//
//  todo 2.where过滤语法
//  概念：通过where对笛卡尔积的结果进行过滤
//  语法：SELECT * FROM table1, table2
//          WHERE table1.field1 = table2.field1;
//  功能：将两表进行笛卡尔积，并过滤出两表field1字段值相同的数据
//  注意：若拼接前两表存在相同的列名，则拼接后必须用【表名.列名】的形式加以区分，否则报错
//
//
//  todo 3.自连接
//  概念：将同一张表看着两个表，进行自我连接与查询
//  语法：SELECT *
//          FROM field_self AS f1, field_self AS f2
//          [WHERE where_definition];
//  功能：将表与自己连接，用于处理表内的关系
//  注意：①多表查询的自连接必须取别名，用于区分前后两个相同的表，否则报错
//      ②自连接时取别名的AS关键字可以省略，语法可以通过


public class _06_多表select语句 {
}
