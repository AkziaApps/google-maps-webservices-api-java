package com.akzia.googleapi.geocoding;

import com.akzia.googleapi.AbstractRequest;
import com.akzia.googleapi.common.GeoPoint;
import com.google.gson.annotations.SerializedName;
import org.apache.http.client.utils.URIBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GoogleGeocodingRequest extends AbstractRequest {

    /**
     * The address that you want to geocode
     */
    @SerializedName("address")
    private String address;

    /**
     * The textual latitude/longitude value for which you wish to obtain the closest, human-readable address.
     */
    @SerializedName("latlng")
    private GeoPoint latLng;

    /**
     * Indicates whether or not the geocoding request comes from a device with a location sensor
     */
    @SerializedName("sensor")
    private boolean sensor;

    /**
     * language — The language in which to return results.
     * See the list of supported domain languages.
     * Note that we often update supported languages so this list may not be exhaustive.
     * If language is not supplied, the geocoder will attempt to use the native language of the domain
     * from which the request is sent wherever possible.
     * https://spreadsheets.google.com/pub?key=p9pdwsai2hDMsLkXsoM05KQ&gid=1
     */
    @SerializedName("language")
    private String language;

    public GoogleGeocodingRequest(String address) {
        this.address = address;
        this.sensor = false;
    }

    public GoogleGeocodingRequest(GeoPoint latLng) {
        this.latLng = latLng;
        this.sensor = false;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GeoPoint getLatLng() {
        return latLng;
    }

    public void setLatLng(GeoPoint latLng) {
        this.latLng = latLng;
    }

    public boolean isSensor() {
        return sensor;
    }

    public void setSensor(boolean sensor) {
        this.sensor = sensor;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "GoogleGeocodingRequest{" +
                "address='" + address + '\'' +
                ", latLng=" + latLng +
                ", sensor=" + sensor +
                '}';
    }

    @Override
    protected String getAPIName() {
        return "geocode";
    }

    @Override
    protected URIBuilder addParameters(URIBuilder builder) throws UnsupportedEncodingException {
        builder.addParameter("sensor", String.valueOf(sensor));
        if (address != null) {
            builder.addParameter("address", URLEncoder.encode(address, "UTF-8"));
        } else if (latLng != null) {
            builder.addParameter("latlng", latLng.toString());
        } else {
            throw new IllegalArgumentException("Both address and latlng are null.");
        }
        if (language != null) {
            builder.addParameter("language", language);
        }
        return builder;
    }
}
