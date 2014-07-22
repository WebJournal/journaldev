CREATE TABLE `User` (
  `user_id` varchar(10) NOT NULL DEFAULT '',
  `password` varchar(40) NOT NULL DEFAULT '',
  `name` varchar(40) NOT NULL DEFAULT '',
  `email` varchar(40) NOT NULL DEFAULT '',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `User` (`user_id`, `password`, `name`, `email`)
VALUES
	('pankaj', 'pankaj123', 'Pankaj Kumar', 'pankaj@journaldev.com');
