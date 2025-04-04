USE photo_chasers;

#########################################################
# Remove all tables if they exist, prior to creating them
#########################################################

DROP TABLE IF EXISTS images;
DROP TABLE IF EXISTS location_subject;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS best_time;
DROP TABLE IF EXISTS subject;


#########################################################
# Create tables
#########################################################

CREATE TABLE best_time (
                         id INTEGER AUTO_INCREMENT PRIMARY KEY,
                         optimal_time varchar(50) NOT NULL UNIQUE
);

CREATE TABLE subject (
                         id INTEGER AUTO_INCREMENT PRIMARY KEY,
                         subject_name varchar(100) NOT NULL UNIQUE
);

CREATE TABLE location (
                      id INTEGER AUTO_INCREMENT PRIMARY KEY,
                      location_name VARCHAR(255) NOT NULL,
                      city VARCHAR(100) NOT NULL,
                      state CHAR(2) NOT NULL,
                      latitude DECIMAL(9,6) NOT NULL,
                      longitude DECIMAL(9,6) NOT NULL,
                      description TEXT NOT NULL,
                      best_time_id INTEGER NOT NULL,
                      subject_id INTEGER NOT NULL,
                      FOREIGN KEY (subject_id) REFERENCES subject(id) ON DELETE RESTRICT,
                      FOREIGN KEY (best_time_id) REFERENCES best_time(id) ON DELETE RESTRICT,
                      UNIQUE (location_name, latitude, longitude)
);

CREATE TABLE images (
                         id INTEGER AUTO_INCREMENT PRIMARY KEY,
                         location_id INTEGER NOT NULL,
                         image_url VARCHAR(500) NOT NULL,
                         FOREIGN KEY (location_id) REFERENCES location(id) ON DELETE CASCADE,
                         UNIQUE (location_id, image_url)
);

###########################
# Load tables
###########################

# best_time
INSERT INTO best_time (optimal_time)
VALUES ("morning"),
       ("afternoon"),
       ("evening"),
       ("golden hour"),
       ("night");
       
# subjects
INSERT INTO subject (subject_name)
VALUES
    ('Nature'),
    ('Architecture'),
    ('Wildlife'),
    ('Abstract'),
    ('Cityscape'),
    ('Historical'),
    ('Waterfront'),
    ('Night'),
    ('Murals'),
    ('Cultural'),
    ('Industrial'),
    ('Parks'),
    ('Minimalism'),
    ('Rural'),
    ('Urban'),
    ('Seasonal'),
    ('People');