-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 21, 2018 at 05:05 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gradedunit`
--

-- --------------------------------------------------------

--
-- Table structure for table `basket`
--

CREATE TABLE `basket` (
  `item_number` int(3) NOT NULL,
  `description` varchar(50) NOT NULL,
  `price` int(6) NOT NULL,
  `quantity` int(5) NOT NULL,
  `total` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `basket`
--

INSERT INTO `basket` (`item_number`, `description`, `price`, `quantity`, `total`) VALUES
(2, 'DIMM 240-pin, 4GB Dual Rank, 1600 MHz / PC3-12800', 25, 3, 75);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `id` int(4) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `email` varchar(35) NOT NULL,
  `contact_number` varchar(11) NOT NULL,
  `address` varchar(25) NOT NULL,
  `post_code` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `first_name`, `last_name`, `email`, `contact_number`, `address`, `post_code`) VALUES
(1, 'Liam', 'Carr', 'thisisliam@gmail.com', '07854698326', '16 this street', 'EH510PU'),
(2, 'Aiden', 'Stokes', 'thisisAiden@gmail.com', '12345678913', '17 this street', 'EH511PU'),
(4, 'Tazme', 'Stewart', 'tazste@hotmail.com', '07869528362', '23 House Cresent', 'SE6 3HA'),
(5, 'Lawrence ', 'Cotzee', 'cotzee03@gmail.com', '04859363252', '23 Apparement Buliding', 'LL53 6UF'),
(6, 'Sven', 'Wilkie', 'dweller@gmail.com', '08369875145', '83 Dwell Cresent', 'CF32 8NG'),
(7, 'Wade', 'Ferreira', 'westcostwade@hotmail.com', '04784789987', '83 Shneef place', 'G61 2EP'),
(8, 'Clare', 'De lachaumette', 'dela@hotmail.com', '07847569325', '79 My house', 'SN3 1DY'),
(9, 'Morn', 'Flakes', 'flakes@gmail.com', '17854789653', '23 Billi Place', 'CF32 8NG'),
(10, 'Martin', 'Van kuik', 'kuiker@wealse.com', '07896547152', '54 trails street', 'NG24 1PG'),
(11, 'Nick', 'Van vuik', 'nick@siren.com', '07856452396', '45 Peel Place', 'SW12 8PZ'),
(13, 'Scott', 'Graham', 'scogra@yahoo.co.uk', '05632452986', '79 Graham Cres', 'TN28 8EA'),
(14, 'Finlay', 'Arthur', 'arthurfin@thismail.com', '07895648523', '79 Dundee house', 'PA61 7YS'),
(16, 'Bob', 'Marley', 'wejammin@mail.com', '42056987420', 'Dagga Street', 'DD5 2TN'),
(19, 'Sheldon', 'Champman', 'battleship@gmail.com', '07859632145', '29 The Battle Has Arrived', 'EH29 9JK'),
(26, 'Bigbob', 'Bob', 'bob@bob.com', '05698745635', '15 Bob Street', 'Eh51 0PO'),
(30, 'Awe', 'Awae', 'awe@awe', '17856985695', '12 Awe', 'eh510ht'),
(31, 'Wade', 'Ferreria', 'awe@awe', '07856985625', '12 Aawe', 'eh510ht'),
(32, 'Calum', 'Arthur', 'calum.@com', '78569856325', '15 this street', 'eh510po'),
(33, 'Peter', 'Piet', 'peit@peit.com', '07856987451', '17 This street', 'eh51 0pl'),
(34, 'Bob', 'Bob', 'awe@awe', '07856985636', '12 asas', 'eh510ht'),
(35, 'Bob', 'Bob', 'awe@awe', '78569856363', '15 this ', 'eh510ht'),
(36, 'Laura', 'Samon', 'awe@awe', '01598620514', '22 this street', 'eh510ht');

-- --------------------------------------------------------

--
-- Table structure for table `customers_history`
--

CREATE TABLE `customers_history` (
  `id` int(4) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `email` varchar(35) NOT NULL,
  `contact_number` varchar(11) NOT NULL,
  `address` varchar(25) NOT NULL,
  `post_code` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers_history`
--

INSERT INTO `customers_history` (`id`, `first_name`, `last_name`, `email`, `contact_number`, `address`, `post_code`) VALUES
(1, 'Liam', 'Carr', 'thisisliam@gmail.com', '07854698326', '16 this street', 'EH510PU'),
(2, 'Aiden', 'Stokes', 'thisisAiden@gmail.com', '12345678913', '17 this street', 'EH511PU'),
(4, 'Tazme', 'Stewart', 'tazste@hotmail.com', '07869528362', '23 House Cresent', 'SE6 3HA'),
(5, 'Lawrence ', 'Cotzee', 'cotzee03@gmail.com', '04859363252', '23 Apparement Buliding', 'LL53 6UF'),
(6, 'Sven', 'Wilkie', 'dweller@gmail.com', '08369875145', '83 Dwell Cresent', 'CF32 8NG'),
(8, 'Clare', 'De lachaumette', 'dela@hotmail.com', '07847569325', '79 My house', 'SN3 1DY'),
(9, 'Morn', 'Flakes', 'flakes@gmail.com', '17854789653', '23 Billi Place', 'CF32 8NG'),
(10, 'Peter', 'Van kuik', 'kuiker@wealse.com', '07896547152', '54 trails street', 'NG24 1PG'),
(11, 'Nick', 'Van vuik', 'nick@siren.com', '07856452396', '45 Peel Place', 'SW12 8PZ'),
(13, 'Scott', 'Graham', 'scogra@yahoo.co.uk', '12345678910', '79 Graham Cres', 'TN28 8EA'),
(14, 'Finlay', 'Arthur', 'arthurfin@thismail.com', '07895648523', '79 Dundee houses', 'PA61 7YS'),
(16, 'Bob', 'Marley', 'wejammin@mail.com', '42056987420', 'Dagga Street', 'DD5 2TN'),
(19, 'Sheldon', 'Champmans', 'battleship@gmail.com', '07859632145', '29 The Battle Has Arrive', 'EH29 9JK');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `id` int(4) NOT NULL,
  `stock_amount` int(3) NOT NULL,
  `unit_cost` int(5) NOT NULL,
  `supplier_id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`id`, `stock_amount`, `unit_cost`, `supplier_id`) VALUES
(1, 45, 50, 1),
(2, 40, 20, 1),
(3, 39, 50, 1),
(4, 37, 25, 1),
(5, 39, 100, 1),
(6, 43, 35, 1),
(7, 44, 70, 1),
(8, 50, 20, 1),
(9, 1, 50, 1);

-- --------------------------------------------------------

--
-- Table structure for table `invoices`
--

CREATE TABLE `invoices` (
  `id` int(3) NOT NULL,
  `staff_id` int(3) NOT NULL,
  `cust_id` int(3) NOT NULL,
  `prod_id` int(3) NOT NULL,
  `quantity` int(4) NOT NULL,
  `total` int(6) NOT NULL,
  `discount` int(3) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoices`
--

INSERT INTO `invoices` (`id`, `staff_id`, `cust_id`, `prod_id`, `quantity`, `total`, `discount`, `date`) VALUES
(1, 2, 2, 4, 2, 64, 0, '2018-04-01'),
(1, 2, 2, 5, 3, 510, 0, '2018-04-01'),
(2, 6, 2, 5, 2, 340, 0, '2018-04-28'),
(2, 6, 2, 8, 1, 33, 0, '2018-04-28'),
(3, 4, 6, 2, 4, 100, 0, '2018-04-30'),
(3, 4, 6, 6, 3, 135, 0, '2018-04-30'),
(3, 4, 6, 9, 1, 76, 0, '2018-04-30'),
(4, 4, 7, 2, 2, 50, 0, '2018-04-30'),
(4, 4, 7, 4, 2, 64, 0, '2018-04-30'),
(5, 4, 13, 5, 2, 340, 0, '2018-04-30'),
(5, 4, 13, 6, 3, 135, 0, '2018-04-30'),
(6, 6, 8, 1, 1, 85, 0, '2018-04-30'),
(6, 6, 8, 4, 3, 96, 0, '2018-04-30'),
(6, 6, 8, 6, 2, 90, 0, '2018-04-30'),
(7, 6, 10, 3, 1, 66, 0, '2018-05-01'),
(7, 6, 10, 5, 1, 170, 0, '2018-05-01'),
(7, 6, 10, 9, 3, 228, 0, '2018-05-01'),
(8, 6, 5, 4, 4, 128, 0, '2018-05-01'),
(8, 6, 5, 6, 1, 45, 0, '2018-05-01'),
(9, 6, 11, 1, 1, 85, 0, '2018-05-01'),
(9, 6, 11, 4, 2, 64, 0, '2018-05-01'),
(9, 6, 11, 7, 2, 188, 0, '2018-05-01'),
(10, 6, 16, 1, 1, 85, 0, '2018-05-01'),
(10, 6, 16, 2, 2, 50, 0, '2018-05-01'),
(10, 6, 16, 3, 3, 198, 0, '2018-05-01'),
(11, 6, 1, 2, 1, 25, 0, '2018-05-01'),
(11, 6, 1, 3, 2, 132, 0, '2018-05-01'),
(11, 6, 1, 7, 1, 94, 0, '2018-05-01'),
(12, 6, 14, 2, 1, 25, 0, '2018-05-01'),
(12, 6, 14, 4, 1, 32, 0, '2018-05-01'),
(12, 6, 14, 5, 1, 170, 0, '2018-05-01'),
(13, 6, 2, 4, 2, 64, 0, '2018-05-01'),
(14, 4, 13, 1, 2, 170, 0, '2018-05-02'),
(14, 4, 13, 3, 1, 66, 0, '2018-05-02'),
(14, 4, 13, 5, 1, 170, 0, '2018-05-02'),
(15, 4, 2, 7, 2, 188, 0, '2018-05-02'),
(15, 4, 2, 9, 1, 76, 0, '2018-05-02'),
(16, 4, 4, 2, 2, 50, 0, '2018-05-02'),
(16, 4, 4, 5, 4, 680, 0, '2018-05-02'),
(17, 4, 8, 2, 1, 25, 0, '2018-05-02'),
(17, 4, 8, 3, 1, 66, 0, '2018-05-02'),
(17, 4, 8, 7, 1, 94, 0, '2018-05-02'),
(18, 4, 2, 6, 1, 45, 0, '2018-05-03'),
(19, 4, 2, 3, 2, 132, 0, '2018-05-08'),
(19, 4, 2, 5, 1, 170, 0, '2018-05-08'),
(20, 4, 16, 2, 1, 25, 0, '2018-05-08'),
(20, 4, 16, 4, 1, 32, 0, '2018-05-08'),
(21, 4, 2, 2, 1, 25, 0, '2018-05-08'),
(21, 4, 2, 5, 1, 170, 0, '2018-05-08');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(4) NOT NULL,
  `name` varchar(25) NOT NULL,
  `description` varchar(50) NOT NULL,
  `category` varchar(25) NOT NULL,
  `price` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `description`, `category`, `price`) VALUES
(1, 'Crucial ', 'Memory Type DDR4, Form Factor: UDIMM, 8GB Single ', 'Memory', 85),
(2, 'Xenta ', 'DIMM 240-pin, 4GB Dual Rank, 1600 MHz / PC3-12800', 'Memory', 25),
(3, 'Silicon Power', '288Pin UDIMM without ECC, 2133 MHz  8GB', 'Memory', 66),
(4, 'Crucial ', 'PC3-12800, DDR3, 1600MHZ, 4GB', 'Memory', 32),
(5, 'Corsair Vengeance ', '2400MHz DDR4 C14 , 8GB', 'Memory', 170),
(6, 'Crucial Ballistix', '4GB, DDR4 PC4-19200, 2400 MT/S', 'Memory', 45),
(7, 'HyperX Fury Black', 'DDR4, 2133MHz, 8GB', 'Memory', 94),
(8, 'Kingston', '4GB DDR3 1333MHz Memory', 'Memory', 33),
(9, 'Corsair Memory', '8GB 2400MHz DDR4 CL15 DIMM ', 'Memory', 76);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `ID` int(3) NOT NULL,
  `First_name` varchar(25) NOT NULL,
  `Last_name` varchar(25) NOT NULL,
  `Username` varchar(25) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Blocked` tinyint(1) NOT NULL,
  `Admin` tinyint(1) NOT NULL,
  `Contact_number` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`ID`, `First_name`, `Last_name`, `Username`, `Password`, `Blocked`, `Admin`, `Contact_number`) VALUES
(1, 'Calum', 'Arthur', 'Calum1', '12345', 0, 1, '11111111111'),
(2, 'Staff', 'Staff', 'Staff2', '12345', 0, 0, '11111111111'),
(4, 'Martin', 'Scott', 'Martin4', 'password', 0, 0, '01506822569'),
(5, 'Liam', 'Bell', 'Liam5', 'thispass', 0, 0, '07859635204'),
(6, 'Andrew', 'Lambert', 'Andrew6', 'andlam', 0, 0, '08254179865'),
(7, 'Jamie', 'Cameron', 'Jamie7', 'andlam', 0, 0, '01806974875'),
(8, 'Cameron', 'Delport', 'Cameron8', 'portcam', 0, 0, '07963589452'),
(9, 'Susan', 'Smith', 'Susan9', 'smith', 0, 0, '07859745333'),
(10, 'Bob', 'William', 'Bob10', 'willibob', 0, 0, '07895625874'),
(15, 'Bob', 'Builder', 'Bob15', 'asdasd', 0, 0, '07856987545'),
(16, 'Bob', 'Bob', 'Bob16', 'password', 0, 0, '07895698754'),
(17, 'Bob', 'Bob', 'Bob17', 'password', 0, 0, '18759865254'),
(18, 'Bob', 'Bob', 'Bob18', 'password', 0, 0, '18759865254'),
(19, 'Bopb', 'Bob', 'Bopb19', 'password', 0, 0, '07898563624'),
(20, 'Bob', 'Bob', 'Bob20', 'password', 0, 0, '07856987452'),
(21, 'Bob', 'Bob', 'Bob21', 'password', 0, 0, '07856951745'),
(22, 'Bob', 'Bob', 'Bob22', 'password', 0, 0, '07856951745'),
(23, 'Yob', 'Yob', 'Yob23', 'password', 0, 0, '07856974521'),
(24, 'Bob', 'Bob', 'Bob24', 'a123', 0, 0, '18759685647'),
(25, 'Cameron', 'Boyle', 'peter', 'A123', 0, 0, '08789548752'),
(26, 'Bob', 'Bob', 'peter', 'y123', 0, 0, '07856985465');

-- --------------------------------------------------------

--
-- Table structure for table `staffhistory`
--

CREATE TABLE `staffhistory` (
  `ID` int(3) NOT NULL,
  `First_name` varchar(25) NOT NULL,
  `Last_name` varchar(25) NOT NULL,
  `Username` varchar(25) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Blocked` tinyint(1) NOT NULL,
  `Admin` tinyint(1) NOT NULL,
  `Contact_number` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staffhistory`
--

INSERT INTO `staffhistory` (`ID`, `First_name`, `Last_name`, `Username`, `Password`, `Blocked`, `Admin`, `Contact_number`) VALUES
(1, 'Calum', 'Arthur', 'Calum1', '12345', 0, 1, '11111111111'),
(4, 'Martin', 'Scott', 'Martin4', 'password', 0, 0, '01506822569'),
(5, 'Liam', 'Bell', 'Liam5', 'thispass', 0, 0, '07859635204'),
(6, 'Andrew', 'Lambert', 'Andrew6', 'password', 0, 0, '08254179865'),
(7, 'Jamie', 'Cameron', 'Jamie7', 'password', 0, 0, '01806974875'),
(8, 'Cameron', 'Delport', 'Cameron8', 'portcam', 0, 0, '07963589452'),
(17, 'Bob', 'Bob', 'bob', 'password', 0, 0, '18759865254'),
(21, 'Bob', 'Bob', 'bob', 'password22', 0, 0, '07856951745');

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `id` int(4) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `company_name` varchar(30) NOT NULL,
  `contact_number` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`id`, `first_name`, `last_name`, `company_name`, `contact_number`) VALUES
(1, 'Sean', 'Martrix', 'Matrix Computer Parts', '07850569874');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `basket`
--
ALTER TABLE `basket`
  ADD PRIMARY KEY (`item_number`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customers_history`
--
ALTER TABLE `customers_history`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`),
  ADD KEY `supplier_id` (`supplier_id`);

--
-- Indexes for table `invoices`
--
ALTER TABLE `invoices`
  ADD PRIMARY KEY (`id`,`prod_id`),
  ADD KEY `staff_id` (`staff_id`),
  ADD KEY `prod_id` (`prod_id`),
  ADD KEY `cust_id` (`cust_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`),
  ADD KEY `id_2` (`id`),
  ADD KEY `id_3` (`id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `staffhistory`
--
ALTER TABLE `staffhistory`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT for table `customers_history`
--
ALTER TABLE `customers_history`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `staffhistory`
--
ALTER TABLE `staffhistory`
  MODIFY `ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`id`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `inventory_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `invoices`
--
ALTER TABLE `invoices`
  ADD CONSTRAINT `invoices_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `invoices_ibfk_2` FOREIGN KEY (`cust_id`) REFERENCES `customers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `invoices_ibfk_3` FOREIGN KEY (`prod_id`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
