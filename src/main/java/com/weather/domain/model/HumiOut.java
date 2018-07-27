package com.weather.domain.model;

import java.io.Serializable;

public class HumiOut implements Serializable {
    private Integer id;

    private Double humidity;

    private String catchTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public String getCatchTime() {
        return catchTime;
    }

    public void setCatchTime(String catchTime) {
        this.catchTime = catchTime == null ? null : catchTime.trim();
    }
}