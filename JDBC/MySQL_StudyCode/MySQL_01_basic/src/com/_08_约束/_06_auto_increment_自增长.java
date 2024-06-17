package com._08_约束;

// auto_increment 自增长
//
// 1.语法：
//  CREATE TABLE table_name(
//      字段名 字段类型 PRIMARY KEY AUTO_INCREMENT,
//      字段名 字段类型,
//      ...
//  );
//
//  添加自增长字段的方法：（假设字段1是被AUTO_INCREMENT修饰的字段）
//  INSERT INTO xxx (字段1, 字段2,...) values (NULL, val2,...);// 为自增数赋空值
//  INSERT INTO xxx (字段2,...) values (val2,...);// 不为自增数赋值（默认为NULL）
//  INSERT INTO xxx values (NULL, val2,...);// 为自增数赋空值
//
//
// 2.功能与用法
//  (1)功能
//      将某字段设置为自增长数，该列从1开始，自动的增长。
//  (2)用法
//      ①被auto_increment修饰的自增长数，首次默认插入1，之后每次插入的值自增1
//      ②向自增长数所在的列添加数据：
//          若向该字段添加NULL，则MySQL会自动插入按照原本规律自动增长的数
//          若向该字段添加指定数，则该自增长数会变成指定数，之后从指定数开始自增长
//
//
// 3.注意事项
//  ①一般auto_increment自增数与主键配合使用
//      若单独使用，则需要保证自增数为unique
//  ②auto_increment修饰的字段一般为整数
//      （小数不报错，但很少用）
//  ③自增长默认从1开始，你也可以通过[alter table 表名 auto_increment = 新值;]来修改自增长数的值
//      同理，也可以在添加数据时，不向自增长字段传入NULL，而是传入指定值，来修改自增长数


public class _06_auto_increment_自增长 {
}
