DROP TABLE IF EXISTS `address_list`;

CREATE TABLE `address_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `telephone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `address` varchar(50) DEFAULT NULL COMMENT '联系地址',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `mark` varchar(255) DEFAULT NULL COMMENT '备注',
  `company` varchar(50) DEFAULT NULL COMMENT '所属公司',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  `updated_name` varchar(20) DEFAULT NULL COMMENT '更新人',
  `updated_time` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `address_list` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `borrow_record`;

CREATE TABLE `borrow_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matnr` int(8) unique NOT NULL COMMENT '物料号',
  `part_name` varchar(20) DEFAULT NULL COMMENT '零部件名称',
  `part_specification` varchar(50) DEFAULT NULL COMMENT '规格',
  `category` varchar(20) DEFAULT NULL COMMENT '所属类别',
  `figure_number` varchar(50) DEFAULT NULL COMMENT '图号',
  `number` int(11) DEFAULT NULL COMMENT '数量',
  `material` varchar(20) DEFAULT NULL COMMENT '材料',
  `borrow_name` varchar(20) DEFAULT NULL COMMENT '借用人',
  `borrow_time` datetime DEFAULT NULL COMMENT '借用时间',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  `updated_name` varchar(20) DEFAULT NULL COMMENT '更新人',
  `updated_time` date DEFAULT NULL COMMENT '更新时间',
  `supplier` varchar(50) DEFAULT NULL COMMENT '所属部门或者客户公司名称',
  `mark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `borrow_record` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `category_table`;

CREATE TABLE `category_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `updated_name` varchar(20) DEFAULT NULL COMMENT '跟新人',
  `mark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

LOCK TABLES `category_table` WRITE;

INSERT INTO `category_table` VALUES
    (1,'外购件','2021-01-00 00:00:00','任利荣','2021-01-00 00:00:00','任利荣',NULL),
    (2,'镜片','2021-01-00 00:00:00','任利荣','2021-01-00 00:00:00','任利荣',NULL),
    (3,'镜头','2021-01-00 00:00:00','任利荣','2021-01-00 00:00:00','任利荣',NULL),
    (4,'半成品','2021-01-00 00:00:00','任利荣','2021-01-00 00:00:00','任利荣',NULL),
    (5,'镜头机械部分','2021-01-00 00:00:00','任利荣','2021-01-00 00:00:00','任利荣',NULL),
    (6,'外购件（）','2021-01-00 00:00:00','任利荣','2021-01-00 00:00:00','任利荣',NULL);

UNLOCK TABLES;

DROP TABLE IF EXISTS `delivery_record`;

CREATE TABLE `delivery_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matnr` int(8) unique NOT NULL COMMENT '物料号',
  `part_name` varchar(20) DEFAULT NULL COMMENT '零部件名称',
  `part_specification` varchar(50) DEFAULT NULL COMMENT '规格',
  `category` varchar(20) DEFAULT NULL COMMENT '所属类别',
  `figure_number` varchar(50) DEFAULT NULL COMMENT '图号',
  `number` bigint(8) DEFAULT NULL COMMENT '发货数量',
  `delivery_name` varchar(20) DEFAULT NULL COMMENT '发货人',
  `delivery_address` varchar(50) DEFAULT NULL COMMENT '发货地址',
  `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
  `borrow_name` varchar(20) DEFAULT NULL COMMENT '收货人姓名',
  `telephone` varchar(28) DEFAULT NULL COMMENT '收货地址',
  `supplier` varchar(50) DEFAULT NULL COMMENT '收货供应商',
  `borrow_address` varchar(50) DEFAULT NULL COMMENT '收获供地址',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  `updated_name` varchar(20) DEFAULT NULL COMMENT '更新人',
  `updated_time` date DEFAULT NULL COMMENT '更新时间',
  `mark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `delivery_record` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `in_record`;

CREATE TABLE `in_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matnr` int(8) unique NOT NULL COMMENT '物料号',
  `part_name` varchar(50) DEFAULT NULL COMMENT '零部件名称',
  `part_specification` varchar(50) DEFAULT NULL COMMENT '规格',
  `figure_number` varchar(50) DEFAULT NULL COMMENT '图号',
  `material` varchar(20) DEFAULT NULL COMMENT '材料',
  `supplier` varchar(50) DEFAULT NULL COMMENT '供货商',
  `category` varchar(20) DEFAULT NULL COMMENT '所属类别',
  `quantity` int(11) DEFAULT NULL COMMENT '入库数量',
  `location` varchar(20) DEFAULT NULL COMMENT '库位',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  `updated_name` varchar(20) DEFAULT NULL COMMENT '更新人',
  `updated_time` date DEFAULT NULL COMMENT '更新时间',
  `mark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `non_conforming`;

CREATE TABLE `non_conforming` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matnr` int(8) unique NOT NULL COMMENT '物料号',
  `part_name` varchar(50) DEFAULT NULL COMMENT '零部件名称',
  `category` varchar(20) DEFAULT NULL COMMENT '所属类别',
  `part_specification` varchar(50) DEFAULT NULL COMMENT '规格',
  `material` varchar(20) DEFAULT NULL COMMENT '材料',
  `figure_number` varchar(50) DEFAULT NULL COMMENT '图号',
  `quantity` bigint(8) DEFAULT NULL COMMENT '入库数量',
  `location` varchar(50) DEFAULT NULL COMMENT '库位',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  `updated_name` varchar(20) DEFAULT NULL COMMENT '更新人',
  `updated_time` date DEFAULT NULL COMMENT '更新时间',
  `mark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `non_conforming` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `out_record`;
CREATE TABLE `out_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matnr` int(8) unique NOT NULL COMMENT '物料号',
  `part_name` varchar(50) DEFAULT NULL COMMENT '零部件名称',
  `category` varchar(20) DEFAULT NULL COMMENT '所属类别',
  `part_specification` varchar(50) DEFAULT NULL COMMENT '规格',
  `figure_number` varchar(50) DEFAULT NULL COMMENT '图号',
  `material` varchar(20) DEFAULT NULL COMMENT '材料',
  `number` int(10) unsigned zerofill DEFAULT NULL COMMENT '领用数量',
  `receive_name` varchar(20) DEFAULT NULL COMMENT '领用人',
  `receive_time` datetime DEFAULT NULL COMMENT '领用时间',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  `updated_name` varchar(20) DEFAULT NULL COMMENT '更新人',
  `updated_time` date DEFAULT NULL COMMENT '更新时间',
  `supplier` varchar(50) DEFAULT NULL COMMENT '供货商',
  `mark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `storage_table`;

CREATE TABLE `storage_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matnr` int(8) unique NOT NULL COMMENT '物料号',
  `part_name` varchar(50) DEFAULT NULL COMMENT '零部件名称',
  `category` varchar(20) DEFAULT NULL COMMENT '类别',
  `part_specification` varchar(50) DEFAULT NULL COMMENT '规格',
  `material` varchar(20) DEFAULT NULL COMMENT '材料',
  `figure_number` varchar(50) DEFAULT NULL COMMENT '图号',
  `number` int(10) unsigned zerofill DEFAULT NULL COMMENT '数量',
  `supplier` varchar(50) DEFAULT NULL COMMENT '供货商',
  `location` varchar(20) DEFAULT NULL COMMENT '库位',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  `updated_name` varchar(20) DEFAULT NULL COMMENT '更新人',
  `updated_time` date DEFAULT NULL COMMENT '更新时间',
  `mark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `user_table`;

CREATE TABLE `user_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `role` varchar(20) DEFAULT NULL COMMENT '角色',
  `authority` varchar(40) DEFAULT NULL COMMENT '权限',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  `updated_name` varchar(20) DEFAULT NULL COMMENT '更新人',
  `updated_time` date DEFAULT NULL COMMENT '更新时间',
  `mark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user_table` WRITE;
UNLOCK TABLES;

