package com.akzia.googleapi.common;

import com.google.gson.annotations.SerializedName;

public class GeoPoint {

    @SerializedName("lat")
    private double latitude;

    @SerializedName("lng")
    private double longitude;

    public GeoPoint() {
    }

    public GeoPoint(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return latitude + "," + longitude;
    }
}
