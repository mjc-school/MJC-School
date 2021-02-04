CREATE TABLE gift_certificate (
  id int AUTO_INCREMENT ,
  name varchar(32) NOT NULL,
  description varchar(128) NOT NULL,
  price decimal(10,2) NOT NULL,
  duration int NOT NULL,
  create_date timestamp NULL DEFAULT NULL,
  last_update_date timestamp NULL DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id (id)
);

INSERT INTO gift_certificate
(id, name,description,price,duration,create_date,last_update_date) VALUES (1, 'SpaCertificate', 'SpaCertificate for 2 person', 100, 40, '2021-01-20 12:27:55', '2021-01-20 12:27:55');
INSERT INTO gift_certificate
(id, name,description,price,duration,create_date,last_update_date) VALUES (2, 'SportCertificate', 'SportCertificate for 4 person', 100, 40, '2021-01-20 12:27:55', '2021-01-20 12:27:55');
INSERT INTO gift_certificate
(id, name,description,price,duration,create_date,last_update_date) VALUES (3, 'DanceCertificate', 'DanceCertificate for 2 person', 100, 40, '2021-01-20 12:27:55', '2021-01-20 12:27:55');
INSERT INTO gift_certificate
(id, name,description,price,duration,create_date,last_update_date) VALUES (4, 'KidsCertificate', 'KidsCertificate for 2 person', 100, 40, '2021-01-20 12:27:55', '2021-01-20 12:27:55');

CREATE TABLE tag (
  id int AUTO_INCREMENT PRIMARY KEY ,
  nameTag varchar(32)

);

INSERT INTO tag (id, nameTag) VALUES (1, 'spa');
INSERT INTO tag (id, nameTag) VALUES (2, 'relax');
INSERT INTO tag (id, nameTag) VALUES (3, 'sport');
INSERT INTO tag (id, nameTag) VALUES (4, 'dance');
INSERT INTO tag (id, nameTag) VALUES (5, 'twist');
INSERT INTO tag (id, nameTag) VALUES (6, 'children');

CREATE TABLE gift_certificate_has_tag (
  gift_certicicate_id_gift_certicicate int NOT NULL,
  tag_id_tag int NOT NULL,
  CONSTRAINT gift_certificate_has_tag_ibfk_1 FOREIGN KEY (gift_certicicate_id_gift_certicicate) REFERENCES gift_certificate (id) ON DELETE CASCADE,
  CONSTRAINT gift_certificate_has_tag_ibfk_2 FOREIGN KEY (tag_id_tag) REFERENCES tag (id) ON DELETE CASCADE
);

INSERT INTO gift_certificate_has_tag (gift_certicicate_id_gift_certicicate, tag_id_tag) VALUES (1, 1);
INSERT INTO gift_certificate_has_tag (gift_certicicate_id_gift_certicicate, tag_id_tag) VALUES (1, 2);
INSERT INTO gift_certificate_has_tag (gift_certicicate_id_gift_certicicate, tag_id_tag) VALUES (2, 3);
INSERT INTO gift_certificate_has_tag (gift_certicicate_id_gift_certicicate, tag_id_tag) VALUES (3, 3);
INSERT INTO gift_certificate_has_tag (gift_certicicate_id_gift_certicicate, tag_id_tag) VALUES (3, 4);
INSERT INTO gift_certificate_has_tag (gift_certicicate_id_gift_certicicate, tag_id_tag) VALUES (3, 5);
INSERT INTO gift_certificate_has_tag (gift_certicicate_id_gift_certicicate, tag_id_tag) VALUES (4, 6);






    