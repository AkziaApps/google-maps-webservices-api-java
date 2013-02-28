package com.akzia.googleapi;

import org.apache.http.NameValuePair;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;

public abstract class AbstractRequest {

    private static final String HOST = "maps.googleapis.com";

    private static final String PATH = "/maps/api/%s/json?";

    public String buildRequest() throws URISyntaxException, UnsupportedEncodingException {
        StringBuilder builder = new StringBuilder();
        builder.append("http://");
        builder.append(HOST);
        builder.append(String.format(PATH, getAPIName()));
        for (NameValuePair pair : addParameters()) {
            builder.append("&");
            builder.append(pair.getName());
            builder.append("=");
            builder.append(pair.getValue());
        }
        return builder.toString();
    }

    protected abstract String getAPIName();

    protected abstract List<NameValuePair> addParameters() throws UnsupportedEncodingException;
}
