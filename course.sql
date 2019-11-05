/*
 Navicat Premium Data Transfer

 Source Server         : ch33
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : douban

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 04/11/2019 10:31:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(4) NOT NULL COMMENT '课程id',
  `course_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程名',
  `teacher_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '授课老师编号',
  `class_hour` int(4) NOT NULL COMMENT '课时',
  `credit` int(4) NOT NULL COMMENT '学分',
  `time` datetime(0) NOT NULL COMMENT '开课时间',
  `total` int(4) DEFAULT NULL COMMENT '总人数',
  `selectedN` int(4) NOT NULL COMMENT '已选人数',
  `place` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地点',
  `priviousC` int(4) DEFAULT NULL COMMENT '先行课',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
