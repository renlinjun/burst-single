/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : burst

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-05-31 19:15:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `ID` varchar(32) NOT NULL COMMENT '账号主键',
  `ACCOUNT_NAME` varchar(20) DEFAULT NULL COMMENT '登录账号',
  `PASSWD` varchar(32) DEFAULT NULL COMMENT '密码',
  `USER_INFO_ID` varchar(32) DEFAULT NULL COMMENT '关联的人员详细信息ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统账户表';

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'admin@test', '123456', '1');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `ID` varchar(32) NOT NULL COMMENT '主键ID',
  `DEPT_CODE` varchar(20) DEFAULT NULL COMMENT '部门代码',
  `DEPT_NAME` varchar(20) DEFAULT NULL COMMENT '部门名称',
  `DEPT_TYPE` char(2) DEFAULT NULL COMMENT '部门类型',
  `P_DEPT` varchar(32) DEFAULT NULL COMMENT '上级部门',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门信息';

-- ----------------------------
-- Records of dept
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `ID` varchar(32) NOT NULL COMMENT '主键ID',
  `MENU_CODE` varchar(40) DEFAULT NULL COMMENT '菜单代码',
  `MENU_NAME` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `MENU_URL` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `APP_ID` varchar(32) DEFAULT NULL COMMENT '菜单所属应用',
  `P_ID` varchar(32) DEFAULT NULL COMMENT '上级菜单ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for opt_resource
-- ----------------------------
DROP TABLE IF EXISTS `opt_resource`;
CREATE TABLE `opt_resource` (
  `ID` char(10) NOT NULL COMMENT '主键ID',
  `RESOURCE_NAME` varchar(20) DEFAULT NULL COMMENT '资源名称',
  `RESOURCE_URL` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `RESOURCE_CODE` varchar(20) DEFAULT NULL COMMENT '资源代码',
  `USE_LOGIN` varchar(8) DEFAULT NULL COMMENT '是否需要登录(true,false)',
  `IS_SIGN` varchar(8) DEFAULT NULL COMMENT '是否需要签名(true.false)',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能操作资源表';

-- ----------------------------
-- Records of opt_resource
-- ----------------------------
INSERT INTO `opt_resource` VALUES ('1', '2', '3', '4', '5', '6');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `ID` varchar(32) NOT NULL COMMENT '主键ID',
  `PERMISSION_NAME` varchar(20) DEFAULT NULL COMMENT '权限名称',
  `PERMISSION_CODE` varchar(20) DEFAULT NULL COMMENT '权限代码',
  `PERMISSION_TYPE_ID` varchar(32) DEFAULT NULL COMMENT '权限类型ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '2', '3', '4');

-- ----------------------------
-- Table structure for permission_menu
-- ----------------------------
DROP TABLE IF EXISTS `permission_menu`;
CREATE TABLE `permission_menu` (
  `MENU_iD` varchar(32) NOT NULL COMMENT '菜单ID',
  `PERMISSION_ID` varchar(32) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`MENU_iD`,`PERMISSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限菜单表';

-- ----------------------------
-- Records of permission_menu
-- ----------------------------

-- ----------------------------
-- Table structure for permission_resource
-- ----------------------------
DROP TABLE IF EXISTS `permission_resource`;
CREATE TABLE `permission_resource` (
  `PERMISSION_ID` varchar(32) NOT NULL COMMENT '权限ID',
  `RESOURCE_ID` varchar(32) NOT NULL COMMENT '资源ID',
  `RESOURCE_TYPE` varchar(255) NOT NULL,
  PRIMARY KEY (`PERMISSION_ID`,`RESOURCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限资源关联表';

-- ----------------------------
-- Records of permission_resource
-- ----------------------------
INSERT INTO `permission_resource` VALUES ('1', '1', '');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `ROLE_ID` varchar(64) DEFAULT NULL COMMENT '角色ID',
  `PERMISSION_ID` varchar(64) DEFAULT NULL COMMENT '权限ID',
  `PERMISSION_TYPE` char(2) DEFAULT NULL COMMENT '权限类型（菜单权限，操作权限，元素权限）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for role_type
-- ----------------------------
DROP TABLE IF EXISTS `role_type`;
CREATE TABLE `role_type` (
  `ID` varchar(32) NOT NULL COMMENT '主键ID',
  `ROLE_TYPE_ID` varchar(20) DEFAULT NULL COMMENT '角色类型ID',
  `ROLE_TYPE_NAME` varchar(32) DEFAULT NULL COMMENT '角色类型名称',
  `ROLE_DESC` varchar(100) DEFAULT NULL COMMENT '类型描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色类型表';

-- ----------------------------
-- Records of role_type
-- ----------------------------

-- ----------------------------
-- Table structure for user_dept
-- ----------------------------
DROP TABLE IF EXISTS `user_dept`;
CREATE TABLE `user_dept` (
  `USER_ID` varchar(32) NOT NULL,
  `DEPT_ID` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_dept
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `ID` varchar(32) NOT NULL COMMENT '主键ID',
  `USER_CODE` varchar(20) DEFAULT NULL COMMENT '人员编号',
  `USER_NAME` varchar(20) DEFAULT NULL COMMENT '人员姓名',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `SEX` char(2) DEFAULT NULL COMMENT '性别(0:男，1：女，3:其它)',
  `AGE` varchar(4) DEFAULT NULL COMMENT '年龄',
  `TITLE` char(2) DEFAULT NULL COMMENT '职称',
  `STATUS` char(2) DEFAULT NULL COMMENT '人员信息状态(Y:可用，N：删除)',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员信息表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('09c3029f65344ae486f5c5e86e7c619b', 'admin', '测试人员', null, null, null, null, null);
INSERT INTO `user_info` VALUES ('e5245d7e718e4aeda7729e127aa47d69', 'admin', '测试人员', null, null, null, null, null);
INSERT INTO `user_info` VALUES ('fc831f67eb4d440086ac1c8997310d24', 'admin', '测试人员', null, null, null, null, null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `USER_ID` char(10) NOT NULL COMMENT '人员ID',
  `ROLE_ID` char(10) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`USER_ID`,`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员角色关联表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('111', '222');
INSERT INTO `user_role` VALUES ('333', '444');
SET FOREIGN_KEY_CHECKS=1;
