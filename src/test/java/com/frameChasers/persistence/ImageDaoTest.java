package com.frameChasers.persistence;

import com.frameChasers.entity.Image;
import com.frameChasers.entity.Location;
import com.frameChasers.entity.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ImageDaoTest {

    private GenericDao<Image> imageDao;
    private GenericDao<Location> locationDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("clean_db.sql");

        imageDao = new GenericDao<>(Image.class);
        locationDao = new GenericDao<>(Location.class);
    }

    @Test
    void testGetByIdSuccess() {
        Image image = imageDao.getById(1);
        assertNotNull(image);
        assertTrue(image.getImageUrl().startsWith("https://"));
    }

    @Test
    void testInsertSuccess() {
        Location location = locationDao.getById(1);
        Image newImage = new Image();
        newImage.setLocation(location);
        newImage.setImageUrl("https://insertedimage.com");

        int id = imageDao.insert(newImage);
        assertTrue(id > 0);

        Image insertedImage = imageDao.getById(id);
        assertEquals("https://insertedimage.com", insertedImage.getImageUrl());
        assertEquals(location.getId(), insertedImage.getLocation().getId());
    }

    @Test
    void testUpdateSuccess() {
        Image imageToUpdate = imageDao.getById(1);
        imageToUpdate.setImageUrl("https://updatedurl.com");
        imageDao.update(imageToUpdate);

        Image updatedImage = imageDao.getById(1);
        assertEquals("https://updatedurl.com", updatedImage.getImageUrl());
    }

    @Test
    void testDeleteSuccess() {
        Image imageToDelete = imageDao.getById(1);
        assertNotNull(imageToDelete);

        imageDao.delete(imageToDelete);

        assertNull(imageDao.getById(1));
    }

    @Test
    void testGetAllSuccess() {
        List<Image> images = imageDao.getAll();
        assertNotNull(images);
        assertFalse(images.isEmpty());
    }

    @Test
    void testGetByPropertyEqual() {
        List<Image> images = imageDao.getByPropertyEqual("imageUrl", "https://myimageurl_1.com");
        assertEquals(1, images.size());
    }

    @Test
    void findByPropertyEqual() {

        Map<String, Object> propertyMap = new HashMap<>();
        propertyMap.put("imageUrl", "https://myimageurl_5.com");

        List<Image> images = imageDao.findByPropertyEqual(propertyMap);

        assertEquals(1, images.size());

    }
}