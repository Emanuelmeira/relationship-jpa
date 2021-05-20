DROP TABLE IF EXISTS CLIENTE;

CREATE TABLE CLIENTE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  year_old INT DEFAULT NULL
);

INSERT INTO CLIENTE (name, last_name, year_old) VALUES
  ('Aliko', 'Dangote', 62),
  ('Bill', 'Gates', 15),
  ('Folrunsho', 'Alakija', 95);