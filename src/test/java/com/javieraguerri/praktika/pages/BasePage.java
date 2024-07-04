package com.javieraguerri.praktika.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage{
    protected AppiumDriver driver;
    private final WebDriverWait standardWait;
    private final FluentWait<AppiumDriver> androidNativeOverlaysWait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        this.standardWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.androidNativeOverlaysWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(12))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
    }

    protected void waitAndClick(WebElement element) {
        standardWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void waitAndroidNativeOverlayAndClick(WebElement element) {
        androidNativeOverlaysWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void waitAndInputText(WebElement element, String text) {
        standardWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    protected boolean waitAndIsVisible(WebElement element) {
        standardWait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

}
