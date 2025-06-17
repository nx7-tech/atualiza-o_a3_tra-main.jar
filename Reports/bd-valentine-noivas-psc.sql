-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: a3
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `valentine_noivas_agendamento`
--

DROP TABLE IF EXISTS `valentine_noivas_agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `valentine_noivas_agendamento` (
  `id_Agendamento` int NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `hora` time NOT NULL,
  `status` varchar(45) NOT NULL,
  `key_Cliente` int NOT NULL,
  `key_Servico` int NOT NULL,
  PRIMARY KEY (`id_Agendamento`),
  UNIQUE KEY `id_Agendamento_UNIQUE` (`id_Agendamento`),
  KEY `fk_cliente_agendamento` (`key_Cliente`),
  KEY `fk_servico_agendamento` (`key_Servico`),
  CONSTRAINT `fk_cliente_agendamento` FOREIGN KEY (`key_Cliente`) REFERENCES `valentine_noivas_cliente` (`id_Cliente`),
  CONSTRAINT `fk_servico_agendamento` FOREIGN KEY (`key_Servico`) REFERENCES `valentine_noivas_servico` (`id_Servico`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valentine_noivas_agendamento`
--

LOCK TABLES `valentine_noivas_agendamento` WRITE;
/*!40000 ALTER TABLE `valentine_noivas_agendamento` DISABLE KEYS */;
INSERT INTO `valentine_noivas_agendamento` VALUES (9,'2025-10-10','10:00:00','Confirmado',1,3),(10,'2025-11-11','11:00:00','Confirmado',2,3),(11,'2025-12-12','17:00:00','Confirmado',1,1),(12,'2025-10-25','13:30:00','Confirmado',4,5);
/*!40000 ALTER TABLE `valentine_noivas_agendamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valentine_noivas_cliente`
--

DROP TABLE IF EXISTS `valentine_noivas_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `valentine_noivas_cliente` (
  `id_Cliente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `cpf_Cliente` varchar(45) NOT NULL,
  `endereco_Cliente` varchar(45) NOT NULL,
  `email_Cliente` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_Cliente`),
  UNIQUE KEY `id_Cliente_UNIQUE` (`id_Cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valentine_noivas_cliente`
--

LOCK TABLES `valentine_noivas_cliente` WRITE;
/*!40000 ALTER TABLE `valentine_noivas_cliente` DISABLE KEYS */;
INSERT INTO `valentine_noivas_cliente` VALUES (1,'Ana Cláudia Santos','+55 (31) 91234-5678','001.234.567-89','Rua das Catuabas 69','ana.clau@hotmail.com'),(2,'Bruna Diaz Carvalho','+55 (31) 98765-4321','987.654.321-01','Rua Santo Domingo 13','brudiaz@gmail.com'),(3,'Carla Silva Santos','+55 (38) 91827-3645','156.987.657-65','Rua Geraldo Ivo 123','carsilsan@outlook.com'),(4,'Dandara Reis Castro','+55 (31) 945689-1237','164.987.321-54','Rua dos Palmares 25','dardara.reis@gmail.com');
/*!40000 ALTER TABLE `valentine_noivas_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valentine_noivas_servico`
--

DROP TABLE IF EXISTS `valentine_noivas_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `valentine_noivas_servico` (
  `id_Servico` int NOT NULL AUTO_INCREMENT,
  `nome_sevico` varchar(45) NOT NULL,
  `preco_servico` varchar(45) NOT NULL,
  `duracao_servico` time NOT NULL,
  PRIMARY KEY (`id_Servico`),
  UNIQUE KEY `id_Servico_UNIQUE` (`id_Servico`),
  UNIQUE KEY `nome_sevico_UNIQUE` (`nome_sevico`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valentine_noivas_servico`
--

LOCK TABLES `valentine_noivas_servico` WRITE;
/*!40000 ALTER TABLE `valentine_noivas_servico` DISABLE KEYS */;
INSERT INTO `valentine_noivas_servico` VALUES (1,'Maquiagem Social','150','01:00:00'),(2,'Cabelo Social','130','01:00:00'),(3,'Maquiagem noiva','400','05:00:00'),(4,'Cabelo noiva','400','05:00:00'),(5,'Vestido Festa','200+','01:00:00'),(6,'Vestido Noiva','3500','05:00:00'),(7,'Maquiagem para Noiva','350.00','02:00:00');
/*!40000 ALTER TABLE `valentine_noivas_servico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-15 23:37:09
