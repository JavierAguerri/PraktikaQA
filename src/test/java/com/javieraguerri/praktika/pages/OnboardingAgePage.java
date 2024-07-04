package com.javieraguerri.praktika.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OnboardingAgePage extends BasePage {
    @AndroidFindBy(id = "ui_button_age18_24")
    private WebElement age18to24button;
    @AndroidFindBy(id = "ui_button_age25_34")
    private WebElement age25to34button;
    @AndroidFindBy(id = "ui_button_age35_44")
    private WebElement age35to44button;

    public OnboardingAgePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void choose18to24() {
        waitAndClick(age18to24button);
    }
    public void choose25to34() {
        waitAndClick(age25to34button);
    }
    public void choose35to44() {
        waitAndClick(age35to44button);
    }
}
