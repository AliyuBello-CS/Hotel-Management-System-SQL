-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: May 21, 2022 at 09:07 PM
-- Server version: 5.7.34
-- PHP Version: 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Hotel Management System`
--

-- --------------------------------------------------------

--
-- Table structure for table `Guest`
--

CREATE TABLE `Guest` (
  `Guest_ID` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Passport_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Hotel`
--

CREATE TABLE `Hotel` (
  `Hotel_id` int(11) NOT NULL,
  `Name` varchar(15) NOT NULL,
  `Address` varchar(30) NOT NULL,
  `Description` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Order`
--

CREATE TABLE `Order` (
  `Order_ID` int(11) NOT NULL,
  `Guest_ID` int(11) NOT NULL,
  `Service_ID` int(11) NOT NULL,
  `OrderDate` date NOT NULL,
  `Time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Reservation`
--

CREATE TABLE `Reservation` (
  `Guest_ID` int(11) NOT NULL,
  `Room_ID` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `ReservationP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Room`
--

CREATE TABLE `Room` (
  `RoomNumber` int(11) NOT NULL,
  `RoomType` varchar(20) NOT NULL,
  `FloorNumber` int(11) NOT NULL,
  `TypicPrice` int(11) NOT NULL,
  `Occupant` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Service`
--

CREATE TABLE `Service` (
  `Service_ID` int(11) NOT NULL,
  `Name` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Guest`
--
ALTER TABLE `Guest`
  ADD PRIMARY KEY (`Guest_ID`);

--
-- Indexes for table `Hotel`
--
ALTER TABLE `Hotel`
  ADD PRIMARY KEY (`Name`);

--
-- Indexes for table `Order`
--
ALTER TABLE `Order`
  ADD PRIMARY KEY (`Order_ID`);

--
-- Indexes for table `Reservation`
--
ALTER TABLE `Reservation`
  ADD PRIMARY KEY (`Guest_ID`,`Room_ID`);

--
-- Indexes for table `Room`
--
ALTER TABLE `Room`
  ADD PRIMARY KEY (`RoomNumber`);

--
-- Indexes for table `Service`
--
ALTER TABLE `Service`
  ADD PRIMARY KEY (`Service_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
