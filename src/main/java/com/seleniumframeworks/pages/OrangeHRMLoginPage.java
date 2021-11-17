package com.seleniumframeworks.pages;

import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage{

    private final By textboxUsername = By.id("txtUsername");
    private final By textboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
    private final By buttonLogin = By.id("btnLogin");

    public OrangeHRMLoginPage enterUsername(String username){
        sendKeys(
                textboxUsername,
                username, "Username");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password){
        sendKeys(textboxPassword, password, "Password");
        return this;
    }

    public OrangeHRMHomePage clickLogin(){
        click(buttonLogin, "LOGIN");
        return new OrangeHRMHomePage();
    }
}
