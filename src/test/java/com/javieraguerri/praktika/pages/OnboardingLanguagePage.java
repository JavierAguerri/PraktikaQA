package com.javieraguerri.praktika.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OnboardingLanguagePage extends BasePage {
    @AndroidFindBy(id = "ui_textEdit_Search")
    private WebElement searchTextInput;
    @AndroidFindBy(id = "ui_button_Spanish")
    private WebElement spanishButton;
    @AndroidFindBy(accessibility = "Switch to Spanish")
    private WebElement switchToSpanishButton;

    public OnboardingLanguagePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void searchLanguage(String language) {
        waitAndInputText(searchTextInput, language);
    }

    public void chooseSpanishLanguage() { // continue is a reserved keyword
        waitAndClick(spanishButton);
    }

    public void switchToSpanish() { // continue is a reserved keyword
        waitAndClick(switchToSpanishButton);
    }
}
