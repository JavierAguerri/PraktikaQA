package com.javieraguerri.praktika.tests;

import com.javieraguerri.praktika.pages.*;
import com.javieraguerri.praktika.steps.OnboardingSteps;
import com.javieraguerri.praktika.steps.PermissionsSteps;
import com.javieraguerri.praktika.steps.WelcomeSteps;
import com.javieraguerri.praktika.utils.Utils;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static com.javieraguerri.praktika.utils.Constants.LANGUAGE_CHANGED;
import static org.assertj.core.api.Assertions.assertThat;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Epic("User management")
@Feature("Onboarding tests")
public class PraktikaTests extends BaseTest {

    private static final Logger logger = LogManager.getLogger(PraktikaTests.class);

    @Test(priority = 1, description = "Change language through onboarding")
    @Severity(SeverityLevel.BLOCKER)
    @Description("1. Open a factory reset instance of the application\n2. Click \"Get Started\" button\n3. Go through onboarding to the language selection screen.\n 4. Change the language.")
    @Story("As a user, I want to change the language through onboarding so I can understand the texts.")
    @Issue("ISSUE-1234")
    public void getStartedAndChangeLanguageThroughOnboardingTest() {
        logger.info(" *** --- getStartedAndChangeLanguageThroughOnboardingTest");
        WelcomeSteps welcomeSteps = new WelcomeSteps();
        welcomeSteps.getStarted();
        PermissionsSteps permissionsSteps = new PermissionsSteps();
        permissionsSteps.allowNotifications();
        OnboardingSteps onboardingSteps = new OnboardingSteps();
        onboardingSteps.chooseGenderFemale();
        onboardingSteps.chooseAge25to34();
        onboardingSteps.inputName("Maria");
        onboardingSteps.searchAndChooseLanguage("Spanish");
        onboardingSteps.verifyInterestsPageVisible();
        Utils.createAndAttachScreenshot(LANGUAGE_CHANGED);
        logger.info("Completed test: getStartedAndChangeLanguageThroughOnboardingTest");
        // this test is meant to pass
    }

    @Test(priority = 2, description = "Demo test to illustrate a failed case")
    @Severity(SeverityLevel.MINOR)
    @Description("This is not a real test, just a dummy one to illustrate how a failed test looks like in Allure reports." +
            "\nFailed cases do not meet expected outcomes due to assertion failures.")
    public void failedAssertionTest() {
        logger.info(" *** --- failedAssertionTest");
        // dummy assertion - this test is meant to fail
        assertThat(false).isTrue();
    }

    @Test(priority = 3, description = "Demo test to illustrate a broken case")
    @Severity(SeverityLevel.MINOR)
    @Description("This is not a real test, just a dummy one to illustrate how a broken test looks like in Allure reports." +
            "\nBroken cases cannot be completed due to issues other than assertion failures, such as exceptions, errors, or other interruptions.")
    public void brokenTest() {
        logger.info(" *** --- brokenTest");
        WelcomePage welcomePage = pageObjectManager.getWelcomePage();
        welcomePage.getStarted();
        PermissionsPage permissionsPage = pageObjectManager.getPermissionsPage();
        permissionsPage.allowPermission();
        // Element won't be found - this test is meant to be broken
        OnboardingAgePage onboardingAgePage = pageObjectManager.getOnboardingAgePage();
        onboardingAgePage.choose25to34();
    }
}
