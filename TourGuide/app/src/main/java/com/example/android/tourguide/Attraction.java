package com.example.android.tourguide;

/**
 * Created by lilla on 15/07/17.
 */

public class Attraction {
    private String description1;
    private String description2;
    private String description3;
    private String geoLocation;
    private int imgId;

    /*Constructor for Sights, Beaches and Restaurants categories*/
    public Attraction(String description1, String description2, String description3, String geoLocation, int imgId
                      ) {
        this.description1 = description1;
        this.description2 = description2;
        this.description3 = description3;
        this.geoLocation = geoLocation;
        this.imgId = imgId;
    }

    /*Constructor for Events category*/
    public Attraction(String description1, String description2, int imgId) {
        this.description1 = description1;
        this.description2 = description2;
        this.imgId = imgId;
    }

    public String getDescription1() {
        return description1;
    }

    public String getDescription2() {
        return description2;
    }

    public String getDescription3() {
        return description3;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public int getImgId() {
        return imgId;
    }

}
