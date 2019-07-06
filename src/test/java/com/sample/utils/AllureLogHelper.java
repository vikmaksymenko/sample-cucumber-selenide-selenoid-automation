package com.sample.utils;

import com.codeborne.selenide.SelenideDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.Reporter;

import java.io.IOException;
import java.io.StringWriter;

public class AllureLogHelper {
    @Attachment("< {0} > message ")
    public static String log(Class clazz, String msg) {
        return clazz.getSimpleName() + ": " + msg;
    }

    @Attachment("< {0} > message ")
    public static String log(Class clazz, String msg, boolean useConsole) {
        if (useConsole) Reporter.log(clazz.getSimpleName() + ": " + msg, true);
        return clazz.getSimpleName() + ": " + msg;
    }

    @Attachment("< {0} > message ")
    public static String log(Class clazz, String subj, String msg, boolean useConsole) {
        if (useConsole) Reporter.log(clazz.getSimpleName() + ": " + subj + " - " + msg, true);
        return clazz.getSimpleName() + ": " + msg;
    }

    @Attachment("{0}")
    public static String log(String subj, String msg) {
        return msg;
    }

    @Attachment("{0}")
    public static String log(String subj, String msg, boolean useConsole) {
        if (useConsole) Reporter.log(subj + ": " + msg, true);
        return msg;
    }

    @Attachment("{0}")
    public static String log(String msg) {
        Reporter.log(msg, true);
        return msg;
    }

    @Attachment("{0}")
    public static String log(String msg, boolean useConsole) {
        if (useConsole) Reporter.log(msg, true);
        return msg;
    }

    @Attachment(value = "{0}", type = "application/json")
    public static String logHar(String name, Har har) {
        StringWriter writer = new StringWriter();
        try {
            har.writeTo(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

    @Attachment(value = "{0}", type = "application/json")
    public static String logJSON(String name, String json) {
        return json;
    }

    public static void takeScreenshot(String name) {
        Allure.addAttachment(name, "image/png");
    }
}
