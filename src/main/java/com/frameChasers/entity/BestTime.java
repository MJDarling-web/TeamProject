package com.frameChasers.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Best time.
 */
@Entity(name = "BestTime")
@Table(name = "best_time")
public class BestTime {

    /** The unique BestTime Id */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id")
    private int id;

    /** The optimal time */
    @Column(name = "optimal_time")
    private String optimalTime;

    /** The list of Locations that reference the best time */
    @OneToMany(mappedBy = "bestTime", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Location> locations = new ArrayList<>();


    /**
     * Instantiates a new Best time.
     */
    public BestTime() {
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
     * Gets optimal time.
     *
     * @return the optimal time
     */
    public String getOptimalTime() {
        return optimalTime;
    }

    /**
     * Sets optimal time.
     *
     * @param optimalTime the optimal time
     */
    public void setOptimalTime(String optimalTime) {
        this.optimalTime = optimalTime;
    }

    /**
     * Gets locations.
     *
     * @return the locations
     */
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * Sets locations.
     *
     * @param locations the locations
     */
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
