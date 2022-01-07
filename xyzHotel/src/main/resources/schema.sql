SET sql_mode = '';

CREATE TABLE if not exists `roomtype` (
    `roomTypeId` int NOT NULL AUTO_INCREMENT,
    `roomTypeName` varchar(255) DEFAULT NULL,
     PRIMARY KEY (`roomTypeId`)
);

CREATE TABLE if not exists  `roomcharge` (
     `roomChargeID` int NOT NULL AUTO_INCREMENT,
     `roomTypeID` int NOT NULL,
     `roomCapacityID` int NOT NULL,
     `roomCharge` decimal(19,2) DEFAULT NULL,
      PRIMARY KEY (`roomChargeID`)
);

CREATE TABLE if not exists `roomcapacity` (
     `roomCapacityID` int NOT NULL AUTO_INCREMENT,
     `capacity` int NOT NULL,
      PRIMARY KEY (`roomCapacityID`)
);

CREATE TABLE if not exists `room` (
    `roomNo` int NOT NULL AUTO_INCREMENT,
    `capacityID` int NOT NULL,
    `isReservation` bit(1) NOT NULL,
    `roomTypeId` int NOT NULL,
    PRIMARY KEY (`roomNo`)
    );

CREATE TABLE if not exists  `conferencehall` (
      `hallNo` int NOT NULL AUTO_INCREMENT,
      `capacity` int NOT NULL,
      `conferenceHallType` varchar(255) DEFAULT NULL,
      `isReservation` bit(1) NOT NULL,
       PRIMARY KEY (`hallNo`)
);

CREATE TABLE if not exists `reservationtype` (
    `reservationTypeId` int NOT NULL AUTO_INCREMENT,
    `reservationTypeName` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`reservationTypeId`)
);

CREATE TABLE if not exists `usertype` (
     `userTypeId` int NOT NULL AUTO_INCREMENT,
     `userType` varchar(255) DEFAULT NULL,
      PRIMARY KEY (`userTypeId`)
);

CREATE TABLE if not exists `paymentmethod` (
      `paymentMethodID` int NOT NULL AUTO_INCREMENT,
      `paymentMethodType` varchar(255) DEFAULT NULL,
      PRIMARY KEY (`paymentMethodID`)
);




