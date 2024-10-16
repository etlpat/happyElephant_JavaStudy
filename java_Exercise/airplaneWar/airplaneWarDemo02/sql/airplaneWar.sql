`test_db`CREATE TABLE airplaneUsers(
	`username` VARCHAR(32) PRIMARY KEY,
	`password` VARCHAR(32),
	sex VARCHAR(8),
	`level` VARCHAR(32)
);

DROP TABLE airplaneUsers;
DESC airplaneUsers;

DELETE FROM airplaneUsers
	WHERE username != '张三';

INSERT INTO airplaneUsers VALUES('老李','123456','男','玩家');




SELECT * FROM airplaneUsers;


-- =======================================

CREATE TABLE airplaneScoreBoard(
	`username` VARCHAR(32),
	gameDateTime DATETIME,
	score INT,
	flyDistance INT,
	PRIMARY KEY (`username`, gameDateTime)
);

DROP TABLE airplaneScoreBoard;
DESC airplaneScoreBoard;

INSERT INTO airplaneScoreBoard VALUES('张三','1111-11-11 11:11:11',1,1),
	('张三','1111-11-11 11:11:22',2,2),
	('张三','1111-11-11 11:11:33',3,3);

DELETE FROM airplaneScoreBoard
	WHERE username != '张三';

SELECT * FROM airplaneScoreBoard
	WHERE username = '张三'
	ORDER BY score DESC;
	
	
	
	
SELECT * FROM airplaneScoreBoard;




