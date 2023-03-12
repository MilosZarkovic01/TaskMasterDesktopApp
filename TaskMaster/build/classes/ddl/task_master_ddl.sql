/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 10.4.27-MariaDB : Database - task_master
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`task_master` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `task_master`;

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phone_number` varchar(25) NOT NULL,
  `date_of_birth` date NOT NULL,
  `monthly_salary` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `employee` */

insert  into `employee`(`id`,`full_name`,`email`,`phone_number`,`date_of_birth`,`monthly_salary`) values 
(1,'John Smith','john.smith@gmail.com','+381 64 2358523','1990-02-09',4500),
(2,'Jane Doe','jane.doe@gmail.com','+381 66 9149860','1998-07-14',3000),
(3,'Bob Johnson','bob.johnson','+381 65 6561214','1991-11-13',5500),
(4,'Annie Williams','annie.williams@gmail.com','+381 63 6364256','1986-09-17',4500),
(6,'John Lui','john.lui@gmail.com','+381 66 8455121','1970-08-25',3500),
(9,'Oliver Johnson','oliver.johnson@gmail.com','+381 66 5645986','1994-03-11',5500);

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(35) NOT NULL,
  `description` varchar(300) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `budget` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `project` */

insert  into `project`(`id`,`project_name`,`description`,`start_date`,`end_date`,`budget`) values 
(2,'Web app update','Update the existing web application','2023-03-15','2023-06-30',50000),
(3,'Mobile app','Develop a new mobile app','2023-02-01','2023-07-31',20000),
(4,'Marketing campaign','This project involves creating and executing a marketing campaign','2023-04-01','2023-06-15',20000),
(5,'Product launch','This project involves launching a new product','2023-08-01','2023-12-31',75000),
(6,'ShopSmart','ShopSmart is a project that aims to help consumers make informed purchasing decisions by providing product reviews, price comparisons, and information on ethical and sustainable production practices.','2023-01-01','2023-07-30',45000),
(8,'Blog','Personal blog for sharing stories','2023-04-01','2023-03-31',25000),
(9,'Online Store','E-commerce platform for clothing','2023-01-01','2023-03-31',55000);

/*Table structure for table `task` */

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `description` varchar(300) NOT NULL,
  `assigned_employee_fk` bigint(20) DEFAULT NULL,
  `due_date` date NOT NULL,
  `project_fk` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `assigned_employee_fk` (`assigned_employee_fk`),
  KEY `project_fk` (`project_fk`),
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`assigned_employee_fk`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `task_ibfk_2` FOREIGN KEY (`project_fk`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `task` */

insert  into `task`(`id`,`title`,`description`,`assigned_employee_fk`,`due_date`,`project_fk`) values 
(3,'Code feature','Implement a new feature for the web application',6,'2023-04-15',2),
(6,'Create marketing plan','Develop a marketing plan for the new product launch',2,'2023-05-15',5),
(8,'Develop software code','Write code for the software development project',1,'2023-10-31',2),
(9,'Redesign website page','Create new design for the website\'s landing and product pages',NULL,'2023-07-15',4),
(13,'Project Task Management','Develop a task management system that allows users to create, assign, and track tasks for different projects.',NULL,'2023-09-30',5),
(14,'Online Grocery Store','Build an online grocery store that allows customers to browse and purchase groceries from the comfort of their own homes.',4,'2023-03-31',2),
(16,'Add product category','Allow customers to browse by',4,'2023-04-15',6),
(17,'Implement search bar','Allow customers to search for',3,'2023-04-30',8);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
