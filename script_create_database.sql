CREATE DATABASE `shopping_portal` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `client` (
  `idclient` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `phonenumber` varchar(15) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  PRIMARY KEY (`idclient`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

CREATE TABLE `product` (
  `idproduct` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`idproduct`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

CREATE TABLE `address_client` (
  `idaddress` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(60) DEFAULT NULL,
  `numberaddress` varchar(10) DEFAULT NULL,
  `reference` varchar(45) DEFAULT NULL,
  `district` varchar(30) DEFAULT NULL,
  `postalcode` varchar(9) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `stateabbreviation` varchar(2) DEFAULT NULL,
  `idclient` int(11) NOT NULL,
  PRIMARY KEY (`idaddress`),
  KEY `fk_address_client_idx` (`idclient`),
  CONSTRAINT `fk_address_client` FOREIGN KEY (`idclient`) REFERENCES `client` (`idclient`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;

CREATE TABLE `orders` (
  `idorder` int(11) NOT NULL AUTO_INCREMENT,
  `idclient` int(11) NOT NULL,
  `idaddress` int(11) NOT NULL,
  `orderdate` date DEFAULT NULL,
  `value` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`idorder`),
  KEY `FK_ORDER_CLIENT_idx` (`idclient`),
  KEY `FK_ORDER_ADDRESS_idx` (`idaddress`),
  CONSTRAINT `FK_ORDER_ADDRESS` FOREIGN KEY (`idaddress`) REFERENCES `address_client` (`idaddress`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ORDER_CLIENT` FOREIGN KEY (`idclient`) REFERENCES `client` (`idclient`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

CREATE TABLE `product_order` (
  `idproduct` int(11) NOT NULL,
  `idorder` int(11) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `value` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`idproduct`,`idorder`),
  KEY `FK_ORDER_idx` (`idorder`),
  CONSTRAINT `FK_ORDER` FOREIGN KEY (`idorder`) REFERENCES `orders` (`idorder`),
  CONSTRAINT `FK_PRODUCT` FOREIGN KEY (`idproduct`) REFERENCES `product` (`idproduct`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
