package com.javieraguerri.praktika.tests;

import com.javieraguerri.praktika.pages.PageObjectManager;
import com.javieraguerri.praktika.utils.DriverManager;
import io.qameta.allure.Step;
import org.testng.annotations.*;

import java.net.MalformedURLException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseTest {
    protected PageObjectManager pageObjectManager;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public void beforeSuite() {
        logger.info("*** *** *** NEW TEST SUITE EXECUTION");
    }

    @BeforeMethod
    @Parameters({"platform"})
    @Step("Initialization")
    public void beforeMethod(String platform) throws MalformedURLException {
        logger.info("*** beforeMethod");
        DriverManager.initialize(platform);
        pageObjectManager = PageObjectManager.getInstance();
    }

    @Step("Cleanup")
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        logger.info("*** afterMethod");
        DriverManager.quitDriver();
    }
}
