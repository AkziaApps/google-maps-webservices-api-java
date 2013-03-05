package com.akzia.googleapi.geocoding;

import com.akzia.googleapi.AbstractResponse;
import com.akzia.googleapi.AbstractTest;
import com.akzia.googleapi.common.GeoPoint;
import com.google.gson.Gson;
import org.junit.Test;

import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class PartialOutputTest extends AbstractTest {

    @Test
    public void testName() throws Exception {
        test();
    }

    @Override
    protected String buildRequest() throws UnsupportedEncodingException, URISyntaxException {
        GoogleGeocodingRequest request = new GoogleGeocodingRequest(new GeoPoint(55.688610, 37.693449));
        request.setLanguage("ru");
        return request.buildRequest();
    }

    @Override
    protected AbstractResponse parseResponse(Gson gson, Reader reader) {
        return gson.fromJson(reader, GoogleGeocodingResponse.class);
    }

    @Override
    protected void advancedAsserts(AbstractResponse response) {
        GoogleGeocodingResponse geocodingResponse = (GoogleGeocodingResponse) response;
        System.out.println(geocodingResponse.getFormattedResult());
    }
}
