package com.weather.domain.model;

import java.io.Serializable;

public class Ultraviolet implements Serializable {
    private Integer id;

    private Integer ultraviolet;

    private String catchTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUltraviolet() {
        return ultraviolet;
    }

    public void setUltraviolet(Integer ultraviolet) {
        this.ultraviolet = ultraviolet;
    }

    public String getCatchTime() {
        return catchTime;
    }

    public void setCatchTime(String catchTime) {
        this.catchTime = catchTime == null ? null : catchTime.trim();
    }
}