package com.javieraguerri.praktika.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AndroidPermissionsPage extends BasePage implements PermissionsPage {

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement allowButton;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private WebElement denyButton;

    public AndroidPermissionsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void allowPermission() {
        waitAndroidNativeOverlayAndClick(allowButton);
    }

    @Override
    public void denyPermission() {
        waitAndClick(denyButton);
    }
}
