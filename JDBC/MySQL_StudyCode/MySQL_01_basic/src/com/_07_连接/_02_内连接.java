package com._07_连接;

// 内连接 JOIN
//
//
// (1)概念
//  MySQL中的内连接INNER JOIN，也可简写为JOIN。
//  和外连接不同，【内连接只会返回两表中匹配的行】。若某表中的一行在另一个表中没有匹配项，则这些行不会出现在结果集中。
//
//
// (2)语法
//      SELECT *
//          FROM left_table [INNER] JOIN right_table
//          ON left_table.field = right_table.field;
//
//
// (3)注意事项
//  ①内连接只返回匹配的行，若某行在另一个表中无匹配行，则会舍去该行
//  ②JOIN依然使用嵌套循环算法，性能良好
//  ③内连接 != 自连接
//      内连接：两表连接，只返回匹配的行
//      自连接：一个表，自己与自己进行连接


public class _02_内连接 {
}
