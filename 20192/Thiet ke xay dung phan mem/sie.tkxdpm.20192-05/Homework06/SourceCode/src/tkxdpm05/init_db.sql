DROP DATABASE IF EXISTS `TKXDPMTEST`;
CREATE DATABASE `TKXDPMTEST`;
USE `TKXDPMTEST`;

DROP TABLE IF EXISTS `Provide`;
DROP TABLE IF EXISTS `ListImportOrder`;
DROP TABLE IF EXISTS `ListSaleOrder`;
DROP TABLE IF EXISTS `ImportOrder`;
DROP TABLE IF EXISTS `SaleOrder`;
DROP TABLE IF EXISTS `Merchandise`;
DROP TABLE IF EXISTS `Site`;
DROP TABLE IF EXISTS `User`;

CREATE TABLE `Merchandise`(
`merchandiseId` int(10) AUTO_INCREMENT ,
`dispName` varchar(255) CHARACTER SET utf8,
`describe` varchar(255) CHARACTER SET utf8,
`unit` varchar(255) CHARACTER SET utf8,
`note` varchar(255) CHARACTER SET utf8,
`price` int(10),
PRIMARY KEY (`merchandiseId`)
) AUTO_INCREMENT = 100000;

CREATE TABLE `Site`	(
	`siteId` int(10) AUTO_INCREMENT,
	`dispName` varchar(255) CHARACTER SET utf8,
	`address` varchar(255) CHARACTER SET utf8,
	`shipDay` int(10),
	`airDay` int(10),
	`other` varchar(255) CHARACTER SET utf8,
	PRIMARY KEY (`siteId`)
)AUTO_INCREMENT = 200000;

CREATE TABLE `Provide`	(
	`provideId` int(10) AUTO_INCREMENT,
	`siteId` int(10),
	`merchandiseId` int(10),
	`instock` int(10),
	PRIMARY KEY (`provideId`),
	CONSTRAINT `FK_Site_Provide` FOREIGN KEY (`siteId`) REFERENCES `Site` (`siteId`) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT `FK_Merchandise_Provide` FOREIGN KEY (`merchandiseId`) REFERENCES `Merchandise` (`merchandiseId`) ON DELETE SET NULL ON UPDATE CASCADE	
) AUTO_INCREMENT = 300000;


CREATE TABLE `SaleOrder`(
	`saleOrderId` int(10) AUTO_INCREMENT,
	`status` varchar(255),
	`deliveryDesired` varchar(255),
	PRIMARY KEY (`saleOrderId`)
) AUTO_INCREMENT = 400000;


CREATE TABLE `SaleOrderDetail`	(
	`saleOrderDetailId` int(10) AUTO_INCREMENT,
	`saleOrderId` int(10),
	`merchandiseId` int(10),
	`quantity` int(10),
	PRIMARY KEY (`saleOrderDetailId`),
	CONSTRAINT `FK_Merchandise_SaleOrderDetail` FOREIGN KEY (`merchandiseId`) REFERENCES `Merchandise` (`merchandiseId`) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT `FK_SaleOrder_SaleOrderDetail` FOREIGN KEY (`saleOrderId`) REFERENCES `SaleOrder` (`saleOrderId`) ON DELETE SET NULL ON UPDATE CASCADE
) AUTO_INCREMENT = 500000;

CREATE TABLE `ImportOrder`(
	`importOrderId` int(10) AUTO_INCREMENT,
	`saleOrderId` int(10),
	`status` varchar(255),
	`deliveryMean` varchar(255),
	`siteId` int(10),
	`merchandiseId` int(10),
	`quantity` int(10),
	PRIMARY KEY (`importOrderId`),
	CONSTRAINT `FK_Site_ImportOrder` FOREIGN KEY (`siteId`) REFERENCES `Site` (`siteId`) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT `FK_Merchandise_ImportOrder` FOREIGN KEY (`merchandiseId`) REFERENCES `Merchandise` (`merchandiseId`) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT `FK_SaleOrder_ImportOrder` FOREIGN KEY (`saleOrderId`) REFERENCES `SaleOrder` (`saleOrderId`) ON DELETE SET NULL ON UPDATE CASCADE	
) AUTO_INCREMENT = 600000;

INSERT INTO `Merchandise` (`merchandiseId`, `dispName`, `describe`, `unit`, `note`, `price`) VALUES (100001, 'But bi', 'Delectus est corporis doloremque id repudiandae molestias.', 'voluptates', 'Harum maiores eum consequatur. Neque harum voluptatem eligendi sunt nisi.', 420148);
INSERT INTO `Merchandise` (`merchandiseId`, `dispName`, `describe`, `unit`, `note`, `price`) VALUES (100002, 'But muc', 'Consectetur aut perspiciatis quae perferendis facilis.', 'molestiae', 'Iste ut rerum omnis id minus. Sint officia cum voluptates sequi et provident qui. Atque maiores itaque ad. Odio velit dolorem eum nulla est id et.', 832752);
INSERT INTO `Merchandise` (`merchandiseId`, `dispName`, `describe`, `unit`, `note`, `price`) VALUES (100003, 'But nuoc', 'Animi est commodi deserunt quod.', 'consequatur', 'Exercitationem qui eaque dicta mollitia facere ipsa optio. Eius facere ab velit quisquam voluptatem unde. Quas voluptatem nihil blanditiis mollitia reiciendis. Qui dolorem debitis animi ut rerum doloremque aperiam.', 222149);
INSERT INTO `Merchandise` (`merchandiseId`, `dispName`, `describe`, `unit`, `note`, `price`) VALUES (100004, 'But may', 'Mollitia enim quos error et animi doloribus magni.', 'non', 'Voluptas autem quaerat ut quia nisi. Tenetur iure tenetur temporibus illo. Magnam itaque ea quaerat porro. Sed excepturi cumque voluptatem ullam necessitatibus.', 681435);
INSERT INTO `Merchandise` (`merchandiseId`, `dispName`, `describe`, `unit`, `note`, `price`) VALUES (100005, 'But mau', 'Cumque officiis corporis qui nemo est neque.', 'nam', 'Nihil debitis excepturi odit et velit fuga et. Corporis facere sint optio velit. Exercitationem facilis aperiam voluptates cupiditate rerum dolores commodi nobis. Vel cumque rerum accusantium vero.', 108041);

INSERT INTO `Site` (`siteId`, `dispName`, `address`, `shipDay`, `airDay`, `other`) VALUES (200001, 'Hayes-Kiehn', '4726 Thiel Terrace\nSchoenville, NH 13023-9896', 8, 9, 'Et perspiciatis eos adipisci quas autem explicabo quae.');
INSERT INTO `Site` (`siteId`, `dispName`, `address`, `shipDay`, `airDay`, `other`) VALUES (200002, 'Jaskolski LLC', '50888 Leda Estate\nRunolfssonfort, IN 52192', 4, 7, 'Inventore est sunt est aut.');
INSERT INTO `Site` (`siteId`, `dispName`, `address`, `shipDay`, `airDay`, `other`) VALUES (200003, 'Ebert-Walker', '43793 Cassin Ridges Suite 137\nNorth Agnes, AK 23422-8384', 7, 7, 'Culpa nesciunt eos beatae a aut eos id qui.');
INSERT INTO `Site` (`siteId`, `dispName`, `address`, `shipDay`, `airDay`, `other`) VALUES (200004, 'Nicolas-Stamm', '024 Emmerich Glens\nSpencerport, NE 87600-7558', 9, 1, 'Beatae velit ipsum officiis officia harum ipsa possimus.');
INSERT INTO `Site` (`siteId`, `dispName`, `address`, `shipDay`, `airDay`, `other`) VALUES (200005, 'Casper Inc', '9628 Amos Turnpike\nWest Imogene, KS 91645-8638', 1, 6, 'Ex eum quia sequi omnis consectetur quidem.');

INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300001, 200001, 100001, 32);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300002, 200002, 100001, 63);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300003, 200003, 100001, 15);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300004, 200004, 100001, 36);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300005, 200005, 100001, 77);

INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300011, 200001, 100002, 31);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300012, 200002, 100002, 62);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300013, 200003, 100002, 13);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300014, 200004, 100002, 34);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300015, 200005, 100002, 75);

INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300021, 200001, 100003, 93);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300022, 200002, 100003, 86);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300023, 200003, 100003, 71);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300024, 200004, 100003, 53);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300025, 200005, 100003, 47);

INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300031, 200001, 100004, 43);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300032, 200002, 100004, 66);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300033, 200003, 100004, 81);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300034, 200004, 100004, 93);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300035, 200005, 100004, 17);

INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300041, 200001, 100005, 23);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300042, 200002, 100005, 63);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300043, 200003, 100005, 14);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300044, 200004, 100005, 63);
INSERT INTO `Provide` (`provideId`, `siteId`, `merchandiseId`, `instock`) VALUES (300045, 200005, 100005, 87);


INSERT INTO `SaleOrder` (`saleOrderId`, `status`, `deliveryDesired`) VALUES (400001, 'NEW', '2011-01-31');
INSERT INTO `SaleOrder` (`saleOrderId`, `status`, `deliveryDesired`) VALUES (400002, 'NEW', '2003-05-12');
INSERT INTO `SaleOrder` (`saleOrderId`, `status`, `deliveryDesired`) VALUES (400003, 'NEW', '1974-10-23');
INSERT INTO `SaleOrder` (`saleOrderId`, `status`, `deliveryDesired`) VALUES (400004, 'NEW', '2010-05-15');

INSERT INTO `SaleOrderDetail` (`saleOrderDetailId`, `saleOrderId`, `merchandiseId`, `quantity`) VALUES (500001, 400001, 100001, 10);
INSERT INTO `SaleOrderDetail` (`saleOrderDetailId`, `saleOrderId`, `merchandiseId`, `quantity`) VALUES (500002, 400001, 100002, 4);
INSERT INTO `SaleOrderDetail` (`saleOrderDetailId`, `saleOrderId`, `merchandiseId`, `quantity`) VALUES (500003, 400001, 100003, 8);
INSERT INTO `SaleOrderDetail` (`saleOrderDetailId`, `saleOrderId`, `merchandiseId`, `quantity`) VALUES (500004, 400001, 100004, 7);
INSERT INTO `SaleOrderDetail` (`saleOrderDetailId`, `saleOrderId`, `merchandiseId`, `quantity`) VALUES (500005, 400001, 100005, 5);

INSERT INTO `SaleOrderDetail` (`saleOrderDetailId`, `saleOrderId`, `merchandiseId`, `quantity`) VALUES (500012, 400002, 100002, 4);
INSERT INTO `SaleOrderDetail` (`saleOrderDetailId`, `saleOrderId`, `merchandiseId`, `quantity`) VALUES (500013, 400002, 100003, 3);
INSERT INTO `SaleOrderDetail` (`saleOrderDetailId`, `saleOrderId`, `merchandiseId`, `quantity`) VALUES (500014, 400002, 100004, 10);
INSERT INTO `SaleOrderDetail` (`saleOrderDetailId`, `saleOrderId`, `merchandiseId`, `quantity`) VALUES (500015, 400002, 100005, 10);
INSERT INTO `SaleOrderDetail` (`saleOrderDetailId`, `saleOrderId`, `merchandiseId`, `quantity`) VALUES (500021, 400003, 100001, 5);
INSERT INTO `SaleOrderDetail` (`saleOrderDetailId`, `saleOrderId`, `merchandiseId`, `quantity`) VALUES (500022, 400003, 100002, 8);
INSERT INTO `SaleOrderDetail` (`saleOrderDetailId`, `saleOrderId`, `merchandiseId`, `quantity`) VALUES (500023, 400003, 100003, 3);
INSERT INTO `SaleOrderDetail` (`saleOrderDetailId`, `saleOrderId`, `merchandiseId`, `quantity`) VALUES (500024, 400003, 100004, 8);

INSERT INTO `SaleOrderDetail` (`saleOrderDetailId`, `saleOrderId`, `merchandiseId`, `quantity`) VALUES (500031, 400004, 100001, 10);
INSERT INTO `SaleOrderDetail` (`saleOrderDetailId`, `saleOrderId`, `merchandiseId`, `quantity`) VALUES (500032, 400004, 100002, 6);
INSERT INTO `SaleOrderDetail` (`saleOrderDetailId`, `saleOrderId`, `merchandiseId`, `quantity`) VALUES (500033, 400004, 100003, 8);


INSERT INTO `ImportOrder` (`importOrderId`, `saleOrderId`, `status`, `deliveryMean`, `siteId`, `merchandiseId`, `quantity`) VALUES (600001, 400001, 'NEW', '1970-09-14', 200001, 100001, 4);
INSERT INTO `ImportOrder` (`importOrderId`, `saleOrderId`, `status`, `deliveryMean`, `siteId`, `merchandiseId`, `quantity`) VALUES (600002, 400001, 'NEW', '2007-10-19', 200001, 100002, 4);
INSERT INTO `ImportOrder` (`importOrderId`, `saleOrderId`, `status`, `deliveryMean`, `siteId`, `merchandiseId`, `quantity`) VALUES (600003, 400001, 'NEW', '2019-10-24', 200001, 100003, 8);
INSERT INTO `ImportOrder` (`importOrderId`, `saleOrderId`, `status`, `deliveryMean`, `siteId`, `merchandiseId`, `quantity`) VALUES (600004, 400001, 'NEW', '1998-10-13', 200001, 100004, 7);
INSERT INTO `ImportOrder` (`importOrderId`, `saleOrderId`, `status`, `deliveryMean`, `siteId`, `merchandiseId`, `quantity`) VALUES (600005, 400001, 'NEW', '1973-09-26', 200001, 100005, 5);
