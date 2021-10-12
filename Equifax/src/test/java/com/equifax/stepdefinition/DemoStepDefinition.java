package com.equifax.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DemoStepDefinition {

    @Given("Start the script")
    public void start_the_script() {
        System.out.println("script execution started");
    }

    @Then("Script execution in progress")
    public void script_execution_in_progress() {
        System.out.println("script execution in progress");
    }

    @Then("Execution completed")
    public void execution_completed() {
        System.out.println("Execution completed");
    }

}
