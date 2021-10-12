package com.equifax.httpclient;

import io.cucumber.messages.internal.com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class HttpClient {

    public void get(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        response.getStatusLine().getStatusCode();
        String responseInString = EntityUtils.toString(response.getEntity(),"UTF-8");
        JSONObject responseInJSON = new JSONObject(responseInString);
    }
}
