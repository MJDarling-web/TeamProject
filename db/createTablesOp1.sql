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
    
INSERT INTO location (location_name, city, state, latitude, longitude, description, best_time_id, subject_id)
VALUES
('Sunset Cliffs', 'San Diego', 'CA', 32.7353, -117.2550, 'Dramatic ocean views and rugged cliffs.', 4, 1),
('Millennium Park', 'Chicago', 'IL', 41.8826, -87.6226, 'Famous for Cloud Gate and city skyline views.', 2, 5),
('Acadia Overlook', 'Bar Harbor', 'ME', 44.3386, -68.2733, 'Scenic views of the ocean and rocky coastline.', 1, 14),
('Brooklyn Bridge', 'New York', 'NY', 40.7061, -73.9969, 'Iconic architecture spanning the East River.', 3, 2),
('Great Smoky Mountains', 'Gatlinburg', 'TN', 35.6532, -83.5070, 'Lush forest, foggy ridges, and wildlife.', 1, 3),
('Mission District Murals', 'San Francisco', 'CA', 37.7599, -122.4148, 'Colorful and expressive mural art.', 2, 9),
('Steel Mill Ruins', 'Pittsburgh', 'PA', 40.4406, -79.9959, 'Gritty industrial relics with rust tones.', 5, 11),
('Lincoln Memorial', 'Washington', 'DC', 38.8893, -77.0502, 'Historic site with striking architecture.', 3, 6),
('Lake Tahoe Shoreline', 'South Lake Tahoe', 'CA', 38.9399, -119.9772, 'Crystal clear water surrounded by mountains.', 4, 7),
('Central Park', 'New York', 'NY', 40.7851, -73.9683, 'Vast park in the heart of Manhattan.', 2, 12);

INSERT INTO images (location_id, image_url)
VALUES
(1, 'https://myimageurl_1.com'),
(1, 'https://myimageurl_2.com'),
(2, 'https://myimageurl_3.com'),
(2, 'https://myimageurl_4.com'),
(3, 'https://myimageurl_5.com'),
(3, 'https://myimageurl_6.com'),
(4, 'https://myimageurl_7.com'),
(4, 'https://myimageurl_8.com'),
(5, 'https://myimageurl_9.com'),
(5, 'https://myimageurl_10.com'),
(6, 'https://myimageurl_11.com'),
(6, 'https://myimageurl_12.com'),
(7, 'https://myimageurl_13.com'),
(7, 'https://myimageurl_14.com'),
(8, 'https://myimageurl_15.com'),
(8, 'https://myimageurl_16.com'),
(9, 'https://myimageurl_17.com'),
(9, 'https://myimageurl_18.com'),
(10, 'https://myimageurl_19.com'),
(10, 'https://myimageurl_20.com');
