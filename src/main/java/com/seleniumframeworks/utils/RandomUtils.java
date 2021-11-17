package com.seleniumframeworks.utils;

import com.github.javafaker.Faker;
import com.seleniumframeworks.enums.PropertyFileConstants;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Base64;

public final class RandomUtils {

    private RandomUtils(){}

    public static String getFakeUsername(String role){
        return role + "_" + new Faker().random().hex(6);
    }

    public static String getFakePassword(){
        return new Faker().internet().password();
    }

    public static String decodeBase64(String string) {
        return new String(Base64.getDecoder().decode(string));
    }

    @SneakyThrows
    public static URL getRemoteDriverURL(){
        return new URL(PropertyFileUtils.getValue(PropertyFileConstants.SELENIUM_HUB));
    }

    @SneakyThrows
    public static URL getElasticsearchURL(){
        return new URL(PropertyFileUtils.getValue(PropertyFileConstants.ELASTICSEARCH));
    }
}
