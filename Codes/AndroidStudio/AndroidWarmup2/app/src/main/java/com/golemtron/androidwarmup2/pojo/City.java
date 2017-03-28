package com.golemtron.androidwarmup2.pojo;

/**
 * Created by taharushain on 3/17/17.
 */

public class City {

    private float lng;
    private long geonameId;
    private String name;
    private String fclName;
    private String toponymName;
    private String fcodeName;
    private String wikipedia;
    private float lat;
    private String fcl;
    private long population;
    private String fcode;

    public City() {
    }

    public City(float lng, long geonameId, String name, String fclName, String toponymName, String fcodeName, String wikipedia, float lat, String fcl, long population, String fcode) {
        this.lng = lng;
        this.geonameId = geonameId;
        this.name = name;
        this.fclName = fclName;
        this.toponymName = toponymName;
        this.fcodeName = fcodeName;
        this.wikipedia = wikipedia;
        this.lat = lat;
        this.fcl = fcl;
        this.population = population;
        this.fcode = fcode;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public long getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(long geonameId) {
        this.geonameId = geonameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFclName() {
        return fclName;
    }

    public void setFclName(String fclName) {
        this.fclName = fclName;
    }

    public String getToponymName() {
        return toponymName;
    }

    public void setToponymName(String toponymName) {
        this.toponymName = toponymName;
    }

    public String getFcodeName() {
        return fcodeName;
    }

    public void setFcodeName(String fcodeName) {
        this.fcodeName = fcodeName;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public String getFcl() {
        return fcl;
    }

    public void setFcl(String fcl) {
        this.fcl = fcl;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }
}
