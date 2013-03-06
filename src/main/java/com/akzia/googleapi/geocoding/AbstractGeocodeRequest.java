package com.akzia.googleapi.geocoding;

import com.akzia.googleapi.AbstractRequest;
import com.akzia.googleapi.common.Bounds;
import com.google.gson.annotations.SerializedName;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractGeocodeRequest extends AbstractRequest {

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

    @SerializedName("bounds")
    private Bounds bounds;

    protected AbstractGeocodeRequest(boolean sensor) {
        this.sensor = sensor;
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

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    @Override
    protected String getAPIName() {
        return "geocode";
    }

    @Override
    protected Map<String, String> addParameters() throws UnsupportedEncodingException {
        Map<String, String> pairs = new HashMap<String, String>();
        pairs.put("sensor", String.valueOf(sensor));
        if (language != null) {
            pairs.put("language", language);
        }
        if (bounds != null) {
            pairs.put("bounds", bounds.toString());
        }
        return pairs;
    }

    @Override
    public String toString() {
        return "AbstractGeocodeRequest{" +
                "sensor=" + sensor +
                ", language='" + language + '\'' +
                ", bounds=" + bounds +
                '}';
    }
}
