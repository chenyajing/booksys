# Host: localhost  (Version: 5.5.27)
# Date: 2018-05-01 20:44:53
# Generator: MySQL-Front 5.3  (Build 4.9)

/*!40101 SET NAMES utf8 */;

#
# Source for table "book"
#

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `pubDate` date DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "book"
#

INSERT INTO `book` VALUES (1,'红与黑',31.3,'司汤达','1830-07-28',1),(2,'苏菲的世界',28.5,'乔斯坦·贾德','1991-08-07',5),(3,'巴黎圣母院',15.6,'雨果','1513-01-14',2),(4,'简·爱',25.2,'夏洛蒂.勃朗特','1827-09-16',5),(5,'傲慢与偏见',35,'简·奥斯汀','2005-09-16',1),(6,'飘',26.5,'玛格丽特·米切尔','1936-09-23',1),(7,'诛仙',50,'萧鼎','2000-03-23',4);

#
# Source for table "category"
#

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "category"
#

INSERT INTO `category` VALUES (1,'文学'),(2,'历史'),(3,'科技'),(4,'仙侠'),(5,'言情');
