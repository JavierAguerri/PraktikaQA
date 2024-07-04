package com.javieraguerri.praktika.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends BasePage {

    @AndroidFindBy(accessibility = "GetStarted Button")
    private WebElement getStartedButton;

    @AndroidFindBy(accessibility = "Missing Button")
    private WebElement missingButton;

    public WelcomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void getStarted() {
        waitAndClick(getStartedButton);
    }

    public boolean isVisibleMissingButton() {
        return waitAndIsVisible(missingButton);
    }
}
