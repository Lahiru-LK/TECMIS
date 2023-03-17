-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 17, 2023 at 06:44 AM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tecmis`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_role` varchar(20) NOT NULL,
  `user_no` int(100) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(10) NOT NULL,
  `user_password` varchar(10) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `dob` date DEFAULT NULL,
  `sex` varchar(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `tp_number` varchar(12) NOT NULL,
  `profile_image` varchar(1000) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`user_no`,`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_role`, `user_no`, `user_id`, `user_password`, `first_name`, `last_name`, `email`, `dob`, `sex`, `address`, `tp_number`, `profile_image`, `date`) VALUES
('admin', 1, 'admin001', 'admin1', 'lahiru', 'prasad', 'lahiruprresath2623@gmail.com', '1980-12-02', 'male', '103,c/1,walgampaye,danthure', '+94767171263', 'D:\\BICT for Campus Lectures\\Lectures\\2RD YEAR\\1st Semester\\Object Oriented Programming Practicum ICT2132 (P)\\Mini Project\\TECMIS\\src\\main\\resources\\com\\tecmis\\project\\image\\userImages\\admin_lahiru.png', NULL),
('student', 2, 'std001', 'std1', 'shanika', 'priyanthi', 'shanikaprianthi9237@gmail.com', '2000-01-29', 'female', '990,d/6,walasmulla,nugegoda', '+94752436375', 'D:\\BICT for Campus Lectures\\Lectures\\2RD YEAR\\1st Semester\\Object Oriented Programming Practicum ICT2132 (P)\\Mini Project\\TECMIS\\src\\main\\resources\\com\\tecmis\\project\\image\\userImages\\std_shanika.png', NULL),
('student', 3, 'std002', 'std2', 'prevven', 'nikmal', 'prevvennikmal233@gmail.com', '2001-05-13', 'male', '25,a/2,colombo,sesmane 2', '+94784623782', 'D:\\BICT for Campus Lectures\\Lectures\\2RD YEAR\\1st Semester\\Object Oriented Programming Practicum ICT2132 (P)\\Mini Project\\TECMIS\\src\\main\\resources\\com\\tecmis\\project\\image\\userImages\\std_preveen.png', NULL),
('lecturer', 4, 'lec001', 'lec1', 'sarath', 'Kumara', 'sarathkumara232@fot.ruh.lk', '1978-05-20', 'male', '990,f/2,kadanaa,rathmalana', '+94784362458', 'D:\\BICT for Campus Lectures\\Lectures\\2RD YEAR\\1st Semester\\Object Oriented Programming Practicum ICT2132 (P)\\Mini Project\\TECMIS\\src\\main\\resources\\com\\tecmis\\project\\image\\userImages\\lec_sarath.png', NULL),
('technical_officer', 5, 'techoff001', 'techo1', 'shima', 'jacko', 'shimajackonik262@gmail.com', '1980-02-11', 'male', '202,g/1,mawnallla,aranayaka', '+94754623422', 'D:\\BICT for Campus Lectures\\Lectures\\2RD YEAR\\1st Semester\\Object Oriented Programming Practicum ICT2132 (P)\\Mini Project\\TECMIS\\src\\main\\resources\\com\\tecmis\\project\\image\\userImages\\techoff_shima.png', NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
