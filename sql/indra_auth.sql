/*
Navicat MySQL Data Transfer

Source Server         : pikp-MySQL
Source Server Version : 80024
Source Host           : localhost:3306
Source Database       : mall4cloud_auth

Target Server Type    : MYSQL
Target Server Version : 80024
File Encoding         : 65001

Date: 2023-03-17 17:25:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `auth_account`
-- ----------------------------
DROP TABLE IF EXISTS `auth_account`;
CREATE TABLE `auth_account` (
  `uid` bigint unsigned NOT NULL COMMENT '全平台用户唯一id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '密码',
  `create_ip` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建ip',
  `status` tinyint NOT NULL COMMENT '状态 1:启用 0:禁用 -1:删除',
  `sys_type` tinyint NOT NULL COMMENT '用户类型见SysTypeEnum 0.普通用户系统 1.商家端 2平台端',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
  `is_admin` tinyint DEFAULT NULL COMMENT '是否是管理员',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE KEY `uk_usertype_userid` (`sys_type`,`user_id`) USING BTREE,
  KEY `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_is_0900_ai_ci COMMENT='统一账户信息';

-- ----------------------------
-- Records of auth_account
-- ----------------------------
INSERT INTO `auth_account` VALUES ('1', '2021-07-01 11:07:38', '2021-07-03 13:11:52', 'admin', '$2a$10$EiwfzqsAVUtuJ0Ry5YPMPOeyc/4shzSUcqMBRInKTijzir48LLkM.', '127.0.0.1', '1', '2', '1', '0', '1');
INSERT INTO `auth_account` VALUES ('9495', '2023-03-17 12:10:42', '2023-03-17 12:10:42', 'root', '$2a$10$1VUHl5TpmtRsbXun8Qx1iOlQvu.d8qjXXTqwmQbVER8EiERDT.jcm', '127.0.0.1', '1', '1', '123', '123', '1');
INSERT INTO `auth_account` VALUES ('112115', '2022-04-14 16:36:13', '2022-04-14 16:36:13', 'admin', '$2a$10$fr9bj14bAJW54agVbZizceMODrC4W8sbVotfH5324q0t50HNdpRqa', '59.41.161.208', '1', '1', '110400', '324', '1');

-- ----------------------------
-- Table structure for `undo_log`
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `branch_id` bigint NOT NULL,
  `xid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `context` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=385 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of undo_log
-- ----------------------------
