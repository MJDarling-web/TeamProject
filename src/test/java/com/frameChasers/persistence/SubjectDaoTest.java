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



}
