package com.javieraguerri.praktika.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OnboardingNamePage extends BasePage {
    @AndroidFindBy(id = "ui_textEdit_Name")
    private WebElement nameTextInput;
    @AndroidFindBy(accessibility = "Continue")
    private WebElement continueButton;

    public OnboardingNamePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void inputName(String name) {
        waitAndInputText(nameTextInput, name);
    }
    public void proceed() { // continue is a reserved keyword
        waitAndClick(continueButton);
    }
}
