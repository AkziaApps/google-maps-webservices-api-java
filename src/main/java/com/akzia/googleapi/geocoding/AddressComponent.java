package com.akzia.googleapi.geocoding;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddressComponent {

    /**
     * long_name is the full text description or name of the address component as returned by the Geocoder.
     */
    @SerializedName("long_name")
    private String longName;

    /**
     * short_name is an abbreviated textual name for the address component, if available.
     * For example, an address component for the state of Alaska may have a long_name of "Alaska"
     * and a short_name of "AK" using the 2-letter postal abbreviation.
     */
    @SerializedName("short_name")
    private String shortName;

    /**
     * types[] is an array indicating the type of the address component.
     */
    @SerializedName("types")
    private List<Type> types;

    public AddressComponent() {
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "AddressComponent{" +
                "longName='" + longName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", types=" + types +
                '}';
    }
}
