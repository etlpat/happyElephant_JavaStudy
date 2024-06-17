package com._09_索引;

// 普通引索
//
// (1)普通索引介绍：
//  ①底层通过B+树实现：
//      B+树是一种自平衡树，能够保持数据有序，并支持高效的插入、删除、查找操作。
//      B+树中，非叶子节点只保存键值信息，而真正的数据存储在叶子节点中。这种结构使得范围查询变得非常高效。
//  ②普通引索特点：
//      普通引索允许在列中插入重复的值
//      主要用于加快数据的检索速度
//      在执行查询时，MySQL可以使用普通索引来快速定位到数据所在的磁盘位置，从而避免全表扫描。
//
//
//
// (2)为字段添加普通索引
//  语法1：ALTER TABLE table_name ADD INDEX index_name(field);
//  语法2：CREATE INDEX index_name ON table_name(field);
//
//
// (3)删除普通索引
//  语法1：ALTER TABLE table_name DROP INDEX index_name;
//  语法2：DROP INDEX index_name ON table_name;
//
//
// (3)显示表中的引索
//  语法1：SHOW INDEX FROM table_name;
//  语法2：SHOW INDEXES FROM table_name;
//  语法3：SHOW KEYS FROM table_name;
//  语法4：DESC table_name;
//
//


public class _04_普通索引_INDEX {
}
