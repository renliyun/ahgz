/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : vot

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 25/01/2021 16:27:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address_list
-- ----------------------------
DROP TABLE IF EXISTS `address_list`;
CREATE TABLE `address_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `sex` int(1) NULL DEFAULT NULL COMMENT '性别',
  `mark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `company` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属公司',
  `created_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `updated_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` date NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for borrow_record
-- ----------------------------
DROP TABLE IF EXISTS `borrow_record`;
CREATE TABLE `borrow_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matnr` int(8) NOT NULL COMMENT '物料号',
  `part_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '零部件名称',
  `part_specification` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `category` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属类别',
  `figure_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图号',
  `number` int(11) NULL DEFAULT NULL COMMENT '数量',
  `material` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '材料',
  `borrow_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借用人',
  `borrow_time` datetime(0) NULL DEFAULT NULL COMMENT '借用时间',
  `created_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `updated_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` date NULL DEFAULT NULL COMMENT '更新时间',
  `supplier` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属部门或者客户公司名称',
  `mark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for category_table
-- ----------------------------
DROP TABLE IF EXISTS `category_table`;
CREATE TABLE `category_table`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `created_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `updated_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '跟新人',
  `mark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category_table
-- ----------------------------
INSERT INTO `category_table` VALUES (1, '外购件', '2021-01-00 00:00:00', '任利荣', '2021-01-00 00:00:00', '任利荣', NULL);
INSERT INTO `category_table` VALUES (2, '镜片', '2021-01-00 00:00:00', '任利荣', '2021-01-00 00:00:00', '任利荣', NULL);
INSERT INTO `category_table` VALUES (3, '镜头', '2021-01-00 00:00:00', '任利荣', '2021-01-00 00:00:00', '任利荣', NULL);
INSERT INTO `category_table` VALUES (4, '半成品', '2021-01-00 00:00:00', '任利荣', '2021-01-00 00:00:00', '任利荣', NULL);
INSERT INTO `category_table` VALUES (5, '镜头机械部分', '2021-01-00 00:00:00', '任利荣', '2021-01-00 00:00:00', '任利荣', NULL);
INSERT INTO `category_table` VALUES (6, '外购件（）', '2021-01-00 00:00:00', '任利荣', '2021-01-00 00:00:00', '任利荣', NULL);

-- ----------------------------
-- Table structure for delivery_record
-- ----------------------------
DROP TABLE IF EXISTS `delivery_record`;
CREATE TABLE `delivery_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matnr` int(8) NOT NULL COMMENT '物料号',
  `part_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '零部件名称',
  `part_specification` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `category` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属类别',
  `figure_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图号',
  `number` bigint(8) NULL DEFAULT NULL COMMENT '发货数量',
  `delivery_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发货人',
  `delivery_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发货地址',
  `delivery_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `borrow_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人姓名',
  `telephone` varchar(28) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  `supplier` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货供应商',
  `borrow_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收获供地址',
  `created_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `updated_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` date NULL DEFAULT NULL COMMENT '更新时间',
  `mark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for in_record
-- ----------------------------
DROP TABLE IF EXISTS `in_record`;
CREATE TABLE `in_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matnr` int(8) NOT NULL COMMENT '物料号',
  `part_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '零部件名称',
  `part_specification` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `figure_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图号',
  `material` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '材料',
  `supplier` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供货商',
  `category` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属类别',
  `quantity` int(11) NULL DEFAULT NULL COMMENT '入库数量',
  `location` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库位',
  `created_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `updated_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` date NULL DEFAULT NULL COMMENT '更新时间',
  `mark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of in_record
-- ----------------------------
INSERT INTO `in_record` VALUES (6, 30000003, '25mm/1.0消热差镜头镜筒机械组', '25mm/1.0', 'XDJ-2047', 'AL24', '安徽光智', '外购件', 10, 'T3', '任利荣', NULL, NULL, '2021-01-12', '');
INSERT INTO `in_record` VALUES (7, 30000003, '25mm/1.0消热差镜头镜筒机械组', '395/1.0消热差镜头', 'XDJ-2042', 'AL24', '安徽光智', '镜头', 2, 'T3', '任利荣', NULL, NULL, '2021-01-12', '');
INSERT INTO `in_record` VALUES (8, 30000001, '25mm/1.0消热差镜头镜筒机械组', '25mm/1.0', 'XDJ-2042', 'AL24', '安徽光智', '外购件', 3, 'T3', '任利荣', NULL, NULL, '2021-01-18', '');
INSERT INTO `in_record` VALUES (9, 30000001, '25mm/1.0消热差镜头镜筒机械组', '25mm/1.0', 'XDJ-2042', 'AL24', '安徽光智', '外购件', 3, 'T3', '任利荣', NULL, NULL, '2021-01-18', '');
INSERT INTO `in_record` VALUES (10, 30000003, '25mm/1.0消热差镜头镜筒机械组', '25mm/1.0', 'XDJ-2042', 'AL24', '安徽光智', '镜头', 2, 'T2', '任利荣', NULL, NULL, '2021-01-18', '');
INSERT INTO `in_record` VALUES (11, 30000003, '25mm/1.0消热差镜头镜筒机械组', '25mm/1.0', 'XDJ-2042', 'AL24', '安徽光智', '镜头', 3, 'T2', '任利荣', NULL, NULL, '2021-01-18', '');
INSERT INTO `in_record` VALUES (12, 30000001, '25mm/1.0消热差镜头镜筒机械组', '25mm/1.0', 'XDJ-2047', 'AL24', '安徽光智', '镜头', 2, 'T2', '任利荣', NULL, NULL, '2021-01-18', '');
INSERT INTO `in_record` VALUES (13, 30000001, '25mm/1.0消热差镜头镜筒机械组', '25mm/1.0', 'XDJ-2045', 'AL24', '安徽光智', '镜头', 3, 'T2', '王美林', NULL, NULL, '2021-01-18', '');
INSERT INTO `in_record` VALUES (14, 30000002, '25mm/1.0消热差镜头镜筒机械组', '25mm/1.0', 'XDJ-2047', 'AL24', '安徽光智', '镜头', 2, 'T2', '王美林', NULL, NULL, '2021-01-18', '');
INSERT INTO `in_record` VALUES (15, 30000001, '275mm/1.0消热差镜头镜筒机械组', '75mm/1.0', 'XDJ-2047', 'AL24', '安徽光智', '镜头', 3, 'T3', '任利荣', NULL, NULL, '2021-01-18', '');
INSERT INTO `in_record` VALUES (16, 30000001, '255mm/1.0消热差镜头镜筒机械组', '55mm/1.0', 'XDJ-2047', 'AL24', '安徽光智', '镜头', 2, 'T2', '任利荣', NULL, NULL, '2021-01-18', '');
INSERT INTO `in_record` VALUES (17, 30000003, '25mm/1.0消热差镜头镜筒机械组', '275mm/1.0消热差镜头镜筒机械组', 'XDJ-2042', 'AL24', '安徽光智', '外购件', 3, 'T2', '任利荣', NULL, NULL, '2021-01-18', '');
INSERT INTO `in_record` VALUES (18, 30000001, '25mm/1.0消热差镜头镜筒机械组', '25mm/1.0', 'XDJ-2042', 'AL24', '安徽光智', '外购件', 3, 'T2', '任利荣', NULL, NULL, '2021-01-18', '');
INSERT INTO `in_record` VALUES (19, 30000003, '25mm/1.0', '275mm/1.0消热差镜头镜筒机械组', 'XDJ-2042', 'AL24', '安徽光智', '外购件', 3, 'T3', '任利荣', NULL, NULL, '2021-01-18', '');
INSERT INTO `in_record` VALUES (20, 30000003, '25mm/1.0消热差镜头镜筒机械组', '25mm/1.0', 'XDJ-2047', '', '安徽光智', '光学镜片', 10, 'T3', '王美林', NULL, NULL, '2021-01-18', '');
INSERT INTO `in_record` VALUES (21, 30000006, '2100mm/1.0消热差镜头镜筒机械组', '100mm/1.0', 'XDJ-2045', 'AL24', '三和康瑞', '镜头', 10, 'T3', '', NULL, NULL, '2021-01-19', '');
INSERT INTO `in_record` VALUES (22, 30000003, '25mm/1.0消热差镜头镜筒机械组', '25mm/1.0', 'XDJ-2042', 'AL24', '安徽光智', '镜头', 3, 'T2', '', NULL, NULL, '2021-01-20', '');
INSERT INTO `in_record` VALUES (23, 30000001, '275mm/1.0消热差镜头镜筒机械组', '75mm/1.0', 'XDJ-2043', 'AL24', '安徽光智', '外购件', 10, 'T0', '', NULL, NULL, '2021-01-21', '');
INSERT INTO `in_record` VALUES (24, 30000003, '395mm/1.0消热差镜头机械部分', '95mm/1.0	', 'XDJ-2044', 'AL24', '三和康瑞', '镜头', 1, 'T0', '任利荣', NULL, NULL, '2021-01-21', '');
INSERT INTO `in_record` VALUES (25, 30000001, '275mm/1.0消热差镜头镜筒机械组', '75mm/1.0', 'XDJ-2043', 'AL27', '安徽光智', '外购件', 14, 'T0', '任利荣', NULL, NULL, '2021-01-25', '测试数据');

-- ----------------------------
-- Table structure for non_conforming
-- ----------------------------
DROP TABLE IF EXISTS `non_conforming`;
CREATE TABLE `non_conforming`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matnr` int(8) NOT NULL COMMENT '物料号',
  `part_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '零部件名称',
  `category` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属类别',
  `part_specification` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `material` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '材料',
  `figure_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图号',
  `quantity` bigint(8) NULL DEFAULT NULL COMMENT '入库数量',
  `location` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库位',
  `created_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `updated_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` date NULL DEFAULT NULL COMMENT '更新时间',
  `mark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for out_record
-- ----------------------------
DROP TABLE IF EXISTS `out_record`;
CREATE TABLE `out_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matnr` int(8) NOT NULL COMMENT '物料号',
  `part_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '零部件名称',
  `category` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属类别',
  `part_specification` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `figure_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图号',
  `material` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '材料',
  `number` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '领用数量',
  `receive_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '领用人',
  `receive_time` datetime(0) NULL DEFAULT NULL COMMENT '领用时间',
  `created_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `updated_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` date NULL DEFAULT NULL COMMENT '更新时间',
  `supplier` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供货商',
  `mark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for storage_table
-- ----------------------------
DROP TABLE IF EXISTS `storage_table`;
CREATE TABLE `storage_table`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matnr` int(8) NOT NULL COMMENT '物料号',
  `part_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '零部件名称',
  `category` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别',
  `part_specification` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `material` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '材料',
  `figure_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图号',
  `number` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '数量',
  `supplier` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供货商',
  `location` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库位',
  `created_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `updated_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` date NULL DEFAULT NULL COMMENT '更新时间',
  `mark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `matnr`(`matnr`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of storage_table
-- ----------------------------
INSERT INTO `storage_table` VALUES (15, 30000001, '275mm/1.0消热差镜头镜筒机械组', '镜头', '75mm/1.0', 'AL27', 'XDJ-2043', 0000000028, '安徽光智', 'T0', '任利荣', '2021-01-20', '任利荣', '2021-01-25', '测试数据');
INSERT INTO `storage_table` VALUES (20, 30000002, '275mm/1.0消热差镜头镜筒机械组', '镜头', '75mm/1.0', 'AL27', 'XDJ-2042', 0000000002, '安徽光智', 'T2', '任利荣', '2021-01-25', '', '2021-01-25', '测试数据');

-- ----------------------------
-- Table structure for user_table
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `authority` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `created_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `updated_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` date NULL DEFAULT NULL COMMENT '更新时间',
  `mark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
