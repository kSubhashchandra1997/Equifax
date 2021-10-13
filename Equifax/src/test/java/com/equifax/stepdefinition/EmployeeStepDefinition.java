package com.equifax.stepdefinition;

import com.equifax.base.TestBase;
import com.equifax.service.EmployeeService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;

public class EmployeeStepDefinition extends TestBase {

    CloseableHttpResponse getEmployeeResponse;
    CloseableHttpResponse createEmployeeResponse;

    @Given("Hit the employees endpoint")
    public void hit_the_employees_endpoint() throws IOException {
        EmployeeService employeeService = new EmployeeService();
        getEmployeeResponse = employeeService.getEmployee("2");
    }
    @Then("Validate the status code get employee")
    public void validate_the_status_code_get_employee() {
        int statusCode = getEmployeeResponse.getStatusLine().getStatusCode();
        if(statusCode==200)
            System.out.println("Status code is matching : "+statusCode);
        else{
            System.out.println("Status code is not matching : "+statusCode);
           System.out.println( getEmployeeResponse.toString());
        }

    }
    @Given("Hit the create employee endpoint")
    public void hit_the_create_employee_endpoint() throws IOException {
        String payloadInJSON = "{\"name\":\"morpheus\",\"job\":\"leader\"}";
        EmployeeService employeeService = new EmployeeService();
        createEmployeeResponse = employeeService.createEmployee(payloadInJSON);
    }
    @Then("Validate the status code for create employee")
    public void validate_the_status_code_for_create_employee() {
        int statusCode = createEmployeeResponse.getStatusLine().getStatusCode();
        if(statusCode==201)
            System.out.println("Status code is matching : "+statusCode);
        else
            System.out.println("Status code is not matching : "+statusCode);
    }
}
