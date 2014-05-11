CREATE TABLE `Transaction` (
  `txn_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `txn_date` date NOT NULL,
  `txn_total` decimal(10,0) NOT NULL,
  PRIMARY KEY (`txn_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

CREATE TABLE `Customer` (
  `txn_id` int(11) unsigned NOT NULL,
  `cust_name` varchar(20) NOT NULL DEFAULT '',
  `cust_email` varchar(20) DEFAULT NULL,
  `cust_address` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`txn_id`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`txn_id`) REFERENCES `Transaction` (`txn_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;