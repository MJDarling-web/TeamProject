package com.urbanphotography.entity;

import jakarta.persistence.*;
import java.util.*;

@Embeddable
@Table(name = "location")
public class coordinates {

    private BigDecimal latitude;
    private BigDecimal longitude;

    //getters and setters

    public BigDecimal getLatitude() {
        return latitude;
    }
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }


}

