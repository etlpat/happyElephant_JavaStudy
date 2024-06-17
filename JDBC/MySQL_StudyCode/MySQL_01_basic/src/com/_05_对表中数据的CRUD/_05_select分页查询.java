package com._05_对表中数据的CRUD;

// select的分页查询
//
// 语法：
//  SELECT * FROM table_name
//      [WHERE where_definition]
//      LIMIT start, rows;
//
// 功能：从第 start+1 行开始，取出rows条记录
//
// 注意：1.start从0开始取
//      2.若第一页从0号开始取，则之后的每一页均为：
//          LIMIT 每页记录条数*(当前页数-1), 每页记录条数


public class _05_select分页查询 {
}
