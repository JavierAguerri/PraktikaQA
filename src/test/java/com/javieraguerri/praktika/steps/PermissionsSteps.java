package com.javieraguerri.praktika.steps;

import com.javieraguerri.praktika.pages.PageObjectManager;
import com.javieraguerri.praktika.pages.PermissionsPage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PermissionsSteps {
    private static final Logger logger = LogManager.getLogger(PermissionsSteps.class);
    private final PermissionsPage permissionsPage;

    public PermissionsSteps() {
        PageObjectManager pageObjectManager = PageObjectManager.getInstance();
        this.permissionsPage = pageObjectManager.getPermissionsPage();
    }

    @Step("Allow notifications")
    public void allowNotifications() {
        logger.info("Allowing notifications");
        permissionsPage.allowPermission();
    }
}
