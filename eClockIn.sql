create database eClockIn;
use eClockIn;
DROP TABLE IF EXISTS `clock_in`;
DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` varchar(10) NOT NULL COMMENT '学号',
  `password` varchar(18) NOT NULL COMMENT '密码',
  `name` varchar(8) NOT NULL COMMENT '姓名',
  `grade` varchar(32) NOT NULL COMMENT '班级',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `clock_in` (
  `clock_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '数据',
  `id` varchar(10) NOT NULL COMMENT '学号',
  `name` varchar(8) NOT NULL COMMENT '姓名',
  `date` datetime NOT NULL COMMENT '日期',
  `tmp` varchar(32) NOT NULL COMMENT '体温',
  PRIMARY KEY (`clock_id`),
  CONSTRAINT `id`
  FOREIGN KEY(`id`) REFERENCES `student`(`id`)
  on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `student` ( `id`, `password`, `name`, `grade` ) VALUES ( 
'123', '123456', 'qwe', '21rg' );
INSERT INTO `student` ( `id`, `password`, `name`, `grade` ) VALUES ( 
'2021146001', '123456', 'qwe', '21rg' );
INSERT INTO `student` ( `id`, `password`, `name`, `grade` ) VALUES ( 
'2021146002', '123456', 'aqw', '21rg' );
INSERT INTO `student` ( `id`, `password`, `name`, `grade` ) VALUES ( 
'2021146003', '123456', 'sdfe', '21rg' );
INSERT INTO `student` ( `id`, `password`, `name`, `grade` ) VALUES ( 
'2021146004', '123456', 'qxcx', '21rg' );
INSERT INTO `student` ( `id`, `password`, `name`, `grade` ) VALUES ( 
'2021146005', '123456', 'jfe', '21rg' );
INSERT INTO `student` ( `id`, `password`, `name`, `grade` ) VALUES ( 
'2021146006', '123456', 'nyr', '21jsj' );


INSERT INTO `clock_in` ( `clock_id`, `id`, `name`, `date`, `tmp` ) VALUES ( 
'1' ,'123', 'wqf', '2022-08-25 15:31:04.0', '体温37℃以下' );
