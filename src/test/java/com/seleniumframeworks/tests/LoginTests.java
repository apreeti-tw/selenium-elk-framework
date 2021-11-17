package com.seleniumframeworks.tests;

import com.seleniumframeworks.annotations.FrameworkAnnotations;
import com.seleniumframeworks.enums.CategoryTypes;
import com.seleniumframeworks.pages.OrangeHRMLoginPage;
import com.seleniumframeworks.utils.DataProviderUtils;
import com.seleniumframeworks.utils.RandomUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTests extends BaseTest {

    @FrameworkAnnotations(author = {"Preeti"}, category = {CategoryTypes.SMOKE})
    @Test(dataProvider = "DataContainer", dataProviderClass = DataProviderUtils.class)
    public void validUserLoginTest(Map<String,String> user) {
        OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage();

        WebElement welcomeMessage =
                orangeHRMLoginPage
                .enterUsername(user.get("username"))
                .enterPassword(RandomUtils.decodeBase64(user.get("password")))
                .clickLogin()
                .getWelcomeMessage();

        Assert.assertTrue(welcomeMessage.isDisplayed());
    }
}
