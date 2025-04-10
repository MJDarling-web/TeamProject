package com.frameChasers.persistence;

import com.frameChasers.entity.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.frameChasers.entity.Subject;
import com.frameChasers.entity.BestTime;
import com.frameChasers.entity.Coordinates;

import java.util.List;

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
}