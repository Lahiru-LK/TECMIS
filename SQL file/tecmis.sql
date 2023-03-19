-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 19, 2023 at 06:11 AM
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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `course_name` varchar(20) NOT NULL,
  `description` varchar(100) NOT NULL,
  `degree` varchar(100) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`course_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`course_name`, `description`, `degree`, `date`) VALUES
('BBT', 'Biosysterm Technology', 'Bachelor of Biosyterm Technology(Hons)', '2023-03-18'),
('BET', 'Engineering Technology', 'Bachelor of Engineering Technology(Hons)', '2023-03-18'),
('BICT', 'Information & Comminication Technology', 'Bachelor of Information & Comminication Technology(Hons)', '2023-03-18');

-- --------------------------------------------------------

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
CREATE TABLE IF NOT EXISTS `notice` (
  `notice_id` varchar(20) NOT NULL,
  `notice_name` varchar(1000) NOT NULL,
  `bodyof_notice` varchar(5000) NOT NULL,
  `notice_imagepdf` varchar(5000) DEFAULT NULL,
  `notice_createdate` date DEFAULT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notice`
--

INSERT INTO `notice` (`notice_id`, `notice_name`, `bodyof_notice`, `notice_imagepdf`, `notice_createdate`) VALUES
('Node0001', 'NOTICE PUBLISHED  THE UNIVERSITY GRANTS COMMISSION', 'It is hereby informed that the University Grants Commission (UGC) decided to consider the \nstudents who will be sitting for the G.C.E. (A/L) Examination to be held in the year 2019 under \nnew syllabus and old syllabus as two distinct populations as directed by the Supreme Court in SC\n\nUniversity Grants Commission\nNo: 20, Ward Place, Colombo 07\n08.04.2019', 'D:\\BICT for Campus Lectures\\Lectures\\2RD YEAR\\1st Semester\\Object Oriented Programming Practicum ICT2132 (P)\\Mini Project\\TECMIS\\src\\main\\resources\\com\\tecmis\\project\\image\\noticeandtimetable\\notice\\notice1.jpg', '2023-03-17'),
('Node0002', 'PGIM', '????????????????????????????????????????????????????????????????????????\n????????????????????????????????????????????????????????????????????\n????????????????????????????\n\n\n123/xxxxx/xxxxx,\nzzzzzzzzzzzzzzzz,\n\n...............................', 'D:\\BICT for Campus Lectures\\Lectures\\2RD YEAR\\1st Semester\\Object Oriented Programming Practicum ICT2132 (P)\\Mini Project\\TECMIS\\src\\main\\resources\\com\\tecmis\\project\\image\\noticeandtimetable\\notice\\notice2.jpg', '2023-03-19');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_role` varchar(20) NOT NULL,
  `user_id` varchar(10) NOT NULL,
  `user_password` varchar(10) NOT NULL,
  `course` varchar(20) DEFAULT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `dob` date DEFAULT NULL,
  `sex` varchar(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `tp_number` varchar(12) NOT NULL,
  `profile_image` varchar(1000) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_role`, `user_id`, `user_password`, `course`, `first_name`, `last_name`, `email`, `dob`, `sex`, `address`, `tp_number`, `profile_image`, `date`) VALUES
('Admin', 'admin001', 'admin1', 'null', 'Lahiru', 'Prasad', 'lahiruprresath2623@gmail.com', '2000-03-21', 'males', '103,c/1,walgampaye,danthure', '+94767171263', 'D:\\BICT for Campus Lectures\\Lectures\\2RD YEAR\\1st Semester\\Object Oriented Programming Practicum ICT2132 (P)\\Mini Project\\TECMIS\\src\\main\\resources\\com\\tecmis\\project\\image\\userImages\\admin_lahiru.png', NULL),
('Student', 'std001', 'std1', 'BBT', 'Shanika', 'Priyanthi', 'shanikaprianthi9237@gmail.com', '2000-01-29', 'female', '990,d/6,walasmulla,nugegoda', '+94752436375', 'D:\\BICT for Campus Lectures\\Lectures\\2RD YEAR\\1st Semester\\Object Oriented Programming Practicum ICT2132 (P)\\Mini Project\\TECMIS\\src\\main\\resources\\com\\tecmis\\project\\image\\userImages\\student\\std_shanika.png', NULL),
('Student', 'std002', 'std2', 'BET', 'Preveen', 'Nikmal', 'prevvennikmal233@gmail.com', '2001-05-13', 'males', '25,a/2,colombo,sesmane 2', '+94784623782', 'D:\\BICT for Campus Lectures\\Lectures\\2RD YEAR\\1st Semester\\Object Oriented Programming Practicum ICT2132 (P)\\Mini Project\\TECMIS\\src\\main\\resources\\com\\tecmis\\project\\image\\userImages\\student\\std_preveen.png', NULL),
('Lecturer', 'lec001', 'lec1', 'null', 'Sarath', 'Kumara', 'sarathkumara232@fot.ruh.lk', '1978-05-20', 'males', '990,f/2,kadanaa,rathmalana', '+94784362458', 'D:\\BICT for Campus Lectures\\Lectures\\2RD YEAR\\1st Semester\\Object Oriented Programming Practicum ICT2132 (P)\\Mini Project\\TECMIS\\src\\main\\resources\\com\\tecmis\\project\\image\\userImages\\lecturer\\lec_sarath.png', NULL),
('Technician_Officer', 'techoff001', 'techo1', 'null', 'Shima', 'Jacko', 'shimajackonik262@gmail.com', '1980-02-11', 'males', '202,g/1,mawnallla,aranayaka', '+94754623422', 'D:\\BICT for Campus Lectures\\Lectures\\2RD YEAR\\1st Semester\\Object Oriented Programming Practicum ICT2132 (P)\\Mini Project\\TECMIS\\src\\main\\resources\\com\\tecmis\\project\\image\\userImages\\technical_officer\\techoff_shima.png', NULL),
('Student', 'std003', 'std3', 'BICT', 'Menaka', 'Prebath', 'menukaprabath22@gmail.com', '1996-02-06', 'males', '80,h/3,waththegama,kandy', '+94767272567', 'D:\\BICT for Campus Lectures\\Lectures\\2RD YEAR\\1st Semester\\Object Oriented Programming Practicum ICT2132 (P)\\Mini Project\\TECMIS\\src\\main\\resources\\com\\tecmis\\project\\image\\userImages\\student\\std_Menaka.jpg', '2023-03-17'),
('Admin', 'admin002', 'admin2', 'null', 'Shakya', 'Deebyana', 'sinkibaby299@gmail.com', '1990-03-05', 'female', '900,b/2,colombo,road,7', '+94787878999', 'D:\\BICT for Campus Lectures\\Lectures\\2RD YEAR\\1st Semester\\Object Oriented Programming Practicum ICT2132 (P)\\Mini Project\\TECMIS\\src\\main\\resources\\com\\tecmis\\project\\image\\userImages\\admin_Shakya.jpg', '2023-03-17');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
