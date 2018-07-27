package com.weather.domain.model;

import java.io.Serializable;

public class AirSpeed implements Serializable {
    private Integer id;

    private Integer airSpeed;

    private String catchTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAirSpeed() {
        return airSpeed;
    }

    public void setAirSpeed(Integer airSpeed) {
        this.airSpeed = airSpeed;
    }

    public String getCatchTime() {
        return catchTime;
    }

    public void setCatchTime(String catchTime) {
        this.catchTime = catchTime == null ? null : catchTime.trim();
    }
}