package com.frameChasers.controller;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Root configuration class for Jersey RESTful services.
 * Defines the base URI path as "/services".
 */
@ApplicationPath("/services")
public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(LocationService.class);
        // Add other resource or provider classes as needed
        return classes;
    }
}