package com.frameChasers.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Subject.
 */
@Entity(name = "Subject")
@Table(name = "subject")
public class Subject {

    /** The unique subject Id */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id")
    private int id;

    /** The name of the subject*/
    @Column(name = "subject_name")
    private String subjectName;

    /** The list of Locations that reference the best time */
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Location> locations = new ArrayList<>();


    /**
     * Instantiates a new Subject.
     */
    public Subject() {
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
     * Gets subject name.
     *
     * @return the subject name
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Sets subject name.
     *
     * @param subjectName the subject name
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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
