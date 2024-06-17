package com._03_表的操作指令;

// 修改表
// 关键字：alter——v.改变、改动
//
//  todo (0)查看表的字段信息
//  语法：DESC table_name;
//  英文：DESC——description：描述
//
//  todo (1)添加字段（列）
//  语法：ALTER TABLE table_name ADD field datatype
//          [NOT NULL DEFAULT xxx] [AFTER field_xxx];
//  后缀：
//      ①NOT NULL DEFAULT xxx：表示该列的元素不能为空，若为空则默认填入xxx
//      ②AFTER field_xxx：表示新字段加入到字段xxx之后
//
//  todo (2)修改字段（列）的类型
//  语法：ALTER TABLE table_name MODIFY field datatype
//          [NOT NULL DEFAULT xxx];
//
//  todo (3)修改字段（列）的名称+类型
//  语法：ALTER TABLE table_name CHANGE 旧字段名 新字段名 datatype
//          [NOT NULL DEFAULT xxx];
//
//  todo (4)删除字段（列）
//  语法：ALTER TABLE table_name DROP field;
//
//  todo (5)修改表名
//  语法：RENAME TABLE 表名 TO 新表名  
//
//  todo (6)修改表的字符集
//  语法：ALTER TABLE table_name CHARACTER SET 字符集;
//
//  todo (7)其它用法
//  ALTER除了能以上基本用法外，还能：
//      ①为表的字段添加、删除完整性约束
//      ②为表的字段添加、删除引索
//      ③修改视图


public class _02_修改表 {
}
