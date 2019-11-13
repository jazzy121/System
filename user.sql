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

 Date: 13/11/2019 09:00:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id编号\r\n作账户登录编号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `pwd` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户权限限制\r\nstudent 学生\r\nteacher 老师\r\nadmin 管理员',
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '性别\r\n',
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '管理员或老师的联系邮箱',
  `depart` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '学生院系或者老师院系',
  `degree` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '老师学历',
  `occupation` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '老师职称',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '管理员或老师的联系电话',
  `major` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '学生专业',
  `classname` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '学生班级',
  `gmt_created` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建日期',
  `gmt_modified` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('A12345', '管理员', 'ac286a2b8639aea46a0a13ede98a614b', 'admin', 'male', '123456789@qq.com', NULL, NULL, NULL, '12345678910', NULL, NULL, '2019-11-10 13:47:37', '2019-11-10 13:47:37');
INSERT INTO `user` VALUES ('B12345', '吖', 'ac286a2b8639aea46a0a13ede98a614b', 'student', '男', '', '物联网', NULL, NULL, '', '物联网', 'B18222', '2019-11-12 10:29:04', '2019-11-12 10:29:04');
INSERT INTO `user` VALUES ('B123456', 'W', 'ac286a2b8639aea46a0a13ede98a614b', 'student', '男', '', '物联网', NULL, NULL, '', '物联网', 'B18221', '2019-11-12 10:30:04', '2019-11-12 10:30:04');
INSERT INTO `user` VALUES ('B12365', '重复', '723c64c5a89c1192c4378f595a2780ee', 'student', '男', '', '计算机', NULL, NULL, '', '软件工程', 'B141011', '2019-11-12 09:57:51', '2019-11-12 09:57:51');
INSERT INTO `user` VALUES ('B18010101', '肖程旭', 'ac286a2b8639aea46a0a13ede98a614b', 'student', '男', '123456789@qq.com', '计软网安院', NULL, NULL, '12345678910', '软件工程', 'B180101', '2019-11-10 13:58:26', '2019-11-10 13:58:26');
INSERT INTO `user` VALUES ('B18031622', '岑海昊', 'ac286a2b8639aea46a0a13ede98a614b', 'student', 'male', '972579187@qq.com', '计软院', NULL, NULL, '13128225306', '软件工程', 'NIIT', '2019-11-10 13:47:37', '2019-11-10 13:47:37');
INSERT INTO `user` VALUES ('T12345', '李小明', 'ac286a2b8639aea46a0a13ede98a614b', 'teacher', 'male', '987654321@qq.com', '软件学院', '博士', '正高级教师', '10987654321', '计算机科学', NULL, '2019-11-11 19:16:12', '2019-11-11 19:16:12');
INSERT INTO `user` VALUES ('T180101', '凌落宸', 'ac286a2b8639aea46a0a13ede98a614b', 'teacher', 'female', '111111111@qq.com', '外语学院', '博士', '正高级教师', '10987654321', '英语文学', NULL, '2019-11-11 19:16:28', '2019-11-11 19:16:28');
INSERT INTO `user` VALUES ('T190101', '武德训', 'ac286a2b8639aea46a0a13ede98a614b', 'teacher', 'male', '999999999@qq.com', '现代邮政学院', '博士', '正高级教师', '10987654321', '邮政', NULL, '2019-11-11 19:16:12', '2019-11-11 19:16:12');
INSERT INTO `user` VALUES ('T45678', '玉小刚', 'ac286a2b8639aea46a0a13ede98a614b', 'teacher', 'male', '987654321@qq.com', '软件学院', '博士', '正高级教师', '10987654321', '计算机科学', NULL, '2019-11-11 19:16:12', '2019-11-11 19:16:12');
INSERT INTO `user` VALUES ('T54321', '王大锤', 'ac286a2b8639aea46a0a13ede98a614b', 'teacher', 'male', '987654321@qq.com', '软件学院', '博士', '正高级教师', '10987654321', '计算机科学', NULL, '2019-11-11 19:16:28', '2019-11-11 19:16:28');
INSERT INTO `user` VALUES ('T87654', '赵培德', 'ac286a2b8639aea46a0a13ede98a614b', 'teacher', 'male', '987654321@qq.com', '软件学院', '博士', '正高级教师', '10987654321', '通信工程', NULL, '2019-11-11 19:16:28', '2019-11-11 19:16:28');

SET FOREIGN_KEY_CHECKS = 1;
