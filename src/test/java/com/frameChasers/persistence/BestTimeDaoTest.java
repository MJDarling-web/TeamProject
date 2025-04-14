package com.frameChasers.persistence;

import com.frameChasers.entity.BestTime;
import com.frameChasers.entity.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestTimeDaoTest {

    private GenericDao<BestTime> bestTimeDao;

    @BeforeEach
    void setUp() {
        bestTimeDao = new GenericDao<>(BestTime.class);

        // Clean up database before each test
        List<BestTime> existingBestTimes = bestTimeDao.getAll();
        for (BestTime bestTime : existingBestTimes) {
            bestTimeDao.delete(bestTime);
        }

        // Insert some sample data before each test
        BestTime bestTime1 = new BestTime();
        bestTime1.setOptimalTime("Morning");

        BestTime bestTime2 = new BestTime();
        bestTime2.setOptimalTime("Afternoon");

        bestTimeDao.insert(bestTime1);
        bestTimeDao.insert(bestTime2);
    }

    @Test
    void testGetAllBestTimes() {
        List<BestTime> bestTimes = bestTimeDao.getAll();
        assertNotNull(bestTimes);
        assertFalse(bestTimes.isEmpty());
        assertEquals(2, bestTimes.size());
    }

    @Test
    void testInsertBestTime() {
        BestTime bestTime = new BestTime();
        bestTime.setOptimalTime("Evening");
        int id = bestTimeDao.insert(bestTime);

        BestTime insertedBestTime = bestTimeDao.getById(id);
        assertNotNull(insertedBestTime);
        assertEquals("Evening", insertedBestTime.getOptimalTime());
    }

    @Test
    void testGetBestTimeById() {
        BestTime bestTime = new BestTime();
        bestTime.setOptimalTime("Noon");
        int id = bestTimeDao.insert(bestTime);

        BestTime retrievedBestTime = bestTimeDao.getById(id);
        assertNotNull(retrievedBestTime);
        assertEquals(id, retrievedBestTime.getId());
        assertEquals("Noon", retrievedBestTime.getOptimalTime());
    }

    @Test
    void testDeleteBestTime() {
        BestTime bestTime = new BestTime();
        bestTime.setOptimalTime("Dawn");
        int id = bestTimeDao.insert(bestTime);

        BestTime insertedBestTime = bestTimeDao.getById(id);
        assertNotNull(insertedBestTime);

        bestTimeDao.delete(insertedBestTime);

        BestTime deletedBestTime = bestTimeDao.getById(id);
        assertNull(deletedBestTime);
    }

    @Test
    void testGetBestTimeByProperty() {
        BestTime bestTime = new BestTime();
        bestTime.setOptimalTime("Night");
        int id = bestTimeDao.insert(bestTime);

        List<BestTime> bestTimes = bestTimeDao.getByPropertyEqual("optimalTime", "Night");
        assertNotNull(bestTimes);
        assertFalse(bestTimes.isEmpty());
        assertEquals(1, bestTimes.size());
        assertEquals("Night", bestTimes.get(0).getOptimalTime());
    }

    @Test
    void findByPropertyEqual() {

        Map<String, Object> propertyMap = new HashMap<>();
        propertyMap.put("optimalTime", "Morning");

        List<BestTime> bestTimes = bestTimeDao.findByPropertyEqual(propertyMap);

        assertEquals(1, bestTimes.size());

    }
}
