package cbs.bsit22a.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class BasicRestQuery {

    protected String dataset;
    protected List<RestParam> params = new ArrayList<>();

    protected   BasicRestQuery(String dataset, List<RestParam> defaultParams, RestParam[] additionalParams) {
        this.dataset = dataset;
        this.params.addAll(defaultParams);
        this.params.addAll(Arrays.stream(additionalParams).toList());
    }

    protected HttpResponse<String> getResponse() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(buildURI()))
                .header("Accept", "application/json")
                .GET()
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    public void printResponse() {
        HttpResponse<String> response = getResponse();

        if (response.statusCode()!= 200) return;

        ObjectMapper objectMapper = new ObjectMapper();
        String out;
        try {
            Object jsonObject = objectMapper.readValue(response.body(), Object.class);
            out = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(out);
    }

    protected String buildURI() {
        StringBuilder sb = new StringBuilder();
        sb.append(getURL());
        sb.append("/");
        sb.append(dataset);
        if (!params.isEmpty())
        {
            sb.append("?");
            sb.append(params.get(0));
            params.remove(0);
        }
        for (RestParam param : params)
        {
            sb.append("&");
            sb.append(param);
        }
        return sb.toString();
    }

    protected abstract String getURL();
}
