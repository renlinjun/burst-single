/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : system

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-05-15 18:38:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `ID` varchar(32) DEFAULT NULL COMMENT '账号主键',
  `ACCOUNT_NAME` varchar(20) DEFAULT NULL COMMENT '登录账号',
  `PASSWD` varchar(32) DEFAULT NULL COMMENT '密码',
  `USER_INFO_ID` varchar(32) DEFAULT NULL COMMENT '关联的人员详细信息ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ID` varchar(32) NOT NULL COMMENT '主键ID',
  `ROLE_CODE` varchar(32) DEFAULT NULL COMMENT '角色代码，唯一',
  `ROLE_NAME` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `ROLE_TYPE_ID` varchar(20) DEFAULT NULL COMMENT '角色类型',
  `ROLE_DESC` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `APP_ID` varchar(32) DEFAULT NULL COMMENT '所属应用',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_type
-- ----------------------------
DROP TABLE IF EXISTS `role_type`;
CREATE TABLE `role_type` (
  `ID` varchar(32) NOT NULL,
  `ROLE_TYPE_ID` varchar(20) DEFAULT NULL,
  `ROLE_TYPE_NAME` varchar(32) DEFAULT NULL,
  `ROLE_DESC` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_type
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `ID` varchar(32) NOT NULL COMMENT '主键ID',
  `USER_ID` varchar(20) DEFAULT NULL COMMENT '人员编号',
  `USER_NAME` varchar(20) DEFAULT NULL COMMENT '人员姓名',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `SEX` char(2) DEFAULT NULL COMMENT '性别(0:男，1：女，3:其它)',
  `AGE` varchar(4) DEFAULT NULL COMMENT '年龄',
  `DEL_FLAG` char(2) DEFAULT NULL COMMENT '人员信息状态(Y:可用，N：删除)',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'test@123', '测试账户', '1124@163.com', '1', '18', 'N');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `USER_ID` char(10) NOT NULL COMMENT '人员ID',
  `ROLE_ID` char(10) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`USER_ID`,`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
