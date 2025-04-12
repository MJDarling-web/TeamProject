package com.frameChasers.controller;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/services")
public class RestApplication extends Application {
    // No overrides needed. Jersey will auto-scan for @Path classes.
}