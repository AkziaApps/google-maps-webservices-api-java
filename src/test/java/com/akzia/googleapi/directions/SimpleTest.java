package com.akzia.googleapi.directions;

import com.akzia.googleapi.AbstractResponse;
import com.akzia.googleapi.AbstractTest;
import com.akzia.googleapi.common.GeoPoint;
import com.google.gson.Gson;
import org.junit.Test;

import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import static junit.framework.Assert.assertTrue;

public class SimpleTest extends AbstractTest {

    @Test
    public void testAddress() throws Exception {
        test();
    }

    @Override
    protected String buildRequest() throws UnsupportedEncodingException, URISyntaxException {
        return new GoogleDirectionsRequest(new GeoPoint(55.688610, 37.693449), new GeoPoint(55.750587, 37.650188)).buildRequest();
    }

    @Override
    protected AbstractResponse parseResponse(Gson gson, Reader reader) {
        return gson.fromJson(reader, GoogleDirectionsResponse.class);
    }

    @Override
    protected void advancedAsserts(AbstractResponse response) {
        GoogleDirectionsResponse directionsResponse = (GoogleDirectionsResponse) response;
        assertTrue(directionsResponse.getRoutes().size() > 0);
    }
}
