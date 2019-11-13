~~~sql
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

~~~

~~~sql
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
~~~
~~~text
+---.idea
|   +---artifacts
|   \---libraries
+---.mvn
|   \---wrapper
+---bin
|   +---.mvn
|   |   \---wrapper
|   \---src
|       +---main
|       |   +---java
|       |   |   \---com
|       |   |       \---selectCourse
|       |   |           \---System
|       |   \---resources
|       \---test
|           \---java
|               \---com
|                   \---selectCourse
|                       \---System
\---src
    +---main
    |   +---java
    |   |   \---com
    |   |       \---system
    |   |           +---controller
    |   |           +---dao
    |   |           +---dataobject
    |   |           +---dto
    |   |           +---eNum
    |   |           \---utils
    |   \---resources
    |       +---mapper
    |       +---static
    |       |   +---css
    |       |   +---fonts
    |       |   +---images
    |       |   \---js
    |       \---templates
    \---test
        \---java
            \---com
                \---system
~~~