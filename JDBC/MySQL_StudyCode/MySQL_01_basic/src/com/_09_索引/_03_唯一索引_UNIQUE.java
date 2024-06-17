package com._09_索引;

// 唯一索引
//
// 1.概念
//  在某字段被声明为unique时，MySQL会【自动】为该列隐式创建唯一索引
//  unique索引所在列的值具有唯一性，且允许有多个NULL值；一个表可以有多个unique引索
//  注意：有唯一约束等价于有唯一引索
//
//
// 2.语法
//  (1)添加唯一索引
//      方式1：在创建表时声明UNIQUE约束（会隐式创建unique引索）
//          CREATE TABLE table_name(
//              字段名 字段类型 UNIQUE, // 将字段被声明为unique时，会自动创建唯一索引
//              ...
//          );
//
//      方式2：使用ALTER TABLE语句添加UNIQUE约束
//          ALTER TABLE table_name ADD UNIQUE (field);
//
//      方式3：使用CREATE语句添加UNIQUE引索
//          CREATE UNIQUE INDEX index_name ON table_name(field);
//
//  (2)删除唯一索引
//      注意：删除唯一索引（唯一约束）的方式，和删除普通索引的方式相同
//      方式1：ALTER TABLE table_name DROP INDEX index_name;
//      方式2：DROP INDEX index_name ON table_name;
//




public class _03_唯一索引_UNIQUE {
}
