package com.weather.domain.model;

import java.io.Serializable;

public class IlluminationOut implements Serializable {
    private Integer id;

    private Integer illumination;

    private String catchTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIllumination() {
        return illumination;
    }

    public void setIllumination(Integer illumination) {
        this.illumination = illumination;
    }

    public String getCatchTime() {
        return catchTime;
    }

    public void setCatchTime(String catchTime) {
        this.catchTime = catchTime == null ? null : catchTime.trim();
    }
}