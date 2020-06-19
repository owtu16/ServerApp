
CREATE DATABASE IF NOT EXISTS servers_db;

USE servers_db;

DROP TABLE IF EXISTS server_tb;
DROP TABLE IF EXISTS user_tb;

CREATE TABLE server_tb(
server_id INT(11) NOT NULL AUTO_INCREMENT,
ip_address VARCHAR(20) NOT NULL,
os_details VARCHAR(20) NOT NULL,
location VARCHAR(20) NOT NULL,
PRIMARY KEY(server_id)
);

CREATE TABLE user_tb(
user_id INT(11) NOT NULL AUTO_INCREMENT,
username VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
PRIMARY KEY(user_id)
);

INSERT INTO user_tb(username,password) VALUES
('admin','admin'),
('readonly','readonly');

 INSERT INTO server_tb(ip_address,os_details,location) VALUES
 ('192.168.1.1','Windows','Palo Alto'),
 ('192.168.1.2','Linux','Palo Alto'),
 ('192.168.1.3','Windows','Texas'),
 ('192.168.1.4','Linux','New Jersey'),
 ('192.168.1.5','Windows','Texas'),
 ('192.168.1.6','Linux','New Jersey'),
 ('192.168.1.7','Linux','New Jersey'),
 ('192.168.1.8','Windows','Palo Alto'),
 ('192.168.1.9','Linux','Texas'),
 ('192.168.1.10','Windows','Palo Alto'),
 ('192.168.1.11','Linux','New Jersey'),
 ('192.168.1.12','Windows','Texas'),
 ('192.168.1.13','Linux','Palo Alto'),
 ('192.168.1.14','Windows','New Jersey'),
 ('192.168.1.15','Linux','Texas'),
 ('192.168.1.16','Windows','New Jersey'),
 ('192.168.1.17','Linux','Palo Alto'),
 ('192.168.1.18','Windows','Texas'),
 ('192.168.1.19','Linux','New Jersey'),
 ('192.168.1.20','Windows','Texas');

SELECT * FROM server_tb;
SELECT * FROM user_tb;