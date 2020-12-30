-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: vot
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address_list`
--

DROP TABLE IF EXISTS `address_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_list`
--

LOCK TABLES `address_list` WRITE;
/*!40000 ALTER TABLE `address_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `address_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow_record`
--

DROP TABLE IF EXISTS `borrow_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `borrow_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow_record`
--

LOCK TABLES `borrow_record` WRITE;
/*!40000 ALTER TABLE `borrow_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrow_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_table`
--

DROP TABLE IF EXISTS `category_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_table`
--

LOCK TABLES `category_table` WRITE;
/*!40000 ALTER TABLE `category_table` DISABLE KEYS */;
INSERT INTO `category_table` VALUES (1,'外购件','2021-01-00 00:00:00','任利荣','2021-01-00 00:00:00','任利荣',NULL),(2,'镜片','2021-01-00 00:00:00','任利荣','2021-01-00 00:00:00','任利荣',NULL),(3,'镜头','2021-01-00 00:00:00','任利荣','2021-01-00 00:00:00','任利荣',NULL),(4,'半成品','2021-01-00 00:00:00','任利荣','2021-01-00 00:00:00','任利荣',NULL),(5,'镜头机械部分','2021-01-00 00:00:00','任利荣','2021-01-00 00:00:00','任利荣',NULL),(6,'外购件（）','2021-01-00 00:00:00','任利荣','2021-01-00 00:00:00','任利荣',NULL);
/*!40000 ALTER TABLE `category_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_record`
--

DROP TABLE IF EXISTS `delivery_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_record`
--

LOCK TABLES `delivery_record` WRITE;
/*!40000 ALTER TABLE `delivery_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `in_record`
--

DROP TABLE IF EXISTS `in_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `in_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `in_record`
--

LOCK TABLES `in_record` WRITE;
/*!40000 ALTER TABLE `in_record` DISABLE KEYS */;
INSERT INTO `in_record` VALUES (1,'50mm/1.0消热差镜头镜筒机械组','50mm/1.0','XDJ-2043','AL24','三和康瑞','外购件',2,'T1','任利荣','2021-01-00','任利荣',NULL,NULL),(2,'25mm/1.0消热差镜头镜筒机械组','25mm/1.0','XDJ-2042','AL24','三和康瑞','外购件',2,'T1','任利荣','2021-01-00','任利荣',NULL,NULL),(3,'20mm/1.0消热差镜头镜筒机械组','20mm/1.0','XDJ-2041','AL24','三和康瑞','外购件',2,'T1','任利荣',NULL,'任利荣','2020-12-24',NULL),(4,'19mm/1.0消热差镜头镜筒机械组','19mm/1.0','XDJ-2040','AL24','三和康瑞','外购件',2,'T1','任利荣',NULL,'任利荣','2020-12-24',NULL),(5,'19mm/1.0消热差镜头镜筒机械组','19mm/1.0','XDJ-2040','AL24','三和康瑞','外购件',2,'T1','任利荣',NULL,'任利荣','2020-12-24',NULL);
/*!40000 ALTER TABLE `in_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `non_conforming`
--

DROP TABLE IF EXISTS `non_conforming`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `non_conforming` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `non_conforming`
--

LOCK TABLES `non_conforming` WRITE;
/*!40000 ALTER TABLE `non_conforming` DISABLE KEYS */;
/*!40000 ALTER TABLE `non_conforming` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `out_record`
--

DROP TABLE IF EXISTS `out_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `out_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `out_record`
--

LOCK TABLES `out_record` WRITE;
/*!40000 ALTER TABLE `out_record` DISABLE KEYS */;
INSERT INTO `out_record` VALUES (1,'19mm/1.0消热差镜头镜筒机械组','外购件','19mm/1.0','XDJ-2040',NULL,0000000003,'霍亚敏',NULL,'任利荣',NULL,'任利荣',NULL,'安徽光智',NULL),(2,'19mm/1.0消热差镜头镜筒机械组','外购件','19mm/1.0','XDJ-2040',NULL,0000000001,'霍亚敏',NULL,'任利荣',NULL,'任利荣',NULL,'安徽光智',NULL);
/*!40000 ALTER TABLE `out_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage_table`
--

DROP TABLE IF EXISTS `storage_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `storage_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage_table`
--

LOCK TABLES `storage_table` WRITE;
/*!40000 ALTER TABLE `storage_table` DISABLE KEYS */;
INSERT INTO `storage_table` VALUES (1,'50mm/1.0消热差镜头镜筒机械组','外购件','50mm/1.0','AL24','XDJ-2043',0000000002,'三和康瑞','T1','任利荣','2020-12-24','任利荣','2020-12-24',NULL),(2,'25mm/1.0消热差镜头镜筒机械组','外购件','25mm/1.0','AL24','XDJ-2042',0000000002,'三和康瑞','T1','任利荣','2020-12-24','任利荣','2020-12-24',NULL),(3,'20mm/1.0消热差镜头镜筒机械组','外购件','20mm/1.0','AL24','XDJ-2041',0000000002,'三和康瑞','T1','任利荣','2020-12-24','任利荣','2020-12-24',NULL),(4,'19mm/1.0消热差镜头镜筒机械组','外购件','19mm/1.0','AL24','XDJ-2040',0000000000,'三和康瑞','T1','任利荣','2020-12-24','任利荣','2020-12-24',NULL);
/*!40000 ALTER TABLE `storage_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_table`
--

DROP TABLE IF EXISTS `user_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_table`
--

LOCK TABLES `user_table` WRITE;
/*!40000 ALTER TABLE `user_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-30 14:59:23
