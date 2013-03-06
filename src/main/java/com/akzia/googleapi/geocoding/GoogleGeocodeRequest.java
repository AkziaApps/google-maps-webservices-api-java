package com.akzia.googleapi.geocoding;

import com.google.gson.annotations.SerializedName;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class GoogleGeocodeRequest extends AbstractGeocodeRequest {

    /**
     * The address that you want to geocode
     */
    @SerializedName("address")
    private String address;

    public GoogleGeocodeRequest(boolean sensor, String address) {
        super(sensor);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    protected String getAPIName() {
        return "geocode";
    }

    @Override
    protected Map<String, String> addParameters() throws UnsupportedEncodingException {
        Map<String, String> pairs = super.addParameters();
        if (address != null) {
            pairs.put("address", address);
        } else {
            throw new IllegalArgumentException("address cant be null");
        }
        return pairs;
    }

    @Override
    public String toString() {
        return "GoogleGeocodeRequest{" +
                "address='" + address + '\'' +
                '}';
    }
}
