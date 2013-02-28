package com.akzia.googleapi.directions;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class GoogleDirectionsSimpleTest {

    @Test
    public void testSimpleRequest() throws Exception {
        GoogleDirectionsRequest request = new GoogleDirectionsRequest("Судостроительная 55", "Затонная 8");
        URI uri = request.buildRequest();

        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(uri);
        HttpResponse response = client.execute(httpGet);

        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            Reader reader = new InputStreamReader(entity.getContent());
            Gson gson = new Gson();
            GoogleDirectionsResponse directionsResponse = gson.fromJson(reader, GoogleDirectionsResponse.class);
            assertNotNull(directionsResponse);
            assertTrue(directionsResponse.getRoutes().size() > 0);
            System.out.println(directionsResponse);
        } finally {
            httpGet.releaseConnection();
        }
    }
}
