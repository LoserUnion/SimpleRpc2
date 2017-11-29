package com.wk.simplerpc.entity;

import java.util.Date;

/**
 * PackageName com.wk.simplerpc.entity
 * Created by wangkang on 2017/11/29.
 */
public class Spittle {
    private final Long id;
    private final Date time;
    private final String message;
    private Double latitude;
    private Double longitude;

    public Spittle(Long id, Date time, String message) {
        this.id = id;
        this.time = time;
        this.message = message;
    }

    public Spittle(Long id, Date time, String message, Double latitude, Double longitude) {
        this.id = id;
        this.time = time;
        this.message = message;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "time:" + time.toString() + "\n"+
                "message:" + message + "\n" +
                "latitude:" + latitude + "\n" +
                "longitude:" + longitude + "\n";
    }
}
