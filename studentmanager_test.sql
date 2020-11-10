/*
 Navicat Premium Data Transfer

 Source Server         : studentmanager
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : studentmanager_test

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 07/11/2020 20:19:15
*/

use database studentmanager_test;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for s_admin
-- ----------------------------
DROP TABLE IF EXISTS `s_admin`;
CREATE TABLE `s_admin`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_admin
-- ----------------------------
INSERT INTO `s_admin` VALUES (1, 'admin', '123456');

-- ----------------------------
-- Table structure for s_attendance
-- ----------------------------
DROP TABLE IF EXISTS `s_attendance`;
CREATE TABLE `s_attendance`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `course_id` int(0) NOT NULL,
  `student_id` int(0) NOT NULL,
  `time` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_attendance
-- ----------------------------

-- ----------------------------
-- Table structure for s_class
-- ----------------------------
DROP TABLE IF EXISTS `s_class`;
CREATE TABLE `s_class`  (
  `class_id` int(0) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `info` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tid` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_class
-- ----------------------------
INSERT INTO `s_class` VALUES (1, '计算机一班', '计算机', 101);
INSERT INTO `s_class` VALUES (17, '软件一班', '软件', 0);
INSERT INTO `s_class` VALUES (19, '计算机一班p', NULL, 0);
INSERT INTO `s_class` VALUES (22, '计算机一班', 'a', 104);
INSERT INTO `s_class` VALUES (23, '计算机一班dsfa ', '计算机一般', 4564);
INSERT INTO `s_class` VALUES (24, '计算机一班789', '计算机一般', 152);

-- ----------------------------
-- Table structure for s_course
-- ----------------------------
DROP TABLE IF EXISTS `s_course`;
CREATE TABLE `s_course`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tid` int(0) NOT NULL,
  `course_date` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `residue_num` int(0) NOT NULL,
  `max_num` int(0) NOT NULL,
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_course
-- ----------------------------
INSERT INTO `s_course` VALUES (3, '软件工程', 102, '骤热', 456, 456, '计算机一般');

-- ----------------------------
-- Table structure for s_leave
-- ----------------------------
DROP TABLE IF EXISTS `s_leave`;
CREATE TABLE `s_leave`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `sid` int(0) NOT NULL,
  `info` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 0,
  `remark` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_leave
-- ----------------------------
INSERT INTO `s_leave` VALUES (1, 1, '生病', 1, '可以');

-- ----------------------------
-- Table structure for s_score
-- ----------------------------
DROP TABLE IF EXISTS `s_score`;
CREATE TABLE `s_score`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `sid` int(0) NOT NULL,
  `cource_id` int(0) NOT NULL,
  `score` double(5, 2) NOT NULL,
  `remark` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_score
-- ----------------------------

-- ----------------------------
-- Table structure for s_student
-- ----------------------------
DROP TABLE IF EXISTS `s_student`;
CREATE TABLE `s_student`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `sid` int(0) NOT NULL,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `class_id` int(0) NOT NULL,
  `sex` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '男',
  `mobile` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_student
-- ----------------------------
INSERT INTO `s_student` VALUES (11, 1, 'ad', '123', 2, '男', '456');
INSERT INTO `s_student` VALUES (12, 123, 'admin', 'a', 1, '男', '456');
INSERT INTO `s_student` VALUES (13, 128, '王麻子', '202cb962ac59075b964b07152d234b70', 22, '男', '31531');

-- ----------------------------
-- Table structure for s_teacher
-- ----------------------------
DROP TABLE IF EXISTS `s_teacher`;
CREATE TABLE `s_teacher`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `tid` int(0) NOT NULL,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `class_id` int(0) NULL DEFAULT 0,
  `sex` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '男',
  `mobile` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_teacher
-- ----------------------------
INSERT INTO `s_teacher` VALUES (10, 102, '李四老师', '111', 15, '男', '13656565656');
INSERT INTO `s_teacher` VALUES (18, 104, '夏青松', '123456', 22, '女', '15174857845');
INSERT INTO `s_teacher` VALUES (19, 105, '光头强', '12345', 0, '男', '456456');

SET FOREIGN_KEY_CHECKS = 1;
