package com.sample.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordSteps {
    @When("type {string}")
    public void type(String searchRequest) {
        $("input#email").setValue(searchRequest);
    }

    @And("push \"Retrieve password\"")
    public void push() {
        $("button#form_submit").click();
    }


    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String message) {
        $("#content").shouldHave(text(message));
    }
}
