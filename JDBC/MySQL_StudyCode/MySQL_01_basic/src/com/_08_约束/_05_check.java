package com._08_约束;

// check 检查约束
//
// 1.语法：
//  CREATE TABLE table_name(
//      字段名 字段类型,
//      字段名 字段类型 CHECK(条件语句),
//      sex varchar(10) CHECK (sex IN ('男', '女')),
//      age int CHECK (age>=0 AND age<=130)
//      ...
//  );
//
//
// 2.功能
//  规定字段需要满足的条件
//
//
// 3.注意事项
//  ①MySQL5.7不支持check，只会做语法校验，但是不会生效
//      MySQL8、SqlServer、Oracle数据库中check约束均会生效


public class _05_check {
}
