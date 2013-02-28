package com.akzia.googleapi;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import static junit.framework.Assert.assertNotNull;

public abstract class AbstractTest {

    public void test() throws IOException, URISyntaxException {
        URI uri = buildRequest();
        System.out.println(uri.toString());

        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(uri);
        HttpResponse response = client.execute(httpGet);
        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            Reader reader = new InputStreamReader(entity.getContent());
            Gson gson = new Gson();
            AbstractResponse parsedResponse = parseResponse(gson, reader);
            assertNotNull(parsedResponse);
            System.out.println(parsedResponse.toString());
            advancedAsserts(parsedResponse);
        } finally {
            httpGet.releaseConnection();
        }
    }

    protected abstract URI buildRequest() throws UnsupportedEncodingException, URISyntaxException;

    protected abstract AbstractResponse parseResponse(Gson gson, Reader reader);

    protected abstract void advancedAsserts(AbstractResponse response);
}
