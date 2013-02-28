package com.akzia.googleapi.geocoding;

import com.akzia.googleapi.common.Bounds;
import com.akzia.googleapi.common.GeoPoint;
import com.google.gson.annotations.SerializedName;

public class Geometry {

    public enum LocationType {
        /**
         * "ROOFTOP" indicates that the returned result is a precise geocode
         * for which we have location information accurate down to street address precision.
         */
        ROOFTOP,

        /**
         * "RANGE_INTERPOLATED" indicates that the returned result reflects an approximation
         * (usually on a road) interpolated between two precise points (such as intersections).
         * Interpolated results are generally returned when rooftop geocodes are unavailable for a street address.
         */
        RANGE_INTERPOLATED,

        /**
         * "GEOMETRIC_CENTER" indicates that the returned result is the geometric center of a result
         * such as a polyline (for example, a street) or polygon (region).
         */
        GEOMETRIC_CENTER,

        /**
         * "APPROXIMATE" indicates that the returned result is approximate.
         */
        APPROXIMATE
    }

    /**
     * location contains the geocoded latitude,longitude value.
     * For normal address lookups, this field is typically the most important.
     */
    @SerializedName("location")
    private GeoPoint location;

    /**
     * location_type stores additional data about the specified location.
     */
    @SerializedName("location_type")
    private LocationType locationType;

    /**
     * viewport contains the recommended viewport for displaying the returned result,
     * specified as two latitude,longitude values defining the southwest and northeast corner
     * of the viewport bounding box.
     * Generally the viewport is used to frame a result when displaying it to a user.
     */
    @SerializedName("viewport")
    private Bounds viewport;

    /**
     * bounds (optionally returned) stores the bounding box which can fully contain the returned result.
     * Note that these bounds may not match the recommended viewport.
     * (For example, San Francisco includes the Farallon islands, which are technically part of the city,
     * ut probably should not be returned in the viewport.)
     */
    @SerializedName("bounds")
    private Bounds bounds;

    public Geometry() {
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public Bounds getViewport() {
        return viewport;
    }

    public void setViewport(Bounds viewport) {
        this.viewport = viewport;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    @Override
    public String toString() {
        return "Geometry{" +
                "location=" + location +
                ", locationType=" + locationType +
                ", viewport=" + viewport +
                ", bounds=" + bounds +
                '}';
    }
}
