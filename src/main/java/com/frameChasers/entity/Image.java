package com.frameChasers.entity;


import jakarta.persistence.*;


/**
 * The type Image.
 */
@Entity(name = "Image")
@Table(name = "images")
public class Image {

    /** Unique identifier for an image */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** The location the image is tied to */
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    /** The url to the image */
    @Column(name = "image_url")
    private String imageUrl;


    /**
     * Instantiates a new Image.
     */
    public Image() {
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
     * Gets location.
     *
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Gets image url.
     *
     * @return the image url
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets image url.
     *
     * @param imageUrl the image url
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
