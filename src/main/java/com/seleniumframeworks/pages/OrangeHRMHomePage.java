package com.seleniumframeworks.pages;

import com.seleniumframeworks.utils.DynamicPathUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class OrangeHRMHomePage extends BasePage{

    private final By textWelcome = By.id("welcome");
    private final String mainMenuLinks = "//a/b[text()='%s']";
    private final String subMenuLinks = "//a[text()='%s']";

    public WebElement getWelcomeMessage(){
        return getElement(textWelcome, "Welcome Message");
    }

    public OrangeHRMHomePage hoverOnMainMenuItem(String menuText){
        hover(By.xpath(DynamicPathUtils.getXpath(mainMenuLinks, menuText)), menuText);
        return this;
    }

    public OrangeHRMHomePage hoverOnSubMenuItem(String menuText){
        hover(By.xpath(DynamicPathUtils.getXpath(subMenuLinks, menuText)), menuText);
        return this;
    }

    public OrangeHRMHomePage clickOnMenuItem(String menuText){
        click(By.xpath(DynamicPathUtils.getXpath(subMenuLinks, menuText)), menuText);
        return this;
    }
}
