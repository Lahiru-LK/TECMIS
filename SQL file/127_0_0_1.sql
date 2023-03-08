-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 08, 2023 at 10:26 AM
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
-- Database: `bict`
--
CREATE DATABASE IF NOT EXISTS `bict` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bict`;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `studnetID` varchar(30) NOT NULL,
  `studnetName` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `subject` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`studnetID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studnetID`, `studnetName`, `age`, `subject`) VALUES
('ST001', 'Lahiru', 22, 'Maths');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
CREATE TABLE IF NOT EXISTS `subject` (
  `subjectCode` varchar(30) NOT NULL,
  `subjectName` varchar(50) DEFAULT NULL,
  `credits` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`subjectCode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subjectCode`, `subjectName`, `credits`) VALUES
('Ict1113', 'JAVA', '3.00'),
('ICT1143', 'HTML', '3.00'),
('ICT1153', 'PHP', '3.00');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `userName` char(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `role` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=91 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userid`, `userName`, `password`, `email`, `role`) VALUES
(86, 'admin', 'admin123', 'admin@gmail.com', 'administrator'),
(81, 'Kavindya', '5d93ceb70e2bf5daa84ec3d0cd2c731a', 'kavin321@gmail.com', 'Student'),
(90, 'Buddhi', '63a9f0ea7bb98050796b649e85481845', 'buddhi1233@gmail.com', 'Student');
--
-- Database: `hos`
--
CREATE DATABASE IF NOT EXISTS `hos` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `hos`;
--
-- Database: `hospital_dbms`
--
CREATE DATABASE IF NOT EXISTS `hospital_dbms` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `hospital_dbms`;

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
CREATE TABLE IF NOT EXISTS `bill` (
  `Bill_ID` varchar(6) NOT NULL,
  `Doctor_Charges` decimal(6,2) DEFAULT NULL,
  `Treatment_Charges` decimal(6,2) DEFAULT NULL,
  `Medicine_Charges` decimal(6,2) DEFAULT NULL,
  `BDate` date DEFAULT NULL,
  `Patient_ID` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`Bill_ID`),
  KEY `Patient_ID` (`Patient_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`Bill_ID`, `Doctor_Charges`, `Treatment_Charges`, `Medicine_Charges`, `BDate`, `Patient_ID`) VALUES
('BL0001', '1500.00', '1400.00', '1500.00', '2021-12-29', 'PT0001'),
('BL0002', '1000.00', '1000.00', '1100.00', '2022-02-19', 'PT0002'),
('BL0003', '2000.00', '1500.00', '1500.00', '2021-10-06', 'PT0003'),
('BL0004', '3500.00', '2500.00', '1500.00', '2021-12-12', 'PT0004'),
('BL0005', '1500.00', '1450.00', '1500.00', '2022-04-01', 'PT0005'),
('BL0006', '2200.00', '2000.00', '1500.00', '2021-11-22', 'PT0006'),
('BL0007', '3500.00', '2100.00', '1500.00', '2022-06-18', 'PT0007'),
('BL0008', '2000.00', '1900.00', '1500.00', '2021-12-10', 'PT0008'),
('BL0009', '1200.00', '2500.00', '1500.00', '2022-07-23', 'PT0009'),
('BL0010', '1500.00', '1500.00', '1500.00', '2022-09-03', 'PT0010'),
('BL0011', '1700.00', '1600.00', '1500.00', '2022-09-22', 'PT0011'),
('BL0012', '1300.00', '1200.00', '1200.00', '2022-11-12', 'PT0012'),
('BL0013', '2300.00', '1900.00', '1500.00', '2022-10-15', 'PT0013'),
('BL0014', '1500.00', '1400.00', '1400.00', '2022-07-14', 'PT0014'),
('BL0015', '1300.00', '1100.00', '1000.00', '2022-06-11', 'PT0015'),
('BL0016', '4000.00', '2000.00', '2500.00', '2022-12-15', 'PT0016'),
('BL0017', '1600.00', '1500.00', '1500.00', '2022-11-23', 'PT0017'),
('BL0018', '2500.00', '2000.00', '1500.00', '2022-08-28', 'PT0018'),
('BL0019', '1500.00', '1400.00', '1500.00', '2022-02-28', 'PT0019'),
('BL0020', '3500.00', '2000.00', '2000.00', '2022-01-02', 'PT0020');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `Department_ID` varchar(4) NOT NULL,
  `Name` char(30) DEFAULT NULL,
  PRIMARY KEY (`Department_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`Department_ID`, `Name`) VALUES
('DP01', 'Dental'),
('DP02', 'OPD'),
('DP03', 'IPD'),
('DP04', 'Operation Theatre Complex'),
('DP05', 'X-ray'),
('DP06', 'MRD'),
('DP07', 'Medical Department'),
('DP08', 'Nursing Department'),
('DP09', 'Paramedical Department'),
('DP10', 'Personnel Department');

-- --------------------------------------------------------

--
-- Table structure for table `department_lab`
--

DROP TABLE IF EXISTS `department_lab`;
CREATE TABLE IF NOT EXISTS `department_lab` (
  `Department_ID` varchar(4) NOT NULL,
  `Laboratory_ID` varchar(4) NOT NULL,
  PRIMARY KEY (`Department_ID`,`Laboratory_ID`),
  KEY `Laboratory_ID` (`Laboratory_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department_lab`
--

INSERT INTO `department_lab` (`Department_ID`, `Laboratory_ID`) VALUES
('DP01', 'LB08'),
('DP02', 'LB06'),
('DP03', 'LB09'),
('DP04', 'LB07'),
('DP05', 'LB04'),
('DP06', 'LB05'),
('DP07', 'LB03'),
('DP08', 'LB02'),
('DP09', 'LB01'),
('DP10', 'LB10');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE IF NOT EXISTS `doctor` (
  `Doctor_ID` varchar(5) NOT NULL,
  `Staff_ID` varchar(5) DEFAULT NULL,
  `DType` char(20) DEFAULT NULL,
  PRIMARY KEY (`Doctor_ID`),
  KEY `Staff_ID` (`Staff_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`Doctor_ID`, `Staff_ID`, `DType`) VALUES
('DC001', 'ST001', 'Cardiologists Doctor'),
('DC002', 'ST002', 'General Practitioner'),
('DC003', 'ST003', 'Dentist'),
('DC004', 'ST004', 'Endocrinology'),
('DC005', 'ST005', 'Neuro Surgen'),
('DC006', 'ST006', 'Psychiatrist'),
('DC007', 'ST007', 'Ophthalmologist'),
('DC008', 'ST008', 'Oncologist'),
('DC009', 'ST009', 'Obstetricians'),
('DC010', 'ST010', 'Dermatologists');

-- --------------------------------------------------------

--
-- Table structure for table `doctor_treat`
--

DROP TABLE IF EXISTS `doctor_treat`;
CREATE TABLE IF NOT EXISTS `doctor_treat` (
  `Doctor_ID` varchar(5) NOT NULL,
  `Patient_ID` varchar(6) NOT NULL,
  `Treatment_Name` varchar(30) DEFAULT NULL,
  `D_Date` date DEFAULT NULL,
  `D_Time` time DEFAULT NULL,
  `Test_Result` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Doctor_ID`,`Patient_ID`),
  KEY `Patient_ID` (`Patient_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor_treat`
--

INSERT INTO `doctor_treat` (`Doctor_ID`, `Patient_ID`, `Treatment_Name`, `D_Date`, `D_Time`, `Test_Result`) VALUES
('DC001', 'PT0001', 'Bypass surgery', '2021-12-29', '02:15:02', 'Normal'),
('DC004', 'PT0002', 'Endoscopy test', '2022-02-19', '14:15:23', 'Continue treatments'),
('DC001', 'PT0003', 'Bone marrow transplant', '2021-10-06', '23:00:00', 'Normal'),
('DC007', 'PT0004', 'Cataract removal surgery', '2021-12-12', '03:00:14', 'Normal'),
('DC005', 'PT0005', 'Neuro therapy', '2022-04-01', '02:00:23', 'Continue treatments'),
('DC007', 'PT0006', 'Eye transplant', '2021-11-22', '15:15:23', 'Normal'),
('DC008', 'PT0007', 'Cancer treatments & surgery', '2022-06-18', '11:00:22', 'Continue treatments'),
('DC001', 'PT0008', 'Cardiovascular test', '2021-12-10', '17:04:12', 'Normal'),
('DC002', 'PT0009', 'Delevery', '2022-07-23', '09:15:54', 'Normal'),
('DC010', 'PT0010', 'Allergy Treatments', '2022-09-03', '20:30:41', 'Normal'),
('DC002', 'PT0011', 'Medical instructions', '2022-09-22', '10:00:00', 'Normal'),
('DC002', 'PT0012', 'Medical instructions', '2022-11-12', '10:30:12', 'Normal'),
('DC002', 'PT0013', 'Medical instructions', '2022-10-15', '09:15:23', 'Normal'),
('DC002', 'PT0014', 'Stitching', '2022-07-14', '09:00:23', 'Normal'),
('DC002', 'PT0015', 'Blood test', '2022-06-11', '09:00:00', 'Admitted'),
('DC003', 'PT0016', 'Tooth filling', '2022-12-15', '11:00:10', 'Normal'),
('DC007', 'PT0017', 'Eye checkup', '2022-11-23', '09:30:56', 'Normal'),
('DC002', 'PT0018', 'Medical instructions', '2022-08-28', '09:00:00', 'Normal'),
('DC002', 'PT0019', 'Medical instructions', '2022-02-28', '10:30:33', 'Normal'),
('DC003', 'PT0020', 'Cavity checkup', '2022-01-02', '09:45:54', 'Normal');

-- --------------------------------------------------------

--
-- Table structure for table `family`
--

DROP TABLE IF EXISTS `family`;
CREATE TABLE IF NOT EXISTS `family` (
  `Staff_ID` varchar(5) NOT NULL,
  `Name` char(30) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Staff_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `gives`
--

DROP TABLE IF EXISTS `gives`;
CREATE TABLE IF NOT EXISTS `gives` (
  `Patient_ID` varchar(6) NOT NULL,
  `Medicine_ID` varchar(5) NOT NULL,
  `G_Date` date DEFAULT NULL,
  `G_Time` time DEFAULT NULL,
  PRIMARY KEY (`Patient_ID`,`Medicine_ID`),
  KEY `Medicine_ID` (`Medicine_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gives`
--

INSERT INTO `gives` (`Patient_ID`, `Medicine_ID`, `G_Date`, `G_Time`) VALUES
('PT0001', 'MD001', '2022-01-15', '13:15:10'),
('PT0002', 'MD002', '2022-03-25', '16:30:00'),
('PT0003', 'MD003', '2021-12-10', '10:10:30'),
('PT0004', 'MD004', '2022-01-27', '13:15:13'),
('PT0005', 'MD005', '2022-05-05', '12:45:40'),
('PT0006', 'MD006', '2021-11-25', '17:45:10'),
('PT0007', 'MD007', '2022-06-25', '14:05:25'),
('PT0008', 'MD008', '2022-01-01', '17:15:10'),
('PT0009', 'MD009', '2022-07-29', '11:15:40'),
('PT0010', 'MD010', '2022-10-01', '12:40:00'),
('PT0011', 'MD011', '2022-09-22', '12:20:10'),
('PT0012', 'MD012', '2022-11-12', '14:50:00'),
('PT0013', 'MD013', '2022-10-15', '10:15:40'),
('PT0014', 'MD014', '2022-07-14', '13:25:13'),
('PT0015', 'MD015', '2022-06-11', '12:10:40'),
('PT0016', 'MD016', '2022-12-15', '13:15:10'),
('PT0017', 'MD017', '2022-11-23', '14:45:25'),
('PT0018', 'MD018', '2022-08-28', '18:12:40'),
('PT0019', 'MD019', '2022-02-28', '13:17:50'),
('PT0020', 'MD020', '2022-01-02', '18:28:14');

-- --------------------------------------------------------

--
-- Table structure for table `inpatient`
--

DROP TABLE IF EXISTS `inpatient`;
CREATE TABLE IF NOT EXISTS `inpatient` (
  `Record_ID` varchar(5) NOT NULL,
  `Admit_Date` date DEFAULT NULL,
  `Discharge_Date` date DEFAULT NULL,
  PRIMARY KEY (`Record_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inpatient`
--

INSERT INTO `inpatient` (`Record_ID`, `Admit_Date`, `Discharge_Date`) VALUES
('RC001', '2021-12-29', '2022-01-15'),
('RC002', '2022-02-19', '2022-03-25'),
('RC003', '2021-10-06', '2021-12-10'),
('RC004', '2021-12-12', '2022-01-27'),
('RC005', '2022-04-01', '2022-05-05'),
('RC006', '2021-11-22', '2021-11-25'),
('RC007', '2022-06-18', '2022-06-25'),
('RC008', '2021-12-10', '2022-01-01'),
('RC009', '2022-07-23', '2022-07-29'),
('RC010', '2022-09-03', '2022-10-01');

-- --------------------------------------------------------

--
-- Table structure for table `laboratory`
--

DROP TABLE IF EXISTS `laboratory`;
CREATE TABLE IF NOT EXISTS `laboratory` (
  `Laboratory_ID` varchar(4) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Laboratory_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `laboratory`
--

INSERT INTO `laboratory` (`Laboratory_ID`, `Name`) VALUES
('LB01', 'LAB 01'),
('LB02', 'LAB 02'),
('LB03', 'LAB 03'),
('LB04', 'LAB 04'),
('LB05', 'LAB 05'),
('LB06', 'LAB 06'),
('LB07', 'LAB 07'),
('LB08', 'LAB 08'),
('LB09', 'LAB 09'),
('LB10', 'LAB 10');

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
CREATE TABLE IF NOT EXISTS `medicine` (
  `Medicine_ID` varchar(5) NOT NULL,
  `MeName` varchar(30) DEFAULT NULL,
  `Quantity` int(5) DEFAULT NULL,
  `Pharmacy_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Medicine_ID`),
  KEY `Pharmacy_ID` (`Pharmacy_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`Medicine_ID`, `MeName`, `Quantity`, `Pharmacy_ID`) VALUES
('MD001', 'Hydrocodone', 1500, 'PH001'),
('MD002', 'Metformin', 1450, 'PH001'),
('MD003', 'Losartan', 1850, 'PH002'),
('MD004', 'Antibiotics', 1200, 'PH002'),
('MD005', 'Albuterol', 1100, 'PH003'),
('MD006', 'Antihistamines', 1600, 'PH003'),
('MD007', 'Gabapentin', 1685, 'PH004'),
('MD008', 'Omeprazole', 1950, 'PH004'),
('MD009', 'Levothyroxine', 1220, 'PH005'),
('MD010', 'Atorvastatin', 1650, 'PH005'),
('MD011', 'Avapro', 1250, 'PH006'),
('MD012', 'Arranon', 1650, 'PH006'),
('MD013', 'Mebaral', 1899, 'PH007'),
('MD014', 'Nadolol', 1650, 'PH007'),
('MD015', 'Saxagliptin', 1256, 'PH008'),
('MD016', 'Welchol', 2025, 'PH008'),
('MD017', 'Halcion', 2500, 'PH009'),
('MD018', 'Jantoven', 2450, 'PH009'),
('MD019', 'Megace', 1630, 'PH010'),
('MD020', 'Samsca', 1956, 'PH010'),
('MD021', 'Famvir', 2458, 'PH010'),
('MD022', 'Selsun', 2369, 'PH002');

-- --------------------------------------------------------

--
-- Table structure for table `nurse`
--

DROP TABLE IF EXISTS `nurse`;
CREATE TABLE IF NOT EXISTS `nurse` (
  `Nurse_ID` varchar(5) NOT NULL,
  `Staff_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Nurse_ID`),
  KEY `Staff_ID` (`Staff_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nurse`
--

INSERT INTO `nurse` (`Nurse_ID`, `Staff_ID`) VALUES
('NR001', 'ST011'),
('NR002', 'ST012'),
('NR003', 'ST013'),
('NR004', 'ST014'),
('NR005', 'ST015'),
('NR006', 'ST016'),
('NR007', 'ST017'),
('NR008', 'ST018'),
('NR009', 'ST019'),
('NR010', 'ST020');

-- --------------------------------------------------------

--
-- Table structure for table `nurse_assign`
--

DROP TABLE IF EXISTS `nurse_assign`;
CREATE TABLE IF NOT EXISTS `nurse_assign` (
  `Nurse_ID` varchar(6) NOT NULL,
  `Room_ID` varchar(6) NOT NULL,
  `NADate` date DEFAULT NULL,
  `NATime` time DEFAULT NULL,
  PRIMARY KEY (`Nurse_ID`,`Room_ID`),
  KEY `Room_ID` (`Room_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nurse_assign`
--

INSERT INTO `nurse_assign` (`Nurse_ID`, `Room_ID`, `NADate`, `NATime`) VALUES
('NR0001', 'RM0001', '2022-10-02', '16:20:00'),
('NR0002', 'RM0002', '2022-11-11', '03:30:10'),
('NR0003', 'RM0003', '2022-08-13', '10:00:00'),
('NR0004', 'RM0004', '2022-10-14', '05:30:15'),
('NR0005', 'RM0005', '2022-01-15', '09:20:40'),
('NR0006', 'RM0006', '2022-12-16', '06:00:00'),
('NR0007', 'RM0007', '2022-10-21', '02:40:10'),
('NR0008', 'RM0008', '2022-08-24', '09:10:00'),
('NR0009', 'RM0009', '2022-07-29', '15:10:30'),
('NR0010', 'RM0010', '2022-06-30', '12:15:00');

-- --------------------------------------------------------

--
-- Table structure for table `outpatient`
--

DROP TABLE IF EXISTS `outpatient`;
CREATE TABLE IF NOT EXISTS `outpatient` (
  `Record_ID` varchar(5) NOT NULL,
  `ODate` date DEFAULT NULL,
  PRIMARY KEY (`Record_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `outpatient`
--

INSERT INTO `outpatient` (`Record_ID`, `ODate`) VALUES
('RC011', '2022-09-22'),
('RC012', '2022-11-12'),
('RC013', '2022-10-15'),
('RC014', '2022-07-14'),
('RC015', '2022-06-11'),
('RC016', '2022-12-15'),
('RC017', '2022-11-23'),
('RC018', '2022-08-28'),
('RC019', '2022-02-28'),
('RC020', '2022-01-02');

-- --------------------------------------------------------

--
-- Table structure for table `paid_by`
--

DROP TABLE IF EXISTS `paid_by`;
CREATE TABLE IF NOT EXISTS `paid_by` (
  `Bill_ID` varchar(6) NOT NULL,
  `Method_ID` varchar(6) NOT NULL,
  `PdDate` date DEFAULT NULL,
  `PdTime` time DEFAULT NULL,
  PRIMARY KEY (`Bill_ID`,`Method_ID`),
  KEY `Method_ID` (`Method_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paid_by`
--

INSERT INTO `paid_by` (`Bill_ID`, `Method_ID`, `PdDate`, `PdTime`) VALUES
('BL0001', 'PM0001', '2022-01-15', '08:05:00'),
('BL0002', 'PM0004', '2022-03-25', '09:25:50'),
('BL0003', 'PM0006', '2021-12-10', '13:10:10'),
('BL0004', 'PM0001', '2022-01-27', '09:36:20'),
('BL0005', 'PM0002', '2022-05-05', '10:51:30'),
('BL0006', 'PM0005', '2021-11-25', '10:20:37'),
('BL0007', 'PM0005', '2022-06-25', '09:13:45'),
('BL0008', 'PM0002', '2022-01-01', '11:26:54'),
('BL0009', 'PM0003', '2022-07-29', '08:45:32'),
('BL0010', 'PM0003', '2022-10-01', '09:00:13'),
('BL0011', 'PM0001', '2022-09-22', '13:56:59'),
('BL0012', 'PM0001', '2022-11-12', '12:34:16'),
('BL0013', 'PM0003', '2022-10-15', '10:22:23'),
('BL0014', 'PM0004', '2022-07-14', '09:48:42'),
('BL0015', 'PM0003', '2022-06-11', '08:25:31'),
('BL0016', 'PM0001', '2022-12-15', '11:59:23'),
('BL0017', 'PM0001', '2022-11-23', '09:12:52'),
('BL0018', 'PM0005', '2022-08-28', '10:35:28'),
('BL0019', 'PM0005', '2022-02-28', '08:46:24'),
('BL0020', 'PM0001', '2022-01-02', '09:14:02');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `Patient_ID` varchar(6) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `State` varchar(4) DEFAULT NULL,
  `Address` varchar(40) DEFAULT NULL,
  `Gender` varchar(8) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Room_ID` varchar(5) DEFAULT NULL,
  `Department_ID` varchar(4) DEFAULT NULL,
  `Doctor_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Patient_ID`),
  KEY `Room_ID` (`Room_ID`),
  KEY `Department_ID` (`Department_ID`),
  KEY `Doctor_ID` (`Doctor_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`Patient_ID`, `Name`, `State`, `Address`, `Gender`, `DOB`, `Room_ID`, `Department_ID`, `Doctor_ID`) VALUES
('PT0001', 'Buddhi Thisara', 'Lv01', 'No.A/38,Thettativu,Batticaloa', 'Male', '2000-03-06', 'RM001', 'DP01', 'DC003'),
('PT0002', 'Lahiru Prasad', 'Lv04', 'No.B/23,Talakiriyagama,Matara', 'Male', '1998-01-30', 'RM002', 'DP03', 'DC006'),
('PT0003', 'Kalini Manoli', 'Lv03', 'No.C/20,Cheddipalayam,Galle', 'Female', '2005-12-31', 'RM003', 'DP04', 'DC005'),
('PT0004', 'Gamini Weragoda', 'Lv01', 'Gelioya,Matara', 'Male', '1977-09-22', 'RM004', 'DP04', 'DC009'),
('PT0005', 'Chanaka Priyanjith', 'Lv02', 'No.B/347,Onegama,Galle', 'Male', '1996-08-13', 'RM005', 'DP03', 'DC002'),
('PT0006', 'Imasha Udawaththa', 'Lv03', 'Padavi Sritissapura,Galle', 'Female', '2002-10-21', 'RM006', 'DP01', 'DC003'),
('PT0007', 'Nandani Silawathi', 'Lv01', 'No.B/32,Ampilanthurai School Rd,Matara', 'Female', '1950-01-02', 'RM007', 'DP03', 'DC010'),
('PT0008', 'Kapuge Namal', 'Lv04', 'No.B/19,Sungavila,Matara', 'Male', '1945-12-29', 'RM008', 'DP03', 'DC007'),
('PT0009', 'Sunila Rajapaksha ', 'Lv03', 'Lindula,Galle', 'Female', '1993-02-05', 'RM009', 'DP01', 'DC003'),
('PT0010', 'Malsha Bandara', 'Lv02', 'No.A32,Maeliya,Galle', 'Male', '1995-12-11', 'RM010', 'DP04', 'DC005'),
('PT0011', 'Dananjaya Banda', 'Lv04', 'No.F30,Cheddipalayam,Galle', 'Male', '1988-10-20', NULL, 'DP02', 'DC010'),
('PT0012', 'Achala Bandara', 'Lv03', 'No.D/35,Mankemi,Galle', 'Female', '1998-03-12', NULL, 'DP02', 'DC002'),
('PT0013', 'Jock Jani', 'Lv04', 'Boraluwewa,Galle', 'Female', '2010-05-15', NULL, 'DP02', 'DC004'),
('PT0014', 'Maleesha Abisheeka', 'Lv04', 'No.B32,Udispattuwa,Galle', 'Male', '2004-07-22', NULL, 'DP02', 'DC008'),
('PT0015', 'Nimesh Silva ', 'Lv04', 'Pallepola,Galle', 'Male', '2001-02-20', NULL, 'DP02', 'DC007'),
('PT0016', 'Isuri Nimali', 'Lv02', 'No.B27,Mahawela,Matara', 'Female', '2004-12-01', NULL, 'DP01', 'DC003'),
('PT0017', 'Kaveesha Nawo', 'Lv03', 'No.B29,Madulkele,Galle', 'Female', '1995-09-24', NULL, 'DP02', 'DC001'),
('PT0018', 'Raveesha Lover', 'Lv01', 'Padavi Sripura,Galle', 'Female', '1990-06-15', NULL, 'DP02', 'DC002'),
('PT0019', 'Seelawathi ', 'Lv02', 'B16,Madulkele,Galle', 'Female', '1941-02-01', NULL, 'DP02', 'DC002'),
('PT0020', 'Sethan Appu', 'Lv04', 'No.22,Maharachchimulla,Matara', 'Male', '1935-12-12', NULL, 'DP01', 'DC003');

-- --------------------------------------------------------

--
-- Table structure for table `patient_contact`
--

DROP TABLE IF EXISTS `patient_contact`;
CREATE TABLE IF NOT EXISTS `patient_contact` (
  `Patient_ID` varchar(6) NOT NULL,
  `Contact` varchar(11) NOT NULL,
  PRIMARY KEY (`Patient_ID`,`Contact`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient_contact`
--

INSERT INTO `patient_contact` (`Patient_ID`, `Contact`) VALUES
('PT0001', '077-9797676'),
('PT0001', '081-9797234'),
('PT0002', '011-2343256'),
('PT0002', '075-2348248'),
('PT0003', '033-1245679'),
('PT0003', '078-2572264'),
('PT0004', '025-6446667'),
('PT0004', '075-2434783'),
('PT0005', '066-4366675'),
('PT0005', '075-2343252'),
('PT0006', '054-0879799'),
('PT0006', '076-2329380'),
('PT0007', '076-2434434'),
('PT0007', '088-1231413'),
('PT0008', '078-2338091'),
('PT0008', '099-5647467'),
('PT0009', '021-5656546'),
('PT0009', '077-2791000'),
('PT0010', '034-5645645'),
('PT0010', '076-2323826');

-- --------------------------------------------------------

--
-- Table structure for table `payment_method`
--

DROP TABLE IF EXISTS `payment_method`;
CREATE TABLE IF NOT EXISTS `payment_method` (
  `Method_ID` varchar(6) NOT NULL,
  `PMType` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Method_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment_method`
--

INSERT INTO `payment_method` (`Method_ID`, `PMType`) VALUES
('PM0001', 'Cash'),
('PM0002', 'Checks'),
('PM0003', 'Debit Cards'),
('PM0004', 'Credit Cards'),
('PM0005', 'Mobile Payments'),
('PM0006', 'E Bank Transfers');

-- --------------------------------------------------------

--
-- Table structure for table `pharmacy`
--

DROP TABLE IF EXISTS `pharmacy`;
CREATE TABLE IF NOT EXISTS `pharmacy` (
  `Pharmacy_ID` varchar(5) NOT NULL,
  `PhName` char(20) DEFAULT NULL,
  `Location` varchar(30) DEFAULT NULL,
  `Contact_No` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`Pharmacy_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
CREATE TABLE IF NOT EXISTS `record` (
  `Record_ID` varchar(5) NOT NULL,
  `Patient_ID` varchar(6) DEFAULT NULL,
  `Weight` varchar(6) DEFAULT NULL,
  `Blood_Group` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`Record_ID`),
  KEY `Patient_ID` (`Patient_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `record`
--

INSERT INTO `record` (`Record_ID`, `Patient_ID`, `Weight`, `Blood_Group`) VALUES
('RC001', 'PT0001', '65', 'A+'),
('RC002', 'PT0002', '70', 'B+'),
('RC003', 'PT0003', '55', 'O+'),
('RC004', 'PT0004', '60', 'AB+'),
('RC005', 'PT0005', '63', 'AB-'),
('RC006', 'PT0006', '59', 'O-'),
('RC007', 'PT0007', '68', 'A-'),
('RC008', 'PT0008', '72', 'B-'),
('RC009', 'PT0009', '77', 'A+'),
('RC010', 'PT0010', '51', 'B+'),
('RC011', 'PT0011', '41', 'B+'),
('RC012', 'PT0012', '75', 'A-'),
('RC013', 'PT0013', '49', 'AB+'),
('RC014', 'PT0014', '66', 'A+'),
('RC015', 'PT0015', '79', 'O-'),
('RC016', 'PT0016', '63', 'AB-'),
('RC017', 'PT0017', '54', 'A-'),
('RC018', 'PT0018', '76', 'O+'),
('RC019', 'PT0019', '74', 'B+'),
('RC020', 'PT0020', '71', 'AB-');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE IF NOT EXISTS `room` (
  `Room_ID` varchar(5) NOT NULL,
  `RType` varchar(20) DEFAULT NULL,
  `Department_ID` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`Room_ID`),
  KEY `Department_ID` (`Department_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`Room_ID`, `RType`, `Department_ID`) VALUES
('RM001', 'VIP_R_01', 'DP01'),
('RM002', 'VIP_R_02', 'DP03'),
('RM003', 'VIP_R_03', 'DP04'),
('RM004', 'Only_Private_R_01', 'DP04'),
('RM005', 'Only_Private_R_02', 'DP03'),
('RM006', 'Only_Private_R_03', 'DP01'),
('RM007', 'Semi_Private_R_01', 'DP03'),
('RM008', 'Semi_Private_R_02', 'DP03'),
('RM009', 'Semi_Private_R_03', 'DP01'),
('RM010', 'Semi_Private_R_04', 'DP04');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE IF NOT EXISTS `staff` (
  `Staff_ID` varchar(5) NOT NULL,
  `Name` char(30) DEFAULT NULL,
  `Salary` decimal(10,2) DEFAULT NULL,
  `Department_ID` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`Staff_ID`),
  KEY `Department_ID` (`Department_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`Staff_ID`, `Name`, `Salary`, `Department_ID`) VALUES
('ST001', 'Dr. Maleesha', '150000.00', 'DP01'),
('ST002', 'Dr. Pathum', '200000.00', 'DP02'),
('ST003', 'Dr. Nimesh', '200000.00', 'DP02'),
('ST004', 'Dr. Lahiru', '200000.00', 'DP02'),
('ST005', 'Dr. Shanaka', '250000.00', 'DP04'),
('ST006', 'Dr. Dhananjaya', '250000.00', 'DP04'),
('ST007', 'Dr. Buddhi', '200000.00', 'DP03'),
('ST008', 'Dr. Prageeth', '250000.00', 'DP04'),
('ST009', 'Dr. Kalini', '200000.00', 'DP03'),
('ST010', 'Dr. Chathumina', '250000.00', 'DP04'),
('ST011', 'Y.L. Nirmani', '100000.00', 'DP01'),
('ST012', 'E.G.T. Ranasinghe', '150000.00', 'DP02'),
('ST013', 'P.M.L. Karunarathne', '150000.00', 'DP03'),
('ST014', 'M.M. Manuji', '200000.00', 'DP04'),
('ST015', 'K.L. Anusarani', '120000.00', 'DP05'),
('ST016', 'W.B. Ama', '120000.00', 'DP06'),
('ST017', 'A.K. Gaurawi', '100000.00', 'DP07'),
('ST018', 'B.D. Sanduni', '100000.00', 'DP08'),
('ST019', 'S.M. Piyumali', '120000.00', 'DP09'),
('ST020', 'G.N. Asini', '120000.00', 'DP10'),
('ST021', 'W.A. Vishan', '50000.00', 'DP01'),
('ST022', 'D.A. Janaka', '50000.00', 'DP01'),
('ST023', 'V.L. Lakshan', '60000.00', 'DP02'),
('ST024', 'E.M. Praveen', '60000.00', 'DP02'),
('ST025', 'G.W. Madhusha', '60000.00', 'DP03'),
('ST026', 'K.A. Kalana', '80000.00', 'DP04'),
('ST027', 'N.W. Sampath', '70000.00', 'DP05'),
('ST028', 'W.V. Vimukthi', '65000.00', 'DP07'),
('ST029', 'L.K. Rangana', '65000.00', 'DP09'),
('ST030', 'B.M. Kaveen', '60000.00', 'DP10');

-- --------------------------------------------------------

--
-- Table structure for table `ward_boy`
--

DROP TABLE IF EXISTS `ward_boy`;
CREATE TABLE IF NOT EXISTS `ward_boy` (
  `Ward_boy_ID` varchar(5) NOT NULL,
  `Staff_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Ward_boy_ID`),
  KEY `Staff_ID` (`Staff_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ward_boy`
--

INSERT INTO `ward_boy` (`Ward_boy_ID`, `Staff_ID`) VALUES
('WB001', 'ST021'),
('WB002', 'ST022'),
('WB003', 'ST023'),
('WB004', 'ST024'),
('WB005', 'ST025'),
('WB006', 'ST026'),
('WB007', 'ST027'),
('WB008', 'ST028'),
('WB009', 'ST029'),
('WB010', 'ST030');

-- --------------------------------------------------------

--
-- Table structure for table `ward_boy_assign`
--

DROP TABLE IF EXISTS `ward_boy_assign`;
CREATE TABLE IF NOT EXISTS `ward_boy_assign` (
  `Ward_boy_ID` varchar(6) NOT NULL,
  `Room_ID` varchar(6) NOT NULL,
  `WADate` date DEFAULT NULL,
  `WATime` time DEFAULT NULL,
  PRIMARY KEY (`Ward_boy_ID`,`Room_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ward_boy_assign`
--

INSERT INTO `ward_boy_assign` (`Ward_boy_ID`, `Room_ID`, `WADate`, `WATime`) VALUES
('WB001', 'RM001', '2022-10-10', '08:20:00'),
('WB002', 'RM002', '2022-10-11', '08:20:00'),
('WB003', 'RM003', '2022-10-13', '08:00:00'),
('WB004', 'RM004', '2022-10-14', '08:30:00'),
('WB005', 'RM005', '2022-10-15', '08:20:40'),
('WB006', 'RM006', '2022-10-16', '06:00:00'),
('WB007', 'RM007', '2022-10-22', '08:00:00'),
('WB008', 'RM008', '2022-10-24', '09:10:00'),
('WB009', 'RM009', '2022-10-29', '08:10:15'),
('WB010', 'RM010', '2022-10-21', '12:15:00');
--
-- Database: `labsheet11`
--
CREATE DATABASE IF NOT EXISTS `labsheet11` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `labsheet11`;

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `book_id` int(11) DEFAULT NULL,
  `book_name` varchar(30) DEFAULT NULL,
  `price` decimal(5,2) DEFAULT NULL,
  `seller_id` varchar(5) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE IF NOT EXISTS `shopping_cart` (
  `buyer_id` int(11) NOT NULL,
  `iterm_code` varchar(5) DEFAULT NULL,
  `seller` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`buyer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `username`, `password`, `role`) VALUES
(18, 'peter', '6816401496ea63ee866ce5811cde9f8c', 'seller'),
(19, 'paul', '8ca7208674ee1f11c7bbcbe3c5f0d139', 'buyer'),
(20, 'jane', '3a18aacd193d5be8f39a443d5d0eb220', 'buyer'),
(21, 'Lahiru', '31664b021282670ef992f5efd5017bf1', 'seller'),
(22, 'Mlaeeshi', '63af6b5d3adda192f432f105bbe55029', 'seller'),
(23, 'fuck', '99754106633f94d350db34d548d6091a', 'seller'),
(24, 'kk', 'dc468c70fb574ebd07287b38d0d0676d', 'buyer'),
(25, 'peter', '6816401496ea63ee866ce5811cde9f8c', 'seller'),
(26, 'paul', '8ca7208674ee1f11c7bbcbe3c5f0d139', 'buyer'),
(27, 'jane', '3a18aacd193d5be8f39a443d5d0eb220', 'buyer');
--
-- Database: `library`
--
CREATE DATABASE IF NOT EXISTS `library` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `library`;
--
-- Database: `maxtronic`
--
CREATE DATABASE IF NOT EXISTS `maxtronic` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `maxtronic`;

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `itm_code` char(4) NOT NULL,
  `itm_description` varchar(25) NOT NULL,
  `itm_unit_price` decimal(9,2) NOT NULL,
  `itm_imported` tinyint(1) DEFAULT NULL,
  `itm_supplier` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`itm_code`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`itm_code`, `itm_description`, `itm_unit_price`, `itm_imported`, `itm_supplier`) VALUES
('IT10', 'Television', '24500.00', 1, 'Sony'),
('IT11', 'Computer', '60500.00', 1, 'Dell'),
('IT12', 'Laser Printer', '19000.00', 1, 'Hp'),
('IT13', 'VCD Player', '7599.00', 1, ''),
('IT15', 'Polisher', '12000.00', 1, 'National'),
('IT16', 'Scanner', '16000.00', NULL, 'Hp'),
('IT17', 'Refrigerator', '65000.00', 1, 'LG'),
('IT18', 'Table Lamp', '2999.90', 0, 'Abans'),
('IT19', 'Wall Clock', '1200.00', 1, ''),
('IT20', 'Blender', '4800.00', 1, 'National'),
('IT14', 'Oven', '7300.00', 0, 'Abans');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `loc_code` char(4) NOT NULL,
  `loc_name` varchar(25) NOT NULL,
  `loc_contact` char(11) DEFAULT NULL,
  `loc_address` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`loc_code`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`loc_code`, `loc_name`, `loc_contact`, `loc_address`) VALUES
('L01', 'Colombo', '0112946058', 'Colombo 04'),
('L02', 'Kalutara', '', 'Main Street'),
('L03', 'Karapitiya', '0912546893', ''),
('L04', 'Matara', '0415670045', 'Dharmapala Mawatha');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
CREATE TABLE IF NOT EXISTS `sales` (
  `sa_trans_no` int(11) NOT NULL AUTO_INCREMENT,
  `sa_item_code` varchar(10) NOT NULL,
  `sa_loction_code` varchar(10) NOT NULL,
  `sa_sales_qty` int(11) DEFAULT NULL,
  `sa_date_of_sale` date DEFAULT NULL,
  PRIMARY KEY (`sa_trans_no`),
  KEY `sa_item_code` (`sa_item_code`),
  KEY `sa_loction_code` (`sa_loction_code`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`sa_trans_no`, `sa_item_code`, `sa_loction_code`, `sa_sales_qty`, `sa_date_of_sale`) VALUES
(1, 'IT10', 'L01', 3, '2016-05-02'),
(2, 'IT10', 'L03', 1, '2016-05-12'),
(3, 'IT13', 'L04', 15, '2016-04-07'),
(4, 'IT11', 'L01', 12, '2016-04-15'),
(5, 'IT11', 'L02', 5, '2016-07-12');

-- --------------------------------------------------------

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
CREATE TABLE IF NOT EXISTS `store` (
  `st_item_code` char(10) NOT NULL,
  `st_location_code` varchar(10) NOT NULL,
  `st_qty` int(11) NOT NULL,
  `st_date` date DEFAULT NULL,
  KEY `st_item_code` (`st_item_code`),
  KEY `st_location_code` (`st_location_code`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `store`
--

INSERT INTO `store` (`st_item_code`, `st_location_code`, `st_qty`, `st_date`) VALUES
('IT10', 'L01', 30, '2016-04-08'),
('IT10', 'L03', 3, '2016-04-02'),
('IT10', 'L04', 10, '2016-04-25'),
('IT11', 'L01', 25, NULL),
('IT11', 'L02', 12, '2016-05-07'),
('IT13', 'L04', 60, '2016-05-09'),
('IT16', 'L02', 5, NULL);
--
-- Database: `mytestdb`
--
CREATE DATABASE IF NOT EXISTS `mytestdb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `mytestdb`;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `ID` int(11) NOT NULL,
  `fist_Name` varchar(45) NOT NULL,
  `last_Name` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`ID`, `fist_Name`, `last_Name`, `city`, `age`) VALUES
(11, 'Kasun', 'Sameera', 'Matara', 18),
(12, 'Sanduni', 'Chandima', 'Tangalle', 23),
(13, 'Samudi', 'Eshara', 'Kalutara', 25),
(14, 'Supun', 'Liyanagama', 'Colombo', 16),
(15, 'Bhagya', 'Lakmini', 'Galle', 22),
(16, 'Nuwan', 'Pradeep', 'Kandy', 20);

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
CREATE TABLE IF NOT EXISTS `subject` (
  `subject_ID` int(11) NOT NULL,
  `subject_Name` varchar(45) NOT NULL,
  PRIMARY KEY (`subject_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subject_ID`, `subject_Name`) VALUES
(111, 'Mathematics'),
(222, 'Science'),
(333, 'Java'),
(444, 'Database Management Systems'),
(555, 'Cloud Computing'),
(666, 'History');
--
-- Database: `practical_04_part02`
--
CREATE DATABASE IF NOT EXISTS `practical_04_part02` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `practical_04_part02`;

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE IF NOT EXISTS `employees` (
  `EMPLOYEE_ID` decimal(6,0) NOT NULL,
  `FIRST_NAME` varchar(20) DEFAULT NULL,
  `LAST_NAME` varchar(25) DEFAULT NULL,
  `EMAIL` varchar(25) DEFAULT NULL,
  `PHONE_NUMBER` varchar(20) NOT NULL,
  `HIRE_DATE` date DEFAULT NULL,
  `JOB_ID` varchar(10) NOT NULL,
  `SALARY` decimal(8,2) DEFAULT NULL,
  `COMMISSION_PACT` decimal(2,2) DEFAULT NULL,
  `MANAGER_ID` decimal(6,0) DEFAULT NULL,
  `DEPARMENT_ID` decimal(6,0) DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`),
  KEY `JOB_ID` (`JOB_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`EMPLOYEE_ID`, `FIRST_NAME`, `LAST_NAME`, `EMAIL`, `PHONE_NUMBER`, `HIRE_DATE`, `JOB_ID`, `SALARY`, `COMMISSION_PACT`, `MANAGER_ID`, `DEPARMENT_ID`) VALUES
('100', 'Steven', 'King', 'SKING', '515.123.4567', '1987-06-17', 'AD_PRES', '24000.00', '0.00', '0', '90'),
('101', 'Neena', 'Kochhar', 'NKOCHHAR', '515.123.4568', '1987-06-18', 'AD_VP', '17000.00', '0.00', '100', '90'),
('102', 'Lex', 'De Haan', 'LDEHAAN', '515.123.4569', '1987-06-19', 'AD_VP', '17000.00', '0.00', '100', '90'),
('103', 'Alexander', 'Hunold', 'AHUNOLD', '590.423.4567', '1987-06-20', 'IT_PROG', '9000.00', '0.00', '102', '60'),
('104', 'Bruce', 'Ernst', 'BERNST', '590.423.4568', '1987-06-21', 'IT_PROG', '6000.00', '0.00', '103', '60'),
('105', 'David', 'Austin', 'DAUSTIN', '590.423.4569', '1987-06-22', 'IT_PROG', '4800.00', '0.00', '103', '60'),
('106', 'Valli', 'Pataballa', 'VPATABAL', '590.423.4560', '1987-06-23', 'IT_PROG', '4800.00', '0.00', '103', '60');

-- --------------------------------------------------------

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
CREATE TABLE IF NOT EXISTS `jobs` (
  `JOB_ID` varchar(25) NOT NULL,
  `JOB_TITLE` varchar(35) NOT NULL,
  `MIN_SALARY` decimal(6,0) DEFAULT '8000',
  `MAX_SALARY` decimal(6,0) DEFAULT NULL,
  PRIMARY KEY (`JOB_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jobs`
--

INSERT INTO `jobs` (`JOB_ID`, `JOB_TITLE`, `MIN_SALARY`, `MAX_SALARY`) VALUES
('AD_PRES', 'Doctor', '110000', '150000'),
('AD_VP', 'Teacher', '60000', '80000'),
('IT_PROG', 'SOF-Engeer', '60000', '80000');
--
-- Database: `shop_db`
--
CREATE DATABASE IF NOT EXISTS `shop_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `shop_db`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `uname` varchar(100) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `name`, `DOB`, `province`, `uname`, `password`) VALUES
(1, 'admin', '2000-01-01', 'central', 'admin@admin.lk', 'admin@22'),
(2, 'Nimesh Rangana', '2000-11-02', 'Central', 'central@admin.lk', 'central@22'),
(3, 'Maleesha Herath', '2000-02-06', 'Western', 'western@admin.lk', 'western@22'),
(4, 'Pathum Vimukthi', '2000-04-01', 'Sabaragamuwa', 'sabaragamuwa@admin.lk', 'sabara@22'),
(5, 'Lahiru Prasad', '2000-03-21', 'North Central', 'northcentral@admin.lk', 'ncentral@22'),
(6, 'Prageeth Siriwardana', '2000-08-13', 'Eastern', 'Eastern@admin.lk', 'Eastern@22'),
(7, 'Dhanajaya Rupasinghe(Dana)', '2000-06-15', 'Uva', 'uva@admin.lk', 'uva@2022'),
(8, 'Buddhi Sampath', '1999-10-02', 'Northern', 'Northern@admin.lk', 'northern@22'),
(9, 'Kalini Jithma', '2000-10-10', 'Southern', 'southern@admin.lk', 'southern@22'),
(10, 'Shanaka Priyanjith', '2000-09-25', 'North Western', 'northwestern@admin.lk', 'nwestern@22');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `quantity` int(255) NOT NULL,
  `price` int(4) DEFAULT NULL,
  `cus_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=139 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`id`, `name`, `image`, `quantity`, `price`, `cus_id`) VALUES
(136, 'HP 255 G8 15 Inch FHD Ryzen 5 5500U Laptop', 'HP 255 G8 15 Inch FHD Ryzen 5 5500U Laptop Rs 245000.00.png', 1, 245000, 5),
(137, 'Krest Chicken Meat Balls 500g', 'Krest Chicken Meat Balls 500g Rs 935.00.png', 1, 935, NULL),
(138, 'Gaming Mouse Pad Desk Mat Mouse pad', 'Gaming Mouse Pad Desk Mat Mouse pad Rs 1100.00.png', 1, 1100, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`cat_id`, `cat_name`, `image`) VALUES
(1, 'Foods', 'food.png'),
(2, 'Computer Office', 'computer-office.png'),
(3, 'Home Garden', 'home-garden.png'),
(4, 'Home Applicanes', 'home-applicanes.png'),
(5, 'Home Improvement', 'home-improvement.png'),
(6, 'Mother Kids', 'mother-kids.png'),
(7, 'Shoes', 'shoes.png'),
(8, 'Tools', 'tools.png'),
(9, 'Toys Hobbies', 'toys-obbies.png');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `cus_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  `uname` varchar(150) DEFAULT NULL,
  `postal_code` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cus_id`, `name`, `dob`, `address`, `contact`, `uname`, `postal_code`, `password`) VALUES
(1, 'Maleesha Herath', '2022-11-09', 'Herath Villa', '0778236207', 'malisha27t@gmail.com', '71034', '123456789'),
(2, 'Nimesha Rangana', '2022-10-07', '72/3 Hospital road , Diyasunnatha', '+94778236207', 'nimesh@gmail.com', '25645', '123456789'),
(3, 'Lahiru', '2022-11-09', 'Kandy', '084598752', 'pathum@gmail.com', '25987', '123456789'),
(4, 'Prageeth', '2022-11-08', 'Alpitiya', '077968733', 'prageeth@gmail.com', '71034', '123456789'),
(5, 'Kalini', '2022-11-16', 'Matara', '0778236207', 'Kalini@gmail.com', '71034', '123456789'),
(8, 'Hasitha', '2022-11-23', 'matara', '078925662', 'Hasitha@gmail.com', '987456', '987654321'),
(9, 'kalini', '2022-11-23', 'mtara', '0415556852', 'jithma@gmail.com', '2000', 'kalini2000');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `number` int(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `method` varchar(255) NOT NULL,
  `flat` int(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `pin_code` int(255) NOT NULL,
  `total_products` varchar(255) NOT NULL,
  `total_price` int(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `Oder_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Customer_ID` int(11) DEFAULT NULL,
  `Full_name` varchar(100) DEFAULT NULL,
  `E_mail` varchar(100) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `City` varchar(60) DEFAULT NULL,
  `State` varchar(50) DEFAULT NULL,
  `Zip_code` varchar(30) DEFAULT NULL,
  `Card_name` varchar(50) DEFAULT NULL,
  `Card_number` varchar(50) DEFAULT NULL,
  `Expire_month` varchar(50) DEFAULT NULL,
  `Expire_year` varchar(20) DEFAULT NULL,
  `CVV` varchar(20) DEFAULT NULL,
  `Total_price` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Oder_ID`),
  KEY `Customer_ID` (`Customer_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`Oder_ID`, `Customer_ID`, `Full_name`, `E_mail`, `Address`, `City`, `State`, `Zip_code`, `Card_name`, `Card_number`, `Expire_month`, `Expire_year`, `CVV`, `Total_price`) VALUES
(36, 5, 'Maleesha Herath', 'malisha27t@gmail.com', 'Herath Villa', 'Kegalle', 'Sabaragamuwa', '71034', 'Maleesha Herath', '51651', 'uyjhbuhjhb', '20020', '11654', '7000'),
(26, 5, 'Maleesha Herath', 'malisha27t@gmail.com', 'Herath Villa', 'Kegalle', 'Sabaragamuwa', '71034', 'Maleesha Herath', '56465654656', 'fggtbft', '4555', '545', '245000'),
(27, 5, 'Maleesha Herath', 'malisha27t@gmail.com', 'Herath Villa', 'Kegalle', 'Sabaragamuwa', '71034', 'Maleesha Herath', '56465654656', 'fggtbft', '4555', '545', '245000'),
(28, 5, 'Maleesha Herath', 'malisha27t@gmail.com', 'Herath Villa', 'Kegalle', 'Sabaragamuwa', '71034', 'Maleesha Herath', '56465654656', 'fggtbft', '4555', '545', '245000'),
(29, 5, 'Maleesha Herath', 'malisha27t@gmail.com', 'Herath Villa', 'Kegalle', 'Sabaragamuwa', '71034', 'Maleesha Herath', '56465654656', 'fggtbft', '4555', '545', '245000'),
(30, 5, 'Maleesha Herath', 'malisha27t@gmail.com', 'Herath Villa', 'Kegalle', 'Sabaragamuwa', '71034', 'Maleesha Herath', '56465654656', 'fggtbft', '4555', '545', '245000'),
(31, 5, 'Maleesha', 'malishaherath77@gmail.com', '72/3 Hospital road , Diyasunnatha', 'Rambukkana', '435345', '71100', 'zxvxcvzxvz', '32344566565', 'fdvd', '45545', 'cxvv', '245310'),
(32, 5, 'Maleesha', 'malishaherath77@gmail.com', '72/3 Hospital road , Diyasunnatha', 'Rambukkana', '435345', '71100', 'zxvxcvzxvz', '32344566565', 'fdvd', '45545', 'cxvv', '245310'),
(33, 5, 'Maleesha Herath', 'malisha27t@gmail.com', 'Herath Villa', 'Kegalle', 'Sabaragamuwa', '71034', 'Maleesha Herath', '33546545', 'fgbfg', '4565', '67686', '245310'),
(34, 5, 'Maleesha Herath', 'malisha27t@gmail.com', 'Herath Villa', 'Kegalle', 'Sabaragamuwa', '71034', 'Maleesha Herath', '345345345', 'dvdgvr', '455', '5435', '5190'),
(35, 5, 'Maleesha Herath', 'malisha27t@gmail.com', 'Herath Villa', 'Kegalle', 'Sabaragamuwa', '71034', 'Maleesha Herath', '2652565', 'mljjim', '202', '2625', '1100'),
(37, 5, 'Maleesha Herathg5', 'malisha27t@gmail.com', 'Herath Villa', 'Kegalle', 'Sabaragamuwa', '71034', 'ythtdyh5', '5544646', 'hreyrh', '54446', '202', '245000'),
(38, 5, 'Maleesha Herath', 'malisha27t@gmail.com', 'Herath Villa', 'Kegalle', 'Sabaragamuwa', '71034', '', '', '', '', '', '252000');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` decimal(12,2) NOT NULL,
  `image` varchar(255) NOT NULL,
  `cat_id` int(11) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cat_id` (`cat_id`)
) ENGINE=MyISAM AUTO_INCREMENT=82 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `price`, `image`, `cat_id`, `description`, `quantity`, `discount`) VALUES
(27, 'Gaming Mouse Pad Desk Mat Mouse pad', '1100.00', 'Gaming Mouse Pad Desk Mat Mouse pad Rs 1100.00.png', 2, '', 200, 3),
(28, 'HP 255 G8 15 Inch FHD Ryzen 5 5500U Laptop', '245000.00', 'HP 255 G8 15 Inch FHD Ryzen 5 5500U Laptop Rs 245000.00.png', 2, 'AMD Ryzenâ„¢ 5 5500U Processor\r\n15.6\" FHD (1920 x 1080), micro-edge, antiglare, 250 nits, 45% NTSC\r\n8 GB DDR4 3200Mhz SDRAM Memory\r\n1TB HDD Hard Disk\r\nGenuine Windows 10 Home 64 bit\r\nHP Long Life 3-cell, 41 Wh Li-ion', 100, 10),
(29, 'Logitech G102 Light Sync 6 Buttons Wired Gaming Mouse', '7000.00', 'Logitech G102 Light Sync 6 Buttons Wired Gaming Mouse Rs 7000.00.png', 2, 'Height: 116.6 mm\r\nWidth: 62.15 mm\r\nDepth: 38.2 mm\r\nWeight: 85 g, (mouse only)\r\nCable length: 2.1 m\r\nLIGHTSYNC RGB lighting\r\n6 programmable buttons\r\nResolution: 200 â€“ 8,000 dpi\r\nUSB data format: 16 bits/axis\r\nUSB report rate: 1000Hz (1ms)\r\nMicroprocessor: 32-bit ARM', 500, 5),
(30, 'Logitech G102 Light Sync 6 Buttons Wired Gaming Mouse', '7000.00', 'Logitech G102 Light Sync 6 Buttons Wired Gaming Mouse Rs 7000.00.png', 2, 'Height: 116.6 mm\r\nWidth: 62.15 mm\r\nDepth: 38.2 mm\r\nWeight: 85 g, (mouse only)\r\nCable length: 2.1 m\r\nLIGHTSYNC RGB lighting\r\n6 programmable buttons\r\nResolution: 200 â€“ 8,000 dpi\r\nUSB data format: 16 bits/axis\r\nUSB report rate: 1000Hz (1ms)\r\nMicroprocessor: 32-bit ARM', 500, 5),
(31, 'OCH 022 â€“ High Back Chair', '38000.00', 'OCH 022 â€“ High Back Chair Rs 38000.00.png', 2, 'The chair cover can perfect prevent the chair from being scratched or covered with dust.\r\nLively colors decorate your offices or houses, highlighting your unique taste.\r\nAfter each cleaning, the waterproof effect will be reduced by 10%\r\nApplicable Chair Type: Electric Competition Chair, executive chairs\r\nApplicable Scene: home and offices', 50, 10),
(32, 'Skip to the beginning of the images gallery', '438000.00', 'Skip to the beginning of the images gallery Rs 438000.00.png', 2, 'Intel Core I5 4th Generation Gaming PC.\r\nRam - DDR3 8GB \r\nHard Disk - 500GB \r\nProcesser - Core i5 4590 3.3ghz \r\nPower Supply - 500W \r\nVGA - 4GB \r\nIntel HD GraphicsMotherboard - H81/B85 MotherboardOrbis Gaming Casing With 4RGB Cooling Fans.\r\nBrand - CYBER \r\nCOLORSSKU154444361_LK-1083254498\r\nDisplay Size - 3\r\nOperating System - Windows\r\nProcessor - Intel Core i5 Model Core i5 4th generation Gaming Computer 500Gb / 8GB RAM \r\nHard Disk (GB)500GB', 10, 15),
(33, 'Writing Table Melamine 4X3 - 5 year warranty -drack brown', '8900.00', 'Writing Table Melamine 4X3 - 5 year warranty -drack brown Rs 8900.90.png', 2, 'Material : High quality Melamine\r\nâ€¢ Long term Usage\r\nâ€¢ Product Type : writing Tabel\r\nâ€¢ Size :50CM X74CM x 120 CM\r\nâ€¢ Durable For Long Time Use\r\nâ€¢ laminated melamine boards\r\nâ€¢ Warranty : 05 Year Warranty', 25, 5),
(34, 'Bairaha Chicken Meat Balls 200Gm', '310.00', 'Bairaha Chicken Meat Balls 200Gm.RS 310.00.png', 1, 'Made with freshly ground chicken, seasoned with herbs and spices. Product received may vary.', 200, 5),
(35, 'Indomie Instant Noodles Mi Goreng 80g', '550.00', 'Indomie Instant Noodles Mi Goreng 80g Rs 550.00.png', 1, 'Indomie noodles are an all time favourite amongst kids and adults alike.', 300, 6),
(36, 'Krest Chicken Meat Balls 500g', '935.00', 'Krest Chicken Meat Balls 500g Rs 935.00.png', 1, 'Made with freshly ground chicken, seasoned with herbs and spices.', 250, 6),
(37, 'MAGGI Daiya Devilled Spicy Blast Noodles 76g', '113.00', 'MAGGI Daiya Devilled Spicy Blast Noodles 76g 114.90.png', 1, 'A fun and tasty snack or quick meal, MAGGI Chicken flavoured 2 Minute Noodles are the most popular flavour in the range. Simply break the noodle cake into quarters and cook on the stove top or in the microwave. Stir in the contents of the flavour sachet. Serve with or without broth as desired. To boost the goodness in your bowl, add lean protein such as cooked chicken, beef or prawns and plenty of vegetables.', 150, 8),
(38, 'Magic I.C Choc 75ml', '100.00', 'Magic I.C Choc 75ml Rs. 100.png', 1, 'A delicious pairing of indulgent caramel ice cream with a rich caramel swirl, covered in a soft chocolate truffle coating.', 450, 10),
(39, 'Red Rice Handy Pack - 400g', '585.00', 'Red Rice Handy Pack - 400g 583.60.png', 1, 'Long grain rice enriched with aromatic taste and exotic nut-like flavour.', 200, 3),
(40, '14 Teeth Rake Garden Rake Steel Heavy use and Strong Head for Loose soil Dry grass leaves Weed Removing cleaning Gardening Rake Farming Tools Rakes Hand Farm Tool', '5560.00', '14 Teeth Rake Garden Rake Steel Heavy use and Strong Head for Loose soil Dry grass leaves Weed Removing cleaning Gardening Rake Farming Tools Rakes Hand Farm Tool Rs 5560.00.png', 3, 'High Quality Garden Rake without Handle\r\n14 Teeth\r\nMaterial- Mild Steel\r\nIdeal for Agricultural use\r\n13 Inches (Approx)\r\nFarm and Garden use\r\nDurable\r\nActual Product may defer from the Image Published based on availability\r\nThis rake is suitable for farming, gardening, cleaning up leaves, weeds, rubble and other debris\r\nStrong, curved teeth have more grabbing power and can handle almost any job', 100, 5),
(41, '16ltr Manual Type Agricultural High Pressure Sprayer Gardening Tool Garden Sprayer', '6590.00', '16ltr Manual Type Agricultural High Pressure Sprayer Gardening Tool Garden Sprayer 6590.90.png', 3, 'Large Tank Capacity 16ltr\r\nConvenient and efficient design\r\nReversible Left and Right handed\r\nHeavy Duty trigger Control\r\nEasy Pressure Control Nozzle\r\nIntegrated Filter Minimizes Blockage\r\nIntegrated filter to fill out small object', 150, 10),
(42, 'Branching Scissors - Flower Scissors', '1290.00', 'Branching Scissors - Flower Scissors RS 1290.00.png', 3, 'Hardened material is anti-rust and durable for long time.\r\nSharp blade and low-friction can make pruner easier and relaxed.\r\nEasy Open/Close with Ergonomically designed Handle for Good Grip.Designed with spring for comfortable use.With lanyard, it is anti lost.\r\nPerfect tool for gardener and family.\r\nExquisite workmanship, anti-corrosion.Compact and lightweight, space saving and portable to carry.\r\nAlso suitable for wire cable cutting.', 300, 15),
(43, 'Plastic Watering can with shower cap', '1199.00', 'Plastic Watering can with shower cap Rs 1199.90.png', 3, 'Brand - No Brand\r\nSKU - 107074708_LK-1024664986\r\nModel - 2022\r\nONE PIECE PER PACK-CAPACITY 7 LITTER', 350, 4),
(44, 'Pruning Saw,Craft Portable Folding Tool,Hacksaws Tree Pruning Garden Gardening Hand Saw Sharp Camping Steels Wooding Trimming Work Tool', '4230.00', 'Pruning Saw,Craft Portable Folding Tool,Hacksaws Tree Pruning Garden Gardening Hand Saw Sharp Camping Steels Wooding Trimming Work Tool Rs 4230.00.png', 3, 'hand saw\r\nTotal Length: 49 CM Saw Length: 18 CM Handle Length\r\n27 CM Application Cutting Wood Handle \r\nmaterial: PP+TPR Teeth\r\nType: Universal Cut Color\r\nCustomized Color Handle Color', 250, 6),
(45, 'Santilizer Spray Bottle 2L Pressure Bottle Water Fertilizer Agriculture Gardening', '1445.00', 'Santilizer Spray Bottle 2L Pressure Bottle Water Fertilizer Agriculture Gardening Rs 1445.00.png', 3, 'Full Range of Applications\r\nGuarantees safety and minimum contact when utilizing chemicals, pesticides,\r\nherbicides, fertilizers etc.\r\nGreat capacity of 2L for convenience\r\nEasy to pump, adjustable spray from a long stream to fine mist\r\nTough poly jar with big opening for easy filling', 500, 5),
(46, '253L NO FROST DOUBLE DOOR IN', '127880.00', '253L NO FROST DOUBLE DOOR IN Rs 127880.00.png', 4, '01 Manufacturer Warranty\r\n10 Year Compressor Warranty\r\n253 Litres Capacity\r\nBlue wave design\r\nTempered Glass Shelves\r\n3 Star Energy Rating\r\nDigital Inverter Compressor\r\nCurd Maestro\r\nStabilizer Free Operation', 50, 10),
(47, 'ARPICO ELECTRIC KETTLE 1L', '5190.00', 'ARPICO ELECTRIC KETTLE 1L Rs 5190.00.png', 4, 'The inside of the handle is undulating, increasing friction, anti-slip, anti-scalding.\r\nVisual scale transparent capacity scale shows water level.\r\nWork light is on to indicate working status.\r\nThe base can accommodate the power cord to hide without occupying land.\r\nLarge diameter pot mouth water injection without opening the lid, pouring water smoothly and quickly.\r\nExternal visual thermometer to master real-time water temperature, choose suitable warm water, brew suitable tea. And extend the curved probe to measure temperature more accurately and sensitively. Boil water, more water source health food contact grade 304 stainless steel long-lasting rust, corrosion resistance. Protection system safe electricity guardian. The kettle from the base will automatically stop the heating work, the water boiling automatically breaks the kettle and automatically breaks, stops heating to prevent thousands of boiling water.', 400, 8),
(48, 'ARPICO GLASS BLENDER 1.5L', '5870.00', 'ARPICO GLASS BLENDER 1.5L Rs 5870.00.png', 4, '1500c.c. calibrated clear glass jug.\r\n2 speeds level and moment speed(P) for extra strong blending.\r\nDry mill for grinding coffee, beans and spices, etc.\r\nStainless steel blade\r\n220-240V 50/60Hz 350W', 450, 9),
(49, 'B&D 35L TOASTER OVEN', '63054.00', 'B&D 35L TOASTER OVEN Rs 63054.00.png', 4, 'Power : 1500W\r\nVoltage : 220-240V\r\nFrequency : 50-60Hz\r\nCapacity: 35L\r\nDouble Glass door for heat insulation\r\nAnti Rust Galvanized Stainless Steel interior\r\nConvection function\r\nToast/bake/Broil function\r\nDouble grill function\r\nThermostat controlled\r\nFunction selector\r\nAdjustable timer\r\nPower on indicator\r\nNon-stick food tray\r\nWire rack & food tray handle\r\nCrumb tray\r\nRotisserie & rotisserie handle', 350, 15),
(50, 'Kawashi Magic Bullet Blender 21 Pcs', '10450.00', 'Kawashi Magic Bullet Blender 21 Pcs Rs 10450.80.png', 4, 'Blade: Stainless steel\r\nHi-speed blender\r\nPulse function for coarse chopping\r\nTap function for sticky food\r\nShake function for thicker and denser food', 250, 10),
(51, 'Sokany - 3 Speed Hand Beater, Hand Mixer 400W (CX-6618)', '3400.00', 'Sokany - 3 Speed Hand Beater, Hand Mixer 400W (CX-6618) Rs 3400.50.png', 4, 'Sokany\r\n6618\r\nMixer\r\nBest\r\nHigh quality', 150, 5),
(52, 'BLACK+DECKER 20V Max Drill & Home Tool Kit, 68 Piece (LDX120PK)', '42250.00', 'BLACK+DECKER 20V Max Drill & Home Tool Kit, 68 Piece (LDX120PK) Rs 42250.00.png', 5, '21v 18v 20v cordless impact drill lithium-ion max best cordless power tool brushless compact drill vs 21v cordless combo kit', 100, 10),
(53, 'CRAFTSMAN Home Tool Kit Mechanics Tools Kit, 57-Piece (CMMT99446)', '21439.00', 'CRAFTSMAN Home Tool Kit Mechanics Tools Kit, 57-Piece (CMMT99446) Rs 21439.00.png', 5, '168pcs hot selling Germany Quality Household Professional Repair Home Tool Hand Tool Kit', 200, 9),
(54, 'Grease Lubricant No Odor Home Improvement Machine Lubricant', '1660.00', 'Grease Lubricant No Odor Home Improvement Machine Lubricant Rs 1660.90.png', 5, 'China competitive manufacturers price MP3 lithium base lubricant grease.', 400, 3),
(55, 'HIBRO Roller Wood Imitation Grain Set Tool Wood Tool Grain Painting Grain DIY Tools & Home Improvement', '6278.00', 'HIBRO Roller Wood Imitation Grain Set Tool Wood Tool Grain Painting Grain DIY Tools & Home Improvement Rs 6278.00.png', 5, 'ROLLINGDOG 70222 Essentials Polyester Knitted 7inch Paint Roller Cover Roller Frame 4PC 7\" Paint Tray Tool Set Paint Kit', 300, 5),
(56, 'Kiwi Knife Set 5 in 1 - Free Gift', '1350.00', 'Kiwi Knife Set 5 in 1 - Free Gift Rs 1498.80.png', 5, 'FINDKING 5 PCS Professional Japanese AUS-10 Damascus Steel Knife Set Kiritsuke Santoku Nakiri Paring Chef Kitchen Knife Set', 450, 3),
(57, 'APPLE MULTIFUNCTION FEEDER 120ML4OZ', '1350.00', 'APPLE MULTIFUNCTION FEEDER 120ML4OZ Rs 1350.00.png', 6, '16oz Easy Hold French Square Glass Milk Bottle Clear Empty Glass Juice Bottle With Tear-off Lid', 500, 5),
(58, 'Baby Carry Bag- Baby Carrier- Embrace Baby Wrap Carrier- Infant Carrier for Newborns - Blue', '5660.00', 'Baby Carry Bag- Baby Carrier- Embrace Baby Wrap Carrier- Infant Carrier for Newborns - Blue Rs 5660.00.png', 6, 'All In 1 Stretchy Ergonomic Design Baby Sling Wrap Baby Hip Seat Carrier Baby Carrier Wrap', 200, 5),
(59, 'BABY CHERAMY 18S L PUL UPS', '2440.00', 'BABY CHERAMY 18S L PUL UPS Rs 2440.00.png', 6, 'Baby Cheramy, absorbent and disposable baby diapers. Size large.', 450, 4),
(60, 'Baby Health Care Set Portable Newborn Baby Tool Kits Kids Grooming Kit', '2450.00', 'Baby Health Care Set Portable Newborn Baby Tool Kits Kids Grooming Kit Rs 2450.90.png', 6, 'Features:Material: PlasticSize: 24*19.7*3.8cmThe kit contains:1. Baby special safety scissors:Round cutter head design, easy to use, easy to stab baby delicate skin.2.', 300, 3),
(61, 'Khomba Baby Gift Pack 4Pcs', '1250.00', 'Khomba Baby Gift Pack 4Pcs Rs 1250.00.png', 6, 'This premium Gift pack is ideal for Baby shower gifts or when visiting a new born.\r\nThe items included are what new moms will need in the first 3 - 6 months after haveing a baby!\r\n', 300, 5),
(62, 'Skip to the end of the images gallery', '199.00', 'Skip to the end of the images gallery Rs 199.80.png', 6, 'Baby Cheramy baby soap is gentle on the skin with many natural ingredients. This soap contains almond oil, vitamin E and milk to gently cleanse and moisturize the skin.', 500, 3),
(63, 'DSI SUPERSPORT GIRLS SCHOOL SHOES SINGLE VELCRO WHITE AGES OF 06 â€“ 07 YEARS', '3450.00', 'DSI SUPERSPORT GIRLS SCHOOL SHOES SINGLE VELCRO WHITE AGES OF 06 â€“ 07 YEARS Rs 3450.00.png', 7, 'Fashionable Elegance.\r\nBrand -DSI Super Sports\r\nConvenient and Practical.\r\nPremium Edition.\r\nPortable & Durable.\r\nExclusive Outlook.', 450, 5),
(64, 'DSI SUPERSPORT GIRLS SCHOOL SHOES SINGLE VELCRO WHITE AGES OF 15 â€“ 16 YEARS', '2900.00', 'DSI SUPERSPORT GIRLS SCHOOL SHOES SINGLE VELCRO WHITE AGES OF 15 â€“ 16 YEARS Rs 2900.90.png', 7, 'Fashionable Elegance.\r\nBrand -DSI Super Sports\r\nConvenient and Practical.\r\nPremium Edition.\r\nPortable & Durable.\r\nExclusive Outlook.', 350, 3),
(65, 'Petalz Women Ladies Footwear Black', '3450.00', 'Petalz Women Ladies Footwear Black Rs 3450.00.png', 7, 'Fashionable Elegance.\r\nBrand - Petalz\r\nConvenient and Practical.\r\nPremium Edition.\r\nPortable & Durable.\r\nExclusive Outlook.', 450, 3),
(66, 'Select by Daraz Walking Shoes for Men', '9950.00', 'Select by Daraz Walking Shoes for Men Rs 9950.00.jpg', 7, '100% Brand New\r\nHigh Quality\r\nLight weight\r\nPremium Edition.\r\nPortable & Durable.\r\nExclusive Outlook.', 350, 8),
(67, 'SuperSport Boys School Shoes Black', '3400.00', 'SuperSport Boys School Shoes Black Rs 3400.00.png', 7, 'Fashionable Elegance.\r\nBrand -DSI Super Sports\r\nConvenient and Practical.\r\nPremium Edition.\r\nPortable & Durable.\r\nExclusive Outlook.', 500, 5),
(68, 'SuperSport Boys School Shoes Black', '4100.00', 'SuperSport Boys School Shoes Black Rs 4100.00.png', 7, 'Fashionable Elegance.\r\nBrand -DSI Super Sports\r\nConvenient and Practical.\r\nPremium Edition.\r\nPortable & Durable.\r\nExclusive Outlook.', 550, 4),
(69, '32 In 1 Screwdriver Box Tool Kit', '750.00', '32 In 1 Screwdriver Box Tool Kit 750.png', 8, '32 in 1 Multi Repair Tool Box Opening Tools Kit\r\nMagnetic Screwdriver for Cell Phones Mp3 Laptop PC etc.\r\nPrecise manual tool set\r\nProfessional Hardware Tools\r\nMaterial: PP & TPR & CR-V steel\r\nGood helping hand for repair cell phones easily.\r\n', 100, 2),
(70, 'ANENG CM81 6000 Counts Push Button Clamp Multimeter New Digital Clamp Meter', '6960.00', 'ANENG CM81 6000 Counts Push Button Clamp Multimeter New Digital Clamp Meter  Rs 6960.00.png', 8, 'Welcome to our store, Follow us to get the latest product information and best prices, and get special fan coupons.\r\nWe will regularly draw fans to send beautiful gifts for our follower.', 150, 5),
(71, 'ANENG Digital Professional  Current Tester Meter Voltmeter Auto', '3120.00', 'ANENG Digital Professional  Current Tester Meter Voltmeter Auto Rs 3120.90.png', 8, '100% brand new and high quality product.2.Follow us to get the latest product information and best prices, and get special fan coupons.3.Choose high quality materials and good quality.', 450, 4),
(72, 'Dt830B Digital Multimeter Manufacturer Direct Sale, Durable, Student, Family, General Electrical Test Yellow', '1600.00', 'Dt830B Digital Multimeter Manufacturer Direct Sale, Durable, Student, Family, General Electrical Test Yellow Rs 1600.00.png', 8, 'Reasonable price\r\nDurable and practical\r\nTop Sales Item\r\nBig Discount\r\nBest Material\r\nFast Delivery\r\nAfter testing & Good Service\r\nBig Demand', 350, 3),
(73, 'Precision Screwdriver set - Tricle - 6 Pcs', '425.00', 'Precision Screwdriver set - Tricle - 6 Pcs rs 425.90.png', 8, 'Precision screwdriver set with 6 pcs\r\nIdeal for repairing small and miniture products.\r\nFull Steel shaft and body\r\nOriginal Tricle brand', 500, 2),
(74, 'Test Light DC 6-24 Voltage Electrical Circuit Tester Power Probe Pen', '1100.00', 'Test Light DC 6-24 Voltage Electrical Circuit Tester Power Probe Pen Rs 1100.00.png', 8, 'Heavy-duty circuit tester with digital LCD display to accurately show DC voltage\r\n', 300, 3),
(75, '1580-Huina 1580 22ch Chanel Professional grade full metal 10kg heavy duty electric RC Excavator', '199500.00', '1580-Huina 1580 22ch Chanel Professional grade full metal 10kg heavy duty electric RC Excavator Rs 199500.00.png', 9, 'Die-Cast Metal Material: high quality material makes the model stronger.\r\nFlexible Arm: arm can be independently moved.\r\nFlexible Body: the workbench can rotate 360Â°.\r\nDelicate Model: is worth to be collected.', 20, 20),
(76, 'Baby tolo car Baby car Play items Baby toys', '6790.00', 'Baby tolo car Baby car Play items Baby toys Rs 6790.00.png', 9, 'Encounter obstacles will automaticaly change direction.\r\nUse 3 section 1.5V AA battery(not including), no battery cover screw.\r\nsize: 9.5cm*16cm*6.8cm', 200, 5),
(77, 'Doctor Set Toys Kids Gift10 Pieces', '690.00', 'Doctor Set Toys Kids Gift10 Pieces Rs 690.00.png', 9, '10pcs/set Children Pretend Play Doctor Nurse Toy Portable Suitcase Medical Kit Kids Educational Role Play Classic Toys\r\n', 500, 2),
(78, 'Hero Lectro C4 26 E Bicycle â€“ Charcoal', '259000.00', 'Hero Lectro C4 26 E Bicycle â€“ Charcoal  259000.00.png', 9, 'The battery is disposed under the ebike seat, and you can choose between direct charging and unloading methods. You acould remove the battery and charge at home or office, but it is more convenient to plug the charger into the ebike body and charge directly.\r\n', 30, 20),
(79, 'Rock Crawler Toy Car 4WD Remote Control Off Road Truck', '11900.00', 'Rock Crawler Toy Car 4WD Remote Control Off Road Truck Rs 11900.00.png', 9, 'Item: Rock Crawler RC Car Frequency: 2.4Ghz\r\nRemote Control Distance: About 30m Charging Time: 3 hours (Please do not over-charge the battery).\r\nFunction: Move Forward/Reverse, Turn Left/Right\r\nIn order to save cost for customers, the cars will be sent without its original box. But we will well pack the the car with polyfoam box to well protect it and save your money.\r\n2*AA battery is needed for the controller, but the battery is not included.\r\n', 100, 15),
(80, 'SMART KIDDOS Knock Piano Series Xylophone', '1450.00', 'SMART KIDDOS Knock Piano Series Xylophone Rs 1450.50.png', 9, '2019 NEW Wooden Xylophone Musical Instrument 8 Tones Toys Multicolor For Children Kids Baby ASD88\r\n1x Xylophone Musical Instrument\r\nEnvironmentally friendly water-soluble paint.', 450, 4),
(81, 'computersss', '10000.00', 'Skip to the beginning of the images gallery Rs 438000.00.png', 2, 'compuers are Goods', 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `seller`
--

DROP TABLE IF EXISTS `seller`;
CREATE TABLE IF NOT EXISTS `seller` (
  `seller_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `contact` char(15) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `uname` varchar(100) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`seller_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `seller`
--

INSERT INTO `seller` (`seller_id`, `name`, `address`, `contact`, `DOB`, `uname`, `password`) VALUES
(1, 'Maleesha Herath', 'Rabukkana', '076-5895698', '0200-11-02', 'seller@seller.lk', 'seller@22');
--
-- Database: `tecmis`
--
CREATE DATABASE IF NOT EXISTS `tecmis` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `tecmis`;

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
  `Email` varchar(100) NOT NULL,
  PRIMARY KEY (`user_no`,`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_role`, `user_no`, `user_id`, `user_password`, `first_name`, `last_name`, `Email`) VALUES
('admin', 1, 'admin001', 'admin1', 'lahiru', 'prasad', 'lahirupresath262@gmail.com'),
('admin', 2, 'admin002', 'admin12', 'kavindya', 'imasha', 'kavindyaima996@gmail.com '),
('student', 3, 'std001', 'std1', 'shanaka', 'priyantha', 'shanakapriyantha123@gmail.com'),
('student', 4, 'std002', 'std2', 'prevven', 'nikmal', 'preveennikamal232@gmail.com'),
('lecturer', 5, 'lec001', 'lec1', 'Sarath', 'Kumara', 'sarathKumara990@gmail.com'),
('technical_officer', 6, 'techoff001', 'techo1', 'shima', 'jacko', 'shimajacko202@gmail.com');
--
-- Database: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
CREATE TABLE IF NOT EXISTS `bill` (
  `Bill_ID` varchar(6) NOT NULL,
  `Doctor_Charges` decimal(6,2) DEFAULT NULL,
  `Treatment_Charges` decimal(6,2) DEFAULT NULL,
  `Medicine_Charges` decimal(6,2) DEFAULT NULL,
  `BDate` date DEFAULT NULL,
  `Patient_ID` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`Bill_ID`),
  KEY `Patient_ID` (`Patient_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`Bill_ID`, `Doctor_Charges`, `Treatment_Charges`, `Medicine_Charges`, `BDate`, `Patient_ID`) VALUES
('BL0001', '1500.00', '1400.00', '1500.00', '2021-12-29', 'PT0001'),
('BL0002', '1000.00', '1000.00', '1100.00', '2022-02-19', 'PT0002'),
('BL0003', '2000.00', '1500.00', '1500.00', '2021-10-06', 'PT0003'),
('BL0004', '3500.00', '2500.00', '1500.00', '2021-12-12', 'PT0004'),
('BL0005', '1500.00', '1450.00', '1500.00', '2022-04-01', 'PT0005'),
('BL0006', '2200.00', '2000.00', '1500.00', '2021-11-22', 'PT0006'),
('BL0007', '3500.00', '2100.00', '1500.00', '2022-06-18', 'PT0007'),
('BL0008', '2000.00', '1900.00', '1500.00', '2021-12-10', 'PT0008'),
('BL0009', '1200.00', '2500.00', '1500.00', '2022-07-23', 'PT0009'),
('BL0010', '1500.00', '1500.00', '1500.00', '2022-09-03', 'PT0010'),
('BL0011', '1700.00', '1600.00', '1500.00', '2022-09-22', 'PT0011'),
('BL0012', '1300.00', '1200.00', '1200.00', '2022-11-12', 'PT0012'),
('BL0013', '2300.00', '1900.00', '1500.00', '2022-10-15', 'PT0013'),
('BL0014', '1500.00', '1400.00', '1400.00', '2022-07-14', 'PT0014'),
('BL0015', '1300.00', '1100.00', '1000.00', '2022-06-11', 'PT0015'),
('BL0016', '4000.00', '2000.00', '2500.00', '2022-12-15', 'PT0016'),
('BL0017', '1600.00', '1500.00', '1500.00', '2022-11-23', 'PT0017'),
('BL0018', '2500.00', '2000.00', '1500.00', '2022-08-28', 'PT0018'),
('BL0019', '1500.00', '1400.00', '1500.00', '2022-02-28', 'PT0019'),
('BL0020', '3500.00', '2000.00', '2000.00', '2022-01-02', 'PT0020');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `Department_ID` varchar(4) NOT NULL,
  `Name` char(30) DEFAULT NULL,
  PRIMARY KEY (`Department_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`Department_ID`, `Name`) VALUES
('DP01', 'Dental'),
('DP03', 'IPD'),
('DP06', 'MRD'),
('DP07', 'Medical Department');

-- --------------------------------------------------------

--
-- Table structure for table `department_lab`
--

DROP TABLE IF EXISTS `department_lab`;
CREATE TABLE IF NOT EXISTS `department_lab` (
  `Department_ID` varchar(4) NOT NULL,
  `Laboratory_ID` varchar(4) NOT NULL,
  PRIMARY KEY (`Department_ID`,`Laboratory_ID`),
  KEY `Laboratory_ID` (`Laboratory_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department_lab`
--

INSERT INTO `department_lab` (`Department_ID`, `Laboratory_ID`) VALUES
('DP01', 'LB08'),
('DP02', 'LB06'),
('DP03', 'LB09'),
('DP04', 'LB07'),
('DP05', 'LB04'),
('DP06', 'LB05'),
('DP07', 'LB03'),
('DP08', 'LB02'),
('DP09', 'LB01'),
('DP10', 'LB10');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE IF NOT EXISTS `doctor` (
  `Doctor_ID` varchar(5) NOT NULL,
  `Staff_ID` varchar(5) DEFAULT NULL,
  `DType` char(20) DEFAULT NULL,
  PRIMARY KEY (`Doctor_ID`),
  KEY `Staff_ID` (`Staff_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`Doctor_ID`, `Staff_ID`, `DType`) VALUES
('DC001', 'ST001', 'Cardiologists Doctor'),
('DC002', 'ST002', 'General Practitioner'),
('DC003', 'ST003', 'Dentist'),
('DC004', 'ST004', 'Endocrinology'),
('DC005', 'ST005', 'Neuro Surgen'),
('DC006', 'ST006', 'Psychiatrist'),
('DC007', 'ST007', 'Ophthalmologist'),
('DC008', 'ST008', 'Oncologist'),
('DC009', 'ST009', 'Obstetricians'),
('DC010', 'ST010', 'Dermatologists');

-- --------------------------------------------------------

--
-- Table structure for table `doctor_treat`
--

DROP TABLE IF EXISTS `doctor_treat`;
CREATE TABLE IF NOT EXISTS `doctor_treat` (
  `Doctor_ID` varchar(5) NOT NULL,
  `Patient_ID` varchar(6) NOT NULL,
  `Treatment_Name` varchar(30) DEFAULT NULL,
  `D_Date` date DEFAULT NULL,
  `D_Time` time DEFAULT NULL,
  `Test_Result` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Doctor_ID`,`Patient_ID`),
  KEY `Patient_ID` (`Patient_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor_treat`
--

INSERT INTO `doctor_treat` (`Doctor_ID`, `Patient_ID`, `Treatment_Name`, `D_Date`, `D_Time`, `Test_Result`) VALUES
('DC001', 'PT0001', 'Bypass surgery', '2021-12-29', '02:15:02', 'Normal'),
('DC004', 'PT0002', 'Endoscopy test', '2022-02-19', '14:15:23', 'Continue treatments'),
('DC001', 'PT0003', 'Bone marrow transplant', '2021-10-06', '23:00:00', 'Normal'),
('DC007', 'PT0004', 'Cataract removal surgery', '2021-12-12', '03:00:14', 'Normal'),
('DC005', 'PT0005', 'Neuro therapy', '2022-04-01', '02:00:23', 'Continue treatments'),
('DC007', 'PT0006', 'Eye transplant', '2021-11-22', '15:15:23', 'Normal'),
('DC008', 'PT0007', 'Cancer treatments & surgery', '2022-06-18', '11:00:22', 'Continue treatments'),
('DC001', 'PT0008', 'Cardiovascular test', '2021-12-10', '17:04:12', 'Normal'),
('DC002', 'PT0009', 'Delevery', '2022-07-23', '09:15:54', 'Normal'),
('DC010', 'PT0010', 'Allergy Treatments', '2022-09-03', '20:30:41', 'Normal'),
('DC002', 'PT0011', 'Medical instructions', '2022-09-22', '10:00:00', 'Normal'),
('DC002', 'PT0012', 'Medical instructions', '2022-11-12', '10:30:12', 'Normal'),
('DC002', 'PT0013', 'Medical instructions', '2022-10-15', '09:15:23', 'Normal'),
('DC002', 'PT0014', 'Stitching', '2022-07-14', '09:00:23', 'Normal'),
('DC002', 'PT0015', 'Blood test', '2022-06-11', '09:00:00', 'Admitted'),
('DC003', 'PT0016', 'Tooth filling', '2022-12-15', '11:00:10', 'Normal'),
('DC007', 'PT0017', 'Eye checkup', '2022-11-23', '09:30:56', 'Normal'),
('DC002', 'PT0018', 'Medical instructions', '2022-08-28', '09:00:00', 'Normal'),
('DC002', 'PT0019', 'Medical instructions', '2022-02-28', '10:30:33', 'Normal'),
('DC003', 'PT0020', 'Cavity checkup', '2022-01-02', '09:45:54', 'Normal');

-- --------------------------------------------------------

--
-- Table structure for table `family`
--

DROP TABLE IF EXISTS `family`;
CREATE TABLE IF NOT EXISTS `family` (
  `Staff_ID` varchar(5) NOT NULL,
  `Name` char(30) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Staff_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `family`
--

INSERT INTO `family` (`Staff_ID`, `Name`, `Address`) VALUES
('ST001', 'Rupasingha', 'No.103 C/1,Walgampaye,Danthure'),
('ST002', 'Jayathilake', 'No.24/4 Laneban Rd, Galle'),
('ST003', 'Weragoda', 'No.76/1,Kurolige Waththe,Baddegama'),
('ST004', 'Herath', 'No.44 Somadevi Place, Kirulapane Avenue'),
('ST005', 'Gunathilake', 'NO.39/1F 2nd Cross Street, 11'),
('ST006', 'Silva', 'No.320 Galle Road, 03'),
('ST007', 'Karunarathne', 'No.18 Cotta Road, 08'),
('ST008', 'Siriwardhana', 'No.40A, Cumaratunga Munidasa'),
('ST009', 'Deshapriya', 'No.Signin Advertising,No 49|2|1, Anagarika'),
('ST010', 'Brahmana', 'No.11/8B, 47th Lane');

-- --------------------------------------------------------

--
-- Table structure for table `gives`
--

DROP TABLE IF EXISTS `gives`;
CREATE TABLE IF NOT EXISTS `gives` (
  `Patient_ID` varchar(6) NOT NULL,
  `Medicine_ID` varchar(5) NOT NULL,
  `G_Date` date DEFAULT NULL,
  `G_Time` time DEFAULT NULL,
  PRIMARY KEY (`Patient_ID`,`Medicine_ID`),
  KEY `Medicine_ID` (`Medicine_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gives`
--

INSERT INTO `gives` (`Patient_ID`, `Medicine_ID`, `G_Date`, `G_Time`) VALUES
('PT0001', 'MD001', '2022-01-15', '13:15:10'),
('PT0002', 'MD002', '2022-03-25', '16:30:00'),
('PT0003', 'MD003', '2021-12-10', '10:10:30'),
('PT0004', 'MD004', '2022-01-27', '13:15:13'),
('PT0005', 'MD005', '2022-05-05', '12:45:40'),
('PT0006', 'MD006', '2021-11-25', '17:45:10'),
('PT0007', 'MD007', '2022-06-25', '14:05:25'),
('PT0008', 'MD008', '2022-01-01', '17:15:10'),
('PT0009', 'MD009', '2022-07-29', '11:15:40'),
('PT0010', 'MD010', '2022-10-01', '12:40:00'),
('PT0011', 'MD011', '2022-09-22', '12:20:10'),
('PT0012', 'MD012', '2022-11-12', '14:50:00'),
('PT0013', 'MD013', '2022-10-15', '10:15:40'),
('PT0014', 'MD014', '2022-07-14', '13:25:13'),
('PT0015', 'MD015', '2022-06-11', '12:10:40'),
('PT0016', 'MD016', '2022-12-15', '13:15:10'),
('PT0017', 'MD017', '2022-11-23', '14:45:25'),
('PT0018', 'MD018', '2022-08-28', '18:12:40'),
('PT0019', 'MD019', '2022-02-28', '13:17:50'),
('PT0020', 'MD020', '2022-01-02', '18:28:14');

-- --------------------------------------------------------

--
-- Table structure for table `inpatient`
--

DROP TABLE IF EXISTS `inpatient`;
CREATE TABLE IF NOT EXISTS `inpatient` (
  `Record_ID` varchar(5) NOT NULL,
  `Admit_Date` date DEFAULT NULL,
  `Discharge_Date` date DEFAULT NULL,
  PRIMARY KEY (`Record_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inpatient`
--

INSERT INTO `inpatient` (`Record_ID`, `Admit_Date`, `Discharge_Date`) VALUES
('RC001', '2021-12-29', '2022-01-15'),
('RC002', '2022-02-19', '2022-03-25'),
('RC003', '2021-10-06', '2021-12-10'),
('RC004', '2021-12-12', '2022-01-27'),
('RC005', '2022-04-01', '2022-05-05'),
('RC006', '2021-11-22', '2021-11-25'),
('RC007', '2022-06-18', '2022-06-25'),
('RC008', '2021-12-10', '2022-01-01'),
('RC009', '2022-07-23', '2022-07-29'),
('RC010', '2022-09-03', '2022-10-01');

-- --------------------------------------------------------

--
-- Table structure for table `laboratory`
--

DROP TABLE IF EXISTS `laboratory`;
CREATE TABLE IF NOT EXISTS `laboratory` (
  `Laboratory_ID` varchar(4) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Laboratory_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `laboratory`
--

INSERT INTO `laboratory` (`Laboratory_ID`, `Name`) VALUES
('LB01', 'LAB 01'),
('LB02', 'LAB 02'),
('LB03', 'LAB 03'),
('LB04', 'LAB 04'),
('LB05', 'LAB 05'),
('LB06', 'LAB 06'),
('LB07', 'LAB 07'),
('LB08', 'LAB 08'),
('LB09', 'LAB 09'),
('LB10', 'LAB 10');

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
CREATE TABLE IF NOT EXISTS `medicine` (
  `Medicine_ID` varchar(5) NOT NULL,
  `MeName` varchar(30) DEFAULT NULL,
  `Quantity` int(5) DEFAULT NULL,
  `Pharmacy_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Medicine_ID`),
  KEY `Pharmacy_ID` (`Pharmacy_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`Medicine_ID`, `MeName`, `Quantity`, `Pharmacy_ID`) VALUES
('MD001', 'Hydrocodone', 1500, 'PH001'),
('MD002', 'Metformin', 1450, 'PH001'),
('MD003', 'Losartan', 1850, 'PH002'),
('MD004', 'Antibiotics', 1200, 'PH002'),
('MD005', 'Albuterol', 1100, 'PH003'),
('MD006', 'Antihistamines', 1600, 'PH003'),
('MD007', 'Gabapentin', 1685, 'PH004'),
('MD008', 'Omeprazole', 1950, 'PH004'),
('MD009', 'Levothyroxine', 1220, 'PH005'),
('MD010', 'Atorvastatin', 1650, 'PH005'),
('MD011', 'Avapro', 1250, 'PH006'),
('MD012', 'Arranon', 1650, 'PH006'),
('MD013', 'Mebaral', 1899, 'PH007'),
('MD014', 'Nadolol', 1650, 'PH007'),
('MD015', 'Saxagliptin', 1256, 'PH008'),
('MD016', 'Welchol', 2025, 'PH008'),
('MD017', 'Halcion', 2500, 'PH009'),
('MD018', 'Jantoven', 2450, 'PH009'),
('MD019', 'Megace', 1630, 'PH010'),
('MD020', 'Samsca', 1956, 'PH010'),
('MD021', 'Famvir', 2458, 'PH010'),
('MD022', 'Selsun', 2369, 'PH002');

-- --------------------------------------------------------

--
-- Table structure for table `nurse`
--

DROP TABLE IF EXISTS `nurse`;
CREATE TABLE IF NOT EXISTS `nurse` (
  `Nurse_ID` varchar(5) NOT NULL,
  `Staff_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Nurse_ID`),
  KEY `Staff_ID` (`Staff_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nurse`
--

INSERT INTO `nurse` (`Nurse_ID`, `Staff_ID`) VALUES
('NR001', 'ST011'),
('NR002', 'ST012'),
('NR003', 'ST013'),
('NR004', 'ST014'),
('NR005', 'ST015'),
('NR006', 'ST016'),
('NR007', 'ST017'),
('NR008', 'ST018'),
('NR009', 'ST019'),
('NR010', 'ST020');

-- --------------------------------------------------------

--
-- Table structure for table `nurse_assign`
--

DROP TABLE IF EXISTS `nurse_assign`;
CREATE TABLE IF NOT EXISTS `nurse_assign` (
  `Nurse_ID` varchar(6) NOT NULL,
  `Room_ID` varchar(6) NOT NULL,
  `NADate` date DEFAULT NULL,
  `NATime` time DEFAULT NULL,
  PRIMARY KEY (`Nurse_ID`,`Room_ID`),
  KEY `Room_ID` (`Room_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nurse_assign`
--

INSERT INTO `nurse_assign` (`Nurse_ID`, `Room_ID`, `NADate`, `NATime`) VALUES
('NR0001', 'RM0001', '2022-10-02', '16:20:00'),
('NR0002', 'RM0002', '2022-11-11', '03:30:10'),
('NR0003', 'RM0003', '2022-08-13', '10:00:00'),
('NR0004', 'RM0004', '2022-10-14', '05:30:15'),
('NR0005', 'RM0005', '2022-01-15', '09:20:40'),
('NR0006', 'RM0006', '2022-12-16', '06:00:00'),
('NR0007', 'RM0007', '2022-10-21', '02:40:10'),
('NR0008', 'RM0008', '2022-08-24', '09:10:00'),
('NR0009', 'RM0009', '2022-07-29', '15:10:30'),
('NR0010', 'RM0010', '2022-06-30', '12:15:00');

-- --------------------------------------------------------

--
-- Table structure for table `outpatient`
--

DROP TABLE IF EXISTS `outpatient`;
CREATE TABLE IF NOT EXISTS `outpatient` (
  `Record_ID` varchar(5) NOT NULL,
  `ODate` date DEFAULT NULL,
  PRIMARY KEY (`Record_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `outpatient`
--

INSERT INTO `outpatient` (`Record_ID`, `ODate`) VALUES
('RC011', '2022-09-22'),
('RC012', '2022-11-12'),
('RC013', '2022-10-15'),
('RC014', '2022-07-14'),
('RC015', '2022-06-11'),
('RC016', '2022-12-15'),
('RC017', '2022-11-23'),
('RC018', '2022-08-28'),
('RC019', '2022-02-28'),
('RC020', '2022-01-02');

-- --------------------------------------------------------

--
-- Table structure for table `paid_by`
--

DROP TABLE IF EXISTS `paid_by`;
CREATE TABLE IF NOT EXISTS `paid_by` (
  `Bill_ID` varchar(6) NOT NULL,
  `Method_ID` varchar(6) NOT NULL,
  `PdDate` date DEFAULT NULL,
  `PdTime` time DEFAULT NULL,
  PRIMARY KEY (`Bill_ID`,`Method_ID`),
  KEY `Method_ID` (`Method_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paid_by`
--

INSERT INTO `paid_by` (`Bill_ID`, `Method_ID`, `PdDate`, `PdTime`) VALUES
('BL0001', 'PM0001', '2022-01-15', '08:05:00'),
('BL0002', 'PM0004', '2022-03-25', '09:25:50'),
('BL0003', 'PM0006', '2021-12-10', '13:10:10'),
('BL0004', 'PM0001', '2022-01-27', '09:36:20'),
('BL0005', 'PM0002', '2022-05-05', '10:51:30'),
('BL0006', 'PM0005', '2021-11-25', '10:20:37'),
('BL0007', 'PM0005', '2022-06-25', '09:13:45'),
('BL0008', 'PM0002', '2022-01-01', '11:26:54'),
('BL0009', 'PM0003', '2022-07-29', '08:45:32'),
('BL0010', 'PM0003', '2022-10-01', '09:00:13'),
('BL0011', 'PM0001', '2022-09-22', '13:56:59'),
('BL0012', 'PM0001', '2022-11-12', '12:34:16'),
('BL0013', 'PM0003', '2022-10-15', '10:22:23'),
('BL0014', 'PM0004', '2022-07-14', '09:48:42'),
('BL0015', 'PM0003', '2022-06-11', '08:25:31'),
('BL0016', 'PM0001', '2022-12-15', '11:59:23'),
('BL0017', 'PM0001', '2022-11-23', '09:12:52'),
('BL0018', 'PM0005', '2022-08-28', '10:35:28'),
('BL0019', 'PM0005', '2022-02-28', '08:46:24'),
('BL0020', 'PM0001', '2022-01-02', '09:14:02');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `Patient_ID` varchar(6) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `State` varchar(4) DEFAULT NULL,
  `Address` varchar(40) DEFAULT NULL,
  `Gender` varchar(8) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Room_ID` varchar(5) DEFAULT NULL,
  `Department_ID` varchar(4) DEFAULT NULL,
  `Doctor_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Patient_ID`),
  KEY `Room_ID` (`Room_ID`),
  KEY `Department_ID` (`Department_ID`),
  KEY `Doctor_ID` (`Doctor_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`Patient_ID`, `Name`, `State`, `Address`, `Gender`, `DOB`, `Room_ID`, `Department_ID`, `Doctor_ID`) VALUES
('PT0002', 'Lahiru Prasad', 'Lv04', 'No.B/23,Talakiriyagama,Matara', 'Male', '1998-01-30', 'RM002', 'DP03', 'DC006'),
('PT0003', 'Kalini Manoli', 'Lv03', 'No.C/20,Cheddipalayam,Galle', 'Female', '2005-12-31', 'RM003', 'DP04', 'DC005'),
('PT0004', 'Gamini Weragoda', 'Lv01', 'Gelioya,Matara', 'Male', '1977-09-22', 'RM004', 'DP04', 'DC009'),
('PT0005', 'Chanaka Priyanjith', 'Lv02', 'No.B/347,Onegama,Galle', 'Male', '1996-08-13', 'RM005', 'DP03', 'DC002'),
('PT0006', 'Imasha Udawaththa', 'Lv03', 'Padavi Sritissapura,Galle', 'Female', '2002-10-21', 'RM006', 'DP01', 'DC003'),
('PT0007', 'Nandani Silawathi', 'Lv01', 'No.B/32,Ampilanthurai School Rd,Matara', 'Female', '1950-01-02', 'RM007', 'DP03', 'DC010'),
('PT0008', 'Kapuge Namal', 'Lv04', 'No.B/19,Sungavila,Matara', 'Male', '1945-12-29', 'RM008', 'DP03', 'DC007'),
('PT0009', 'Sunila Rajapaksha ', 'Lv03', 'Lindula,Galle', 'Female', '1993-02-05', 'RM009', 'DP01', 'DC003'),
('PT0010', 'Malsha Bandara', 'Lv02', 'No.A32,Maeliya,Galle', 'Male', '1995-12-11', 'RM010', 'DP04', 'DC005'),
('PT0011', 'Dananjaya Banda', 'Lv04', 'No.F30,Cheddipalayam,Galle', 'Male', '1988-10-20', NULL, 'DP02', 'DC010'),
('PT0012', 'Achala Bandara', 'Lv03', 'No.D/35,Mankemi,Galle', 'Female', '1998-03-12', NULL, 'DP02', 'DC002'),
('PT0013', 'Jock Jani', 'Lv04', 'Boraluwewa,Galle', 'Female', '2010-05-15', NULL, 'DP02', 'DC004'),
('PT0014', 'Maleesha Abisheeka', 'Lv04', 'No.B32,Udispattuwa,Galle', 'Male', '2004-07-22', NULL, 'DP02', 'DC008'),
('PT0015', 'Nimesh Silva ', 'Lv04', 'Pallepola,Galle', 'Male', '2001-02-20', NULL, 'DP02', 'DC007'),
('PT0016', 'Isuri Nimali', 'Lv02', 'No.B27,Mahawela,Matara', 'Female', '2004-12-01', NULL, 'DP01', 'DC003'),
('PT0017', 'Kaveesha Nawo', 'Lv03', 'No.B29,Madulkele,Galle', 'Female', '1995-09-24', NULL, 'DP02', 'DC001'),
('PT0018', 'Raveesha Lover', 'Lv01', 'Padavi Sripura,Galle', 'Female', '1990-06-15', NULL, 'DP02', 'DC002'),
('PT0019', 'Seelawathi ', 'Lv02', 'B16,Madulkele,Galle', 'Female', '1941-02-01', NULL, 'DP02', 'DC002'),
('PT0020', 'Sethan Appu', 'Lv04', 'No.22,Maharachchimulla,Matara', 'Male', '1935-12-12', NULL, 'DP01', 'DC003');

-- --------------------------------------------------------

--
-- Table structure for table `patient_contact`
--

DROP TABLE IF EXISTS `patient_contact`;
CREATE TABLE IF NOT EXISTS `patient_contact` (
  `Patient_ID` varchar(6) NOT NULL,
  `Contact` varchar(11) NOT NULL,
  PRIMARY KEY (`Patient_ID`,`Contact`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient_contact`
--

INSERT INTO `patient_contact` (`Patient_ID`, `Contact`) VALUES
('PT0001', '077-9797676'),
('PT0001', '081-9797234'),
('PT0002', '011-2343256'),
('PT0002', '075-2348248'),
('PT0003', '033-1245679'),
('PT0003', '078-2572264'),
('PT0004', '025-6446667'),
('PT0004', '075-2434783'),
('PT0005', '066-4366675'),
('PT0005', '075-2343252'),
('PT0006', '054-0879799'),
('PT0006', '076-2329380'),
('PT0007', '076-2434434'),
('PT0007', '088-1231413'),
('PT0008', '078-2338091'),
('PT0008', '099-5647467'),
('PT0009', '021-5656546'),
('PT0009', '077-2791000'),
('PT0010', '034-5645645'),
('PT0010', '076-2323826');

-- --------------------------------------------------------

--
-- Table structure for table `payment_method`
--

DROP TABLE IF EXISTS `payment_method`;
CREATE TABLE IF NOT EXISTS `payment_method` (
  `Method_ID` varchar(6) NOT NULL,
  `PMType` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Method_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment_method`
--

INSERT INTO `payment_method` (`Method_ID`, `PMType`) VALUES
('PM0001', 'Cash'),
('PM0002', 'Checks'),
('PM0003', 'Debit Cards'),
('PM0004', 'Credit Cards'),
('PM0005', 'Mobile Payments'),
('PM0006', 'E Bank Transfers');

-- --------------------------------------------------------

--
-- Table structure for table `pharmacy`
--

DROP TABLE IF EXISTS `pharmacy`;
CREATE TABLE IF NOT EXISTS `pharmacy` (
  `Pharmacy_ID` varchar(5) NOT NULL,
  `PhName` char(20) DEFAULT NULL,
  `Location` varchar(30) DEFAULT NULL,
  `Contact_No` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`Pharmacy_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pharmacy`
--

INSERT INTO `pharmacy` (`Pharmacy_ID`, `PhName`, `Location`, `Contact_No`) VALUES
('PH001', 'The New Pharmacy', 'Kurunegala', '071-2582341'),
('PH002', 'Thumsetha Pharmacy', 'Colombo', '011-9876352'),
('PH003', 'Vijitha Pharmacy', 'Galle', '071-7895871'),
('PH004', 'New Lanka Medicare', 'Vavuniya', '075-4893251'),
('PH005', 'Kasun Pharmacy', 'Kuliyapitiya', '072-4562587'),
('PH006', 'Roguss pharmacy', 'Nigambo', '081-2323456'),
('PH007', 'Kalani Pharmacy', 'Matara', '074-9513572'),
('PH008', 'Supipi Pharmacy', 'Kamburupitiya', '076-9517513'),
('PH009', 'United Pharmacy', 'Badulla', '070-4902367'),
('PH010', 'Sewana Pharmacy', 'Kurunegala', '035-4585636');

-- --------------------------------------------------------

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
CREATE TABLE IF NOT EXISTS `record` (
  `Record_ID` varchar(6) NOT NULL,
  `Patient_ID` varchar(6) DEFAULT NULL,
  `Weight` varchar(6) DEFAULT NULL,
  `Blood_Group` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`Record_ID`),
  KEY `Patient_ID` (`Patient_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `record`
--

INSERT INTO `record` (`Record_ID`, `Patient_ID`, `Weight`, `Blood_Group`) VALUES
('RC001', 'PT0001', '65', 'A+'),
('RC002', 'PT0002', '70', 'B+'),
('RC003', 'PT0003', '55', 'O+'),
('RC004', 'PT0004', '60', 'AB+'),
('RC005', 'PT0005', '63', 'AB-'),
('RC006', 'PT0006', '59', 'O-'),
('RC007', 'PT0007', '68', 'A-'),
('RC008', 'PT0008', '72', 'B-'),
('RC009', 'PT0009', '77', 'A+'),
('RC010', 'PT0010', '51', 'B+'),
('RC011', 'PT0011', '41', 'B+'),
('RC012', 'PT0012', '75', 'A-'),
('RC013', 'PT0013', '49', 'AB+'),
('RC014', 'PT0014', '66', 'A+'),
('RC015', 'PT0015', '79', 'O-'),
('RC016', 'PT0016', '63', 'AB-'),
('RC017', 'PT0017', '54', 'A-'),
('RC018', 'PT0018', '76', 'O+'),
('RC019', 'PT0019', '74', 'B+'),
('RC020', 'PT0020', '71', 'AB-');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE IF NOT EXISTS `room` (
  `Room_ID` varchar(5) NOT NULL,
  `RType` varchar(20) DEFAULT NULL,
  `Department_ID` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`Room_ID`),
  KEY `Department_ID` (`Department_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`Room_ID`, `RType`, `Department_ID`) VALUES
('RM001', 'Only_Private_R_03', 'DP01'),
('RM002', 'VIP_R_02', 'DP03'),
('RM003', 'VIP_R_03', 'DP04'),
('RM004', 'Only_Private_R_01', 'DP04'),
('RM005', 'Only_Private_R_02', 'DP03'),
('RM006', 'Only_Private_R_03', 'DP01'),
('RM007', 'Semi_Private_R_01', 'DP03'),
('RM008', 'Semi_Private_R_02', 'DP03'),
('RM009', 'Semi_Private_R_03', 'DP01'),
('RM010', 'Semi_Private_R_04', 'DP04');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE IF NOT EXISTS `staff` (
  `Staff_ID` varchar(5) NOT NULL,
  `Name` char(30) DEFAULT NULL,
  `Salary` decimal(6,2) DEFAULT NULL,
  `Department_ID` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`Staff_ID`),
  KEY `Department_ID` (`Department_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ward_boy_assign`
--

DROP TABLE IF EXISTS `ward_boy_assign`;
CREATE TABLE IF NOT EXISTS `ward_boy_assign` (
  `Ward_boy_ID` varchar(6) NOT NULL,
  `Room_ID` varchar(6) NOT NULL,
  `WADate` date DEFAULT NULL,
  `WATime` time DEFAULT NULL,
  PRIMARY KEY (`Ward_boy_ID`,`Room_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ward_boy_assign`
--

INSERT INTO `ward_boy_assign` (`Ward_boy_ID`, `Room_ID`, `WADate`, `WATime`) VALUES
('WB001', 'RM001', '2022-10-10', '08:20:00'),
('WB002', 'RM002', '2022-10-11', '08:20:00'),
('WB003', 'RM003', '2022-10-13', '08:00:00'),
('WB004', 'RM004', '2022-10-14', '08:30:00'),
('WB005', 'RM005', '2022-10-15', '08:20:40'),
('WB006', 'RM006', '2022-10-16', '06:00:00'),
('WB007', 'RM007', '2022-10-22', '08:00:00'),
('WB008', 'RM008', '2022-10-24', '09:10:00'),
('WB009', 'RM009', '2022-10-29', '08:10:15'),
('WB010', 'RM010', '2022-10-21', '12:15:00');

-- --------------------------------------------------------

--
-- Table structure for table `word_boy`
--

DROP TABLE IF EXISTS `word_boy`;
CREATE TABLE IF NOT EXISTS `word_boy` (
  `Word_boy_ID` varchar(5) NOT NULL,
  `Staff_ID` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Word_boy_ID`),
  KEY `Staff_ID` (`Staff_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
