CREATE TABLE `Employee` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
 
INSERT INTO `Employee` (`id`, `name`, `role`, `insert_time`)
VALUES
    (3, 'Pankaj', 'CEO', now());
INSERT INTO `Employee` (`id`, `name`, `role`, `insert_time`)
VALUES
    (14, 'David', 'Developer', now());
