package com.frameChasers.persistence;

import com.frameChasers.entity.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubjectDaoTest {

    private GenericDao<Subject> subjectDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("clean_db.sql");

        subjectDao = new GenericDao<>(Subject.class);
    }

    @Test
    void testGetByIdSuccess() {
        Subject subject = subjectDao.getById(1);
        assertNotNull(subject);
        assertEquals("Nature", subject.getSubjectName());
    }

    @Test
    void testInsertSuccess() {
        Subject newSubject = new Subject();
        newSubject.setSubjectName("Test Subject");

        int id = subjectDao.insert(newSubject);
        assertTrue(id > 0);

        Subject insertedSubject = subjectDao.getById(id);
        assertEquals("Test Subject", insertedSubject.getSubjectName());
    }

    @Test
    void testUpdateSuccess() {
        Subject subject = subjectDao.getById(1);
        subject.setSubjectName("Updated Subject");
        subjectDao.update(subject);

        Subject updatedSubject = subjectDao.getById(1);
        assertEquals("Updated Subject", updatedSubject.getSubjectName());
    }

    @Test
    void testDeleteSuccess() {
        Subject subject = subjectDao.getById(2);
        assertNotNull(subject);
        subjectDao.delete(subject);
        assertNull(subjectDao.getById(2));
    }

    @Test
    void testGetAllSuccess() {
        List<Subject> subjects = subjectDao.getAll();
        assertNotNull(subjects);
        assertFalse(subjects.isEmpty());
    }

    @Test
    void testGetByPropertyEqual() {
        List<Subject> subjects = subjectDao.getByPropertyEqual("subjectName", "Nature");
        assertEquals(1, subjects.size());
    }
}