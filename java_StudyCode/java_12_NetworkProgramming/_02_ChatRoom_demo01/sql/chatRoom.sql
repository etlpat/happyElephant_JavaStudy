CREATE DATABASE chatRoom;

USE chatroom;

DROP TABLE USER;

CREATE TABLE `user` (
  `username` VARCHAR(50) PRIMARY KEY,
  `password` VARCHAR(50)
);

DESC USER;
		
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

INSERT INTO `user`(username,PASSWORD) 
	VALUES('张三','123456'), 
		('李四','123456'),
		('王五','123456'),
		('赵六','123456'),
		('孙七','123456'),
		('周八','123456');
	
		
SELECT * FROM USER;