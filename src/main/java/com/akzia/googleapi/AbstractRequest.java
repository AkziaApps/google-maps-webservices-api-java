package com.akzia.googleapi;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Map;

public abstract class AbstractRequest {

    private static final String HOST = "maps.googleapis.com";

    private static final String PATH = "/maps/api/%s/json?";

    public String buildRequest() throws URISyntaxException, UnsupportedEncodingException {
        StringBuilder builder = new StringBuilder();
        builder.append("http://");
        builder.append(HOST);
        builder.append(String.format(PATH, getAPIName()));
        for (Map.Entry<String, String> pair : addParameters().entrySet()) {
            builder.append("&");
            builder.append(pair.getKey());
            builder.append("=");
            builder.append(pair.getValue());
        }
        return builder.toString();
    }

    protected abstract String getAPIName();

    protected abstract Map<String, String> addParameters() throws UnsupportedEncodingException;
}
