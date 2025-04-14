package com.frameChasers.persistence;

import com.frameChasers.entity.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.frameChasers.entity.Subject;
import com.frameChasers.entity.BestTime;
import com.frameChasers.entity.Coordinates;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LocationDaoTest {

    private GenericDao<Location> locationDao;

    @BeforeEach
    void setUp() {
        // Reset the test database to a known state before each test
        Database database = Database.getInstance();
        database.runSQL("clean_db.sql");

        locationDao = new GenericDao<>(Location.class);
    }

    @Test
    void testGetByIdSuccess() {
        Location location = locationDao.getById(1);
        assertNotNull(location);
        assertEquals("Sunset Cliffs", location.getLocationName());
    }

    @Test
    void testInsertSuccess() {
        GenericDao<Subject> subjectDao = new GenericDao<>(Subject.class);
        Subject subject = subjectDao.getById(1);

        BestTime bestTime = new GenericDao<>(BestTime.class).getById(1);

        Location newLocation = new Location();
        newLocation.setLocationName("Test Spot");
        newLocation.setCity("Testville");
        newLocation.setState("TS");
        newLocation.setCoordinates(new Coordinates(11.111111, -22.222222));
        newLocation.setDescription("A test description.");
        newLocation.setBestTime(bestTime);
        newLocation.setSubject(subject);

        int id = locationDao.insert(newLocation);
        assertTrue(id > 0);

        Location insertedLocation = locationDao.getById(id);
        assertEquals("Test Spot", insertedLocation.getLocationName());
    }

    @Test
    void testDeleteSuccess() {
        Location location = locationDao.getById(2);
        assertNotNull(location);
        locationDao.delete(location);
        assertNull(locationDao.getById(2));
    }

    @Test
    void testUpdateSuccess() {
        Location locationToUpdate = locationDao.getById(1);
        locationToUpdate.setCity("Updated City");
        locationDao.update(locationToUpdate);

        Location updatedLocation = locationDao.getById(1);
        assertEquals("Updated City", updatedLocation.getCity());
    }

    @Test
    void testGetAllSuccess() {
        List<Location> locations = locationDao.getAll();
        assertNotNull(locations);
        assertFalse(locations.isEmpty());
    }

    @Test
    void testGetByPropertyEqual() {
        List<Location> locations = locationDao.getByPropertyEqual("state", "CA");
        assertFalse(locations.isEmpty());
    }

    @Test
    void testCoordinates() {
        GenericDao<Subject> subjectDao = new GenericDao<>(Subject.class);
        Subject subject = subjectDao.getById(1);
        BestTime bestTime = new GenericDao<>(BestTime.class).getById(1);

        Coordinates coords = new Coordinates(33.123456, -117.654321);
        Location newLocation = new Location();
        newLocation.setLocationName("Beach Spot");
        newLocation.setCity("Oceanside");
        newLocation.setState("CA");
        newLocation.setCoordinates(coords);
        newLocation.setDescription("A relaxing beach");
        newLocation.setBestTime(bestTime);
        newLocation.setSubject(subject);

        int id = locationDao.insert(newLocation);
        Location inserted = locationDao.getById(id);

        assertEquals(new BigDecimal("33.123456"), inserted.getCoordinates().getLatitude());
        assertEquals(new BigDecimal("-117.654321"), inserted.getCoordinates().getLongitude());
    }

    @Test
    void findByPropertyEqual() {

        Map<String, Object> propertyMap = new HashMap<>();
        propertyMap.put("state", "CA");
        propertyMap.put("city", "San Diego");

        List<Location> locations = locationDao.findByPropertyEqual(propertyMap);

        assertEquals(1, locations.size());

    }

}