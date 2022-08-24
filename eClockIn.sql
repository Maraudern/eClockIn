create database eClockIn;
use eClockIn;
DROP TABLE IF EXISTS `t_student`;
DROP TABLE IF EXISTS EMP;
DROP TABLE IF EXISTS DEPT;
DROP TABLE IF EXISTS SALGRADE;

CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `stuno` varchar(10) DEFAULT NULL COMMENT '学号',
  `password` varchar(18) NOT NULL  COMMENT '密码',
  `name` varchar(8) DEFAULT NULL COMMENT '姓名',
  `grade` varchar(32) DEFAULT NULL COMMENT '班级',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_student` ( `stuno`, `password`, `name` ) VALUES ( 
'2021b46001', '123456', 'qwe'); 
INSERT INTO `t_student` ( `stuno`, `password`, `name` ) VALUES ( 
'2021b46002', '123456', 'asd'); 
INSERT INTO `t_student` ( `stuno`, `password`, `name` ) VALUES ( 
'2021b46003', '123456', 'fgh'); 
INSERT INTO `t_student` ( `stuno`, `password`, `name` ) VALUES ( 
'2021b46004', '123456', 'ert'); 
commit;
 