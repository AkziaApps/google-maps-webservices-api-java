package com.akzia.googleapi;

import org.apache.http.client.utils.URIBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

public abstract class AbstractRequest {

    private static final String HOST = "maps.googleapis.com";

    private static final String PATH = "/maps/api/%s/json";

    public URI buildRequest() throws URISyntaxException, UnsupportedEncodingException {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http");
        uriBuilder.setHost(HOST);
        uriBuilder.setPath(String.format(PATH, getAPIName()));
        uriBuilder = addParameters(uriBuilder);
        return uriBuilder.build();
    }

    protected abstract String getAPIName();

    protected abstract URIBuilder addParameters(URIBuilder builder) throws UnsupportedEncodingException;
}
