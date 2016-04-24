/*
 Navicat Premium Data Transfer

 Source Server         : 50.117.87.158
 Source Server Type    : MySQL
 Source Server Version : 50173
 Source Host           : 50.117.87.158
 Source Database       : egouer

 Target Server Type    : MySQL
 Target Server Version : 50173
 File Encoding         : utf-8

 Date: 04/22/2016 00:27:23 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `Function`
-- ----------------------------
DROP TABLE IF EXISTS `Function`;
CREATE TABLE `Function` (
  `functionId` bigint(11) NOT NULL,
  `functionName` varchar(20) NOT NULL,
  `functionCode` varchar(10) NOT NULL,
  `addTime` datetime NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  `functionUrl` varchar(30) DEFAULT NULL,
  `functionType` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`functionId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `Menu`
-- ----------------------------
DROP TABLE IF EXISTS `Menu`;
CREATE TABLE `Menu` (
  `menuId` bigint(11) NOT NULL,
  `menuName` varchar(50) NOT NULL,
  `orderNum` int(2) NOT NULL DEFAULT '0',
  `status` varchar(10) NOT NULL,
  `addTime` datetime NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  `menuCode` varchar(10) NOT NULL,
  `menuType` varchar(10) NOT NULL COMMENT '菜单类型：菜单，模块',
  `supMenuCode` varchar(10) NOT NULL DEFAULT '0',
  `menuUrl` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `Role`
-- ----------------------------
DROP TABLE IF EXISTS `Role`;
CREATE TABLE `Role` (
  `roleId` bigint(11) NOT NULL,
  `roleName` varchar(20) NOT NULL,
  `addTime` datetime NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  `roleCode` varchar(10) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `RoleFunction`
-- ----------------------------
DROP TABLE IF EXISTS `RoleFunction`;
CREATE TABLE `RoleFunction` (
  `roleFunctionId` bigint(11) NOT NULL,
  `roleCode` varchar(10) NOT NULL,
  `functionCode` varchar(10) NOT NULL,
  `addTime` datetime NOT NULL,
  PRIMARY KEY (`roleFunctionId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `RoleMenu`
-- ----------------------------
DROP TABLE IF EXISTS `RoleMenu`;
CREATE TABLE `RoleMenu` (
  `roleMenuId` bigint(11) NOT NULL,
  `menuCode` varchar(10) NOT NULL,
  `roleCode` varchar(10) NOT NULL,
  `addTime` datetime NOT NULL,
  PRIMARY KEY (`roleMenuId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `User`
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `userId` bigint(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) NOT NULL,
  `password` varchar(32) NOT NULL,
  `status` varchar(10) NOT NULL,
  `addTime` datetime NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `UserRole`
-- ----------------------------
DROP TABLE IF EXISTS `UserRole`;
CREATE TABLE `UserRole` (
  `userRoleId` bigint(11) NOT NULL,
  `userId` bigint(11) NOT NULL,
  `roleCode` varchar(10) NOT NULL,
  `addTime` datetime DEFAULT NULL,
  PRIMARY KEY (`userRoleId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
