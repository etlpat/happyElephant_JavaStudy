package com._08_约束;

// unique 唯一约束
//
// 1.语法：
//  CREATE TABLE table_name(
//      字段名 字段类型,
//      字段名 字段类型 UNIQUE,
//      ...
//  );
//
// 2.功能
//  当列定义了unique约束后，该列值是不能重复的（但是可以有多个NULL）
//
// 3.注意事项
//  ①若没有指定not null，则unique字段可以有多个NULL
//  ②一张表可以有多个unique字段
//


public class _03_unique {
}
