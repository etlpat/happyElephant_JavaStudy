package com._05_对表中数据的CRUD;

// 表的复制和去重
//
//  todo 1.快速建表
//  功能：建立与table1的数据类型、顺序完全相同的表table2
//  语法：CREATE TABLE table2 LIKE table1;
//
//
//  todo 2.为表拷贝数据
//  功能：将SELECT子查询返回的数据插入到表中
//  语法：INSERT INTO table_name(field1, field2,...)
//          SELECT field1, field2,... FROM ... [WHERE ...];
//  注意：SELECT返回的表的字段与前面要求的字段一一对应即可
//
//  表的自我复制语法：
//      INSERT INTO table1 SELECT * FROM table1;
//
//
//  todo 3.表的数据去重
//  注意：SQL语言中并没有直接对表的数据物理去重的语句，因此只能利用表的CRUT语句进行去重
//  步骤：①创建与原始表结构完全相同的空临时表
//      ②利用SELECT语句和DISTINCT关键字，向临时表中插入去重后的原始表数据
//      ③清空原始表
//      ④将临时表中的数据拷贝到原始表
//      ⑤删除临时表
//
//  以对table表进行去重为例，指令如下：
//      CREATE TABLE tmp LIKE table;
//      INSERT INTO tmp SELECT DISTINCT * FROM table;
//      DELETE FROM table;
//      INSERT INTO table SELECT * FROM tmp;
//      DROP TABLE tmp;
//


public class _08_表的复制和去重 {
}
