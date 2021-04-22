-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: social_network
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `child_comment`
--

DROP TABLE IF EXISTS `child_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `child_comment` (
  `child_comment_id` int NOT NULL AUTO_INCREMENT,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `comment_image` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `parent_comment_id` int NOT NULL,
  `user_id` int NOT NULL,
  `comment_time` datetime NOT NULL,
  PRIMARY KEY (`child_comment_id`),
  KEY `parent_idx` (`parent_comment_id`),
  KEY `fdsfd_idx` (`user_id`),
  CONSTRAINT `fdsfd` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `parent` FOREIGN KEY (`parent_comment_id`) REFERENCES `parent_comment` (`parent_comment_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `child_comment`
--

LOCK TABLES `child_comment` WRITE;
/*!40000 ALTER TABLE `child_comment` DISABLE KEYS */;
INSERT INTO `child_comment` VALUES (1,'this is child comment of user_3',NULL,1,3,'2021-02-01 10:05:20'),(2,'this is child comment of user_1',NULL,1,1,'2021-02-01 09:05:20'),(3,'this is child comment of user_1',NULL,2,1,'2021-02-01 10:05:20'),(4,'this is child comment of user_1',NULL,3,1,'2021-02-01 11:05:20'),(5,'this is child comment of user_4',NULL,3,4,'2021-02-01 12:05:20'),(6,'this is child comment of user_1',NULL,3,1,'2021-02-01 13:05:20'),(7,'this is child comment of user_2',NULL,4,2,'2021-02-01 14:05:20'),(8,'this is child comment of user_2',NULL,5,2,'2021-02-01 15:05:20'),(9,'this is child comment of user_3',NULL,7,3,'2021-02-01 16:05:20'),(10,'this is child comment of user_3',NULL,7,3,'2021-02-01 17:05:20'),(11,'this is child comment of user_4',NULL,9,4,'2021-02-01 18:05:20'),(12,'this is child comment of user_1',NULL,10,1,'2021-02-01 19:05:20');
/*!40000 ALTER TABLE `child_comment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-22 14:01:34
