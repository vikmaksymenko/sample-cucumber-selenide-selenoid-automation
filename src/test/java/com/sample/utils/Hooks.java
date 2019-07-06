package com.sample.utils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Allure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.fail;

public class Hooks {
    @Before
    public void setUp(Scenario scenario) {
        for (String tag : scenario.getSourceTagNames()) {
            if (tag.contains("issue")) {
                String message = "The case is marked with @issue.";

                Pattern pattern = Pattern.compile("@issue=(.*)");
                Matcher matcher = pattern.matcher(tag);
                if(matcher.matches()) {
                    String linkPattern = System.getProperty("allure.link.issue.pattern");
                    String link = linkPattern.replace("{}", matcher.group(1));
                    message += "Sea details in " + link;
                }

                fail(message);
            }
        }
    }
}
