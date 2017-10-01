CREATE TABLE IF NOT EXISTS gis_project.map_points (
   id INT NOT NULL AUTO_INCREMENT,
   address VARCHAR(255) NOT NULL,
   point POINT NOT NULL,
   PRIMARY KEY (id)
);