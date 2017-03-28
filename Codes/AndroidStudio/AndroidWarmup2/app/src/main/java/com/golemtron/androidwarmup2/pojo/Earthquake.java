package com.golemtron.androidwarmup2.pojo;

/**
 * Created by taharushain on 3/17/17.
 */

public class Earthquake {
    private String datetime;
    private float depth;
    private String src;
    private String eqid;
    private float lng;
    private float lat;
    private float magnitude;

    public Earthquake() {
    }

    public Earthquake(String datetime, float depth, String src, String eqid, float lng, float lat, float magnitude) {
        this.datetime = datetime;
        this.depth = depth;
        this.src = src;
        this.eqid = eqid;
        this.lng = lng;
        this.lat = lat;
        this.magnitude = magnitude;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getEqid() {
        return eqid;
    }

    public void setEqid(String eqid) {
        this.eqid = eqid;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(float magnitude) {
        this.magnitude = magnitude;
    }
}
