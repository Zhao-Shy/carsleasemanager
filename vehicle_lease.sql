/*
 Navicat Premium Data Transfer

 Source Server         : myself
 Source Server Type    : MySQL
 Source Server Version : 50624
 Source Host           : localhost:3306
 Source Schema         : vehicle_lease

 Target Server Type    : MySQL
 Target Server Version : 50624
 File Encoding         : 65001

 Date: 30/01/2020 22:31:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lease_contact
-- ----------------------------
DROP TABLE IF EXISTS `lease_contact`;
CREATE TABLE `lease_contact`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '租赁合同id',
  `deposit` decimal(11, 0) NULL DEFAULT NULL COMMENT '押金',
  `status` int(1) NULL DEFAULT NULL COMMENT '租赁方式（0出租，1预租，2续租）',
  `lease_type` int(1) NULL DEFAULT NULL COMMENT '租赁类型（0短租，1长租）',
  `begin_time` datetime(0) NULL DEFAULT NULL COMMENT '租赁开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '租赁截止时间',
  `begin_oil` decimal(11, 0) NULL DEFAULT NULL COMMENT '租赁时油量',
  `end_oil` decimal(11, 0) NULL DEFAULT NULL COMMENT '归还时油量',
  `oil_spread` decimal(11, 0) NULL DEFAULT NULL COMMENT '油量补差',
  `maintain_spread` decimal(11, 0) NULL DEFAULT NULL COMMENT '维修费用',
  `overdue_spread` decimal(11, 0) NULL DEFAULT NULL COMMENT '预期补差',
  `amount` decimal(11, 0) NULL DEFAULT NULL COMMENT '租金统计',
  `overdue_time` int(11) NULL DEFAULT NULL COMMENT '预期天数',
  `vehicle_id` int(11) NULL DEFAULT NULL COMMENT '租赁车辆id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '租赁用户id',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注信息',
  `del_flag` int(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `vehicle_contact`(`vehicle_id`) USING BTREE,
  INDEX `user_contact`(`user_id`) USING BTREE,
  CONSTRAINT `user_contact` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `vehicle_contact` FOREIGN KEY (`vehicle_id`) REFERENCES `sys_vehicle` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '租赁合同管理' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `user_type` int(1) NULL DEFAULT NULL COMMENT '用户类型（0普通用户，1会员）',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `moblie` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭地址',
  `occupation` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业（字典查询）',
  `id_card_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证照片',
  `driver_license_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '驾驶证照片',
  `member_type` int(1) NULL DEFAULT NULL COMMENT '会员类型（0大众会员，1至尊会员）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `del_flag` int(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_vehicle
-- ----------------------------
DROP TABLE IF EXISTS `sys_vehicle`;
CREATE TABLE `sys_vehicle`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车辆id',
  `vehicle_logo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车标',
  `vehicle_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车牌号',
  `travel_num` int(11) NULL DEFAULT NULL COMMENT '行驶公里',
  `vehicle_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆照片',
  `vehicle_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆信息',
  `contact_begin` datetime(0) NULL DEFAULT NULL COMMENT '车辆使用权开始时间',
  `contact_end` datetime(0) NULL DEFAULT NULL COMMENT '车辆使用权截止时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注信息',
  `del_flag` int(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '车辆管理' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for vehicle_accident
-- ----------------------------
DROP TABLE IF EXISTS `vehicle_accident`;
CREATE TABLE `vehicle_accident`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '事故登记id',
  `accident_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事故描述',
  `accident_time` datetime(0) NULL DEFAULT NULL COMMENT '事故发生时间',
  `vehicle_id` int(11) NULL DEFAULT NULL COMMENT '车辆id',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注信息',
  `del_flag` int(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `vehicle_accident`(`vehicle_id`) USING BTREE,
  CONSTRAINT `vehicle_accident` FOREIGN KEY (`vehicle_id`) REFERENCES `sys_vehicle` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '事故登记' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for vehicle_maintain
-- ----------------------------
DROP TABLE IF EXISTS `vehicle_maintain`;
CREATE TABLE `vehicle_maintain`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '维修记录id',
  `maintain_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修详情',
  `begin_time` datetime(0) NULL DEFAULT NULL COMMENT '维修开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '维修截止时间',
  `vehicle_id` int(11) NULL DEFAULT NULL COMMENT '车辆id',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注信息',
  `del_flag` int(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `vehicle_maintain`(`vehicle_id`) USING BTREE,
  CONSTRAINT `vehicle_maintain` FOREIGN KEY (`vehicle_id`) REFERENCES `sys_vehicle` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '维修记录' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
