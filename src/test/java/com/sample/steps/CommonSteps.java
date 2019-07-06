package com.sample.steps;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class CommonSteps {
    @Given("^navigate to \"([^\"]*)\"$")
    public void navigateTo(String url) {
        open(url);
    }
}
