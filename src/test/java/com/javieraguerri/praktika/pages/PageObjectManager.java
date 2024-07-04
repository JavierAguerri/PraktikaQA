package com.javieraguerri.praktika.pages;

import com.javieraguerri.praktika.utils.DriverManager;
import io.appium.java_client.AppiumDriver;

import static com.javieraguerri.praktika.utils.Constants.*;

public class PageObjectManager {

    private static PageObjectManager instance;
    private final AppiumDriver driver;
    private WelcomePage welcomePage;
    private PermissionsPage permissionsPage;
    private OnboardingGenderPage onboardingGenderPage;
    private OnboardingAgePage onboardingAgePage;
    private OnboardingNamePage onboardingNamePage;
    private OnboardingLanguagePage onboardingLanguagePage;
    private OnboardingInterestsPage onboardingInterestsPage;

    private PageObjectManager() {
        this.driver = DriverManager.getDriver();
    }

    public static PageObjectManager getInstance() {
        if (instance == null) {
            instance = new PageObjectManager();
        }
        return instance;
    }

    public WelcomePage getWelcomePage() {
        if (welcomePage == null) {
            welcomePage = new WelcomePage(driver);
        }
        return welcomePage;
    }

    public PermissionsPage getPermissionsPage() {
        if (permissionsPage == null) {
            String platform = driver.getCapabilities().getPlatformName().toString();
            if (ANDROID_PLATFORM_NAME.equalsIgnoreCase(platform)) {
                permissionsPage = new AndroidPermissionsPage(driver);
            }
            else if (IOS_PLATFORM_NAME.equalsIgnoreCase(platform)) {
                permissionsPage = new IosPermissionsPage(driver);
            } else {
                throw new RuntimeException(platform);
            }
        }
        return permissionsPage;
    }

    public OnboardingGenderPage getOnboardingGenderPage() {
        if (onboardingGenderPage == null) {
            onboardingGenderPage = new OnboardingGenderPage(driver);
        }
        return onboardingGenderPage;
    }

    public OnboardingAgePage getOnboardingAgePage() {
        if (onboardingAgePage == null) {
            onboardingAgePage = new OnboardingAgePage(driver);
        }
        return onboardingAgePage;
    }

    public OnboardingNamePage getOnboardingNamePage() {
        if (onboardingNamePage == null) {
            onboardingNamePage = new OnboardingNamePage(driver);
        }
        return onboardingNamePage;
    }

    public OnboardingLanguagePage getOnboardingLanguagePage() {
        if (onboardingLanguagePage == null) {
            onboardingLanguagePage = new OnboardingLanguagePage(driver);
        }
        return onboardingLanguagePage;
    }

    public OnboardingInterestsPage getOnboardingInterestsPage() {
        if (onboardingInterestsPage == null) {
            onboardingInterestsPage = new OnboardingInterestsPage(driver);
        }
        return onboardingInterestsPage;
    }
}
