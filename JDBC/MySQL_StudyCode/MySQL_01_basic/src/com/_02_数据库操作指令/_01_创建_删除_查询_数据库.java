package com._02_数据库操作指令;

// 创建、删除、查询数据库
//
// TODO 本节指令
//  CREATE DATABASE db_name [CHARACTER SET charset_name] [COLLATE collation_name];
//  DROP DATABASE db_name;
//  SHOW DATABASES;
//  SHOW CREATE DATABASE db_name;
//
//
//  todo 1.创建数据库
//  语法：
//      CREATE DATABASE db_name [CHARACTER SET charset_name] [COLLATE collation_name];
//      CREATE DATABASE 数据库名;
//  后缀：
//      ①CHARACTER SET：指定数据库使用的字符集（默认是utf8）
//      ②COLLATE：指定字符集的校对规则（默认是utf8_general_ci）
//          常用校对规则：utf8_bin[区分大小写]，utf8_general_ci[不区分大小写]
//  知识点补充：
//      在数据库中创建表，表默认的字符集和校对规则就是该数据库的字符集和校对规则
//
//
//  todo 2.删除数据库【慎用】
//  语法：DROP DATABASE 数据库名;
//
//
//  todo 3.查询数据库
//  ①显示所有数据库：SHOW DATABASES;
//  ②显示数据库的创建语句：SHOW CREATE DATABASE 数据库名;
//
//
//  todo 4.注意事项
//  ①当我们要创建的数据库名，刚好是关键字时，可以用反引号``将数据库名称框起来
//      `db_name`，此时无论数据库名是否为关键字，都能作为库名使用


public class _01_创建_删除_查询_数据库 {
}