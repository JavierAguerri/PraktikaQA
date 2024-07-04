package com.javieraguerri.praktika.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OnboardingInterestsPage extends BasePage {

    @AndroidFindBy(accessibility = "¡Hola!\n¿Cuáles son sus aficiones e intereses?")
    private WebElement titleView;

    public OnboardingInterestsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isVisibleTitleText() {
        return waitAndIsVisible(titleView);
    }
}
