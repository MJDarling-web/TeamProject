package com.frameChasers.persistence;

import com.frameChasers.entity.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationDaoTest {

    private GenericDao<Location> locationDao;

    @BeforeEach
    void setUp() {
        locationDao = new GenericDao<>(Location.class);
    }





}