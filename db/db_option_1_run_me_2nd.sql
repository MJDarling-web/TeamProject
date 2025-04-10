-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: photo_chasers_test
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `best_time`
--

DROP TABLE IF EXISTS `best_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `best_time` (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `optimal_time` varchar(50) NOT NULL,
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `optimal_time` (`optimal_time`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `best_time`
--

LOCK TABLES `best_time` WRITE;
/*!40000 ALTER TABLE `best_time` DISABLE KEYS */;
INSERT INTO `best_time` VALUES (2,'afternoon'),(3,'evening'),(4,'golden hour'),(1,'morning'),(5,'night');
/*!40000 ALTER TABLE `best_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `images` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `location_id` int NOT NULL,
                          `image_url` varchar(500) NOT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `location_id` (`location_id`,`image_url`),
                          CONSTRAINT `images_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` VALUES (1,1,'https://myimageurl_1.com'),(2,1,'https://myimageurl_2.com'),(3,2,'https://myimageurl_3.com'),(4,2,'https://myimageurl_4.com'),(5,3,'https://myimageurl_5.com'),(6,3,'https://myimageurl_6.com'),(7,4,'https://myimageurl_7.com'),(8,4,'https://myimageurl_8.com'),(10,5,'https://myimageurl_10.com'),(9,5,'https://myimageurl_9.com'),(11,6,'https://myimageurl_11.com'),(12,6,'https://myimageurl_12.com'),(13,7,'https://myimageurl_13.com'),(14,7,'https://myimageurl_14.com'),(15,8,'https://myimageurl_15.com'),(16,8,'https://myimageurl_16.com'),(17,9,'https://myimageurl_17.com'),(18,9,'https://myimageurl_18.com'),(19,10,'https://myimageurl_19.com'),(20,10,'https://myimageurl_20.com');
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `location_name` varchar(255) NOT NULL,
                            `city` varchar(100) NOT NULL,
                            `state` char(2) NOT NULL,
                            `latitude` decimal(9,6) NOT NULL,
                            `longitude` decimal(9,6) NOT NULL,
                            `description` text NOT NULL,
                            `best_time_id` int NOT NULL,
                            `subject_id` int NOT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `location_name` (`location_name`,`latitude`,`longitude`),
                            KEY `subject_id` (`subject_id`),
                            KEY `best_time_id` (`best_time_id`),
                            CONSTRAINT `location_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE RESTRICT,
                            CONSTRAINT `location_ibfk_2` FOREIGN KEY (`best_time_id`) REFERENCES `best_time` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Sunset Cliffs','San Diego','CA',32.735300,-117.255000,'Dramatic ocean views and rugged cliffs.',4,1),(2,'Millennium Park','Chicago','IL',41.882600,-87.622600,'Famous for Cloud Gate and city skyline views.',2,5),(3,'Acadia Overlook','Bar Harbor','ME',44.338600,-68.273300,'Scenic views of the ocean and rocky coastline.',1,14),(4,'Brooklyn Bridge','New York','NY',40.706100,-73.996900,'Iconic architecture spanning the East River.',3,2),(5,'Great Smoky Mountains','Gatlinburg','TN',35.653200,-83.507000,'Lush forest, foggy ridges, and wildlife.',1,3),(6,'Mission District Murals','San Francisco','CA',37.759900,-122.414800,'Colorful and expressive mural art.',2,9),(7,'Steel Mill Ruins','Pittsburgh','PA',40.440600,-79.995900,'Gritty industrial relics with rust tones.',5,11),(8,'Lincoln Memorial','Washington','DC',38.889300,-77.050200,'Historic site with striking architecture.',3,6),(9,'Lake Tahoe Shoreline','South Lake Tahoe','CA',38.939900,-119.977200,'Crystal clear water surrounded by mountains.',4,7),(10,'Central Park','New York','NY',40.785100,-73.968300,'Vast park in the heart of Manhattan.',2,12);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `subject_name` varchar(100) NOT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `subject_name` (`subject_name`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (4,'Abstract'),(2,'Architecture'),(5,'Cityscape'),(10,'Cultural'),(6,'Historical'),(11,'Industrial'),(13,'Minimalism'),(9,'Murals'),(1,'Nature'),(8,'Night'),(12,'Parks'),(17,'People'),(14,'Rural'),(16,'Seasonal'),(15,'Urban'),(7,'Waterfront'),(3,'Wildlife');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-10  8:20:20
