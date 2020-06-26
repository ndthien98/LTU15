-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: db
-- ------------------------------------------------------
-- Server version	10.1.26-MariaDB-0+deb9u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dbo.BANGXH`
--

DROP TABLE IF EXISTS `dbo.BANGXH`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.BANGXH` (
  `MACLB` varchar(3) DEFAULT NULL,
  `NAM` smallint(6) DEFAULT NULL,
  `VONG` tinyint(4) DEFAULT NULL,
  `SOTRAN` tinyint(4) DEFAULT NULL,
  `THANG` tinyint(4) DEFAULT NULL,
  `HOA` tinyint(4) DEFAULT NULL,
  `THUA` tinyint(4) DEFAULT NULL,
  `HIEUSO` varchar(3) DEFAULT NULL,
  `DIEM` tinyint(4) DEFAULT NULL,
  `HANG` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.BANGXH`
--

LOCK TABLES `dbo.BANGXH` WRITE;
/*!40000 ALTER TABLE `dbo.BANGXH` DISABLE KEYS */;
INSERT INTO `dbo.BANGXH` VALUES ('BBD',2009,1,1,1,0,0,'3-0',3,1),('BBD',2009,2,2,1,0,1,'3-5',3,2),('BBD',2009,3,3,2,0,1,'4-5',6,1),('BBD',2009,4,4,2,1,1,'6-7',7,1),('GDT',2009,1,1,0,1,0,'1-1',1,3),('GDT',2009,2,1,0,1,0,'1-1',1,4),('GDT',2009,3,2,1,1,0,'3-1',4,2),('GDT',2009,4,3,1,2,0,'5-1',5,2),('KKH',2009,1,1,0,1,0,'1-1',1,2),('KKH',2009,2,2,0,2,0,'3-3',2,3),('KKH',2009,3,3,0,2,1,'3-4',2,4),('KKH',2009,4,4,1,2,1,'4-4',5,3),('SDN',2009,1,1,0,0,1,'0-3',0,5),('SDN',2009,2,2,1,1,0,'2-5',1,5),('SDN',2009,3,2,1,1,0,'2-5',1,5),('SDN',2009,4,2,1,1,0,'2-5',1,5),('TPY',2009,1,0,0,0,0,'0-0',0,4),('TPY',2009,2,1,1,0,0,'5-0',3,1),('TPY',2009,3,2,1,0,1,'5-2',3,3),('TPY',2009,4,3,1,0,2,'5-3',3,4);
/*!40000 ALTER TABLE `dbo.BANGXH` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.CAULACBO`
--

DROP TABLE IF EXISTS `dbo.CAULACBO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.CAULACBO` (
  `MACLB` varchar(4) DEFAULT NULL,
  `TENCLB` varchar(21) DEFAULT NULL,
  `MASAN` varchar(2) DEFAULT NULL,
  `MATINH` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.CAULACBO`
--

LOCK TABLES `dbo.CAULACBO` WRITE;
/*!40000 ALTER TABLE `dbo.CAULACBO` DISABLE KEYS */;
INSERT INTO `dbo.CAULACBO` VALUES ('BBD','Becamex Bình Dương','GD','BD'),('GDT','Gạch Đồng Tâm Long An','LA','LA'),('HAGL','Hoàng Anh Gia Lai','PL','GL'),('KKH','Khatoco Khánh Hòa','NT','KH'),('SDN','SHB Đà Nẵng','CL','DN'),('TPY','Thép Phú Yên','TH','PY');
/*!40000 ALTER TABLE `dbo.CAULACBO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.CAUTHU`
--

DROP TABLE IF EXISTS `dbo.CAUTHU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.CAUTHU` (
  `MACT` tinyint(4) DEFAULT NULL,
  `HOTEN` varchar(17) DEFAULT NULL,
  `VITRI` varchar(8) DEFAULT NULL,
  `NGAYSINH` varchar(19) DEFAULT NULL,
  `DIACHI` varchar(0) DEFAULT NULL,
  `MACLB` varchar(4) DEFAULT NULL,
  `MAQG` varchar(3) DEFAULT NULL,
  `SO` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.CAUTHU`
--

LOCK TABLES `dbo.CAUTHU` WRITE;
/*!40000 ALTER TABLE `dbo.CAUTHU` DISABLE KEYS */;
INSERT INTO `dbo.CAUTHU` VALUES (1,'Nguyễn Vũ Phong','Tiền Đạo','1990-02-20 00:00:00','','BBD','VN',10),(2,'Nguyễn Công Vinh','Tiền Đạo','1992-03-10 00:00:00','','HAGL','VN',9),(4,'Trần Tấn Tài','Tiền vệ','1989-11-12 00:00:00','','BBD','VN',8),(5,'Phan Hồng Sơn','Thủ môn','1991-06-10 00:00:00','','HAGL','VN',1),(6,'Ronaldo','Tiền vệ','1989-12-12 00:00:00','','SDN','BRA',7),(7,'Robinho','Tiền vệ','1989-10-12 00:00:00','','SDN','BRA',8),(8,'Vidic','Hậu vệ','1987-10-15 00:00:00','','HAGL','ANH',3),(9,'Trần Văn Santos','Thủ môn','1990-10-21 00:00:00','','BBD','TBN',1),(10,'Nguyễn Trường Sơn','Hậu vệ','1993-08-26 00:00:00','','BBD','VN',4);
/*!40000 ALTER TABLE `dbo.CAUTHU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.HLV_CLB`
--

DROP TABLE IF EXISTS `dbo.HLV_CLB`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.HLV_CLB` (
  `MAHLV` varchar(5) DEFAULT NULL,
  `MACLB` varchar(4) DEFAULT NULL,
  `VAITRO` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.HLV_CLB`
--

LOCK TABLES `dbo.HLV_CLB` WRITE;
/*!40000 ALTER TABLE `dbo.HLV_CLB` DISABLE KEYS */;
INSERT INTO `dbo.HLV_CLB` VALUES ('HL001','BBD','HLV Chính'),('HL002','SDN','HLV Chính'),('HL003','HAGL','HLV Chính'),('HL004','GDT','HLV Chính'),('HL005','BBD','HLV thủ môn');
/*!40000 ALTER TABLE `dbo.HLV_CLB` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.HUANLUYENVIEN`
--

DROP TABLE IF EXISTS `dbo.HUANLUYENVIEN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.HUANLUYENVIEN` (
  `MAHLV` varchar(5) DEFAULT NULL,
  `TENHLV` varchar(14) DEFAULT NULL,
  `NGAYSINH` varchar(19) DEFAULT NULL,
  `DIACHI` varchar(0) DEFAULT NULL,
  `DIENTHOAI` varchar(11) DEFAULT NULL,
  `MAQG` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.HUANLUYENVIEN`
--

LOCK TABLES `dbo.HUANLUYENVIEN` WRITE;
/*!40000 ALTER TABLE `dbo.HUANLUYENVIEN` DISABLE KEYS */;
INSERT INTO `dbo.HUANLUYENVIEN` VALUES ('HL001','Vital','1955-10-15 00:00:00','','','BDN'),('HL002','Lê Huỳnh Đức','1972-05-20 00:00:00','','01223456789','VN'),('HL003','Chatchai','1954-12-11 00:00:00','','01218990889','THA'),('HL004','Hoàng Anh Tuấn','1970-06-10 00:00:00','','','VN'),('HL005','Trần Công Minh','1973-07-07 00:00:00','','0909099990','VN'),('HL006','Trần Văn Phúc','1965-03-02 00:00:00','','','VN');
/*!40000 ALTER TABLE `dbo.HUANLUYENVIEN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.QUOCGIA`
--

DROP TABLE IF EXISTS `dbo.QUOCGIA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.QUOCGIA` (
  `MAQG` varchar(3) DEFAULT NULL,
  `TENQG` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.QUOCGIA`
--

LOCK TABLES `dbo.QUOCGIA` WRITE;
/*!40000 ALTER TABLE `dbo.QUOCGIA` DISABLE KEYS */;
INSERT INTO `dbo.QUOCGIA` VALUES ('ANH','Anh Quốc'),('BDN','Đồ Đào Nha'),('BRA','Brazil'),('ITA','Ý'),('TBN','Tây Ban Nha'),('THA','Thái Lan'),('VN','Việt Nam');
/*!40000 ALTER TABLE `dbo.QUOCGIA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.SANVD`
--

DROP TABLE IF EXISTS `dbo.SANVD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.SANVD` (
  `MASAN` varchar(2) DEFAULT NULL,
  `TENSAN` varchar(18) DEFAULT NULL,
  `DIACHI` varchar(55) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.SANVD`
--

LOCK TABLES `dbo.SANVD` WRITE;
/*!40000 ALTER TABLE `dbo.SANVD` DISABLE KEYS */;
INSERT INTO `dbo.SANVD` VALUES ('CL','San Chi Lăng','127 Võ Văn Tần, Đà Nẵng'),('GD','Sân Gò Đậu','123 QL1, TX Thủ Dầu Một'),('LA','Sân Long An','102 Hùng Vương, TX Tân AN'),('NT','Sân 19/8 Nha Trang','128 Phan Chu Trinh, Nha Trang'),('PL','Sân Pleiku','22 Hồ Tùng Mậu Tổ 12 Thống Nhất Thị xã Pleiku , Gia Lai'),('TH','Sân Tuy Hòa','57 Trường Chinh, Tuy Hòa, Phú Yên');
/*!40000 ALTER TABLE `dbo.SANVD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.TINH`
--

DROP TABLE IF EXISTS `dbo.TINH`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.TINH` (
  `MATINH` varchar(2) DEFAULT NULL,
  `TENTINH` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.TINH`
--

LOCK TABLES `dbo.TINH` WRITE;
/*!40000 ALTER TABLE `dbo.TINH` DISABLE KEYS */;
INSERT INTO `dbo.TINH` VALUES ('BD','Bình Dương'),('DN','Đà Nẵng'),('GL','Gia Lai'),('KH','Khánh Hòa'),('LA','Long An'),('PY','Phú Yên');
/*!40000 ALTER TABLE `dbo.TINH` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.TRANDAU`
--

DROP TABLE IF EXISTS `dbo.TRANDAU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.TRANDAU` (
  `MATRAN` tinyint(4) DEFAULT NULL,
  `NAM` smallint(6) DEFAULT NULL,
  `VONG` tinyint(4) DEFAULT NULL,
  `NGAYTD` varchar(19) DEFAULT NULL,
  `MACLB1` varchar(3) DEFAULT NULL,
  `MACLB2` varchar(3) DEFAULT NULL,
  `MASAN` varchar(2) DEFAULT NULL,
  `KETQUA` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.TRANDAU`
--

LOCK TABLES `dbo.TRANDAU` WRITE;
/*!40000 ALTER TABLE `dbo.TRANDAU` DISABLE KEYS */;
INSERT INTO `dbo.TRANDAU` VALUES (1,2009,1,'2009-02-07 00:00:00','BBD','SDN','GD','3-0'),(2,2009,1,'2009-02-07 00:00:00','KKH','GDT','NT','1-1'),(3,2009,2,'2009-02-16 00:00:00','SDN','KKH','CL','2-2'),(4,2009,2,'2009-02-16 00:00:00','TPY','BBD','TH','5-0'),(5,2009,3,'2009-03-01 00:00:00','TPY','GDT','TH','0-2'),(6,2009,3,'2009-03-01 00:00:00','KKH','BBD','NT','0-1'),(8,2009,4,'2009-03-07 00:00:00','KKH','TPY','NT','1-0'),(9,2009,4,'2009-03-07 00:00:00','BBD','GDT','GD','2-2');
/*!40000 ALTER TABLE `dbo.TRANDAU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.sysdiagrams`
--

DROP TABLE IF EXISTS `dbo.sysdiagrams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.sysdiagrams` (
  `name` varchar(0) DEFAULT NULL,
  `principal_id` varchar(0) DEFAULT NULL,
  `diagram_id` varchar(0) DEFAULT NULL,
  `version` varchar(0) DEFAULT NULL,
  `definition` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.sysdiagrams`
--

LOCK TABLES `dbo.sysdiagrams` WRITE;
/*!40000 ALTER TABLE `dbo.sysdiagrams` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo.sysdiagrams` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-22 15:20:28
