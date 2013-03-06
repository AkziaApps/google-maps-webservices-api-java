package com.akzia.googleapi.geocoding;

import com.akzia.googleapi.AbstractResponse;
import com.akzia.googleapi.AbstractTest;
import com.akzia.googleapi.common.GeoPoint;
import com.google.gson.Gson;
import org.junit.Test;

import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import static junit.framework.Assert.assertTrue;

public class ReverseSimpeTest extends AbstractTest {

    @Test
    public void testSimple() throws Exception {
        test();
    }

    @Override
    protected String buildRequest() throws UnsupportedEncodingException, URISyntaxException {
        GoogleReverseGeocodeRequest request = new GoogleReverseGeocodeRequest(false, new GeoPoint(55.688610, 37.693449));
        request.setLanguage("ru");
        return request.buildRequest();
    }

    @Override
    protected AbstractResponse parseResponse(Gson gson, Reader reader) {
        return gson.fromJson(reader, GoogleGeocodeResponse.class);
    }

    @Override
    protected void advancedAsserts(AbstractResponse response) {
        GoogleGeocodeResponse geocodingResponse = (GoogleGeocodeResponse) response;
        assertTrue(geocodingResponse.getResults().size() > 0);
    }
}
