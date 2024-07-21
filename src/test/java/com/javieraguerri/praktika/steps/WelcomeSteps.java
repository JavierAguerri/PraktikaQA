package com.javieraguerri.praktika.steps;

import com.javieraguerri.praktika.pages.PageObjectManager;
import com.javieraguerri.praktika.pages.WelcomePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WelcomeSteps {
    private static final Logger logger = LogManager.getLogger(WelcomeSteps.class);
    private final WelcomePage welcomePage;

    public WelcomeSteps() {
        PageObjectManager pageObjectManager = PageObjectManager.getInstance();
        this.welcomePage = pageObjectManager.getPage(WelcomePage.class);
    }

    @Step("Get started")
    public void getStarted() {
        logger.info("Getting started");
        welcomePage.getStarted();
    }
}
