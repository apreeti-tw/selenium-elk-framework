package com.seleniumframeworks.pages;

import com.seleniumframeworks.driver.DriverManager;
import com.seleniumframeworks.enums.ExplicitWaits;
import com.seleniumframeworks.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.seleniumframeworks.factory.ExplicitWaitFactory.executeWaitBy;

public class BasePage {

    protected void click(By by, String elementName){
        executeWaitBy(ExplicitWaits.CLICKABLE, by);
        DriverManager.getDriver().findElement(by).click();
        ExtentLogger.pass("Clicked on element: "+elementName);
    }

    protected void hover(By by, String elementName){
        executeWaitBy(ExplicitWaits.CLICKABLE, by);
        new Actions(DriverManager.getDriver()).moveToElement(DriverManager.getDriver().findElement(by)).build().perform();
        ExtentLogger.pass("Clicked on element: "+elementName);
    }

    protected void sendKeys(By by, String value, String elementName){
        executeWaitBy(ExplicitWaits.PRESENCE, by);
        DriverManager.getDriver().findElement(by).sendKeys(value);
        ExtentLogger.pass("Entered text in element: "+elementName);
    }

    protected WebElement getElement(By by, String elementName){
        executeWaitBy(ExplicitWaits.PRESENCE, by);
        ExtentLogger.pass("Returned element: "+elementName);
        return DriverManager.getDriver().findElement(by);
    }

    protected List<WebElement> getElements(By by, String elementName){
        executeWaitBy(ExplicitWaits.PRESENCE, by);
        ExtentLogger.pass("Returned elements: "+elementName);
        return DriverManager.getDriver().findElements(by);
    }

    protected void selectText(By by, String value, String elementName){
        executeWaitBy(ExplicitWaits.PRESENCE, by);
        new Select(DriverManager.getDriver().findElement(by)).selectByVisibleText(value);
        ExtentLogger.pass("Selected text from element: "+elementName);
    }

    public Object[] findValueInTableContent(By by, String value){
        List<WebElement> table = DriverManager.getDriver().findElements(by);
        return table
                .parallelStream()
                .filter(val -> val.getText().contains(value))
                .toArray();
    }
}
