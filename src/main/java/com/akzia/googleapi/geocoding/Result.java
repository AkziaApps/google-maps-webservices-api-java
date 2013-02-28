package com.akzia.googleapi.geocoding;

import com.google.gson.annotations.SerializedName;

public class Result {

    /**
     * formatted_address is a string containing the human-readable address of this location.
     * Often this address is equivalent to the "postal address," which sometimes differs from country to country.
     * (Note that some countries, such as the United Kingdom, do not allow distribution of true postal addresses
     * due to licensing restrictions.) This address is generally composed of one or more address components.
     * For example, the address "111 8th Avenue, New York, NY" contains separate address components for "111"
     * (the street number, "8th Avenue" (the route), "New York" (the city) and "NY" (the US state).
     * These address components contain additional information as noted below.
     */
    @SerializedName("formatted_address")
    private String formattedAddress;

    @SerializedName("geomerty")
    private Geometry geometry;

    public Result() {
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @Override
    public String toString() {
        return "Result{" +
                "formattedAddress='" + formattedAddress + '\'' +
                ", geometry=" + geometry +
                '}';
    }
}