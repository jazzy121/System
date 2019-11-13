/*
 Navicat Premium Data Transfer

 Source Server         : bluer
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 118.31.68.37:3306
 Source Schema         : System

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 13/11/2019 09:00:19
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
  `teacher_id` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '授课老师编号',
  `class_hour` int(4) NOT NULL COMMENT '课时',
  `credit` int(4) NOT NULL COMMENT '学分',
  `time` datetime(0) NOT NULL COMMENT '开课时间',
  `total` int(4) NOT NULL COMMENT '总人数',
  `selectedN` int(4) NOT NULL COMMENT '已选人数',
  `place` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地点',
  `priviousC` int(4) DEFAULT NULL COMMENT '先行课',
  `target` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT ',分隔 用户编号',
  `gmt_created` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建日期',
  `gmt_modified` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '高等数学', 'T12345,', 36, 3, '2019-09-02 08:00:00', 60, 1, '教三-101', 4, 'B18031622,B12345,', '2019-11-12 18:51:46', '2019-11-12 18:51:46');
INSERT INTO `course` VALUES (2, '离散数学', 'T54321,', 48, 3, '2019-09-02 10:50:00', 100, 2, '教三-102', NULL, 'B18031622,B12345,', '2019-11-12 18:51:47', '2019-11-12 18:51:47');
INSERT INTO `course` VALUES (4, 'test2', 'T12345,T54321,', 36, 4, '2020-01-15 08:00:00', 100, 6, 'test地点', 4, 'S12345,B18031622,B12345,', '2019-11-12 18:51:48', '2019-11-12 18:51:48');
INSERT INTO `course` VALUES (5, 'TEsta', 'T12345,', 32, 32, '2019-01-01 00:01:00', 1, 1, '教三-102', 4, 'B12345,', '2019-11-12 18:51:48', '2019-11-12 18:51:48');

SET FOREIGN_KEY_CHECKS = 1;
