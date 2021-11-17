package com.seleniumframeworks.tests;

import com.seleniumframeworks.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Map;

public class BaseTest {

    protected BaseTest(){}

    @BeforeMethod
    protected void setup(Object[] runManager) throws IOException {
        Driver.initDriver(((Map<String,String>) runManager[0]).get("browser"));
    }

    @AfterMethod
    protected void tearDown(){
        Driver.quitDriver();
    }
}
