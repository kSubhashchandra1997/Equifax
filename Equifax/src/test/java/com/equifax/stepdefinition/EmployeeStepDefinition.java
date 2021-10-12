package com.equifax.stepdefinition;

import com.equifax.base.TestBase;
import com.equifax.httpclient.HttpClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class EmployeeStepDefinition extends TestBase {

    CloseableHttpResponse response;

    @Given("Hit the employees endpoint")
    public void hit_the_employees_endpoint() throws IOException {
        TestBase testBase = new TestBase();
        String baseURL = testBase.getProperty("URL");
        String serviceURL = testBase.getProperty("serviceURL");
        String url = baseURL+serviceURL;

        HttpClient httpClient = new HttpClient();
        System.out.println("Hitting the Employee endpoint");
        response = httpClient.get(url);
    }
    @Then("Validate the status code")
    public void validate_the_status_code() {
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Getting the status code");
        System.out.println("Status code = "+statusCode);

        SoftAssert softassert = new SoftAssert();
        System.out.println("Validating the status code");
        softassert.assertEquals(statusCode, 200);
    }
}
