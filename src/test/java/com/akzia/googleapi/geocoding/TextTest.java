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
        GoogleGeocodeRequest request = new GoogleGeocodeRequest(false, "затонная");
        request.setLanguage("ru");
        return request.buildRequest();
    }

    @Override
    protected AbstractResponse parseResponse(Gson gson, Reader reader) {
        return gson.fromJson(reader, GoogleGeocodeResponse.class);
    }

    @Override
    protected void advancedAsserts(AbstractResponse response) {

    }
}
