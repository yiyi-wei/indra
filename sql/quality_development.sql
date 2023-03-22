/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80024
Source Host           : localhost:3306
Source Database       : quality_development

Target Server Type    : MYSQL
Target Server Version : 80024
File Encoding         : 65001

Date: 2023-03-22 17:10:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `academic`
-- ----------------------------
DROP TABLE IF EXISTS `academic`;
CREATE TABLE `academic` (
  `id` char(19) NOT NULL COMMENT '学院id',
  `academic_name` varchar(255) NOT NULL COMMENT '学院名',
  `teacher_id` char(19) NOT NULL COMMENT '处理人id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='学院管理';

-- ----------------------------
-- Records of academic
-- ----------------------------
INSERT INTO `academic` VALUES ('1632453815116529665', '旅游管理系', '1632909338630811650', '2023-03-06 02:51:34', '2023-03-06 02:51:34');
INSERT INTO `academic` VALUES ('1632453850478706689', '信息教育系', '1632923126574739457', '2023-03-06 02:51:42', '2023-03-06 02:51:42');
INSERT INTO `academic` VALUES ('1632453871622193153', '文化艺术系', '1632923280044322817', '2023-03-06 02:51:47', '2023-03-06 02:51:47');

-- ----------------------------
-- Table structure for `class_info`
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `id` char(19) NOT NULL COMMENT '班级主键',
  `teacher_id` char(19) NOT NULL COMMENT '班主任id',
  `profession_id` char(19) NOT NULL COMMENT '专业id',
  `class_name` varchar(255) NOT NULL COMMENT '班级',
  `grade` int NOT NULL COMMENT '年级2020',
  `academic_id` char(19) NOT NULL COMMENT '学院id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='班级信息管理';

-- ----------------------------
-- Records of class_info
-- ----------------------------
INSERT INTO `class_info` VALUES ('1632456747610308609', '1632456586892967937', '1633673588793982978', '2022级旅游管理专业一班', '2022', '1632453815116529665', '2023-03-06 03:03:13', '2023-03-09 11:53:31');
INSERT INTO `class_info` VALUES ('1633098843002425346', '1633098753525338114', '1632455432909914114', '2021级婴幼儿托育服务与管理专业一班', '2021', '1632453850478706689', '2023-03-07 21:34:40', '2023-03-07 21:34:40');
INSERT INTO `class_info` VALUES ('1633676730923335681', '1637318970224873474', '1632454642455576577', '2023级酒店管理与数字化运营专业二班', '2023', '1632453815116529665', '2023-03-09 11:51:00', '2023-03-09 11:53:27');
INSERT INTO `class_info` VALUES ('1637308458950754306', '1632456586892967937', '1633673588793982978', '2022级旅游管理专业2班', '2022', '1632453815116529665', '2023-03-19 12:22:11', '2023-03-19 12:22:11');

-- ----------------------------
-- Table structure for `learn_year`
-- ----------------------------
DROP TABLE IF EXISTS `learn_year`;
CREATE TABLE `learn_year` (
  `id` char(19) NOT NULL COMMENT '学年id',
  `start_time` int DEFAULT NULL COMMENT '学年开始年份2020',
  `end_time` int DEFAULT NULL COMMENT '学年结束年份2021',
  `teacher_id` char(19) DEFAULT NULL COMMENT '处理人id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='学年信息管理';

-- ----------------------------
-- Records of learn_year
-- ----------------------------
INSERT INTO `learn_year` VALUES ('1559142366642724866', '2019', '2020', '1', '2022-08-15 19:38:02', '2022-08-15 19:38:02');
INSERT INTO `learn_year` VALUES ('1559142402428526593', '2020', '2021', '1', '2022-08-15 19:38:11', '2022-08-15 19:38:11');
INSERT INTO `learn_year` VALUES ('1559142422359859202', '2021', '2022', '1', '2022-08-15 19:38:16', '2022-08-15 19:38:16');
INSERT INTO `learn_year` VALUES ('1559154145804472321', '2018', '2019', null, '2022-08-15 20:24:51', '2022-08-15 20:24:51');
INSERT INTO `learn_year` VALUES ('1569286993286840322', '2022', '2023', null, '2022-09-12 19:29:10', '2022-09-12 19:29:10');
INSERT INTO `learn_year` VALUES ('1584543016801062914', '2017', '2018', null, '2022-10-24 21:51:09', '2022-10-24 21:51:09');
INSERT INTO `learn_year` VALUES ('1585227324582842370', '2023', '2024', null, '2022-10-26 19:10:21', '2022-10-26 19:10:21');

-- ----------------------------
-- Table structure for `manage_user`
-- ----------------------------
DROP TABLE IF EXISTS `manage_user`;
CREATE TABLE `manage_user` (
  `id` char(19) NOT NULL COMMENT '用户主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `role_id` char(19) NOT NULL COMMENT '角色Id',
  `user_real_name` varchar(16) NOT NULL COMMENT '用户的真实姓名',
  `academic_id` char(19) NOT NULL COMMENT '学院Id',
  `phone` varchar(11) NOT NULL COMMENT '电话号码',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='教师、团支书等用户信息表';

-- ----------------------------
-- Records of manage_user
-- ----------------------------
INSERT INTO `manage_user` VALUES ('1632456586892967937', 'lygl01', 'c4ca4238a0b923820dcc509a6f75849b', '3', '2022级旅游管理专业一班辅导员', '1632453815116529665', '13877778888', '2023-03-06 03:02:35', '2023-03-08 21:44:25');
INSERT INTO `manage_user` VALUES ('1632904199891185666', 'xc01', 'c4ca4238a0b923820dcc509a6f75849b', '5', '宣传委员', '1632453815116529665', '13877660011', '2023-03-07 08:41:14', '2023-03-07 08:41:14');
INSERT INTO `manage_user` VALUES ('1632904367885643777', 'zz01', 'c4ca4238a0b923820dcc509a6f75849b', '6', '组织委员', '1632453815116529665', '13899001122', '2023-03-07 08:41:54', '2023-03-07 08:41:54');
INSERT INTO `manage_user` VALUES ('1632906286037331969', 'root', 'c4ca4238a0b923820dcc509a6f75849b', '1', 'root', '1632453815116529665', '13800000000', '2023-03-07 08:49:31', '2023-03-07 08:49:31');
INSERT INTO `manage_user` VALUES ('1632909338630811650', 'xi01', 'c4ca4238a0b923820dcc509a6f75849b', '2', '基层团委', '1632453815116529665', '13277227711', '2023-03-07 09:01:39', '2023-03-07 18:42:26');
INSERT INTO `manage_user` VALUES ('1632910265991426049', 'tzs01', 'c4ca4238a0b923820dcc509a6f75849b', '4', '业一', '1632453815116529665', '13877771111', '2023-03-07 09:05:20', '2023-03-19 12:56:12');
INSERT INTO `manage_user` VALUES ('1632923126574739457', 'xi02', 'c4ca4238a0b923820dcc509a6f75849b', '2', '基层团委', '1632453850478706689', '13900221111', '2023-03-07 09:56:26', '2023-03-07 09:56:26');
INSERT INTO `manage_user` VALUES ('1632923280044322817', 'xi03', 'c4ca4238a0b923820dcc509a6f75849b', '2', '基层团委', '1632453871622193153', '13788119911', '2023-03-07 09:57:03', '2023-03-07 09:57:03');
INSERT INTO `manage_user` VALUES ('1633098753525338114', 'zhang', '45c48cce2e2d7fbdea1afc51c7c6ad26', '3', '钟浩', '1632453850478706689', '15945637891', '2023-03-07 21:34:19', '2023-03-07 21:34:19');
INSERT INTO `manage_user` VALUES ('1637318177404948481', 'tzs', 'c4ca4238a0b923820dcc509a6f75849b', '4', '团支书', '1632453815116529665', '13899992222', '2023-03-19 13:00:48', '2023-03-19 13:00:48');
INSERT INTO `manage_user` VALUES ('1637318970224873474', 'fdy', 'c4ca4238a0b923820dcc509a6f75849b', '3', '辅导员', '1632453815116529665', '13000009999', '2023-03-19 13:03:57', '2023-03-19 13:03:57');

-- ----------------------------
-- Table structure for `profession`
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession` (
  `id` char(19) NOT NULL COMMENT '专业id',
  `academic_id` char(19) NOT NULL COMMENT '学院id',
  `profession_name` varchar(255) DEFAULT NULL COMMENT '专业名',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='专业信息管理';

-- ----------------------------
-- Records of profession
-- ----------------------------
INSERT INTO `profession` VALUES ('1632454642455576577', '1632453815116529665', '酒店管理与数字化运营', '2023-03-06 02:54:51', '2023-03-08 20:17:57');
INSERT INTO `profession` VALUES ('1632454731693588482', '1632453815116529665', '中西面点工艺', '2023-03-06 02:55:12', '2023-03-06 02:55:12');
INSERT INTO `profession` VALUES ('1632454784512458754', '1632453815116529665', '会展策划与管理', '2023-03-06 02:55:25', '2023-03-06 02:55:25');
INSERT INTO `profession` VALUES ('1632454836026900482', '1632453815116529665', '研学旅行管理与服务', '2023-03-06 02:55:37', '2023-03-06 02:55:37');
INSERT INTO `profession` VALUES ('1632454918625329153', '1632453815116529665', '智慧景区开发与管理', '2023-03-06 02:55:57', '2023-03-06 02:55:57');
INSERT INTO `profession` VALUES ('1632454951487700994', '1632453815116529665', '智慧旅游技术应用', '2023-03-06 02:56:05', '2023-03-06 02:56:05');
INSERT INTO `profession` VALUES ('1632455033813499905', '1632453871622193153', '美容美体艺术', '2023-03-06 02:56:24', '2023-03-06 02:56:24');
INSERT INTO `profession` VALUES ('1632455095499128833', '1632453871622193153', '歌舞表演(声乐方向)', '2023-03-06 02:56:39', '2023-03-06 02:56:39');
INSERT INTO `profession` VALUES ('1632455189258600450', '1632453871622193153', '歌舞表演(舞蹈方向)', '2023-03-06 02:57:01', '2023-03-06 02:57:11');
INSERT INTO `profession` VALUES ('1632455355055243265', '1632453871622193153', '工艺美术品设计', '2023-03-06 02:57:41', '2023-03-06 02:57:41');
INSERT INTO `profession` VALUES ('1632455432909914114', '1632453850478706689', '婴幼儿托育服务与管理', '2023-03-06 02:57:59', '2023-03-06 02:57:59');
INSERT INTO `profession` VALUES ('1632455509913141250', '1632453850478706689', '大数据与财务管理', '2023-03-06 02:58:18', '2023-03-06 02:58:18');
INSERT INTO `profession` VALUES ('1632455575151345665', '1632453850478706689', '电子商务', '2023-03-06 02:58:33', '2023-03-06 02:58:33');
INSERT INTO `profession` VALUES ('1633673588793982978', '1632453815116529665', '旅游管理专业', '2023-03-09 11:38:30', '2023-03-09 11:38:30');

-- ----------------------------
-- Table structure for `quality_development`
-- ----------------------------
DROP TABLE IF EXISTS `quality_development`;
CREATE TABLE `quality_development` (
  `id` char(19) NOT NULL COMMENT '素拓大类id',
  `quality_name` varchar(245) NOT NULL COMMENT '素拓大类项目名',
  `quality_max_score` double(10,1) NOT NULL COMMENT '该项目最高分',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='素拓的大类管理';

-- ----------------------------
-- Records of quality_development
-- ----------------------------
INSERT INTO `quality_development` VALUES ('1559740262513647618', '思想成长', '3.0', '2022-08-17 11:13:52', '2022-10-22 20:56:56');
INSERT INTO `quality_development` VALUES ('1559740314644652033', '实践实习', '1.5', '2022-08-17 11:14:04', '2022-08-17 11:14:04');
INSERT INTO `quality_development` VALUES ('1559740347293114369', '志愿服务', '1.5', '2022-08-17 11:14:12', '2022-08-17 11:14:12');
INSERT INTO `quality_development` VALUES ('1559740408391540737', '创新创业', '10.5', '2022-08-17 11:14:27', '2022-08-17 11:14:27');
INSERT INTO `quality_development` VALUES ('1559740467787079681', '文体活动', '3.0', '2022-08-17 11:14:41', '2022-08-17 11:14:41');
INSERT INTO `quality_development` VALUES ('1559740498418081793', '社会工作', '3.0', '2022-08-17 11:14:48', '2022-08-17 11:14:48');
INSERT INTO `quality_development` VALUES ('1559740572552404994', '技能特长', '1.0', '2022-08-17 11:15:06', '2022-08-17 11:15:06');
INSERT INTO `quality_development` VALUES ('1633462940684439554', '政治思想', '0.5', '2023-03-08 21:41:28', '2023-03-08 21:41:37');

-- ----------------------------
-- Table structure for `quality_every_info`
-- ----------------------------
DROP TABLE IF EXISTS `quality_every_info`;
CREATE TABLE `quality_every_info` (
  `id` char(19) NOT NULL COMMENT '素拓分id',
  `student_id` char(19) NOT NULL COMMENT '学生id',
  `teacher_check_id` char(19) NOT NULL COMMENT '处理人id',
  `status` int NOT NULL DEFAULT '0' COMMENT '0未处理，1通过，2拒绝',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `development_id` char(19) NOT NULL COMMENT '素拓大类id',
  `properties_id` char(19) NOT NULL COMMENT '素拓小类id',
  `score` double(10,1) NOT NULL COMMENT '本次获得的分数',
  `learn_year_id` char(19) NOT NULL COMMENT '学年id',
  `semester` int NOT NULL COMMENT '学期1为第一学期，2为第二学期',
  `back_reason` varchar(255) DEFAULT NULL COMMENT '驳回理由',
  `teacher_add_id` char(19) NOT NULL COMMENT '添加人Id',
  `add_time` datetime DEFAULT NULL COMMENT '学生做此项目的时间',
  `check_time` datetime DEFAULT NULL COMMENT '审核时间',
  `proof_addr` varchar(255) DEFAULT NULL COMMENT '证明材料的磁盘地址',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='每一位学生的每一条数据的详细记录，并且可以进行审核';

-- ----------------------------
-- Records of quality_every_info
-- ----------------------------
INSERT INTO `quality_every_info` VALUES ('1631530027042598913', '1631529462069850113', '1631529008053219330', '1', null, '1559740408391540737', '1559755796143702017', '0.5', '1584543016801062914', '1', null, '1631529008053219330', '2023-03-13 00:00:00', '2023-03-03 13:41:05', 'file/proof/202306010111/2023_03_03/17b3ddd7-1da0-4311-adee-0df8f0e7870c.png', '2023-03-03 13:40:45', '2023-03-03 13:41:05', '0');
INSERT INTO `quality_every_info` VALUES ('1631530198488969217', '1631529462069850113', '1631529008053219330', '1', null, '1559740467787079681', '1559756793528221697', '2.0', '1584543016801062914', '1', null, '1631529008053219330', '2023-02-27 00:00:00', '2023-03-03 13:43:03', null, '2023-03-03 13:41:26', '2023-03-03 13:43:03', '0');
INSERT INTO `quality_every_info` VALUES ('1631530281536188417', '1631529462069850113', '1631529008053219330', '1', null, '1559740467787079681', '1559759393136869377', '1.9', '1584543016801062914', '1', null, '1631529008053219330', '2023-03-20 00:00:00', '2023-03-03 13:43:01', null, '2023-03-03 13:41:46', '2023-03-03 13:43:01', '0');
INSERT INTO `quality_every_info` VALUES ('1631530363618717697', '1631529462069850113', '1631529008053219330', '1', null, '1559740498418081793', '1559757238556459010', '1.5', '1559154145804472321', '2', null, '1631529008053219330', '2023-02-26 00:00:00', '2023-03-03 13:42:57', null, '2023-03-03 13:42:06', '2023-03-03 13:42:57', '0');
INSERT INTO `quality_every_info` VALUES ('1631530459647307777', '1631529462069850113', '1631529008053219330', '1', null, '1559740467787079681', '1559759393136869377', '2.0', '1559154145804472321', '1', null, '1631529008053219330', '2023-03-06 00:00:00', '2023-03-03 13:42:56', null, '2023-03-03 13:42:29', '2023-03-03 13:42:56', '0');
INSERT INTO `quality_every_info` VALUES ('1631530534062649345', '1631529462069850113', '1631529008053219330', '1', null, '1559740262513647618', '1559754173229072386', '1.0', '1559154145804472321', '1', null, '1631529008053219330', '2023-02-26 00:00:00', '2023-03-03 13:42:54', null, '2023-03-03 13:42:46', '2023-03-03 13:42:54', '0');
INSERT INTO `quality_every_info` VALUES ('1631530748500635650', '1631529462069850113', '1631529008053219330', '1', null, '1559740498418081793', '1559757579607900162', '1.0', '1559142366642724866', '2', null, '1631529008053219330', '2023-02-26 00:00:00', '2023-03-03 13:43:45', null, '2023-03-03 13:43:37', '2023-03-03 13:43:45', '0');
INSERT INTO `quality_every_info` VALUES ('1631537169057280002', '1631529462069850113', '1631529008053219330', '0', null, '1559740347293114369', '1559755441506910209', '0.2', '1584543016801062914', '1', null, '1631529008053219330', '2023-03-13 00:00:00', null, 'file/proof/202306010111/2023_03_03/46719605-c0d4-400a-a07c-f5c9aa0edcc6.png', '2023-03-03 14:09:08', '2023-03-03 14:09:08', '0');
INSERT INTO `quality_every_info` VALUES ('1633079853685329922', '1631529462069850113', '1632456586892967937', '1', null, '1559740498418081793', '1559757238556459010', '0.6', '1584543016801062914', '1', null, '1632456586892967937', '2023-03-07 00:00:00', '2023-03-07 20:20:17', 'file/proof/202306010111/2023_03_07/d935168a-78b0-4855-8bbe-33f24bc598ec.jpg', '2023-03-07 20:19:13', '2023-03-07 20:20:17', '0');
INSERT INTO `quality_every_info` VALUES ('1633096049084256257', '1631529462069850113', '1637318970224873474', '2', null, '1559740262513647618', '1559753316299210753', '0.3', '1559154145804472321', '1', '信息不全', '1632904199891185666', '2023-03-06 00:00:00', '2023-03-19 13:07:20', 'file/proof/202306010111/2023_03_07/c43d471f-6959-4ddc-a6ba-54248b9f7cee.jpg', '2023-03-07 21:23:34', '2023-03-19 13:07:20', '0');
INSERT INTO `quality_every_info` VALUES ('1633440942168133634', '1633095567754317826', '1632456586892967937', '0', null, '1559740408391540737', '1559755987303301122', '0.3', '1584543016801062914', '1', null, '1632456586892967937', '2023-03-13 00:00:00', null, 'file/proof/234567890890/2023_03_08/41403b06-d21c-4be9-894c-19326e3c46ef.jpg', '2023-03-08 20:14:03', '2023-03-08 20:14:03', '0');
INSERT INTO `quality_every_info` VALUES ('1633441088775835649', '1632903849985568769', '1632909338630811650', '2', null, '1559740408391540737', '1559756184678858753', '0.8', '1584543016801062914', '1', null, '1632456586892967937', '2023-03-05 00:00:00', '2023-03-09 12:28:10', 'file/proof/202306010000/2023_03_08/43266ecf-a148-418a-8296-426071755552.jpg', '2023-03-08 20:14:38', '2023-03-09 12:28:10', '0');
INSERT INTO `quality_every_info` VALUES ('1637318703643299842', '1637318384951693313', '1637318970224873474', '1', '参加团课教育、团干培', '1559740262513647618', '1559753479117897729', '0.3', '1584543016801062914', '1', null, '1637318177404948481', '2023-03-18 00:00:00', '2023-03-19 13:04:36', 'file/proof/202307101011/2023_03_19/5600541c-e0b6-45d4-a319-48e6be045b2a.png', '2023-03-19 13:02:54', '2023-03-19 13:04:36', '0');

-- ----------------------------
-- Table structure for `quality_properties`
-- ----------------------------
DROP TABLE IF EXISTS `quality_properties`;
CREATE TABLE `quality_properties` (
  `id` char(19) NOT NULL COMMENT '素拓小类管理id',
  `properties_num` varchar(255) NOT NULL COMMENT '小类的资源编号',
  `properties_name` varchar(255) NOT NULL COMMENT '小类名',
  `gain_score` double(10,1) DEFAULT NULL COMMENT '目标分数',
  `development_id` char(19) NOT NULL COMMENT '所属的大类编号',
  `is_range` tinyint(1) NOT NULL COMMENT '是否是范围给分',
  `range_min` double(10,1) DEFAULT NULL COMMENT '范围给分的最低分',
  `range_max` double(10,1) DEFAULT NULL COMMENT '范围给分的最高分',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='素拓分的小类管理';

-- ----------------------------
-- Records of quality_properties
-- ----------------------------
INSERT INTO `quality_properties` VALUES ('1559753479117897729', 'A102', '参加团课教育、团干培训', '0.3', '1559740262513647618', '0', '0.0', '0.0', '2022-08-17 12:06:23', '2022-10-25 20:43:57');
INSERT INTO `quality_properties` VALUES ('1559753620210089985', 'A201', '参加团课教育、团干培训', null, '1559740262513647618', '1', '0.1', '1.0', '2022-08-17 12:06:57', '2022-08-17 12:06:57');
INSERT INTO `quality_properties` VALUES ('1559753833721135105', 'A202', '获评道德模范、孝心少年等道德类典型人物', null, '1559740262513647618', '1', '0.2', '0.5', '2022-08-17 12:07:47', '2022-08-17 12:07:47');
INSERT INTO `quality_properties` VALUES ('1559753925995823105', 'A203', '经学校认定的好人好事、见义勇为等典型行为', null, '1559740262513647618', '1', '0.1', '1.0', '2022-08-17 12:08:09', '2022-10-26 19:47:27');
INSERT INTO `quality_properties` VALUES ('1559754041641172994', 'A301', '遵纪守法表现', null, '1559740262513647618', '1', '0.3', '0.9', '2022-08-17 12:08:37', '2022-08-17 12:08:37');
INSERT INTO `quality_properties` VALUES ('1559754173229072386', 'A401', '获得各院（系）级以上表彰', null, '1559740262513647618', '1', '0.1', '1.0', '2022-08-17 12:09:08', '2022-08-17 12:09:08');
INSERT INTO `quality_properties` VALUES ('1559754225683038210', 'A402', '积极参加学校组织开展的主题教育活动荣获奖励', null, '1559740262513647618', '1', '0.1', '1.0', '2022-08-17 12:09:21', '2022-08-17 12:09:21');
INSERT INTO `quality_properties` VALUES ('1559754355039567873', 'A403', '参军入伍期间表现', null, '1559740262513647618', '1', '0.1', '0.5', '2022-08-17 12:09:52', '2022-08-17 12:09:52');
INSERT INTO `quality_properties` VALUES ('1559754423012458498', 'A404', '获得各类奖学金', null, '1559740262513647618', '1', '0.1', '0.2', '2022-08-17 12:10:08', '2022-08-17 12:10:08');
INSERT INTO `quality_properties` VALUES ('1559754815783862273', 'B101', '假期参加社会实践', '0.2', '1559740314644652033', '0', '0.0', '0.0', '2022-08-17 12:11:42', '2022-08-17 12:11:42');
INSERT INTO `quality_properties` VALUES ('1559754899594444802', 'B102', '参加学院组织的“三下乡”等社会实践', '0.5', '1559740314644652033', '0', '0.0', '0.0', '2022-08-17 12:12:02', '2022-08-17 12:12:02');
INSERT INTO `quality_properties` VALUES ('1559755164640903169', 'B301', '参加非本专业选修课', '0.5', '1559740314644652033', '0', '0.0', '0.0', '2022-08-17 12:13:05', '2022-08-17 12:13:05');
INSERT INTO `quality_properties` VALUES ('1559755292424568833', 'C101', '参加学校组织的西部计划活动', '0.6', '1559740347293114369', '0', '0.0', '0.0', '2022-08-17 12:13:35', '2022-08-17 12:13:35');
INSERT INTO `quality_properties` VALUES ('1559755441506910209', 'C201', '参加青年志愿者协会组织的社区服务活动', null, '1559740347293114369', '1', '0.1', '0.3', '2022-08-17 12:14:11', '2022-08-17 12:14:11');
INSERT INTO `quality_properties` VALUES ('1559755548889481217', 'C202', '参加青年志愿者协会组织的环保公益活动', null, '1559740347293114369', '1', '0.1', '0.3', '2022-08-17 12:14:36', '2022-08-17 12:14:36');
INSERT INTO `quality_properties` VALUES ('1559755607731372034', 'C203', '参加青年志愿者协会组织的赛事服务活动', null, '1559740347293114369', '1', '0.1', '0.3', '2022-08-17 12:14:50', '2022-08-17 12:14:50');
INSERT INTO `quality_properties` VALUES ('1559755796143702017', 'D101', '参加各级别竞赛', null, '1559740408391540737', '1', '0.1', '2.0', '2022-08-17 12:15:35', '2022-08-17 12:15:35');
INSERT INTO `quality_properties` VALUES ('1559755903958286338', 'D201', '公开发表论文、论著、评论、社会调查报告（增刊不列入）等', null, '1559740408391540737', '1', '0.2', '2.0', '2022-08-17 12:16:01', '2022-08-17 12:16:01');
INSERT INTO `quality_properties` VALUES ('1559755987303301122', 'D202', '在校级以上报刊、校园网、新媒体等发表文章', null, '1559740408391540737', '1', '0.2', '1.0', '2022-08-17 12:16:21', '2022-08-17 12:16:21');
INSERT INTO `quality_properties` VALUES ('1559756105951772674', 'D203', '参加校级以上科技成果展览', null, '1559740408391540737', '1', '0.1', '2.0', '2022-08-17 12:16:49', '2022-08-17 12:16:49');
INSERT INTO `quality_properties` VALUES ('1559756184678858753', 'D204', '获得专利', null, '1559740408391540737', '1', '0.8', '2.0', '2022-08-17 12:17:08', '2022-08-17 12:17:08');
INSERT INTO `quality_properties` VALUES ('1559756293126782978', 'D301', '学生自主创业，取得一定成效', null, '1559740408391540737', '1', '0.3', '1.0', '2022-08-17 12:17:34', '2022-08-17 12:17:34');
INSERT INTO `quality_properties` VALUES ('1559756561763565570', 'D302', '学生积极参加各类创业培训', '0.5', '1559740408391540737', '0', '0.0', '0.0', '2022-08-17 12:18:38', '2022-08-17 12:18:38');
INSERT INTO `quality_properties` VALUES ('1559756793528221697', 'E101', '参加各级别文体比赛', null, '1559740467787079681', '1', '0.2', '2.0', '2022-08-17 12:19:33', '2022-08-17 12:19:33');
INSERT INTO `quality_properties` VALUES ('1559756889959464961', 'E201', '作为成员参加校内外各种公益性演出', null, '1559740467787079681', '1', '0.1', '0.4', '2022-08-17 12:19:56', '2022-08-17 12:19:56');
INSERT INTO `quality_properties` VALUES ('1559756981726642178', 'E301', '参加社团活动', null, '1559740467787079681', '1', '0.1', '0.5', '2022-08-17 12:20:18', '2022-08-17 12:20:18');
INSERT INTO `quality_properties` VALUES ('1559757085959290882', 'E302', '参加学院组织的各种讲座、活动', null, '1559740467787079681', '1', '0.1', '0.5', '2022-08-17 12:20:43', '2022-08-17 12:20:43');
INSERT INTO `quality_properties` VALUES ('1559757238556459010', 'F101', '积极服务学生并担任学生干部', null, '1559740498418081793', '1', '0.1', '1.5', '2022-08-17 12:21:19', '2022-08-17 12:21:19');
INSERT INTO `quality_properties` VALUES ('1559757463039803393', 'F201', '利用假期在校外兼职', '0.5', '1559740498418081793', '0', '0.0', '0.0', '2022-08-17 12:22:13', '2022-08-17 12:22:13');
INSERT INTO `quality_properties` VALUES ('1559757579607900162', 'F301', '参军入伍，复员后返校学习', '1.0', '1559740498418081793', '0', '0.0', '0.0', '2022-08-17 12:22:41', '2022-08-17 12:22:41');
INSERT INTO `quality_properties` VALUES ('1559758581278998529', 'G101', '参加技能培训并获得专业技能证书（国家级）', null, '1559740572552404994', '1', '0.5', '1.0', '2022-08-17 12:26:39', '2022-08-17 12:26:39');
INSERT INTO `quality_properties` VALUES ('1559758912293470209', 'A103', '参加青年大学习线上团课学习', null, '1559740262513647618', '1', '0.1', '1.0', '2022-08-17 12:06:30', '2022-10-26 19:47:12');
INSERT INTO `quality_properties` VALUES ('1559759393136869377', 'E401', '利用课余时间到图书馆阅览书籍', null, '1559740467787079681', '1', '0.1', '2.0', '2022-08-17 12:20:53', '2022-08-17 12:29:53');
INSERT INTO `quality_properties` VALUES ('1559761811908100097', 'B201', '参加学校组织的交流访学活动', '0.5', '1559740314644652033', '0', '0.0', '0.0', '2022-08-17 12:12:20', '2022-08-17 12:39:30');
INSERT INTO `quality_properties` VALUES ('1585236948514033666', 'A101', '获得比赛奖励', null, '1559740262513647618', '1', '0.1', '0.5', '2022-10-26 19:48:35', '2022-10-26 19:48:35');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` char(19) NOT NULL COMMENT '角色id',
  `role_name` varchar(255) NOT NULL COMMENT '角色名',
  `purview` int NOT NULL COMMENT '权限枚举',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='角色管理，内部有一个权限枚举，后期要注意定义';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '校团委', '0', '2022-08-16 12:03:17', '2022-08-16 12:03:18');
INSERT INTO `role` VALUES ('2', '基层团委', '1', '2022-08-16 12:03:30', '2022-08-16 12:03:32');
INSERT INTO `role` VALUES ('3', '辅导员', '2', '2022-08-16 12:03:45', '2022-08-16 12:03:47');
INSERT INTO `role` VALUES ('4', '团支书', '3', '2022-08-16 12:03:54', '2022-08-16 12:03:56');
INSERT INTO `role` VALUES ('5', '宣传委员', '4', '2022-08-16 12:04:14', '2022-08-16 12:04:16');
INSERT INTO `role` VALUES ('6', '组织委员', '5', '2022-08-16 13:25:35', '2022-08-16 13:25:37');
INSERT INTO `role` VALUES ('8', '系统管理员', '-1', '2022-08-16 13:25:55', '2022-08-16 13:25:57');

-- ----------------------------
-- Table structure for `student_info`
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `id` char(19) NOT NULL COMMENT '学生信息主键',
  `name` varchar(50) NOT NULL COMMENT '学生姓名',
  `gender` int NOT NULL COMMENT '学生性别',
  `academic_id` char(19) NOT NULL COMMENT '二级学院id',
  `class_id` char(19) NOT NULL COMMENT '班级编号',
  `profession_id` char(19) NOT NULL COMMENT '专业编号',
  `is_up_grade` tinyint(1) NOT NULL COMMENT '是否为专升本 1（true）是专升本， 0（false）不是',
  `quality_total` double(9,1) DEFAULT '0.0' COMMENT '素拓总分',
  `politic_status` int DEFAULT NULL COMMENT '政治面貌，枚举类->1.群众',
  `prove_addr` varchar(255) DEFAULT NULL COMMENT '素拓满了以后存在磁盘的地址',
  `birthday` date DEFAULT NULL COMMENT '学生生日',
  `race` varchar(10) DEFAULT NULL COMMENT '学生民族',
  `teacher_id` char(19) NOT NULL COMMENT '添加该学生的老师id',
  `student_addr` varchar(255) DEFAULT NULL COMMENT '学生地址',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  `join_time` date DEFAULT NULL COMMENT '入校时间',
  `student_num` varchar(12) NOT NULL COMMENT '学生学号',
  `phone` varchar(11) NOT NULL COMMENT '学生手机号',
  PRIMARY KEY (`id`),
  KEY `academic` (`academic_id`) USING BTREE,
  KEY `name` (`name`) USING BTREE,
  KEY `class` (`class_id`) USING BTREE,
  KEY `profession` (`profession_id`) USING BTREE,
  KEY `studentNum` (`student_num`) USING BTREE,
  KEY `phone` (`phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='所有学生的信息管理';

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES ('1631529462069850113', '满分学生', '1', '1632453815116529665', '1633676730923335681', '1632454642455576577', '0', '7.5', '0', null, '2023-03-01', '汉族', '1559426977604169729', '贵州', '2023-03-03 13:38:31', '2023-03-19 13:06:52', '2023-03-06', '202306010111', '13877771111');
INSERT INTO `student_info` VALUES ('1632903849985568769', '组织委员', '1', '1632453815116529665', '1633676730923335681', '1632454642455576577', '0', '0.0', '1', null, '2023-03-06', 'han', '1632456586892967937', 'guizhou', '2023-03-07 08:39:50', '2023-03-19 12:59:34', '2023-03-05', '202306010000', '13899001122');
INSERT INTO `student_info` VALUES ('1632904005422280705', '宣传委员', '0', '1632453815116529665', '1633676730923335681', '1632454642455576577', '0', '0.0', '0', null, '2023-03-12', 'han', '1632456586892967937', 'guizhou', '2023-03-07 08:40:27', '2023-03-19 12:59:21', '2023-03-13', '202301010561', '13877660011');
INSERT INTO `student_info` VALUES ('1633078267550552065', '小小', '1', '1632453850478706689', '1633098843002425346', '1632455432909914114', '0', '0.0', '0', null, '2023-03-27', '汉族', '1632904199891185666', '贵州', '2023-03-07 20:12:55', '2023-03-07 21:53:43', '2023-03-13', '233515689745', '15863692456');
INSERT INTO `student_info` VALUES ('1633079213722619905', '王雪', '0', '1632453850478706689', '1633098843002425346', '1632455432909914114', '0', '0.0', '2', null, '2023-03-07', '汉', '1632456586892967937', '贵州', '2023-03-07 20:16:40', '2023-03-07 21:45:33', '2023-03-14', '123456789880', '17886578900');
INSERT INTO `student_info` VALUES ('1633095567754317826', '业一', '0', '1632453850478706689', '1633098843002425346', '1632455432909914114', '0', '0.0', '2', null, '2023-03-05', '汉', '1632904199891185666', '贵州', '2023-03-07 21:21:39', '2023-03-08 21:37:40', '2023-03-05', '234567890890', '18365578976');
INSERT INTO `student_info` VALUES ('1633099314131816450', '扎根', '1', '1632453850478706689', '1633098843002425346', '1632455432909914114', '0', '0.0', '0', null, '2023-03-07', '汉', '1632909338630811650', '贵州', '2023-03-07 21:36:33', '2023-03-07 21:36:49', '2023-03-06', '123456789123', '18032567893');
INSERT INTO `student_info` VALUES ('1637317653783842817', '团支书', '1', '1632453815116529665', '1633676730923335681', '1632454642455576577', '0', '0.0', '0', null, '2023-03-18', '汉族', '1632906286037331969', '贵州', '2023-03-19 12:58:43', '2023-03-19 12:58:43', '2023-03-18', '202306010411', '13899992222');
INSERT INTO `student_info` VALUES ('1637318384951693313', '普通学生', '1', '1632453815116529665', '1633676730923335681', '1632454642455576577', '0', '0.3', '0', null, '2023-03-18', '汉族', '1637318177404948481', '贵州', '2023-03-19 13:01:38', '2023-03-19 13:01:38', '2023-03-18', '202307101011', '13812344321');

-- ----------------------------
-- Table structure for `system`
-- ----------------------------
DROP TABLE IF EXISTS `system`;
CREATE TABLE `system` (
  `id` char(19) NOT NULL COMMENT '系统管理id',
  `start_time` datetime NOT NULL COMMENT '系统开启时间',
  `end_time` datetime NOT NULL COMMENT '系统关闭时间',
  `user_id` char(19) NOT NULL COMMENT '操作人id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='系统开放时间管理';

-- ----------------------------
-- Records of system
-- ----------------------------
