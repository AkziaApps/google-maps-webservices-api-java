package com.akzia.googleapi.geocoding;

import com.google.gson.annotations.SerializedName;

/**
 * The types[] array within the returned result indicates the address type.
 * These types may also be returned within address_components[] arrays to indicate the type of the particular address
 * component. Addresses within the geocoder may have multiple types; the types may be considered "tags".
 * For example, many cities are tagged with the political and locality type.
 */
public enum Type {

    /**
     * street_address indicates a precise street address
     */
    @SerializedName("street_address")
    STREET_ADDRESS,

    /**
     * route indicates a named route (such as "US 101").
     */
    @SerializedName("route")
    ROUTE,

    /**
     * intersection indicates a major intersection, usually of two major roads.
     */
    @SerializedName("intersection")
    INTERSECTION,

    /**
     * political indicates a political entity. Usually, this type indicates a polygon of some civil administration.
     */
    @SerializedName("political")
    POLITICAL,

    /**
     * country indicates the national political entity, and is typically the highest order type returned by the Geocoder.
     */
    @SerializedName("country")
    COUNTRY,

    /**
     * administrative_area_level_1 indicates a first-order civil entity below the country level.
     * Within the United States, these administrative levels are states. Not all nations exhibit these administrative levels.
     */
    @SerializedName("administrative_area_level_1")
    ADMINISTRATIVE_AREA_LEVEL_1,

    /**
     * administrative_area_level_2 indicates a second-order civil entity below the country level.
     * Within the United States, these administrative levels are counties. Not all nations exhibit these administrative levels.
     */
    @SerializedName("administrative_area_level_2")
    ADMINISTRATIVE_AREA_LEVEL_2,

    /**
     * administrative_area_level_3 indicates a third-order civil entity below the country level.
     * This type indicates a minor civil division. Not all nations exhibit these administrative levels.
     */
    @SerializedName("administrative_area_level_3")
    ADMINISTRATIVE_AREA_LEVEL_3,

    /**
     * colloquial_area indicates a commonly-used alternative name for the entity.
     */
    @SerializedName("colloquial_area")
    COLLOQUIAL_AREA,

    /**
     * locality indicates an incorporated city or town political entity.
     */
    @SerializedName("locality")
    LOCALITY,

    /**
     * sublocality indicates an first-order civil entity below a locality
     */
    @SerializedName("sublocality")
    SUBLOCALITY,

    /**
     * neighborhood indicates a named neighborhood
     */
    @SerializedName("neighborhood")
    NEIGHBORHODD,

    /**
     * premise indicates a named location, usually a building or collection of buildings with a common name
     */
    @SerializedName("premise")
    PREMISE,

    /**
     * subpremise indicates a first-order entity below a named location, usually a singular building within a collection of buildings with a common name
     */
    @SerializedName("subpremise")
    SUBPREMISE,

    /**
     * postal_code indicates a postal code as used to address postal mail within the country.
     */
    @SerializedName("postal_code")
    POSTAL_CODE,

    /**
     * natural_feature indicates a prominent natural feature.
     */
    @SerializedName("natural_feature")
    NATURAL_FEATURE,

    /**
     * airport indicates an airport.
     */
    @SerializedName("airport")
    AIRPORT,

    /**
     * park indicates a named park.
     */
    @SerializedName("park")
    PARK,

    /**
     * point_of_interest indicates a named point of interest. Typically, these "POI"s are prominent local entities that don't easily fit in another category such as "Empire State Building" or "Statue of Liberty."
     */
    @SerializedName("point_of_interest")
    POINT_OF_INTEREST,

    /**
     * post_box indicates a specific postal box.
     */
    @SerializedName("post_box")
    POST_BOX,

    /**
     * street_number indicates the precise street number.
     */
    @SerializedName("street_number")
    STREET_NUMBER,

    /**
     * floor indicates the floor of a building address.
     */
    @SerializedName("floor")
    FLOOR,

    /**
     * room indicates the room of a building address.
     */
    @SerializedName("room")
    ROOM
}
