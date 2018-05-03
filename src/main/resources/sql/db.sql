/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.7.21 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `T_USER` (
    `USER_ID` varchar(64) not null comment '用户ID',,
    `USER_NAME` VARCHAR(64) comment '用户名称',
    `USER_ACCOUNT` VARCHAR(64) comment '用户账户',
    `USER_SEX` VARCHAR(64) comment '用户性别',
    `OPEN_ID` VARCHAR(64) comment 'openId',
    `DEL_FLAG` VARCHAR(1) comment '删除标记',
    primary key (USER_ID)
); 
insert into `T_USER` (`USER_ID`, `USER_NAME`, `USER_SEX`, `OPEN_ID`, `DEL_FLAG`, `USER_ACCOUNT`) values('1','test','M','','1','test1');
insert into `T_USER` (`USER_ID`, `USER_NAME`, `USER_SEX`, `OPEN_ID`, `DEL_FLAG`, `USER_ACCOUNT`) values('2','test2','M','','1','test2');
insert into `T_USER` (`USER_ID`, `USER_NAME`, `USER_SEX`, `OPEN_ID`, `DEL_FLAG`, `USER_ACCOUNT`) values('3','test3','M','','1','test3');
insert into `T_USER` (`USER_ID`, `USER_NAME`, `USER_SEX`, `OPEN_ID`, `DEL_FLAG`, `USER_ACCOUNT`) values('4','test4','M','','1','test4');
insert into `T_USER` (`USER_ID`, `USER_NAME`, `USER_SEX`, `OPEN_ID`, `DEL_FLAG`, `USER_ACCOUNT`) values('5','test5','M','','1','test5');
