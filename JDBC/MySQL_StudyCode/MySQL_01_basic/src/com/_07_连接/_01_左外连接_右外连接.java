package com._07_连接;

// 左外连接、右外连接
//
//  todo 1.左外连接
//  语法：SELECT *
//          FROM left_table LEFT JOIN right_table
//          ON left_table.field = right_table.field;
//
//  功能：【左侧的表完全显示】，将符合匹配条件的右表数据连接到左表上。
//      对于左表中的每一行，如果在右表中有匹配的行，则这两行会基于匹配条件进行连接。
//      若左表中的某一行在右表中没有匹配的行，则结果集中仍会包含左表的这一行，但右表对应的列值将为 NULL。
//
//  底层实现：
//      左外连接，是使用循环嵌套算法，将右表的数据拼接到左表上，右表无匹配则拼接NULL
//      注意：外连接的实现并不会生成笛卡尔积再过滤，这种方法效率低下、耗费空间；外连接直接使用效率较高的循环嵌套算法
//
//
//
//  todo 2.右外连接
//  语法：SELECT *
//          FROM left_table RIGHT JOIN right_table
//          ON left_table.field = right_table.field;
//
//  功能：【右侧的表完全显示】，将符合匹配条件的左表数据连接到右表上。
//      右外连接与左外连接的功能和原理完全相同，类比左外连接即可
//


public class _01_左外连接_右外连接 {
}
