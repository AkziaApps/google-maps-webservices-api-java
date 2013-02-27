package com.akzia.googleapi.directions;

import com.google.gson.annotations.SerializedName;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class GoogleDirectionsRequest {

    /**
     * origin – адрес отправного пункта маршрута.
     * Для вычисления маршрута служба выполняет геокодирование строки
     * и преобразует ее в значения координат широты и долготы.
     */
    @SerializedName("origin")
    private String originAddress;

    /**
     * origin – текстовое значение широты и долготы отправного пункта маршрута.
     * При передаче координат не допускаются пробелы между значениями широты и долготы.
     */
    @SerializedName("origin")
    private GeoPoint originLocation;

    /**
     * destination – адрес пункта назначения.
     * Для вычисления маршрута служба выполняет геокодирование строки
     * и преобразует ее в значения координат широты и долготы.
     */
    @SerializedName("destination")
    private String destinationAddress;

    /**
     * destination – текстовое значение широты и долготы пункта назначения.
     * При передаче координат не допускаются пробелы между значениями широты и долготы.
     */
    @SerializedName("destination")
    private GeoPoint destinationLocation;

    /**
     * sensor указывает, исходит ли запрос маршрута от устройства с датчиком местоположения.
     */
    @SerializedName("sensor")
    private boolean sensor;

    public GoogleDirectionsRequest(String originAddress, String destinationAddress) {
        this.originAddress = originAddress;
        this.destinationAddress = destinationAddress;
        this.sensor = true;
    }

    public GoogleDirectionsRequest(GeoPoint originLocation, GeoPoint destinationLocation) {
        this.originLocation = originLocation;
        this.destinationLocation = destinationLocation;
        this.sensor = true;
    }

    public String buildUri() throws URISyntaxException {
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();

        if (originAddress != null) {
            pairs.add(new BasicNameValuePair("origin", originAddress));
        } else if (originLocation != null) {
            pairs.add(new BasicNameValuePair("origin", originLocation.toURIParam()));
        } else {
            throw new IllegalArgumentException("Origin is required parameter");
        }

        if (destinationAddress != null) {
            pairs.add(new BasicNameValuePair("destination", destinationAddress));
        } else if (destinationLocation != null) {
            pairs.add(new BasicNameValuePair("destination", destinationLocation.toURIParam()));
        } else {
            throw new IllegalArgumentException("Destination is required parameter");
        }

        pairs.add(new BasicNameValuePair("sensor", String.valueOf(sensor)));

        URI uri = URIUtils.createURI("http", "maps.googleapis.com", -1, "/maps/api/directions/json", URLEncodedUtils.format(pairs, "UTF-8"), null);
        return uri.toString().replace("%2C", ",");
    }

    public String getOriginAddress() {
        return originAddress;
    }

    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }

    public GeoPoint getOriginLocation() {
        return originLocation;
    }

    public void setOriginLocation(GeoPoint originLocation) {
        this.originLocation = originLocation;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public GeoPoint getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(GeoPoint destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public boolean isSensor() {
        return sensor;
    }

    public void setSensor(boolean sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "GoogleDirectionsRequest{" +
                "originAddress='" + originAddress + '\'' +
                ", originLocation=" + originLocation +
                ", destinationAddress='" + destinationAddress + '\'' +
                ", destinationLocation=" + destinationLocation +
                ", sensor=" + sensor +
                '}';
    }
}
