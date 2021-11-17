package com.seleniumframeworks.driver;

import com.seleniumframeworks.enums.Browsers;
import com.seleniumframeworks.enums.PropertyFileConstants;
import com.seleniumframeworks.utils.PropertyFileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;

import static com.seleniumframeworks.driver.DriverManager.getDriver;
import static com.seleniumframeworks.driver.DriverManager.unload;
import static com.seleniumframeworks.utils.RandomUtils.getRemoteDriverURL;

public final class Driver {
    private Driver(){}

    @SneakyThrows
    public static void initDriver(String browser) {
        if(Objects.isNull(getDriver())){
            if(browser.equalsIgnoreCase(Browsers.CHROME.toString())){
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                DriverManager.setDriver(new RemoteWebDriver(getRemoteDriverURL(), chromeOptions));
                getDriver().get(PropertyFileUtils.getValue(PropertyFileConstants.URL));
            } else if (browser.equalsIgnoreCase(Browsers.FIREFOX.toString())){
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                DriverManager.setDriver(new RemoteWebDriver(getRemoteDriverURL(), firefoxOptions));
                getDriver().get(PropertyFileUtils.getValue(PropertyFileConstants.URL));
            }
        }
    }

    public static void quitDriver(){
        if(Objects.nonNull(getDriver())){
            getDriver().quit();
            unload();
        }
    }
}
