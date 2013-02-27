package com.akzia.googleapi.directions;

import com.google.gson.annotations.SerializedName;

public class Bounds {

    @SerializedName("northeast")
    private GeoPoint northEast;

    @SerializedName("southwest")
    private GeoPoint southWest;

    public Bounds() {
    }

    public GeoPoint getNorthEast() {
        return northEast;
    }

    public void setNorthEast(GeoPoint northEast) {
        this.northEast = northEast;
    }

    public GeoPoint getSouthWest() {
        return southWest;
    }

    public void setSouthWest(GeoPoint southWest) {
        this.southWest = southWest;
    }

    @Override
    public String toString() {
        return "Bounds{" +
                "northEast=" + northEast +
                ", southWest=" + southWest +
                '}';
    }
}
