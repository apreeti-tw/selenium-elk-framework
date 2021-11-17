package com.seleniumframeworks.factory;

import com.seleniumframeworks.constants.Constants;
import com.seleniumframeworks.driver.DriverManager;
import com.seleniumframeworks.enums.ExplicitWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

public final class ExplicitWaitFactory {
    private ExplicitWaitFactory(){}

    private static final int EXPLICIT_WAIT_TIMEOUT = Constants.getExplicitWaitTimeout();

    private static final Map<ExplicitWaits, Consumer<By>> MAP = new EnumMap(ExplicitWaits.class);

    private static final Consumer<By> EXPLICIT_WAIT_BY_PRESENCE = by -> new WebDriverWait(DriverManager.getDriver(), EXPLICIT_WAIT_TIMEOUT).until(driver -> driver.findElement(by).isDisplayed());
    private static final Consumer<By> EXPLICIT_WAIT_BY_CLICKABLE = by -> new WebDriverWait(DriverManager.getDriver(), EXPLICIT_WAIT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(by));

    static {
        MAP.put(ExplicitWaits.CLICKABLE, EXPLICIT_WAIT_BY_PRESENCE);
        MAP.put(ExplicitWaits.PRESENCE, EXPLICIT_WAIT_BY_CLICKABLE);
    }

    public static void executeWaitBy(ExplicitWaits waitStrategy, By by){
        MAP.get(waitStrategy).accept(by);
    }
}
