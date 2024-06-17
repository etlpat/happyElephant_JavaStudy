package com._06_函数;

// group by 子句
//
//
// 1.介绍
//  核心：先分组，后聚合
//  GROUP BY子句用于对查询结果进行分组，方便之后对每个组进行聚合操作
//  GROUP BY子句通常与统计函数一起使用，如：COUNT()、SUM()、AVG()、MAX()、MIN()等
//  【使用GROUP BY对表格进行分组之后，统计函数会对每个组分别进行操作】
//
//
// 2.语法
//  (1)基本语法：
//      SELECT group_filed/统计函数(filed)...
//          FROM table_name
//          GROUP BY group_filed
//          [HAVING 条件语句];
//
//  功能：将表格按照group_filed列来进行分组查询（group_filed列的值相同的数据分为一组）
//       之后用having语句对分组的结果进行过滤
//
//  注意：①若使用某列对表格数据进行分组，则该列的每一种值都会划分出一个组别
//       ②使用group by分组后，统计函数会自动对每个组分别进行统计运算
//       ③having语句中，可以使用as定义的别名
//
//
//  (2)多次分组语法：
//      SELECT group_filed1, group_filed2, 统计函数(filed), ...
//          FROM table_name
//          GROUP BY group_filed1, group_filed2, ...
//          [HAVING 条件语句];
//
//  功能：将表格按照group by语句中的多个字段，从左到右，依次分组
//      （先按group_filed1分组，之后将分完的每个组再按group_filed2继续分组...）


public class _02_GROUP_BY子句 {
}
