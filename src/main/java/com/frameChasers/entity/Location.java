package com.frameChasers.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * The type Location.
 */
@Entity
@Table(name = "location", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"location_name", "latitude", "longitude"})
})
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "location_name", nullable = false, length = 255)
    private String locationName;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, length = 2)
    private String state;

    @Embedded
    private Coordinates coordinates;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "best_time_id", nullable = false)
    @JsonBackReference(value = "bestTime-locations")
    private BestTime bestTime;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    @JsonBackReference(value = "subject-locations")
    private Subject subject;

    /** List of the Location's images */
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference(value = "location-images")
    private List<Image> images = new ArrayList<>();

    /**
     * Instantiates a new Location.
     */
    public Location() {
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets location name.
     *
     * @return the location name
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * Sets location name.
     *
     * @param locationName the location name
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets coordinates.
     *
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Sets coordinates.
     *
     * @param coordinates the coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets best time.
     *
     * @return the best time
     */

    public BestTime getBestTime() {
        return bestTime;
    }

    /**
     * Sets best time.
     *
     * @param bestTime the best time
     */
    public void setBestTime(BestTime bestTime) {
        this.bestTime = bestTime;
    }

    /**
     * Gets subject.
     *
     * @return the subject
     */

    public Subject getSubject() {
        return subject;
    }

    /**
     * Sets subject.
     *
     * @param subject the subject
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * Gets images.
     *
     * @return the images
     */

    public List<Image> getImages() {
        return images;
    }

    /**
     * Sets images.
     *
     * @param images the images
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }
}