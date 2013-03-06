package com.akzia.googleapi.geocoding;

import com.akzia.googleapi.common.GeoPoint;
import com.google.gson.annotations.SerializedName;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class GoogleReverseGeocodeRequest extends AbstractGeocodeRequest {

    /**
     * The textual latitude/longitude value for which you wish to obtain the closest, human-readable address.
     */
    @SerializedName("latlng")
    private GeoPoint latLng;

    public GoogleReverseGeocodeRequest(boolean sensor, GeoPoint latLng) {
        super(sensor);
        this.latLng = latLng;
    }

    public GeoPoint getLatLng() {
        return latLng;
    }

    public void setLatLng(GeoPoint latLng) {
        this.latLng = latLng;
    }

    @Override
    protected String getAPIName() {
        return "geocode";
    }

    @Override
    protected Map<String, String> addParameters() throws UnsupportedEncodingException {
        Map<String, String> pairs = super.addParameters();
        if (latLng != null) {
            pairs.put("latlng", latLng.toString());
        } else {
            throw new IllegalArgumentException("latlng cant be null");
        }
        return pairs;
    }

    @Override
    public String toString() {
        return "GoogleReverseGeocodeRequest{" +
                "latLng=" + latLng +
                '}';
    }
}
