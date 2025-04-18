package com.frameChasers.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frameChasers.entity.Location;
import com.frameChasers.entity.Subject;
import com.frameChasers.persistence.GenericDao;
import com.frameChasers.entity.Image;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    /**
     * Gets all locations
     * @param city optional city parameter
     * @param state optional state parameter
     * @param subject optional subject parameter
     * @return response with list of locations if results positive
     * @throws JsonProcessingException
     */
    @GET
    public Response getAllLocations(
            @QueryParam("city") String city,
            @QueryParam("state") String state,
            @QueryParam("subject") String subject) throws JsonProcessingException {

        GenericDao<Location> locationDao = new GenericDao<>(Location.class);
        GenericDao<Subject> subjectDao = new GenericDao<>(Subject.class);
        Map<String, Object> propertyMap = new HashMap<String, Object>();
        List<Location> locations;

        // Endpoint http://localhost:8080/urbanPhotography_war/services/locations?city=chicago&state=il&subject=cityscape

        // Check for query params
        if (city != null) {
            // Add city to the list if included in query param
            propertyMap.put("city", city);
        }
        if (state != null) {
            // Add state to the list if included in query param
            propertyMap.put("state", state);
        }
        if (subject != null) {
            // Get the subject object
            List<Subject> subjectList = subjectDao.getByPropertyEqual("subjectName", subject);

            if (subjectList.isEmpty()) {
                return Response.status(404).entity("Subject not found").build();
            }

            Subject subjectObj = subjectList.get(0);


            // Add subject to list if exists and included in query param
            propertyMap.put("subject", subjectObj);
        }

        // If any query params are present, then use them to retrieve the filtered list of locations
        if (!propertyMap.isEmpty()) {
            locations = locationDao.findByPropertyEqual(propertyMap);
        } else {
            // If no query params present, get all locations
            locations = locationDao.getAll();
        }

        // If no locations exist
        if (locations.isEmpty()) {
            return Response.status(404).entity("{\"message\": \"Location not found\"}").build();
        }

        // If locations do exists
        return Response.status(200).entity(locations).build();


    }

    /**
     * Get a specific location by its location id
     * @param id the id of the location
     * @return the location that matches the id
     */
    @GET
    @Path("/{id}")
    public Response getLocationById(@PathParam("id") int id) {
        GenericDao<Location> dao = new GenericDao<>(Location.class);
        Location location = dao.getById(id);

        // Endpoint http://localhost:8080/urbanPhotography_war/services/locations/{id}

        if (location == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Location not found\"}")
                    .build();
        }

        return Response.ok(location).build();
    }


    /**
     * Deletes a location based on location id
     * @param id the location id to be deleted
     * @return the response code and message
     */
    @DELETE
    @Path("/{id}")
    public Response deleteLocationById(@PathParam("id") int id) {

        // Endpoint http://localhost:8080/urbanPhotography_war/services/locations/{locationId}

        GenericDao<Location> locationDao = new GenericDao<>(Location.class);

        Location location = locationDao.getById(id);

        if (location == null) {
            return Response.status(404).entity("{\"error\": \"Location not found\"}").build();
        }

        // Delete the location
        locationDao.delete(location);

        // Return a success response message after deleting location
        String successResponse = "{\"message\": \"Location " + id + " deleted successfully\"}";
        return Response.status(200).entity(successResponse).build();

    }


    /**
     * Deletes an image from a location based on image id
     * @param locationId the location id to be deleted
     * @param imageId the image id to be deleted
     * @return the response code and message
     */
    @DELETE
    @Path("/{locationId}/images/{imageId}")
    public Response deleteLocationById(
            @PathParam("locationId") int locationId
            , @PathParam("imageId") int imageId) {

        // Endpoint:  http://localhost:8080/urbanPhotography_war/services/locations/{locationId}/images/{imageId}

        GenericDao<Location> locationDao = new GenericDao<>(Location.class);
        GenericDao<Image> imageDao = new GenericDao<>(Image.class);

        Location location = locationDao.getById(locationId);

        // If location does not exist, return a 404
        if (location == null) {
            return Response.status(404).entity("{\"error\": \"Location not found\"}").build();
        }

        // Get the image from the location list of images
        Image image = imageDao.getById(imageId);

        // If image does not exist, or it doesn't exist for the location specified, throw a 404
        if (image == null || image.getLocation().getId() != locationId) {
            return Response.status(404).entity("{\"error\": \"Image not found for this location\"}").build();
        }

        // Delete the image if location and image exist
        imageDao.delete(image);

        // Return a success response message after deleting image
        String successResponse = "{\"message\": \"Image " + imageId + " deleted successfully for location " + locationId + "\"}";
        return Response.status(200).entity(successResponse).build();

    }

    /**
     * updates existing location
     * @param id of the location
     * @param updatedLocation of new location
     * @return response of success or failure
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLocation(@PathParam("id") int id, Location updatedLocation) {
        GenericDao<Location> dao = new GenericDao<>(Location.class);
        Location existingLocation = dao.getById(id);

        if (existingLocation == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Location not found\"}")
                    .build();
        }
        //update fields
        existingLocation.setLocationName(updatedLocation.getLocationName());
        existingLocation.setCity(updatedLocation.getCity());
        existingLocation.setState(updatedLocation.getState());
        existingLocation.setCoordinates(updatedLocation.getCoordinates());
        existingLocation.setDescription(updatedLocation.getDescription());
        existingLocation.setBestTime(updatedLocation.getBestTime());
        existingLocation.setSubject(updatedLocation.getSubject());

        dao.update(existingLocation);

        return Response.ok(existingLocation).build();
    }

    /**
     * Updates an image's URL for a specific location
     * @param locationId the location ID the image belongs to
     * @param imageId the image ID to update
     * @param updatedImage the new image object with updated URL
     * @return response with success or error
     */
    @PUT
    @Path("/{locationId}/images/{imageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateImageForLocation(
            @PathParam("locationId") int locationId,
            @PathParam("imageId") int imageId,
            Image updatedImage) {

        GenericDao<Image> imageDao = new GenericDao<>(Image.class);
        Image image = imageDao.getById(imageId);

        if (image == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        image.setImageUrl(updatedImage.getImageUrl());
        imageDao.update(image);

        return Response.ok(image).build();
    }
}