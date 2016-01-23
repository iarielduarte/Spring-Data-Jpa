/*
SQLyog Community v11.25 (64 bit)
MySQL - 5.6.20 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `author` */

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `author` */

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`id`,`name`) values (1,'Testing Repository'),(2,'Test Spring Jpa'),(3,'Test 1453347431368');

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `person` */

insert  into `person`(`id`,`firstname`,`lastname`) values (2,'ariel','duarte'),(3,'First 1453348461113','Last 1453348461113'),(4,'First 1453348750074','Last 1453348750074'),(5,'First 1453349260440','Last 1453349260440'),(6,'First 1453349635391','Last 1453349635391'),(7,'First 1453350067321','Last 1453350067321'),(8,'First 1453350172568','Last 1453350172568'),(9,'First 1453350209410','Last 1453350209410'),(10,'First 1453350536685','Last 1453350536685'),(11,'First 1453350621313','Last 1453350621313'),(12,'First 1453350675626','Last 1453350675626'),(13,'First 1453350761779','Last 1453350761779'),(14,'First 1453351292468','Last 1453351292468'),(15,'First 1453351314148','Last 1453351314148'),(16,'First 1453351366248','Last 1453351366248'),(17,'First 1453351421018','Last 1453351421018'),(18,'First 1453351479043','Last 1453351479043'),(19,'First 1453411641329','Last 1453411641329'),(20,'First Name 1453412864750','Last Name 1453412864750'),(21,'First Name 1453413243474','Last Name 1453413243474'),(22,'First Name 1453413306824','Last Name 1453413306824'),(23,'First Name 1453413578090','Last Name 1453413578090'),(24,'Test First Name 1453413775327','Test Last Name 1453413775327'),(25,'Test First Name 1453413825656','Test Last Name 1453413825656'),(26,'Test First Name 1453414099267','Test Last Name 1453414099267'),(27,'Test First Name 1453414207634','Test Last Name 1453414207634'),(28,'Test First Name 1453414286231','Test Last Name 1453414286231'),(29,'Test Insert Person - First Name1453414897601','Test Insert Person - Last Name1453414897601');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
