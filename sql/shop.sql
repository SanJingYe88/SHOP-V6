/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.0.45-community-nt : Database - shop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shop` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shop`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(11) NOT NULL auto_increment COMMENT '地址id',
  `country` varchar(10) NOT NULL COMMENT '国家',
  `province` varchar(10) NOT NULL COMMENT '省份',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='这是地址表';

/*Data for the table `address` */

insert  into `address`(`id`,`country`,`province`) values (1,'中国','北京'),(2,'美国','华盛顿'),(3,'日本','东京'),(4,'中国','上海');

/*Table structure for table `buy_history` */

DROP TABLE IF EXISTS `buy_history`;

CREATE TABLE `buy_history` (
  `id` int(11) NOT NULL auto_increment,
  `u_id` int(11) default NULL,
  `g_id` int(11) default NULL,
  `buyTime` varchar(20) default NULL,
  `num` int(3) default NULL,
  `money` int(10) default NULL,
  `goodName` varchar(100) default NULL,
  PRIMARY KEY  (`id`),
  KEY `u_id` (`u_id`),
  KEY `g_id` (`g_id`),
  CONSTRAINT `buy_history_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`),
  CONSTRAINT `buy_history_ibfk_2` FOREIGN KEY (`g_id`) REFERENCES `good` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

/*Data for the table `buy_history` */

insert  into `buy_history`(`id`,`u_id`,`g_id`,`buyTime`,`num`,`money`,`goodName`) values (47,1,11,'2017-06-30 00:52:24',3,5097,'华为畅享7 Plus 4GB+64GB '),(48,1,21,'2017-06-30 00:52:24',2,198,'安德的游戏三部曲'),(53,1,11,'2017-06-30 02:33:31',1,1699,'华为畅享7 Plus 4GB+64GB '),(54,1,11,'2017-06-30 02:36:16',2,3398,'华为畅享7 Plus 4GB+64GB '),(55,1,31,'2017-06-30 02:37:47',2,398,'达尔优（dare-u）108键机械合金版'),(56,1,11,'2017-06-30 02:37:47',2,3398,'华为畅享7 Plus 4GB+64GB '),(57,1,11,'2017-06-30 02:39:48',2,3398,'华为畅享7 Plus 4GB+64GB '),(58,1,11,'2017-06-30 02:42:42',1,1699,'华为畅享7 Plus 4GB+64GB '),(59,1,11,'2017-06-30 02:46:09',1,1699,'华为畅享7 Plus 4GB+64GB '),(60,1,11,'2017-06-30 02:47:35',3,5097,'华为畅享7 Plus 4GB+64GB '),(61,1,11,'2017-06-30 02:51:14',2,3398,'华为畅享7 Plus 4GB+64GB '),(62,1,10,'2017-06-30 09:41:49',2,4198,'荣耀8 4GB+32GB 全网通 珠光白'),(63,1,11,'2017-06-30 09:41:49',2,3398,'华为畅享7 Plus 4GB+64GB ');

/*Table structure for table `emp` */

DROP TABLE IF EXISTS `emp`;

CREATE TABLE `emp` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(50) NOT NULL,
  `age` tinyint(3) unsigned NOT NULL,
  `salary` float(8,2) unsigned default NULL,
  `register_date` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `emp` */

insert  into `emp`(`id`,`username`,`age`,`salary`,`register_date`) values (1,'sffff',20,6666.66,'2017-10-27 23:17:41');

/*Table structure for table `good` */

DROP TABLE IF EXISTS `good`;

CREATE TABLE `good` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(200) default NULL,
  `price` int(11) default NULL,
  `xl` int(11) default NULL,
  `kcl` int(11) default NULL,
  `picPath` varchar(20) default NULL,
  `typeid` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `good` */

insert  into `good`(`id`,`name`,`price`,`xl`,`kcl`,`picPath`,`typeid`) values (1,'联想 Lenovo 小新AirPro',4788,12345,0,'pic/1.jpg',1),(2,'小米(MI)Air 13.3英寸全金属超',4998,12345,5268,'pic/2.jpg',1),(3,'华硕（ASUS)超薄游戏笔记本电脑',4788,12345,5268,'pic/3.jpg',1),(4,'联想(Lenovo)小新310经典版',4388,12345,5268,'pic/4.jpg',1),(5,'华硕(ASUS) 顽石四代FL5700U',4788,12345,5268,'pic/5.jpg',1),(6,'联想(Lenovo)小新锐7000',4788,12345,5268,'pic/6.jpg',1),(7,'宏碁 Acer F5-573G游戏笔记本',3699,5869,12500,'pic/7.jpg',1),(8,'Apple MacBook Pro 13',13788,12345,5268,'pic/8.jpg',1),(9,'联想 ThinkPad E470c',4288,12345,5268,'pic/9.jpg',1),(10,'荣耀8 4GB+32GB 全网通 珠光白',2099,12345,5268,'pic/10.jpg',2),(11,'华为畅享7 Plus 4GB+64GB ',1699,12345,5268,'pic/11.jpg',2),(12,'OPPO R9s 全网通4G+64G',2599,12345,5268,'pic/12.jpg',2),(13,'小米 红米 4X 全网通版 2+16',699,12345,5268,'pic/13.jpg',2),(14,'诺基亚6 (Nokia6) 4GB+64',1699,12345,5268,'pic/14.jpg',2),(15,'荣耀V9 手机 铂光金 全网通 6+64',2699,12345,5268,'pic/15.jpg',2),(16,'360手机 N5 全网通 6GB+64G',1599,12345,5268,'pic/16.jpg',2),(17,'一加手机3T (A3010) 6GB+6',1699,12345,5268,'pic/17.jpg',2),(18,'魅族 魅蓝E2 3GB+32GB 全网通',1299,12345,5268,'pic/18.jpg',2),(19,'银河帝国：基地七部曲',225,12345,5268,'pic/19.jpg',3),(20,'克苏鲁神话',40,12345,5268,'pic/20.jpg',3),(21,'安德的游戏三部曲',99,12345,5268,'pic/21.jpg',3),(22,'银河英雄传说',70,12345,5268,'pic/22.jpg',3),(23,'来自新世界',61,12345,5268,'pic/23.jpg',3),(24,'亚特兰蒂斯',94,12345,5268,'pic/24.jpg',3),(25,'贩罪四部曲',110,12345,5268,'pic/25.jpg',3),(26,'红楼梦 上下共2册二册 曹雪芹',50,12345,5268,'pic/26.jpg',3),(27,'三体三部曲',70,12345,5268,'pic/27.jpg',3),(28,'雷蛇（Razer）炼狱蝰蛇 DeathA',249,12345,5268,'pic/28.jpg',4),(29,'达尔优（dare-u） G60 牧马人游',119,12345,5268,'pic/29.jpg',4),(30,'罗技（Logitech）G402 高速追',299,12345,5268,'pic/30.jpg',4),(31,'达尔优（dare-u）108键机械合金版',199,12345,5268,'pic/31.jpg',4),(32,'罗技（Logitech）MK120 键鼠',129,12345,5268,'pic/32.jpg',4),(33,'罗技（Logitech）MK275 无线',199,12345,5268,'pic/33.jpg',4);

/*Table structure for table `good_address` */

DROP TABLE IF EXISTS `good_address`;

CREATE TABLE `good_address` (
  `id` int(11) NOT NULL auto_increment,
  `u_id` int(11) default NULL,
  `sheng` varchar(10) default NULL,
  `shi` varchar(10) default NULL,
  `quxian` varchar(10) default NULL,
  `address` varchar(70) default NULL,
  `name` varchar(10) default NULL,
  `phone` varchar(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `good_address_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `good_address` */

insert  into `good_address`(`id`,`u_id`,`sheng`,`shi`,`quxian`,`address`,`name`,`phone`) values (1,1,'河北省','廊坊市','燕郊','华北科技学院','李灏','18831608982'),(3,2,'北京市','丰台区','方庄','芳古园','程心','18833334444'),(4,4,NULL,NULL,NULL,'威慑纪元61年','维德','18877778888'),(6,2,'北京市',NULL,NULL,'危机纪元1年','程心','18833334444'),(7,3,NULL,NULL,NULL,'公元20XX年','罗辑','18855556666'),(8,3,NULL,NULL,NULL,'危机纪元3年','罗辑','18855556666'),(9,3,NULL,NULL,NULL,'危机纪元208年','罗辑','18855556666');

/*Table structure for table `good_msg` */

DROP TABLE IF EXISTS `good_msg`;

CREATE TABLE `good_msg` (
  `id` int(11) NOT NULL auto_increment,
  `goodid` int(11) default NULL,
  `userid` int(11) default NULL,
  `time` varchar(20) default NULL,
  `content` text,
  PRIMARY KEY  (`id`),
  KEY `goodid` (`goodid`),
  KEY `userid` (`userid`),
  CONSTRAINT `good_msg_ibfk_1` FOREIGN KEY (`goodid`) REFERENCES `good` (`id`),
  CONSTRAINT `good_msg_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `good_msg` */

/*Table structure for table `good_type` */

DROP TABLE IF EXISTS `good_type`;

CREATE TABLE `good_type` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `good_type` */

insert  into `good_type`(`id`,`name`) values (1,'电脑'),(2,'手机'),(3,'图书'),(4,'电脑配件');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `stu_id` int(11) NOT NULL auto_increment,
  `stu_name` varchar(40) NOT NULL,
  PRIMARY KEY  (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`stu_id`,`stu_name`) values (1,'艾AA'),(2,'艾BB'),(3,'艾CC'),(4,'艾DD');

/*Table structure for table `student_msg` */

DROP TABLE IF EXISTS `student_msg`;

CREATE TABLE `student_msg` (
  `stu_id` int(11) NOT NULL,
  `stu_msg` varchar(100) NOT NULL,
  PRIMARY KEY  (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student_msg` */

insert  into `student_msg`(`stu_id`,`stu_msg`) values (1,'这是 艾AA 的信息'),(2,'这是 艾BB 的信息'),(3,'这是 艾CC 的信息'),(5,'这是 艾EE 的信息');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(16) default NULL,
  `password` varchar(10) default NULL,
  `phone` varchar(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`phone`) values (1,'艾AA','123456','18811112222'),(2,'程心','123456','18833334444'),(3,'艾AA','123456','18855556666'),(4,'维德','123456','18877778888');

/* Function  structure for function  `get_date` */

/*!50003 DROP FUNCTION IF EXISTS `get_date` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `get_date`() RETURNS varchar(50) CHARSET utf8
return date_format(now(), '%Y年-%m月-%d日 %H时:%i分:%s秒') */$$
DELIMITER ;

/* Procedure structure for procedure `sp_version` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_version` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_version`()
select VERSION() */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
