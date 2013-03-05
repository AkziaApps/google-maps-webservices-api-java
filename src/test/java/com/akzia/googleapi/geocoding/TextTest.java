package com.akzia.googleapi.geocoding;

import com.akzia.googleapi.AbstractResponse;
import com.akzia.googleapi.AbstractTest;
import com.google.gson.Gson;
import org.junit.Test;

import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class TextTest extends AbstractTest {

    @Test
    public void testName() throws Exception {
        test();
    }

    @Override
    protected String buildRequest() throws UnsupportedEncodingException, URISyntaxException {
        GoogleGeocodingRequest request = new GoogleGeocodingRequest("затонная");
        request.setLanguage("ru");
        return request.buildRequest();
    }

    @Override
    protected AbstractResponse parseResponse(Gson gson, Reader reader) {
        return gson.fromJson(reader, GoogleGeocodingResponse.class);
    }

    @Override
    protected void advancedAsserts(AbstractResponse response) {

    }
}
