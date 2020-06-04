DROP TABLE IF EXISTS billionaires;
DROP TABLE IF EXISTS libros;

CREATE TABLE billionaires (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);

INSERT INTO billionaires (first_name, last_name, career) VALUES
  ('Aliko', 'Dangote', 'Billionaire Industrialist'),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');

CREATE TABLE libros (
  isbn VARCHAR(40) PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

INSERT INTO libros (isbn, name) VALUES
  ('203-234-234-234-234-23', 'Papeles en el viento'),
  ('203-234-234-234-123-56', 'Lo que el viento se llevo'),
  ('123-456-567-432-122-22', 'Narnia');

SELECT name FROM libros;
