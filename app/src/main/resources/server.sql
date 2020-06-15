
CREATE DATABASE IF NOT EXISTS servers_db;

USE servers_db;

DROP TABLE IF EXISTS server_tb;

CREATE TABLE server_tb(
--id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
ip_address VARCHAR(15) NOT NULL,
os_details VARCHAR(7) NOT NULL,
location VARCHAR(10) NOT NULL
);
 INSERT INTO server_tb VALUES
 ('12.12.89.23','Windows','Palo Alto'),
 ('23.1.23.19','Linux','Palo Alto'),
 ('23.83.48.12','Windows','Texas'),
 ('89.1.2.3','Linux','New Jersey'),
 ('10.2.3.12','Windows','Texas'),
 ('255.255.255.255','Linux','New Jersey'),
 ('231.21.12.38','Linux','New Jersey'),
 ('21.82.231.29','Windows','Palo Alto'),
 ('49.21.34.89','Linux','Texas'),
 ('1.3.89.2','Windows','Palo Alto'),
 ('29.245.21.28','Linux','New Jersey'),
 ('23.123.89.21','Windows','Texas'),
 ('23.89.47.123','Linux','Palo Alto'),
 ('34.21.48.82','Windows','New Jersey'),
 ('84.21.48.23','Linux','Texas'),
 ('112.23.8.2','Windows','New Jersey'),
 ('21.38.29.21','Linux','Palo Alto'),
 ('21.23.42.21','Windows','Texas'),
 ('92.22.48.21','Linux','New Jersey'),
 ('2.32.8.21','Windows','Texas');

--INSERT INTO server_tb VALUES
--(1,'12.12.89.23','Windows','Palo Alto'),
--(2,'23.1.23.19','Linux','Palo Alto'),
--(3,'23.83.48.12','Windows','Texas'),
--(4,'89.1.2.3','Linux','New Jersey'),
--(5,'10.2.3.12','Windows','Texas'),
--(6,'255.255.255.255','Linux','New Jersey'),
--(7,'231.21.12.38','Linux','New Jersey'),
--(8,'21.82.231.29','Windows','Palo Alto'),
--(9,'49.21.34.89','Linux','Texas'),
--(10,'1.3.89.2','Windows','Palo Alto'),
--(11,'29.245.21.28','Linux','New Jersey'),
--(12,'23.123.89.21','Windows','Texas'),
--(13,'23.89.47.123','Linux','Palo Alto'),
--(14,'34.21.48.82','Windows','New Jersey'),
--(15,'84.21.48.23','Linux','Texas'),
--(16,'112.23.8.2','Windows','New Jersey'),
--(17,'21.38.29.21','Linux','Palo Alto'),
--(18,'21.23.42.21','Windows','Texas'),
--(19,'92.22.48.21','Linux','New Jersey'),
--(20,'2.32.8.21','Windows','Texas');

SELECT * FROM server_tb;