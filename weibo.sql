/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : weibo

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2016-05-26 13:15:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `account_id` int(5) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `pic` varchar(150) DEFAULT NULL,
  `follow` int(11) DEFAULT NULL,
  `fans` int(11) DEFAULT NULL,
  `weibo` int(11) DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `Unique_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'zs@163.com', '123456', '大王来巡山', '1.jpg', '1', '1', '17');
INSERT INTO `account` VALUES ('17', 'ls@163.com', '123456', '我是17', '2.jpg', '0', '0', '0');
INSERT INTO `account` VALUES ('18', 'ls2@163.com', '123456', '我是18', '3.jpg', '0', '0', '1');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `cid` int(5) NOT NULL AUTO_INCREMENT,
  `account_id` int(5) DEFAULT NULL,
  `wid` int(5) DEFAULT NULL,
  `comment_content` varchar(140) DEFAULT NULL,
  `cdatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cid`),
  KEY `FK_Relationship_3` (`wid`),
  KEY `FK_Relationship_4` (`account_id`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`wid`) REFERENCES `weibo` (`wid`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `fid` int(5) NOT NULL AUTO_INCREMENT,
  `account_id` int(5) DEFAULT NULL,
  `follow` int(11) DEFAULT NULL,
  PRIMARY KEY (`fid`),
  KEY `FK_Relationship_1` (`account_id`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of follow
-- ----------------------------
INSERT INTO `follow` VALUES ('1', '18', '1');
INSERT INTO `follow` VALUES ('2', '18', '17');
INSERT INTO `follow` VALUES ('3', '17', '1');
INSERT INTO `follow` VALUES ('4', '1', '17');
INSERT INTO `follow` VALUES ('5', '1', '18');

-- ----------------------------
-- Table structure for weibo
-- ----------------------------
DROP TABLE IF EXISTS `weibo`;
CREATE TABLE `weibo` (
  `wid` int(5) NOT NULL AUTO_INCREMENT,
  `account_id` int(5) DEFAULT NULL,
  `content` varchar(140) DEFAULT NULL,
  `liked` int(11) DEFAULT NULL,
  `comment` int(11) DEFAULT NULL,
  `wdatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`wid`),
  KEY `FK_Relationship_2` (`account_id`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibo
-- ----------------------------
INSERT INTO `weibo` VALUES ('1', '1', 'hello11', null, null, '2016-05-24 09:57:13');
INSERT INTO `weibo` VALUES ('2', '1', 'world111', null, null, '2016-05-24 09:57:30');
INSERT INTO `weibo` VALUES ('3', '17', '17hello', null, null, '2016-05-24 09:57:53');
INSERT INTO `weibo` VALUES ('4', '18', '18hello', null, null, '2016-05-24 09:58:06');
INSERT INTO `weibo` VALUES ('5', '1', 'test', '0', '0', '2016-05-26 10:58:41');
INSERT INTO `weibo` VALUES ('6', '1', 'test4', '0', '0', '2016-05-26 11:04:23');
INSERT INTO `weibo` VALUES ('7', '1', 'test5', '0', '0', '2016-05-26 11:07:05');
INSERT INTO `weibo` VALUES ('8', '1', 'tes9', '0', '0', '2016-05-26 11:14:19');
INSERT INTO `weibo` VALUES ('9', '1', 'test9', '0', '0', '2016-05-26 11:21:55');
INSERT INTO `weibo` VALUES ('10', '1', '我的第一条测试微薄', '0', '0', '2016-05-26 11:58:02');
INSERT INTO `weibo` VALUES ('11', '1', '我的第一条测试微薄', '0', '0', '2016-05-26 11:59:59');
INSERT INTO `weibo` VALUES ('12', '1', '我的第一条测试微薄2', '0', '0', '2016-05-26 12:00:04');
INSERT INTO `weibo` VALUES ('13', '1', '我的第一条测试微薄2234234234234234', '0', '0', '2016-05-26 12:02:21');
INSERT INTO `weibo` VALUES ('14', '1', '我的第一条测试微薄2234234234234234', '0', '0', '2016-05-26 12:02:41');
INSERT INTO `weibo` VALUES ('15', '1', '我的第一条测试微薄2234234234234234\nsafasfdafsafasf', '0', '0', '2016-05-26 12:05:47');
INSERT INTO `weibo` VALUES ('16', '1', '我的第一条测试微薄2234234234234234\nsafasfdafsafasf', '0', '0', '2016-05-26 12:12:39');
INSERT INTO `weibo` VALUES ('17', '1', 'sdfdsf', '0', '0', '2016-05-26 12:12:47');
INSERT INTO `weibo` VALUES ('18', '1', 'sdfsdfsdfsdf', '0', '0', '2016-05-26 12:13:15');
INSERT INTO `weibo` VALUES ('19', '1', 'sdfsdfsdfsdf', '0', '0', '2016-05-26 12:13:19');
INSERT INTO `weibo` VALUES ('20', '1', 'sss', '0', '0', '2016-05-26 12:13:21');
INSERT INTO `weibo` VALUES ('21', '18', 'afdfsdfsdfd', '0', '0', '2016-05-26 13:14:46');
