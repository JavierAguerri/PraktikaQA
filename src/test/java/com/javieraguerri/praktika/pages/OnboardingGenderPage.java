package com.javieraguerri.praktika.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OnboardingGenderPage extends BasePage {
    @AndroidFindBy(id = "ui_button_man")
    private WebElement maleButton;
    @AndroidFindBy(id = "ui_button_woman")
    private WebElement femaleButton;
    @AndroidFindBy(id = "ui_button_unknown")
    private WebElement unknownButton;

    public OnboardingGenderPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void chooseMale() {
        waitAndClick(maleButton);
    }
    public void chooseFemale() {
        waitAndClick(femaleButton);
    }
    public void chooseUnkown() {
        waitAndClick(unknownButton);
    }


}
