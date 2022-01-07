INSERT INTO roomtype(roomTypeId, roomTypeName)
VALUES ('1', 'Premier Beach Access Room'),
       ('2', 'Premier Ocean View Room'),
       ('3', 'Deluxe Ocean View Room'),
       ('4', 'Garden Pool Villa'),
       ('5', 'Ocean View Pool Villa'),
       ('6', 'Beach Pool Villa'),
       ('7', 'Two Bedroom Garden Pool Villa');

INSERT INTO roomCapacity(roomCapacityID, capacity)
VALUES ('1', '2'),
       ('2', '3'),
       ('3', '4'),
       ('4', '6');

INSERT INTO roomCharge(roomChargeID, roomTypeID, roomCapacityID, roomCharge)
VALUES ('1', '1','1','25000'),
       ('2', '1','2','30000'),
       ('3', '1','3','40000'),
       ('4', '2','1','50000'),
       ('5', '2','2','60000'),
       ('6', '2','3','70000'),
       ('7', '3','1','75000'),
       ('8', '3','2','80000'),
       ('9', '3','3','90000'),
       ('10','4','1','100000'),
       ('11', '4','2','140000'),
       ('12', '5','3','70000'),
       ('13', '5','4','165000'),
       ('14', '6','3','180000'),
       ('15', '6','4','200000'),
       ('16', '7','3','250000'),
       ('17', '7','4','300000');


INSERT INTO conferencehall(hallNo, capacity, conferenceHallType,isReservation)
VALUES ('1', '50', 'Verala',0),('2', '100', 'conference hall',0),
       ('3', '150', 'Wedding hall',0),('4', '10', 'Il Mare',0),
       ('5', '20', 'Meetings',0),('6', '300', 'Beach',0),
       ('7', '500', 'Garden',0);

INSERT INTO room(roomNo, capacityID, isReservation,roomTypeId)
VALUES ('1','1',0,'1'),('2','1',0,'1'),('3','3',0,'1'), ('4','3',0,'2'),
       ('5','3',0,'2'), ('6','1',0,'2'),('7','2',0,'2'),('8','2',0,'3'),
       ('9','3',0,'4'),('10','3',0,'5'),('11','2',0,'6'),('12','4',0,'6'),
       ('13','4',0,'7'),('14','4',0,'7'),('15','4',0,'8'),('16','4',0,'8');

INSERT INTO reservationtype(reservationTypeId, reservationTypeName)
VALUES ('1', 'Room'),('2', 'Hall');

INSERT INTO paymentmethod(paymentMethodID, paymentMethodType)
VALUES ('1', 'Card'),('2', 'Cash'),('3','Online Payment');

INSERT INTO usertype(userTypeId, userType)
VALUES ('1', 'admin'),('2', 'customer');





