/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : weather

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-07-27 14:17:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for air_speed
-- ----------------------------
DROP TABLE IF EXISTS `air_speed`;
CREATE TABLE `air_speed` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `air_speed` double(11,0) DEFAULT NULL,
  `catch_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of air_speed
-- ----------------------------
INSERT INTO `air_speed` VALUES ('1', null, 'Thu Jul 26 19:04:59 SGT 2018');
INSERT INTO `air_speed` VALUES ('2', '10', 'Thu Jul 26 19:05:27 SGT 2018');
INSERT INTO `air_speed` VALUES ('3', '11', 'Fri Jul 27 13:13:44 SGT 2018');

-- ----------------------------
-- Table structure for atmospheric_pressure
-- ----------------------------
DROP TABLE IF EXISTS `atmospheric_pressure`;
CREATE TABLE `atmospheric_pressure` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `atmospheric_pressure` double(11,0) DEFAULT NULL,
  `catch_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of atmospheric_pressure
-- ----------------------------
INSERT INTO `atmospheric_pressure` VALUES ('1', '10005', 'Thu Jul 26 19:14:16 SGT 2018');
INSERT INTO `atmospheric_pressure` VALUES ('2', '9999', 'Fri Jul 27 12:21:45 SGT 2018');

-- ----------------------------
-- Table structure for humidity_indoor
-- ----------------------------
DROP TABLE IF EXISTS `humidity_indoor`;
CREATE TABLE `humidity_indoor` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `humidity` double(11,0) DEFAULT NULL,
  `catch_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of humidity_indoor
-- ----------------------------
INSERT INTO `humidity_indoor` VALUES ('1', '27', 'Thu Jul 26 17:36:45 SGT 2018');
INSERT INTO `humidity_indoor` VALUES ('2', '27', 'Thu Jul 26 18:53:58 SGT 2018');
INSERT INTO `humidity_indoor` VALUES ('3', '26', 'Fri Jul 27 13:05:41 SGT 2018');

-- ----------------------------
-- Table structure for humidity_outdoor
-- ----------------------------
DROP TABLE IF EXISTS `humidity_outdoor`;
CREATE TABLE `humidity_outdoor` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `humidity` double(11,0) DEFAULT NULL,
  `catch_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of humidity_outdoor
-- ----------------------------
INSERT INTO `humidity_outdoor` VALUES ('1', '50', 'Thu Jul 26 17:43:15 SGT 2018');
INSERT INTO `humidity_outdoor` VALUES ('2', '50', 'Fri Jul 27 13:10:17 SGT 2018');
INSERT INTO `humidity_outdoor` VALUES ('3', '50', 'Fri Jul 27 13:10:25 SGT 2018');

-- ----------------------------
-- Table structure for illumination_indoor
-- ----------------------------
DROP TABLE IF EXISTS `illumination_indoor`;
CREATE TABLE `illumination_indoor` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `illumination` double(11,0) DEFAULT NULL,
  `catch_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of illumination_indoor
-- ----------------------------
INSERT INTO `illumination_indoor` VALUES ('1', null, 'Thu Jul 26 18:55:14 SGT 2018');
INSERT INTO `illumination_indoor` VALUES ('2', '150', 'Thu Jul 26 18:56:05 SGT 2018');
INSERT INTO `illumination_indoor` VALUES ('3', '150', 'Fri Jul 27 13:05:58 SGT 2018');
INSERT INTO `illumination_indoor` VALUES ('4', '150', 'Fri Jul 27 13:06:21 SGT 2018');

-- ----------------------------
-- Table structure for illumination_outdoor
-- ----------------------------
DROP TABLE IF EXISTS `illumination_outdoor`;
CREATE TABLE `illumination_outdoor` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `illumination` double(11,0) DEFAULT NULL,
  `catch_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of illumination_outdoor
-- ----------------------------
INSERT INTO `illumination_outdoor` VALUES ('1', '10000', 'Thu Jul 26 18:43:14 SGT 2018');

-- ----------------------------
-- Table structure for outdoors
-- ----------------------------
DROP TABLE IF EXISTS `outdoors`;
CREATE TABLE `outdoors` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  ` temperature` double(20,0) DEFAULT NULL,
  `humidity` double(20,0) DEFAULT NULL,
  `illumination_intensity` double(20,0) DEFAULT NULL,
  `ultraviolet_ray` double(20,0) DEFAULT NULL,
  `air_speed` double(20,0) DEFAULT NULL,
  `wind_direction` varchar(255) DEFAULT NULL,
  `atmospheric_pressure` double(20,0) DEFAULT NULL,
  `catch_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outdoors
-- ----------------------------
INSERT INTO `outdoors` VALUES ('1', '27', '50', '50', '0', '2', 'EW', '10000', '2018-07-26 16:30:00');

-- ----------------------------
-- Table structure for temperature_indoor
-- ----------------------------
DROP TABLE IF EXISTS `temperature_indoor`;
CREATE TABLE `temperature_indoor` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `temperature` double(11,0) DEFAULT NULL,
  `catch_time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of temperature_indoor
-- ----------------------------
INSERT INTO `temperature_indoor` VALUES ('1', '26', null);
INSERT INTO `temperature_indoor` VALUES ('2', '27', 'Thu Jul 26 17:11:17 SGT 2018');
INSERT INTO `temperature_indoor` VALUES ('3', '30', 'Fri Jul 27 13:05:20 SGT 2018');

-- ----------------------------
-- Table structure for temperature_outdoor
-- ----------------------------
DROP TABLE IF EXISTS `temperature_outdoor`;
CREATE TABLE `temperature_outdoor` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `temperature` double(11,0) DEFAULT NULL,
  `catch_time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of temperature_outdoor
-- ----------------------------
INSERT INTO `temperature_outdoor` VALUES ('1', '35', 'Thu Jul 26 17:27:29 SGT 2018');
INSERT INTO `temperature_outdoor` VALUES ('2', '35', 'Fri Jul 27 13:09:46 SGT 2018');

-- ----------------------------
-- Table structure for ultraviolet
-- ----------------------------
DROP TABLE IF EXISTS `ultraviolet`;
CREATE TABLE `ultraviolet` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `ultraviolet` double(11,0) DEFAULT NULL,
  `catch_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ultraviolet
-- ----------------------------
INSERT INTO `ultraviolet` VALUES ('1', '15', 'Thu Jul 26 19:31:15 SGT 2018');

-- ----------------------------
-- Table structure for wind_direction
-- ----------------------------
DROP TABLE IF EXISTS `wind_direction`;
CREATE TABLE `wind_direction` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `wind_direction` varchar(255) DEFAULT NULL,
  `catch_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wind_direction
-- ----------------------------
INSERT INTO `wind_direction` VALUES ('1', 'South-East', 'Thu Jul 26 19:22:41 SGT 2018');
INSERT INTO `wind_direction` VALUES ('2', null, 'Thu Jul 26 19:30:59 SGT 2018');
INSERT INTO `wind_direction` VALUES ('3', 'South-East', 'Thu Jul 26 20:16:16 SGT 2018');
