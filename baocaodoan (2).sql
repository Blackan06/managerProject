-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 28, 2022 at 09:51 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `baocaodoan`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` int(111) NOT NULL,
  `name` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `phone` bigint(20) NOT NULL,
  `role` varchar(255) NOT NULL,
  `isLeader` tinyint(1) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `name`, `mail`, `password`, `group_id`, `phone`, `role`, `isLeader`, `gender`) VALUES
(1, 'admin', 'admin@fpt.edu.vn', '123', NULL, 0, 'admin', NULL, NULL),
(2, 'Nguyen Le Hai Dang', 'dangnlhse141070@fpt.edu.vn', '123', 1, 839043756, 'student', 0, 'name'),
(3, 'Thanh Nguyen', 'giaovien@fpt.edu.vn', '123', 1, 839043756, 'teacher', NULL, 'man');

-- --------------------------------------------------------

--
-- Table structure for table `finalpointproject`
--

CREATE TABLE `finalpointproject` (
  `id` int(11) NOT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `point` double DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `group`
--

CREATE TABLE `group` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `group`
--

INSERT INTO `group` (`id`, `name`) VALUES
(1, 'group 1');

-- --------------------------------------------------------

--
-- Table structure for table `meeting`
--

CREATE TABLE `meeting` (
  `id` int(11) NOT NULL,
  `scheduleMeeting_id` int(11) DEFAULT NULL,
  `link-meeting` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `meetingrecord`
--

CREATE TABLE `meetingrecord` (
  `id` int(11) NOT NULL,
  `meeting_id` int(11) DEFAULT NULL,
  `content` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `urlProject` varchar(255) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`id`, `name`, `urlProject`, `createTime`, `group_id`) VALUES
(3, 'haha', 'hihi', '2020-02-01', 1),
(7, 'hihi', 'hihi', '2020-02-01', NULL),
(8, 'hihi', 'hihi', '2020-02-01', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `point` double DEFAULT NULL,
  `comment` text DEFAULT NULL,
  `timeCreate` date DEFAULT NULL,
  `timeSubmit` date DEFAULT NULL,
  `urlReport` text DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `report`
--

INSERT INTO `report` (`id`, `name`, `point`, `comment`, `timeCreate`, `timeSubmit`, `urlReport`, `project_id`) VALUES
(32, 'naruto ', NULL, NULL, '2022-06-17', '2022-06-18', 'rrrr', 1),
(40, 'Nguyen Le Hai Dang', NULL, NULL, '2022-06-01', '2022-06-01', '', 0),
(41, 'singsingmyblues', NULL, NULL, '2022-06-01', '2022-06-01', '', 0),
(42, 'naruto ', NULL, NULL, '2022-06-01', '2022-06-01', '', 0),
(46, 'Nguyen Le Hai Dang', NULL, NULL, '2022-06-01', '2022-06-01', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `schedulemeeting`
--

CREATE TABLE `schedulemeeting` (
  `id` int(11) NOT NULL,
  `timeMeeting` datetime DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `schedulereport`
--

CREATE TABLE `schedulereport` (
  `id` int(11) NOT NULL,
  `timeReport` date DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `report_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD KEY `group_id` (`group_id`);

--
-- Indexes for table `finalpointproject`
--
ALTER TABLE `finalpointproject`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FinalPointProject-Project` (`project_id`);

--
-- Indexes for table `group`
--
ALTER TABLE `group`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `meeting`
--
ALTER TABLE `meeting`
  ADD PRIMARY KEY (`id`),
  ADD KEY `scheduleMeeting_id` (`scheduleMeeting_id`);

--
-- Indexes for table `meetingrecord`
--
ALTER TABLE `meetingrecord`
  ADD PRIMARY KEY (`id`),
  ADD KEY `meeting_id` (`meeting_id`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`),
  ADD KEY `group_id` (`group_id`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `schedulemeeting`
--
ALTER TABLE `schedulemeeting`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Account-ScheduleMeeting` (`account_id`),
  ADD KEY `project_id` (`project_id`);

--
-- Indexes for table `schedulereport`
--
ALTER TABLE `schedulereport`
  ADD PRIMARY KEY (`id`),
  ADD KEY `account_id` (`account_id`),
  ADD KEY `report_id` (`report_id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Teacher-Project` (`project_id`),
  ADD KEY `Teacher-Account` (`account_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(111) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `report`
--
ALTER TABLE `report`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `schedulereport`
--
ALTER TABLE `schedulereport`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `meeting`
--
ALTER TABLE `meeting`
  ADD CONSTRAINT `meeting_ibfk_1` FOREIGN KEY (`scheduleMeeting_id`) REFERENCES `schedulemeeting` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `meetingrecord`
--
ALTER TABLE `meetingrecord`
  ADD CONSTRAINT `meetingrecord_ibfk_1` FOREIGN KEY (`meeting_id`) REFERENCES `meeting` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `project_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `schedulemeeting`
--
ALTER TABLE `schedulemeeting`
  ADD CONSTRAINT `schedulemeeting_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `schedulereport`
--
ALTER TABLE `schedulereport`
  ADD CONSTRAINT `schedulereport_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `schedulereport_ibfk_2` FOREIGN KEY (`report_id`) REFERENCES `report` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
