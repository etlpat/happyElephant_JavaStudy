package com._08_约束;

// not null 非空约束
//
// 1.语法：
//  CREATE TABLE table_name(
//      字段名 字段类型,
//      字段名 字段类型 NOT NULL,
//      字段名 字段类型 NOT NULL DEFAULT 默认值,
//      ...
//  );
//
// 2.功能：
//  保证插入或更新数据时，指定为NOT NULL的字段值不能为空
//  （若为NULL则报错）
//
// 3.注意：
//  ①NOT NULL通常与DEFAULT关键字配合使用
//      DEFAULT用于设置默认值。这样，在插入记录时不为该列提供值时，MySQL会自动使用默认值。
//


public class _01_not_null {
}
