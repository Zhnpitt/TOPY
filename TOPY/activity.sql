/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : activity

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2022-11-21 13:19:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `act_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `act_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sponsor` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `co_organizer` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sign_up_start_date` datetime DEFAULT NULL,
  `sign_up_end_date` datetime DEFAULT NULL,
  `act_start_date` datetime DEFAULT NULL,
  `act_end_date` datetime DEFAULT NULL,
  `act_content` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `count_tmp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('25', '1', null, '1', 'parent', '2022-11-01 00:00:00', '2022-11-24 00:00:00', '2022-11-09 00:00:00', '2022-12-01 00:00:00', '123', '99');
INSERT INTO `activity` VALUES ('26', '陪孩子散步', null, '小芳姥爷', 'parent', '2022-11-21 00:00:00', '2022-11-21 00:00:00', '2022-11-21 00:00:00', '2022-11-21 00:00:00', '1', '0');

-- ----------------------------
-- Table structure for activity_sign_in
-- ----------------------------
DROP TABLE IF EXISTS `activity_sign_in`;
CREATE TABLE `activity_sign_in` (
  `user_id` int(11) NOT NULL DEFAULT '0',
  `activity_id` int(11) NOT NULL DEFAULT '0',
  `sign_in_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`,`activity_id`),
  KEY `activity_id` (`activity_id`),
  CONSTRAINT `activity_sign_in_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `activity_sign_in_ibfk_3` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of activity_sign_in
-- ----------------------------
INSERT INTO `activity_sign_in` VALUES ('55', '25', '2022-11-21 11:21:23');

-- ----------------------------
-- Table structure for activity_sign_up
-- ----------------------------
DROP TABLE IF EXISTS `activity_sign_up`;
CREATE TABLE `activity_sign_up` (
  `user_id` int(11) NOT NULL DEFAULT '0',
  `activity_id` int(11) NOT NULL DEFAULT '0',
  `sign_up_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`,`activity_id`),
  KEY `activity_id` (`activity_id`),
  CONSTRAINT `activity_sign_up_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `activity_sign_up_ibfk_2` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of activity_sign_up
-- ----------------------------
INSERT INTO `activity_sign_up` VALUES ('55', '25', '2022-11-21 11:21:20');

-- ----------------------------
-- Table structure for dafen
-- ----------------------------
DROP TABLE IF EXISTS `dafen`;
CREATE TABLE `dafen` (
  `userid` varchar(11) NOT NULL,
  `activity_id` varchar(11) NOT NULL,
  `fenshu` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `actname` varchar(255) DEFAULT NULL,
  `dafenren` varchar(255) DEFAULT NULL,
  `dafenren_id` varchar(255) DEFAULT NULL,
  UNIQUE KEY `a1` (`userid`,`activity_id`,`dafenren`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dafen
-- ----------------------------
INSERT INTO `dafen` VALUES ('老人', '18', '100', 'very good', '去人民公园跳广场舞', null, null);
INSERT INTO `dafen` VALUES ('老人', '18', '100', 'very good', '去人民公园跳广场舞', '小明家长', null);
INSERT INTO `dafen` VALUES ('1', '20', '100', 'very good', '1', '小明家长', null);
INSERT INTO `dafen` VALUES ('小芳姥爷', '21', '50', 'just soso', '遛狗', '我是宠物', null);
INSERT INTO `dafen` VALUES ('1', '25', '100', 'very good', '1', '小明家长', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `register_date` datetime DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('55', '小明家长', 'parent', '123', '2022-11-19 18:31:30', '男', '123');
INSERT INTO `user` VALUES ('56', '小芳姥爷', 'elderly', '123', '2022-11-19 18:48:06', '男', '11111');
INSERT INTO `user` VALUES ('57', '我是宠物', 'pets', '123', '2022-11-19 19:24:31', '男', '2222');

-- ----------------------------
-- Table structure for yuanwang
-- ----------------------------
DROP TABLE IF EXISTS `yuanwang`;
CREATE TABLE `yuanwang` (
  `content` varchar(1000) DEFAULT NULL,
  `leixing` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sn` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`sn`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yuanwang
-- ----------------------------
INSERT INTO `yuanwang` VALUES ('dfdsfdsfdsfqetsdgfdfdasgwearasdfsafeas', 'fumu', '父母', '6');
INSERT INTO `yuanwang` VALUES ('', 'fumu', '父母', '7');
INSERT INTO `yuanwang` VALUES ('123123', '小明家长', 'parent', '8');
