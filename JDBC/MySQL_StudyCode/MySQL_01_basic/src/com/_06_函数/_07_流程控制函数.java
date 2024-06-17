package com._06_函数;

// 流程控制函数
//
//  todo (1)if函数
//  语法：if(exp1, exp2, exp3)
//  功能：若exp1为true，则返回exp2；否则返回exp3（类似三目操作符）
//
//
//  todo (2)ifnull函数
//  语法：ifnull(exp1, exp2)
//  功能：若exp1不为null，返回exp1；否则返回exp2
//  补充：MySQL语句中，判断字段是否为空需要用【IS】关键字，而非“=”
//       e.g.`name` is null
//
//
//  todo (3)case表达式
//  语法：SELECT CASE
//          WHEN exp1A THEN exp1B
//          WHEN exp2A THEN exp2B
//          WHEN exp3A THEN exp3B
//          ...
//          [ELSE expN]
//          END
//
//  执行逻辑：从上到下依次判断when子句是否为真，
//          直到找到第一个为真的when子句，返回对应的then子句的值，然后结束case表达式；
//          若遍历完全部when子句，都为假，则执行else子句，然后结束case表达式
//
//  注意：整条select case语句，只返回首个真值when语句对应的then子句的值
//       因此，该select子句经常作为子查询来使用


public class _07_流程控制函数 {
}
