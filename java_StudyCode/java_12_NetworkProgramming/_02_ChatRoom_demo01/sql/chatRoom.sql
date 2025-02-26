CREATE DATABASE chatRoom;

USE chatroom;

DROP TABLE USER;

CREATE TABLE `user` (
  `username` VARCHAR(50) PRIMARY KEY,
  `password` VARCHAR(50)
);

DESC USER;

INSERT INTO `user`(username,PASSWORD) 
	VALUES('zhangsan','123456'), 
		('lisi','123456'),
		('wangwu','123456'),
		('zhaoliu','123456');
		
INSERT INTO `user`(username,PASSWORD) 
	VALUES('111',''), 
		('222',''),
		('333',''),
		('444',''),
		('555',''),
		('666',''),
		('777',''),
		('888',''),
		('999',''),
		('000','');
		
SELECT * FROM USER;