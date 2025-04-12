package com.frameChasers.controller;

import com.frameChasers.entity.Location;
import com.frameChasers.persistence.GenericDao;
import com.frameChasers.entity.Image;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


/**
 * LocationService class handles HTTP requests related to photography locations.
 * It uses the GenericDao class for database operations.
 * This class is part of a RESTful web service that allows clients to manage photography locations.
 */

@Path("/locations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LocationService {

    /**
     * Adds a new photography location to the database.
     * @param location The location object submitted by the client
     * @return A response indicating the result of the operation, including the new ID
     */
    @POST
    public Response addLocation(Location location) {
        GenericDao<Location> dao = new GenericDao<>(Location.class);
        int id = dao.insert(location);

        return Response.status(Response.Status.CREATED)
                .entity("{\"id\": " + id + "}")
                .build();
    }

    /**
     * Adds an image URL to an existing location's image list.
     * @param locationId The ID of the location to update
     * @param imageUrl A plain text URL string for the new image
     * @return A response indicating success or failure
     */
    @POST
    @Path("/{locationId}/images")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response addImageToLocation(@PathParam("locationId") int locationId, String imageUrl) {
        GenericDao<Location> dao = new GenericDao<>(Location.class);
        Location location = dao.getById(locationId);

        if (location == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Location not found")
                    .build();
        }

        Image image = new Image();
        image.setImageUrl(imageUrl);
        image.setLocation(location); // required for @ManyToOne

        location.getImages().add(image);
        dao.update(location);

        return Response.ok("{\"message\": \"Image added successfully\"}").build();
    }

    @GET
    public Response getAllLocations() {
        GenericDao<Location> dao = new GenericDao<>(Location.class);
        return Response.ok(dao.getAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getLocationById(@PathParam("id") int id) {
        GenericDao<Location> dao = new GenericDao<>(Location.class);
        Location location = dao.getById(id);

        if (location == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Location not found\"}")
                    .build();
        }

        return Response.ok(location).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String testEndpoint() {
        return "It works!";
    }
}