package com.weather.domain.model;

import java.io.Serializable;

public class Ultraviolet implements Serializable {
    private Integer id;

    private Double ultraviolet;

    private String catchTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getUltraviolet() {
        return ultraviolet;
    }

    public void setUltraviolet(Double ultraviolet) {
        this.ultraviolet = ultraviolet;
    }

    public String getCatchTime() {
        return catchTime;
    }

    public void setCatchTime(String catchTime) {
        this.catchTime = catchTime == null ? null : catchTime.trim();
    }
}