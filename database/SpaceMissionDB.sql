-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: space_mission_db
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `agency`
--

DROP TABLE IF EXISTS `agency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agency` (
  `agency_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `founding_year` year DEFAULT NULL,
  PRIMARY KEY (`agency_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agency`
--

LOCK TABLES `agency` WRITE;
/*!40000 ALTER TABLE `agency` DISABLE KEYS */;
INSERT INTO `agency` VALUES (1,'NASA','United States',1958),(2,'ISRO','India',1969),(3,'ESA','Europe',1975);
/*!40000 ALTER TABLE `agency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `astronaut`
--

DROP TABLE IF EXISTS `astronaut`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `astronaut` (
  `astronaut_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  `agency_id` int DEFAULT NULL,
  PRIMARY KEY (`astronaut_id`),
  KEY `agency_id` (`agency_id`),
  CONSTRAINT `astronaut_ibfk_1` FOREIGN KEY (`agency_id`) REFERENCES `agency` (`agency_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `astronaut`
--

LOCK TABLES `astronaut` WRITE;
/*!40000 ALTER TABLE `astronaut` DISABLE KEYS */;
INSERT INTO `astronaut` VALUES (1,'Neil Armstrong','1930-08-05','Commander','American',1),(2,'Christina H. Koch','1979-01-29','Flight Engineer','American',1),(3,'Rakesh Sharma','1949-01-13','Pilot','Indian',2),(4,'Kalpana Chawla','1962-03-17','Mission Specialist','Indian-American',2),(5,'Samantha Cristoforetti','1977-04-26','Flight Engineer','Italian',3),(6,'Alexander Gerst','1976-05-03','Scientist','German',3),(7,'Sunita Williams','1965-09-19','Flight Engineer','American-Indian',1);
/*!40000 ALTER TABLE `astronaut` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `astronaut_assignment_log`
--

DROP TABLE IF EXISTS `astronaut_assignment_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `astronaut_assignment_log` (
  `log_id` int NOT NULL AUTO_INCREMENT,
  `astronaut_id` int DEFAULT NULL,
  `mission_id` int DEFAULT NULL,
  `assigned_at` datetime DEFAULT NULL,
  PRIMARY KEY (`log_id`),
  KEY `astronaut_id` (`astronaut_id`),
  KEY `mission_id` (`mission_id`),
  CONSTRAINT `astronaut_assignment_log_ibfk_1` FOREIGN KEY (`astronaut_id`) REFERENCES `astronaut` (`astronaut_id`),
  CONSTRAINT `astronaut_assignment_log_ibfk_2` FOREIGN KEY (`mission_id`) REFERENCES `mission` (`mission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `astronaut_assignment_log`
--

LOCK TABLES `astronaut_assignment_log` WRITE;
/*!40000 ALTER TABLE `astronaut_assignment_log` DISABLE KEYS */;
INSERT INTO `astronaut_assignment_log` VALUES (1,2,7,'2025-06-16 10:06:48'),(2,7,6,'2025-06-18 15:50:34');
/*!40000 ALTER TABLE `astronaut_assignment_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `launch`
--

DROP TABLE IF EXISTS `launch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `launch` (
  `launch_id` int NOT NULL AUTO_INCREMENT,
  `launch_time` datetime DEFAULT NULL,
  `launch_site` varchar(100) DEFAULT NULL,
  `outcome` varchar(100) DEFAULT NULL,
  `mission_id` int DEFAULT NULL,
  `spacecraft_id` int DEFAULT NULL,
  PRIMARY KEY (`launch_id`),
  KEY `mission_id` (`mission_id`),
  KEY `spacecraft_id` (`spacecraft_id`),
  CONSTRAINT `launch_ibfk_1` FOREIGN KEY (`mission_id`) REFERENCES `mission` (`mission_id`),
  CONSTRAINT `launch_ibfk_2` FOREIGN KEY (`spacecraft_id`) REFERENCES `spacecraft` (`spacecraft_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `launch`
--

LOCK TABLES `launch` WRITE;
/*!40000 ALTER TABLE `launch` DISABLE KEYS */;
INSERT INTO `launch` VALUES (18,'1977-09-05 12:56:00','Cape Canaveral, USA','Success',6,1),(19,'2011-11-26 15:02:00','Cape Canaveral, USA','Success',7,2),(20,'2008-10-22 00:52:00','Satish Dhawan Space Center, India','Success',8,3),(21,'2013-11-05 09:08:00','Satish Dhawan Space Center, India','Success',9,4),(22,'2025-06-16 12:00:00','Autotest Site','Success',6,1),(23,'2025-12-01 14:45:00','Guiana Space Centre,French Guiana','Scheduled',6,1);
/*!40000 ALTER TABLE `launch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mission`
--

DROP TABLE IF EXISTS `mission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mission` (
  `mission_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `spacecraft_id` int DEFAULT NULL,
  `mission_control_id` int DEFAULT NULL,
  `launch_id` int DEFAULT NULL,
  PRIMARY KEY (`mission_id`),
  KEY `spacecraft_id` (`spacecraft_id`),
  KEY `mission_control_id` (`mission_control_id`),
  KEY `launch_id` (`launch_id`),
  CONSTRAINT `mission_ibfk_1` FOREIGN KEY (`spacecraft_id`) REFERENCES `spacecraft` (`spacecraft_id`),
  CONSTRAINT `mission_ibfk_2` FOREIGN KEY (`mission_control_id`) REFERENCES `mission_control` (`mission_control_id`),
  CONSTRAINT `mission_ibfk_3` FOREIGN KEY (`launch_id`) REFERENCES `launch` (`launch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mission`
--

LOCK TABLES `mission` WRITE;
/*!40000 ALTER TABLE `mission` DISABLE KEYS */;
INSERT INTO `mission` VALUES (6,'Voyager 1 Mission','1977-09-05',NULL,'Active',1,1,18),(7,'Curiosity Mission','2011-11-26',NULL,'Active',2,1,19),(8,'Chandrayaan-1','2008-10-22','2009-08-31','Completed',3,2,20),(9,'Mangalyaan Mission','2013-11-05',NULL,'Active',4,2,21),(10,'Voyager 1 Mission','1977-09-05',NULL,'Active',1,1,NULL),(11,'Curiosity Mission','2011-11-26',NULL,'Active',2,1,NULL),(12,'Chandrayaan-1','2008-10-22','2009-08-31','Completed',3,2,NULL),(13,'Mangalyaan Mission','2013-11-05',NULL,'Active',4,2,NULL),(14,'Rosetta Comet Mission','2004-03-02','2016-09-30','Completed',5,3,NULL),(18,'dgeud','2022-12-02','2022-12-31','Active',3,4,NULL);
/*!40000 ALTER TABLE `mission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mission_astronaut`
--

DROP TABLE IF EXISTS `mission_astronaut`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mission_astronaut` (
  `mission_id` int NOT NULL,
  `astronaut_id` int NOT NULL,
  PRIMARY KEY (`mission_id`,`astronaut_id`),
  KEY `astronaut_id` (`astronaut_id`),
  CONSTRAINT `mission_astronaut_ibfk_1` FOREIGN KEY (`mission_id`) REFERENCES `mission` (`mission_id`),
  CONSTRAINT `mission_astronaut_ibfk_2` FOREIGN KEY (`astronaut_id`) REFERENCES `astronaut` (`astronaut_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mission_astronaut`
--

LOCK TABLES `mission_astronaut` WRITE;
/*!40000 ALTER TABLE `mission_astronaut` DISABLE KEYS */;
INSERT INTO `mission_astronaut` VALUES (6,1),(6,2),(7,2),(6,3),(7,4),(7,5),(8,6),(6,7);
/*!40000 ALTER TABLE `mission_astronaut` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mission_control`
--

DROP TABLE IF EXISTS `mission_control`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mission_control` (
  `mission_control_id` int NOT NULL AUTO_INCREMENT,
  `location` varchar(100) DEFAULT NULL,
  `director` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`mission_control_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mission_control`
--

LOCK TABLES `mission_control` WRITE;
/*!40000 ALTER TABLE `mission_control` DISABLE KEYS */;
INSERT INTO `mission_control` VALUES (1,'Houston, Texas, USA','Gene Kranz'),(2,'Bangalore, India','Ritu Karidhal'),(3,'Darmstadt, Germany','Günther Hasinger'),(4,'Moscow, Russia','Yuri Koptev');
/*!40000 ALTER TABLE `mission_control` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mission_log`
--

DROP TABLE IF EXISTS `mission_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mission_log` (
  `log_id` int NOT NULL AUTO_INCREMENT,
  `mission_name` varchar(100) DEFAULT NULL,
  `inserted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mission_log`
--

LOCK TABLES `mission_log` WRITE;
/*!40000 ALTER TABLE `mission_log` DISABLE KEYS */;
INSERT INTO `mission_log` VALUES (1,'Rosetta Comet Mission','2025-06-18 15:57:46'),(2,'dgeud','2025-06-19 12:25:50');
/*!40000 ALTER TABLE `mission_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payload`
--

DROP TABLE IF EXISTS `payload`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payload` (
  `payload_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `spacecraft_id` int DEFAULT NULL,
  PRIMARY KEY (`payload_id`),
  KEY `spacecraft_id` (`spacecraft_id`),
  CONSTRAINT `payload_ibfk_1` FOREIGN KEY (`spacecraft_id`) REFERENCES `spacecraft` (`spacecraft_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payload`
--

LOCK TABLES `payload` WRITE;
/*!40000 ALTER TABLE `payload` DISABLE KEYS */;
INSERT INTO `payload` VALUES (31,'Hubble Space Telescope','Telescope','Deployed',1),(32,'Chandrayaan-2 Lander','Lander','Crashed',2),(33,'Mars Rover Perseverance','Rover','Operational',3),(34,'Solar Orbiter','Scientific Instrument','Operational',4),(35,'James Webb Telescope','Telescope','Operational',5);
/*!40000 ALTER TABLE `payload` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spacecraft`
--

DROP TABLE IF EXISTS `spacecraft`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spacecraft` (
  `spacecraft_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `manufacturer` varchar(100) DEFAULT NULL,
  `capacity` int DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`spacecraft_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spacecraft`
--

LOCK TABLES `spacecraft` WRITE;
/*!40000 ALTER TABLE `spacecraft` DISABLE KEYS */;
INSERT INTO `spacecraft` VALUES (1,'Voyager 1','NASA',0,'Active (Interstellar)'),(2,'Curiosity','NASA',0,'Active'),(3,'Chandrayaan-1','ISRO',0,'Mission ended (2010)'),(4,'Mangalyaan (MOM)','ISRO',0,'Active'),(5,'Rosetta','ESA',0,'Mission ended (2016)');
/*!40000 ALTER TABLE `spacecraft` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-06 12:37:55
