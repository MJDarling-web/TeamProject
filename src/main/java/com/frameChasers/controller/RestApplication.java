package com.frameChasers.controller;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/services")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("com.frameChasers.controller"); // This registers LocationService
        // register(JacksonFeature.class); // <-- Optional, if jersey-media-json-jackson is in your pom
    }
}