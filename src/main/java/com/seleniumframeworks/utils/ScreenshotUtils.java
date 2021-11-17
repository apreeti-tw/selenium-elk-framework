package com.seleniumframeworks.utils;

import com.seleniumframeworks.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtils {
    private ScreenshotUtils(){}

    public static String getBase64() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
