package com.javieraguerri.praktika.steps;

import com.javieraguerri.praktika.pages.*;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.assertj.core.api.Assertions.assertThat;

public class OnboardingSteps {
    private static final Logger logger = LogManager.getLogger(OnboardingSteps.class);
    private final OnboardingGenderPage onboardingGenderPage;
    private final OnboardingAgePage onboardingAgePage;
    private final OnboardingNamePage onboardingNamePage;
    private final OnboardingLanguagePage onboardingLanguagePage;
    private final OnboardingInterestsPage onboardingInterestsPage;

    public OnboardingSteps() {
        PageObjectManager pageObjectManager = PageObjectManager.getInstance();
        this.onboardingGenderPage = pageObjectManager.getOnboardingGenderPage();
        this.onboardingAgePage = pageObjectManager.getOnboardingAgePage();
        this.onboardingNamePage = pageObjectManager.getOnboardingNamePage();
        this.onboardingLanguagePage = pageObjectManager.getOnboardingLanguagePage();
        this.onboardingInterestsPage = pageObjectManager.getOnboardingInterestsPage();
    }

    @Step("Choose gender: Female")
    public void chooseGenderFemale() {
        logger.info("Choosing gender: Female");
        onboardingGenderPage.chooseFemale();
    }

    @Step("Choose age: 25 to 34")
    public void chooseAge25to34() {
        logger.info("Choosing age: 25 to 34");
        onboardingAgePage.choose25to34();
    }

    @Step("Input name: {0}")
    public void inputName(String name) {
        logger.info("Input name: " + name);
        onboardingNamePage.inputName(name);
        onboardingNamePage.proceed();
    }

    @Step("Search and choose language: {0}")
    public void searchAndChooseLanguage(String language) {
        logger.info("Searching and choosing language: " + language);
        onboardingLanguagePage.searchLanguage(language);
        onboardingLanguagePage.chooseSpanishLanguage();
        onboardingLanguagePage.switchToSpanish();
    }

    @Step("Verify Interests page is visible")
    public void verifyInterestsPageVisible() {
        logger.info("Verifying Interests page is visible");
        assertThat(onboardingInterestsPage.isVisibleTitleText()).isTrue();
    }
}
