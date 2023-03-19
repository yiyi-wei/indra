/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80024
Source Host           : localhost:3306
Source Database       : mall4cloud_rbac

Target Server Type    : MYSQL
Target Server Version : 80024
File Encoding         : 65001

Date: 2023-03-19 17:26:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `parent_id` bigint unsigned NOT NULL COMMENT '父菜单ID，一级菜单为0',
  `biz_type` tinyint DEFAULT NULL COMMENT '业务类型 1 店铺菜单 2平台菜单',
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限，需要有哪个权限才能访问该菜单',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '路径 就像uri',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '1.''Layout'' 为布局，不会跳页面 2.''components-demo/tinymce'' 跳转到该页面',
  `redirect` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '当设置 noRedirect 的时候该路由在面包屑导航中不可被点击',
  `always_show` tinyint DEFAULT NULL COMMENT '一直显示根路由',
  `hidden` tinyint DEFAULT NULL COMMENT '当设置 true 的时候该路由不会在侧边栏出现 如401，login等页面，或者如一些编辑页面/edit/1',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设定路由的名字，一定要填写不然使用<keep-alive>时会出现各种问题',
  `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设置该路由在侧边栏和面包屑中展示的名字',
  `icon` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设置该路由的图标，支持 svg-class，也支持 el-icon-x element-ui 的 icon',
  `no_cache` tinyint DEFAULT NULL COMMENT '如果设置为true，则不会被 <keep-alive> 缓存(默认 false)',
  `breadcrumb` tinyint DEFAULT NULL COMMENT '如果设置为false，则不会在breadcrumb面包屑中显示(默认 true)',
  `affix` tinyint DEFAULT NULL COMMENT '若果设置为true，它则会固定在tags-view中(默认 false)',
  `active_menu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '当路由设置了该属性，则会高亮相对应的侧边栏。',
  `seq` int DEFAULT NULL COMMENT '排序，越小越靠前',
  PRIMARY KEY (`menu_id`) USING BTREE,
  KEY `idx_pid` (`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=328 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单管理';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('111', '2020-12-01 14:20:42', '2021-01-28 10:12:08', '0', '1', null, '/rbac', 'Layout', null, null, '0', '权限管理', '权限管理', 'el-icon-office-building', null, null, null, null, '99');
INSERT INTO `menu` VALUES ('112', '2020-12-01 14:22:09', '2021-01-28 10:12:14', '111', '1', null, '/multishop/shop_user', 'multishop/shop-user', null, null, '0', '用户管理', '用户管理', '', null, null, null, null, '0');
INSERT INTO `menu` VALUES ('134', '2020-12-03 16:49:48', '2021-01-28 10:12:22', '111', '1', null, 'role', 'rbac/role', null, null, '0', '角色管理', '角色管理', null, null, null, null, null, '1');
INSERT INTO `menu` VALUES ('137', '2020-12-03 17:54:02', '2021-01-28 10:13:07', '141', '1', null, 'attr', 'product/attr', null, null, '0', '属性管理', '属性管理', null, null, null, null, null, '0');
INSERT INTO `menu` VALUES ('139', '2020-12-03 17:54:02', '2021-01-28 10:13:20', '141', '1', null, 'category', 'product/category', null, null, '0', 'category', '分类管理', null, null, null, null, null, '2');
INSERT INTO `menu` VALUES ('141', '2020-12-03 17:55:22', '2021-01-01 09:01:48', '0', '1', null, '/product', 'Layout', null, null, '0', '商品管理', '商品管理', 'product', null, null, null, null, '0');
INSERT INTO `menu` VALUES ('142', '2020-12-03 17:54:02', '2021-03-12 09:31:52', '141', '1', null, 'prod_info', 'product/prod-info', null, null, '0', '发布商品', '发布商品', null, null, null, null, null, '4');
INSERT INTO `menu` VALUES ('145', '2020-12-04 10:08:17', '2021-01-28 10:13:47', '0', '1', null, '/multishop', 'Layout', null, null, '0', '店铺管理', '店铺管理', 'el-icon-house', null, null, null, null, '0');
INSERT INTO `menu` VALUES ('146', '2020-12-04 10:09:38', '2021-01-28 10:13:53', '145', '1', null, 'index_img', 'multishop/index-img', null, null, '0', '轮播图管理', '轮播图管理', '', null, null, null, null, '0');
INSERT INTO `menu` VALUES ('147', '2020-12-04 11:30:59', '2021-01-01 09:28:45', '0', '1', null, '/order', 'Layout', null, null, '0', '订单管理', '订单管理', 'order', null, null, null, null, '90');
INSERT INTO `menu` VALUES ('148', '2020-12-04 11:32:46', '2021-01-28 09:52:10', '147', '1', null, 'order', 'order/order', null, null, '0', 'order', '订单管理', null, null, null, null, null, '1');
INSERT INTO `menu` VALUES ('152', '2020-12-16 10:16:39', '2021-01-28 10:13:32', '141', '1', null, 'list', 'product/list', null, null, '0', '商品列表', '商品列表', '', null, null, null, null, '5');
INSERT INTO `menu` VALUES ('155', '2020-12-01 14:20:42', '2021-04-22 10:30:44', '0', '2', null, '/rbac', 'Layout', null, null, '0', '权限管理', '权限管理', 'el-icon-office-building', null, null, null, null, '99');
INSERT INTO `menu` VALUES ('156', '2020-12-01 14:22:09', '2021-04-22 10:30:44', '155', '2', null, '/platform/sys_user', 'platform/sys-user', null, null, '0', '用户管理', '用户管理', '', null, null, null, null, '0');
INSERT INTO `menu` VALUES ('157', '2020-12-03 16:49:48', '2021-04-22 10:30:44', '155', '2', null, 'role', 'rbac/role', null, null, '0', '角色管理', '角色管理', null, null, null, null, null, '1');
INSERT INTO `menu` VALUES ('158', '2020-12-03 16:49:48', '2021-04-22 10:30:44', '155', '2', null, 'menu', 'rbac/menu', null, null, '0', '平台菜单管理', '平台菜单管理', null, null, null, null, null, '2');
INSERT INTO `menu` VALUES ('159', '2020-12-03 16:49:48', '2021-04-22 10:30:44', '155', '2', null, 'menu_permission', 'rbac/menu-permission', null, null, '0', '菜单资源', '菜单资源', null, null, null, null, null, '3');
INSERT INTO `menu` VALUES ('160', '2020-12-03 17:54:02', '2021-04-22 10:30:44', '164', '2', null, 'attr', 'product/attr', null, null, '0', '属性管理', '属性管理', null, null, null, null, null, '0');
INSERT INTO `menu` VALUES ('161', '2020-12-03 17:54:02', '2021-04-22 10:30:44', '164', '2', null, 'brand', 'product/brand', null, null, '0', '品牌管理', '品牌管理', null, null, null, null, null, '1');
INSERT INTO `menu` VALUES ('162', '2020-12-03 17:54:02', '2021-04-22 10:30:44', '164', '2', null, 'category', 'product/category', null, null, '0', 'category', '分类管理', null, null, null, null, null, '2');
INSERT INTO `menu` VALUES ('164', '2020-12-03 17:55:22', '2021-04-22 10:30:44', '0', '2', null, '/product', 'Layout', null, null, '0', 'product', '商品管理', 'el-icon-shopping-bag-1', null, null, null, null, '0');
INSERT INTO `menu` VALUES ('175', '2020-12-16 10:16:39', '2021-04-22 10:30:44', '164', '2', null, 'list', 'product/list', null, null, '0', '商品管理', '商品管理', '', null, null, null, null, '5');
INSERT INTO `menu` VALUES ('178', '2020-12-22 09:26:41', '2021-04-22 10:30:44', '155', '2', null, 'shop-menu', 'rbac/shop-menu', null, null, '0', '店铺菜单管理', '店铺菜单管理', '', null, null, null, null, '2');
INSERT INTO `menu` VALUES ('255', '2021-01-27 14:10:56', '2021-04-22 10:30:44', '0', '2', null, '/platform', 'Layout', null, null, '0', 'platform', '平台管理', 'tree', null, null, null, null, '0');
INSERT INTO `menu` VALUES ('256', '2021-01-27 14:14:51', '2021-04-22 10:30:44', '255', '2', null, 'hot-search', 'platform/hot-search', null, null, '0', 'hot-search', '热搜管理', 'el-icon-search', null, null, null, null, '0');
INSERT INTO `menu` VALUES ('257', '2021-01-28 09:48:39', '2021-04-22 10:30:44', '255', '2', null, 'index-img', 'platform/index-img', null, null, '0', '轮播图管理', '轮播图管理', 'el-icon-picture-outline', null, null, null, null, '0');
INSERT INTO `menu` VALUES ('258', '2021-01-28 11:06:52', '2021-01-28 11:06:52', '145', '1', null, 'hot-search', 'multishop/hot-search', null, null, '0', 'hot-search', '热搜管理', '', null, null, null, null, '0');
INSERT INTO `menu` VALUES ('302', '2021-05-13 19:02:02', '2021-05-13 19:02:20', '255', '2', null, 'shop-detail', 'platform/shop-detail', null, null, '1', '店铺详情', '店铺详情', '', null, null, null, null, '0');
INSERT INTO `menu` VALUES ('306', '2021-05-14 17:32:04', '2021-05-14 17:34:08', '255', '2', null, 'shop-edit', 'platform/shop-edit', null, null, '1', '店铺编辑', '店铺编辑', '', null, null, null, null, '0');
INSERT INTO `menu` VALUES ('327', '2021-06-30 20:22:45', '2021-06-30 20:25:49', '255', '2', null, 'shop-manage', 'platform/shop-manage', null, null, '0', '店铺管理', '店铺管理', 'el-icon-s-order', null, null, null, null, '3');

-- ----------------------------
-- Table structure for `menu_permission`
-- ----------------------------
DROP TABLE IF EXISTS `menu_permission`;
CREATE TABLE `menu_permission` (
  `menu_permission_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '菜单资源用户id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `menu_id` bigint NOT NULL COMMENT '资源关联菜单',
  `biz_type` tinyint NOT NULL COMMENT '业务类型 1 店铺菜单 2平台菜单',
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限对应的编码',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '资源名称',
  `uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '资源对应服务器路径',
  `method` tinyint NOT NULL COMMENT '请求方法 1.GET 2.POST 3.PUT 4.DELETE',
  PRIMARY KEY (`menu_permission_id`) USING BTREE,
  UNIQUE KEY `uk_permission` (`permission`,`biz_type`) USING BTREE,
  KEY `idx_menuid` (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单资源';

-- ----------------------------
-- Records of menu_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint unsigned NOT NULL COMMENT '创建者ID',
  `biz_type` tinyint DEFAULT NULL COMMENT '业务类型 1 店铺菜单 2平台菜单',
  `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
  PRIMARY KEY (`role_id`) USING BTREE,
  KEY `idx_tenant_id` (`tenant_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色';

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for `role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '关联id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `role_id` bigint unsigned NOT NULL COMMENT '角色ID',
  `menu_id` bigint unsigned DEFAULT NULL COMMENT '菜单ID',
  `menu_permission_id` bigint unsigned DEFAULT NULL COMMENT '菜单资源用户id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_roleid_menu_permission_id` (`role_id`,`menu_id`,`menu_permission_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1924 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of role_menu
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of undo_log
-- ----------------------------

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '关联id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `user_id` bigint unsigned NOT NULL COMMENT '用户ID',
  `role_id` bigint unsigned NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_userid_roleid` (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=254 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of user_role
-- ----------------------------
