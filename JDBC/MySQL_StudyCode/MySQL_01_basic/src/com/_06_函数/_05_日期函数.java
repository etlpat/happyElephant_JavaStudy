package com._06_函数;

// 日期函数
//
// (1)常见函数
// ①日期时间的获取函数
//  now()：获取当前的datetime（日期+时间）
//  current_date()：获取当前date（日期）
//  current_time()：获取当前time（时间）
//  current_timestamp()：获取当前时间戳（日期+时间）
//
// ②日期时间的操作函数
//  date_add(datetime, INTERVAL num YEAR/MONTH/DAY/HOUR/MINUTE/SECOND)：在datetime上增加日期或时间
//  date_sub(datetime, INTERVAL num YEAR/MONTH/DAY/HOUR/MINUTE/SECOND)：在datetime上减少日期或时间
//  datediff(datetime1, datetime2)：求两个datetime间的日期差（单位：天）【是datetime1-datetime2的天数，结果可正可负】
//  timediff(datetime1, datetime2)：求两个datetime间的时间差（单位：时:分:秒）
//  date(datetime)：返回datetime的date部分
//  time(datetime)：返回datetime的time部分
//  year/month/day/hour/minute/second(datetime)：返回datetime的年/月/日/时/分/秒部分
//
// ③关于时间戳的函数
//  unix_timestamp()：返回1970-1-1 0:0:0到现在的秒数[时间戳]（单位：秒）
//  from_unixtime(unix_timestamp, '%Y-%m-%d %H:%i:%s')：将秒数（最好是1970-1-1至今的时间戳）转换为datetime
//  （实际开发中，经常使用int来保存一个unix时间戳，之后通过from_unixtime函数来转换）
//
//
//
// (2)注意事项
//  1.date_add和date_sub函数，既可以用datetime作为参数，也可以用date作为参数
//      当参数是datetime时，可以为该参数增减“年月日时分秒”；当参数是date是，只能为该参数增减“年月日”
//  2.datediff的参数既可以是datetime，也可以是date
//  3,timediff的参数既可以是datetime，也可以是time
//  4.datetime类型，可以直接用比较运算符如>、<、=对时间先后进行比较


public class _05_日期函数 {
}
