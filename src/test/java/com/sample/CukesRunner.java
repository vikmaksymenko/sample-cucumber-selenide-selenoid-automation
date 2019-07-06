package com.sample;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeTest;

@CucumberOptions
public class CukesRunner extends AbstractTestNGCucumberTests {
    @BeforeTest
    public void startDriver() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1024x768";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.remote = "http://localhost:4444/wd/hub";

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}
