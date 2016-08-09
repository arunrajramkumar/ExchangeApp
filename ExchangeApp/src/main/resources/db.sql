CREATE TABLE `exchange_rate_details` (
  `ID` int(10) NOT NULL,
  `CURRENCY_NAME` varchar(20) NOT NULL,
  `VALUE_FOR_USD` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exchange_rate_details`
--

INSERT INTO `exchange_rate_details` (`ID`, `CURRENCY_NAME`, `VALUE_FOR_USD`) VALUES
(1, 'INR', 68.2),
(2, 'AED', 3.673039),
(3, 'EUR', 0.898242),
(4, 'GBP', 0.683926),
(5, 'HTG', 59.434525);
