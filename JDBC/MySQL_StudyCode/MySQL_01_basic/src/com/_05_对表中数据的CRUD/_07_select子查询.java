package com._05_对表中数据的CRUD;

// select子查询
//
//  todo 1.概念
//  子查询，也叫嵌套查询，是嵌套在其它SQL语句中的SELECT查询，极大提升了查询的灵活性
//  子查询可以返回：单个值/一列值/一行值/多行多列的表
//
//
//  todo 2.使用方法
//  使用方法：实际应用中，我们应先根据要求写出对应的子查询，再将子查询整体看作其返回结果，代入到外部查询中
//  (1)若子查询返回单个值：WHERE field = (SELECT子查询)
//  (2)若子查询返回一列值：WHERE field IN (SELECT子查询)
//  (3)若子查询返回一行值：WHERE (field1, field2,...) = (SELECT子查询)
//  (4)若子查询返回多行多列的表：WHERE (field1, field2,...) IN (SELECT子查询)
//  (5)若子查询返回多行多列的表：FROM table1, (SELECT子查询) AS table2
//
//  注意：①当子查询返回单个值/单行值，可以看作只含有一个元素的列/表，因此用“IN”代替“=”
//      ②若子查询返回一行/多行值，可以将每一行看作一个列表元素，用 (列表)=(子查询) 的形式进行过滤
//      ③若子查询返回一行/多行值，则等号左侧的(field1, field2,...)要与子查询返回的列一一对应
//      ④当子查询返回表，可以用于FROM语句多表查询，也可以用于WHERE语句过滤
//
//
//  todo 3.语法
//  (1)返回单个值的子查询：（用于where过滤）
//      SELECT *
//          FROM table_name
//          WHERE field = (
//              SELECT field // 返回单个值
//              FROM ...
//              WHERE ...
//          );
//
//  (2)返回一列值的子查询：（用于where过滤）
//      SELECT *
//          FROM table_name
//          WHERE field IN (
//              SELECT DISTINCT field // 返回一列值（结果要用DISTINCT去重）
//              FROM ...
//              WHERE ...
//          );
//
//  (3)返回一行值的子查询：（用于where过滤）
//      SELECT *
//          FROM table_name
//          WHERE (field1, field2,...) = ( // 字段列表必须加括号，且与子查询返回的列一一对应
//              SELECT field1, field2,... // 返回一行值
//              FROM ...
//              WHERE ...
//          );
//
//  (4)返回多行多列的表的子查询：（用于where过滤）
//      SELECT *
//          FROM table_name
//          WHERE (field1, field2,...) IN (
//              SELECT DISTINCT field1, field2,... // 返回一个表（去重）
//              FROM ...
//              WHERE ...
//          );
//
//  (5)返回多行多列的表的子查询：（用于from进行笛卡尔积）
//      SELECT *
//          FROM table1, (
//              SELECT field1, field2... // 返回一个表（记得对该表起别名）
//              FROM ...
//              WHERE ...
//          ) AS table2
//          [WHERE where_definition];
//
//
//  todo 4.ALL和ANY关键字
//  概念：ALL——全部；ANY——任意
//  语法：①field > ALL(数值列表/返回一列值的子查询)
//       ②field > ANY(数值列表/返回一列值的子查询)
//  功能：以上①表示字段比列表的全部值都要大；②表示字段比列表的任意一个值大
//  注意：ALL、ANY关键字通常可以用含MAX、MIN的句子替换
//


public class _07_select子查询 {
}
