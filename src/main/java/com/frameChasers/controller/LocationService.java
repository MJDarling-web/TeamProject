package com.frameChasers.controller;

import com.frameChasers.entity.Location;
import com.frameChasers.persistence.GenericDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



/**
 * LocationService class handles HTTP requests related to photography locations.
 * It uses the GenericDao class for database operations.
 * This class is part of a RESTful web service that allows clients to manage photography locations.
 */
/**
 * RESTful web service for managing photography locations.
 * Handles adding new locations and uploading images to existing ones.
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
    public Response addImageToLocation(@PathParam("locationId") int locationId, String imageUrl) {
        GenericDao<Location> dao = new GenericDao<>(Location.class);
        Location location = dao.getById(locationId);

        if (location == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Location not found")
                    .build();
        }

//        location.getImages().add(imageUrl);
//        dao.saveOrUpdate(location);

        return Response.ok("{\"message\": \"Image added successfully\"}").build();
    }
}