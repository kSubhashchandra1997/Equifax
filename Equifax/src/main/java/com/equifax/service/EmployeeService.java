package com.equifax.service;

import com.equifax.base.TestBase;
import com.equifax.httpclient.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;

public class EmployeeService {
    String baseUrl;
    String createEmployeeServiceUrl = "api/users/";
    String getEmployeeServiceUrl = "/api/users/";

    HttpClient httpClient;

    public EmployeeService(){
        httpClient = new HttpClient();

        TestBase testBase = new TestBase();
        this.baseUrl = testBase.getProperty("URL");
    }
    public CloseableHttpResponse getEmployee(String userId) throws IOException {

        return httpClient.get(baseUrl+getEmployeeServiceUrl+userId);
    }
    public CloseableHttpResponse createEmployee(String payloadInJSON) throws IOException {

        return httpClient.post(baseUrl+createEmployeeServiceUrl,payloadInJSON);
    }
}
