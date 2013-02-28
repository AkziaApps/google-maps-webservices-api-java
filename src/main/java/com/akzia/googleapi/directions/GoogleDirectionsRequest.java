package com.akzia.googleapi.directions;

import com.akzia.googleapi.AbstractRequest;
import com.akzia.googleapi.common.GeoPoint;
import com.google.gson.annotations.SerializedName;
import org.apache.http.client.utils.URIBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GoogleDirectionsRequest extends AbstractRequest {

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
     * default - false
     */
    @SerializedName("sensor")
    private boolean sensor;

    public GoogleDirectionsRequest(String originAddress, String destinationAddress) {
        this.originAddress = originAddress;
        this.destinationAddress = destinationAddress;
        this.sensor = false;
    }

    public GoogleDirectionsRequest(GeoPoint originLocation, GeoPoint destinationLocation) {
        this.originLocation = originLocation;
        this.destinationLocation = destinationLocation;
        this.sensor = false;
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

    @Override
    protected String getAPIName() {
        return "directions";
    }

    @Override
    protected URIBuilder addParameters(URIBuilder builder) throws UnsupportedEncodingException {
        builder.addParameter("sensor", String.valueOf(sensor));
        if (originAddress != null) {
            builder.addParameter("origin", URLEncoder.encode(originAddress, "UTF-8"));
        } else if (getOriginLocation() != null) {
            builder.addParameter("origin", originLocation.toString());
        } else {
            throw new IllegalArgumentException("Origin is required parameter");
        }
        if (destinationAddress != null) {
            builder.addParameter("destination", URLEncoder.encode(destinationAddress, "UTF-8"));
        } else if (destinationLocation != null) {
            builder.addParameter("destination", destinationLocation.toString());
        } else {
            throw new IllegalArgumentException("Destination is required parameter");
        }
        return builder;
    }
}
