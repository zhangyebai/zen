DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'autoincr id',
  `bookId` varchar(36) NOT NULL COMMENT 'only id of book',
  `author` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` int(10) unsigned zerofill NOT NULL DEFAULT '0000000001',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;