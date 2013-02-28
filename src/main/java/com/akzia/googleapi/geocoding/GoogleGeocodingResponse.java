package com.akzia.googleapi.geocoding;

import com.akzia.googleapi.AbstractResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GoogleGeocodingResponse extends AbstractResponse {

    public enum Status {
        /**
         * "OK" indicates that no errors occurred; the address was successfully parsed and
         * at least one geocode was returned.
         */
        OK,

        /**
         * "ZERO_RESULTS" indicates that the geocode was successful but returned no results.
         * This may occur if the geocode was passed a non-existent address or a latlng in a remote location.
         */
        ZERO_RESULTS,

        /**
         * "OVER_QUERY_LIMIT" indicates that you are over your quota.
         */
        OVER_QUERY_LIMIT,

        /**
         * "REQUEST_DENIED" indicates that your request was denied, generally because of lack of a sensor parameter.
         */
        REQUEST_DENIED,

        /**
         * "INVALID_REQUEST" generally indicates that the query (address or latlng) is missing.
         */
        INVALID_REQUEST,

        /**
         * UNKNOWN_ERROR indicates that the request could not be processed due to a server error.
         * The request may succeed if you try again.
         */
        UNKNOWN_ERROR
    }

    /**
     * The "status" field within the Geocoding response object contains the status of the request,
     * and may contain debugging information to help you track down why Geocoding is not working.
     */
    @SerializedName("status")
    private Status status;

    @SerializedName("results")
    private List<Result> results;

    public GoogleGeocodingResponse() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "GoogleGeocodingResponse{" +
                "status=" + status +
                ", results=" + results +
                '}';
    }
}
